package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.TimeoffLogDAO;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.TimeoffLog;
import vn.vissoft.portal.entities.timeOffLaborResult;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;


@Repository
public class TimeoffLogDAOImpl implements TimeoffLogDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean addTimeoffLog(TimeoffLog timeoffLog) {
        entityManager.merge(timeoffLog);
        return true;
    }

    @Override
    public boolean addTimeoffLogDuplicate(TimeoffLog timeoffLog) {
        entityManager.merge(timeoffLog);
        return true;
    }

    @Override
    public boolean addTimeoffHalfaDay(TimeoffLog timeoffLog) {
        entityManager.merge(timeoffLog);
        return true;
    }

    @Override
    public List<TimeoffLog> getTimeOffByUserCode(String code) {
        String hql = "FROM TimeoffLog WHERE permission = 1 AND usercode =: code AND timeoff_type LIKE 'Xin nghỉ'";
        List<TimeoffLog> list = entityManager.createQuery(hql).setParameter("code", code).getResultList();
        return list;
    }

    @Override
    public List<TimeoffLog> getTimeOffInMonthByUserCode(String userCode, String date) {
        String hql = "FROM TimeoffLog AS tl WHERE tl.permission = 1 AND tl.usercode =: userCode AND MONTH(tl.daywork) =: toDate AND tl.timeoff_type LIKE 'Xin nghỉ'";
        List<TimeoffLog> list = entityManager.createQuery(hql).setParameter("userCode", userCode).setParameter("toDate", Integer.parseInt(date)).getResultList();
        return list;
    }


    @Override
    public List<TimeoffLog> sumTotalTimeOffInMonth(String userCode) {
        String hql = "FROM TimeoffLog AS tol WHERE tol.usercode =: userCode AND MONTH(tol.daywork) = MONTH(NOW()) AND tol.timeoff_type LIKE 'Xin nghỉ' " +
                "GROUP BY tol.daywork";
        List<TimeoffLog> list = entityManager.createQuery(hql).setParameter("userCode", userCode).getResultList();
        return list;
    }

    @Override
    public List<TimeoffLog> getTotalTimeOffPermissionInMonth(String userCode, String date) {
        String hql = "FROM TimeoffLog AS tol WHERE tol.permission = 1 AND tol.usercode =: userCode AND MONTH(tol.daywork) =: date AND tol.timeoff_type LIKE 'Xin nghỉ' " +
                "GROUP BY tol.daywork";
        List<TimeoffLog> list = entityManager.createQuery(hql).setParameter("userCode", userCode).setParameter("date" ,Integer.parseInt(date)).getResultList();
        return list;
    }

    @Override
    public timeOffLaborResult getTimeOffDate(Integer userId, String userCode) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("getTimeOff")
                .registerStoredProcedureParameter(
                        "userId",
                        Integer.class,
                        ParameterMode.IN
                )
                .registerStoredProcedureParameter(
                        "userCode",
                        String.class,
                        ParameterMode.IN
                )
                .registerStoredProcedureParameter(
                        "outDuocNghi",
                        Integer.class,
                        ParameterMode.OUT
                ).registerStoredProcedureParameter(
                        "outNghiCoLuong",
                        Integer.class,
                        ParameterMode.OUT
                ).registerStoredProcedureParameter(
                        "outNghiKhongLuong",
                        Integer.class,
                        ParameterMode.OUT
                ).registerStoredProcedureParameter(
                        "outConLai",
                        Integer.class,
                        ParameterMode.OUT
                );
        query.setParameter("userId", userId);
        query.setParameter("userCode", userCode);
        query.execute();

        timeOffLaborResult timeOffLaborResult = new timeOffLaborResult();
        timeOffLaborResult.setToLabor(Integer.parseInt(query.getOutputParameterValue("outDuocNghi").toString()));
        timeOffLaborResult.setUserId(userId);
        timeOffLaborResult.setToTimeOff(Integer.parseInt(query.getOutputParameterValue("outNghiCoLuong").toString()));
        timeOffLaborResult.setToTimeOff(Integer.parseInt(query.getOutputParameterValue("outNghiKhongLuong").toString()));
        timeOffLaborResult.setToTimeOffLeft(Integer.parseInt(query.getOutputParameterValue("outConLai").toString()));
        return timeOffLaborResult;
    }

    @Override
    public List<TimeoffLog> getExistLog(String usercode, String date) {
        String hql = " from TimeoffLog AS tol WHERE tol.usercode =  '"+usercode+"' and tol.daywork = '"+date+"' and  tol.timeoff_type = 'Onsite' and tol.labor = 1";
        System.out.println(hql);
         List<TimeoffLog> lst = entityManager.createQuery(hql).getResultList();
        return lst;
    }

    @Override
    public Reason getReasonbyCode(String code) {
        String hql = "from "+Reason.class.getName()+" rs where rs.rCode =" +"'"+code+"'";
        List<Reason>rs = entityManager.createQuery(hql).getResultList();
        if (rs != null && rs.size() > 0) {
            return rs.get(0);
        }
        return null;


    }
}
