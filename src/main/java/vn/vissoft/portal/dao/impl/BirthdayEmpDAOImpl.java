package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.BirthdayEmpDAO;
import vn.vissoft.portal.entities.Notify;
import vn.vissoft.portal.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class BirthdayEmpDAOImpl implements BirthdayEmpDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserBirthdayByMounth() {
        String hql = "from " + User.class.getName() + " ur where MONTH(ur.birthDay) = MONTH(NOW()) and ur.status=1";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<User> getUserByCondition(int page, int pageSize, String columnSortName, Boolean asc, String fromdate,
                                         String todate, Integer status) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = builder.createQuery();
        Root<User> from = criteriaQuery.from(User.class);
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        List<Predicate> PD = new ArrayList<Predicate>();
        if (fromdate != null && todate != null) {
            PD.add(builder.between(from.<Date>get("birthDay").as(String.class), fromdate, todate));
        }
        if (status != null) {
            PD.add(builder.equal(from.get("status"), status));
        }
        select.select(from).where(PD.toArray(new Predicate[] {}));
        if (columnSortName != null && !columnSortName.equals("")) {
            if (asc == null || asc) {
                select.orderBy(builder.asc(from.get(columnSortName)));
            } else {
                select.orderBy(builder.desc(from.get(columnSortName)));
            }

        }
        Query query = entityManager.createQuery(criteriaQuery);
        List<User> lstResult = query.getResultList();

        return lstResult;
    }

    @Override
    public List<Object[]> getAgeEmp() {
        return entityManager
                .createQuery("Select ur.username, ur.fullName ,ur.birthDay, YEAR(NOW()) - YEAR(ur.birthDay) "
                        + "as age,DAY(NOW()) - DAY(ur.birthDay) as Countdown from " + User.class.getName() + " ur "
                        + "where status = 1 and MONTH(NOW()) " + "= MONTH(ur.birthDay) ")
                .getResultList();

    }

    @Override
    public List<Object[]> getBirthdaysoon() {
        return entityManager
                .createQuery("Select ur.username,ur.fullName,ur.birthDay from " + User.class.getName() + " ur "
                        + "where MONTH(NOW()) = MONTH(ur.birthDay) and DAY(NOW()) + 3 = DAY(ur.birthDay)")
                .getResultList();

    }

    @Override
    public List<Object[]> getBirthdayrealtime() {
        return entityManager.createQuery("select ur.username,ur.fullName,ur.birthDay from " + User.class.getName()
                + " ur " + "where MONTH(NOW()) = MONTH(ur.birthDay) and DAY(NOW()) = DAY(ur.birthDay)").getResultList();
    }

    @Override
    public List<Object[]> getNotifybySourceType2() {
        return entityManager.createQuery("select nf.nID , nf.nStatus, nf.sourceType from " + Notify.class.getName()
                + " nf " + "where nf.nStatus=0 and nf.sourceType=2").getResultList();
    }

    @Override
    public List<Object[]> getNotifybySourceType3() {
        return entityManager.createQuery("select nf.nID , nf.nStatus, nf.sourceType from " + Notify.class.getName()
                + " nf " + "where nf.nStatus=0 and nf.sourceType=3").getResultList();
    }

    @Override
    public List<User> SearchBirtday(int page, int pageSize, String columnSortName, Boolean asc, String fromdate,
                                    String todate) {
        String hql = "from  " + User.class.getName() + " as ur";
        if (fromdate == null && todate == null) {
//			where DATE_FORMAT(ur.birthDay,'%m-%d')
            hql = hql + " order by MONTH(ur.birthDay) asc";
        }
        if (fromdate != null && todate != null) {
//				where DATE_FORMAT(ur.birthDay,'%m-%d')
            hql = hql + " where ur.status = 1 and DATE_FORMAT(ur.birthDay,'%m')   between " + fromdate + " and "
                    + todate + " order by  DAY(ur.birthDay) asc ";
        }
        if (fromdate != null && todate == null) {
            hql = hql + " where ur.status = 1   and DATE_FORMAT(ur.birthDay,'%m')   between " + fromdate + " and "
                    + " DATE_FORMAT(DATE(NOW()),'%m')" + " order by  Month(ur.birthDay) asc ";
        }
        List<User> Lst = entityManager.createQuery(hql).getResultList();
        return Lst;
    }

}
