package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.TimeOffDAO;
import vn.vissoft.portal.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import java.lang.Object;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class TimeOffDAOImpl implements TimeOffDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<TimeOff> findByRtUser(Integer idUser) {
        return entityManager.createQuery("SELECT rp FROM " + TimeOff.class.getName() + " rp WHERE rp.rtUser.id="
                + idUser + " and  rp.toStatus = 1 and rp.rtReason != 59 ORDER BY rp.rtCreateDate DESC").getResultList();
    }

    @Override
    public List<Object[]> getTheUnreadReport() {
        return entityManager.createQuery("SELECT COUNT(rp.rtStatus), rp.rtApprover FROM " + TimeOff.class.getName()
                + " rp WHERE rp.rtStatus = 2 GROUP BY rp.rtApprover").getResultList();
    }

    @Override
    public List<TimeOff> getAllSortByCreateDate() {
        String hql = "FROM TimeOff AS rp ORDER BY  rp.rtCreateDate DESC";
        List<TimeOff> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public List<TimeOff> filterTimeOffByReasonType(Integer reasonId, String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<TimeOff> from = criteriaQuery.from(TimeOff.class);
        CriteriaQuery<java.lang.Object> select = criteriaQuery.select(from);

//        order by to.rtStatus desc, to.toStatus desc, to.rtCreateDate desc
        select.orderBy(criteriaBuilder.desc(from.get("rtStatus")), criteriaBuilder.desc(from.get("toStatus")), criteriaBuilder.desc(from.get("rtCreateDate")));
        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(criteriaBuilder.notEqual(from.get("rtReason"), 59));

        if (reasonId != null && reasonId != 0) {
            predicates.add(criteriaBuilder.equal(from.get("rtReason"), reasonId));
        }

        if (code != null && !code.equals("")) {
            predicates.add(criteriaBuilder.equal(from.get("rtApprover"), code));
        }

        select.select(from).where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        List<TimeOff> lstResult = query.getResultList();
        return lstResult;
    }

    @Override
    public TimeoffLog getDetailTimeoff(String username) {
        String hql = "From " + TimeoffLog.class.getName() + " as toLog where toLog.usercode =" + username + " and Month(toLog.daywork) = Month(now()) order by toLog.daywork desc ";
        List<TimeoffLog> reportEmpsLst = entityManager.createQuery(hql).setParameter("username", username)
                .getResultList();
        return null;

    }


    @Override
    public List<Object[]> searchTimeOff(String username, String code, String beginDate, String endDate) {
        StringBuilder sql = new StringBuilder("" + "SELECT to.rtID, to.rtCreateDate, to.rtLeaveDateBegin,"
                + " to.rtLeaveDateEnd, to.rtApprovedDate, to.rtStatus, to.rtApprover, to.rtUser, to.rtReason, to.rtDescription "
                + "FROM User as u JOIN TimeOff as to ON u.id = to.rtUser WHERE to.rtStatus != 2 ");

        // Save all param
        Map<String, Object> listParameter = new HashMap<>();

        if (username != null) {
            sql = sql.append(" AND u.username LIKE :username");
            listParameter.put("username", username);
        }

        if (code != null) {
            sql = sql.append(" AND u.code LIKE :code");
            listParameter.put("code", code);
        }

        if (beginDate != null && endDate != null) {
            sql = sql.append(" AND DATE_FORMAT(to.rtLeaveDateBegin, '%Y-%m-%d') BETWEEN " + "DATE_FORMAT('" + beginDate
                    + "', '%Y-%m-%d') AND DATE_FORMAT('" + endDate + "', '%Y-%m-%d')");

        } else if (beginDate != null) {
            sql = sql.append(" AND DATE_FORMAT(to.rtLeaveDateBegin, '%Y-%m-%d') > " + "'" + beginDate + "'");
            listParameter.put("beginDate", beginDate);
        } else if (endDate != null) {
            sql = sql.append(" AND DATE_FORMAT(to.rtLeaveDateBegin, '%Y-%m-%d') < " + "'" + endDate + "'");
            listParameter.put("endDate", endDate);
        }
        sql= sql.append(" ORDER BY to.rtApprovedDate desc");

        Query query = entityManager.createQuery(sql.toString());

        // Set parameter for query
        for (Map.Entry me : listParameter.entrySet()) {
            if (me.getKey().equals("username") || me.getKey().equals("code")) {
                query.setParameter((String) me.getKey(), "%" + me.getValue() + "%");
            }
        }
        return query.getResultList();
    }

    @Override
    public List<TimeOff> haveTimeOff(int idUser, String leaveDateEnd) {
        String hql = "SELECT to FROM " + TimeOff.class.getName() + " to WHERE to.rtUser = " + idUser
                + " AND DATE_FORMAT(to.rtLeaveDateEnd,'%Y-%m-%d') = '" + leaveDateEnd + "'" + "  AND to.rtStatus = 1";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    @Transactional
    public void updateLabor(TimeoffLabor timeoffLabor) {
        entityManager.flush();
        entityManager.merge(timeoffLabor);
    }

    @Override
    @Transactional
    public void UndoTimeoff(Integer toID) throws ParseException {
        try {
            Date date = new Date();
            TimeOff to = getTimeoff_code(toID);
            Notify nf = new Notify();
            to.setToStatus(0);
            nf.setnContent("Đơn xin nghỉ của " + to.getRtUser().getFullName() + " Đã bị thu hồi");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date nCreateDate = (Date) dateFormat.parse(date.toString());
            nf.setnCreateDate(nCreateDate);
            nf.setSourceType(1);
            nf.setnStatus(0);
            nf.setnReceiver(to.getRtApprover());
            nf.setnSender(to.getRtUser());
            entityManager.merge(to);
            entityManager.persist(nf);
        } catch (Exception e) {
        }
    }

    @Override
    public Notify getNotify_code(Integer toID, Date createdate) {
        String hql = " from  " + Notify.class.getName()
                + " nf where nf.nSender.id = :rtID and nf.nCreateDate = :createdate";
        List<Notify> NFEmpsLst = entityManager.createQuery(hql).setParameter("rtID", toID)
                .setParameter("createdate", createdate).getResultList();
        if (NFEmpsLst != null && NFEmpsLst.size() > 0) {
            return NFEmpsLst.get(0);
        }
        return null;
    }

    @Override
    public TimeOff getTimeoff_code(Integer toID) {
        String hql = " from  " + TimeOff.class.getName() + " to where to.rtID = :rtID";
        List<TimeOff> TOEmpsLst = entityManager.createQuery(hql).setParameter("rtID", toID).getResultList();
        if (TOEmpsLst != null && TOEmpsLst.size() > 0) {
            return TOEmpsLst.get(0);
        }
        return null;
    }

    @Override
    public List<TimeOff> getAllApproved(String code) {
        String hql = " from " + TimeOff.class.getName() + " to where to.rtApprover like '%" + code
                + "%' and to.rtReason !=59 order by to.rtStatus desc, to.toStatus desc, to.rtCreateDate desc";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<TimeOff> getAllTimeOff() {
        String hql = " from " + TimeOff.class.getName() + " to "
                + " where to.rtReason !=59 order by to.rtStatus desc, to.toStatus desc, to.rtCreateDate desc ";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<TimeOff> countApprovedForManager(String code) {
        String hql = "FROM TimeOff AS  to WHERE  to.rtApprover =: code AND to.rtStatus = 2 AND to.toStatus = 1 AND to.rtReason !=59";
        List<TimeOff> list = entityManager.createQuery(hql).setParameter("code", code).getResultList();
        return list;
    }

    @Override
    public List<TimeOff> countApprovedForAdmin() {
        String hql = "FROM TimeOff AS to WHERE to.rtReason != 59 and to.rtStatus = 2 AND to.toStatus = 1";
        List<TimeOff> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public List<TotaltimeOffLog> getall() {
        String hql = "from " + TotaltimeOffLog.class.getName() + " tto";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public boolean addTotaltimeOffLog(TotaltimeOffLog ttO) {
        // TODO Auto-generated method stub
        entityManager.persist(ttO);
        return true;
    }

    @Override
    public TotaltimeOffLog getbyid(Integer id) {
        TotaltimeOffLog test = entityManager.find(TotaltimeOffLog.class, id);
        return test;
    }

    @Override
    public void updateTotalTimeOff(Integer id, Date createDate, Integer totalTimeOff) {
        TimeOff timeOff = entityManager.find(TimeOff.class, id);
        timeOff.setTot_Timeoff(totalTimeOff);
        entityManager.merge(timeOff);
    }

    @Override
    public List<TimeoffLog> getDetailTimeoffLogXN(String username, String date) {
        String hql = "from " + TimeoffLog.class.getName() + " t where t.usercode like '%" + username + "%'"
                + "and DATE_FORMAT(t.daywork,'%m-%Y') = " + "'" + date + "'" + " and t.timeoff_type like '%" + "Xin nghỉ" + "%' order by t.daywork asc";
        System.out.println(hql);
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<TimeoffLog> getDetailTimeoffLogOS(String username, String date) {
        String hql = "from " + TimeoffLog.class.getName() + " t where t.usercode like '%" + username + "%'"
                + "and DATE_FORMAT(t.daywork,'%m-%Y') = " + "'" + date + "'" + " and t.timeoff_type like '%" + "Onsite" + "%' order by t.daywork asc";
        System.out.println(hql);
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]>
    countotalXN(String userCode, String date) {
        String hql = "select SUM(t.labor),t.usercode from "+ TimeoffLog.class.getName()+" t where t.usercode like '%" + userCode + "%'"
                + "and DATE_FORMAT(t.daywork,'%m-%Y') = " + "'" + date + "'" + " and t.timeoff_type like '%" + "Xin nghỉ" + "%'"
                +"group by t.usercode";
        return  entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> CounttotalOS(String userCode, String date) {
        String hql = "select SUM(t.labor),t.usercode from "+ TimeoffLog.class.getName()+" t where t.usercode like '%" + userCode + "%'"
                + "and DATE_FORMAT(t.daywork,'%m-%Y') = " + "'" + date + "'" + " and t.timeoff_type like '%" + "Onsite" + "%'"
                +"group by t.usercode";
        return  entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<TimeOff> gettTimeOffDuplicateInMonth(Integer userid, String DateBegin) {
        String hql = "from "+ TimeOff.class.getName() +" as to where to.rtUser =" + userid + " and  MONTH(to.rtLeaveDateBegin) = MONTH('"+DateBegin+"') and ( to.toStatus=1 or to.toStatus =3 ) and to.rtStatus != 0 and to.rtReason = 59 ";
        return entityManager.createQuery(hql).getResultList();
    }


}
