package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.ReasonDAO;
import vn.vissoft.portal.entities.Reason;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReasonDAOImpl implements ReasonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Reason> getAll() {
        String hql = "from " + Reason.class.getName() + " where rType !=3 and rStatus =1  ";
        return (List<Reason>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Reason> getReasonTimeOff() {
        String hql = "from " + Reason.class.getName() + " where rStatus =1 and rID != 7 and rID != 8 and rID != 59 and rID != 3";
        return (List<Reason>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Reason> getAlls() {
        String hql = "from " + Reason.class.getName() + " where rStatus =1  ";
        return (List<Reason>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    @Transactional
    public boolean addReason(Reason reason) {
        entityManager.persist(reason);
        return true;
    }

    @Override
    public boolean Reason_Exist(Reason reason) {
        String hql = "from " + reason.getClass().getName() + " rs where rs.rCode = :reason_code";
        return entityManager.createQuery(hql).setParameter("reason_code", reason.getrCode()).getResultList().size() > 0
                ? true
                : false;
    }

    @Override
    @Transactional
    public void updateReason(Reason reason) {
        entityManager.flush();
        entityManager.merge(reason);

    }

    @Override
    @Transactional
    public void deletebyReasonCode(String re_code) {
        Reason reason = getReasonbyReasonCode(re_code);
        reason.setrStatus(0);
        entityManager.merge(reason);

    }

    @Override
    public Reason getReasonbyReasonCode(String re_code) {
        String hql = "from " + Reason.class.getName() + " re where re.rCode = :reason_code";
        @SuppressWarnings("unchecked")
        List<Reason> lstReason = entityManager.createQuery(hql).setParameter("reason_code", re_code).getResultList();
        if (lstReason != null && lstReason.size() > 0) {
            return lstReason.get(0);
        }
        return null;
    }

    @Override
    public Reason GetReasonByID(Integer re_id) {
        String hql = "from " + Reason.class.getName() + " re where re.rID = :reason_id";
        @SuppressWarnings("unchecked")
        List<Reason> lstReason = entityManager.createQuery(hql).setParameter("reason_id", re_id).getResultList();
            if (lstReason != null && lstReason.size() > 0) {
                return lstReason.get(0);
            }
        return null;
    }

    @Override
    public List<Reason> getReasonByCondition(int page, int pageSize, String columnSortName, Boolean asc,
                                             String reasonCode, String reasonName, Integer reasontype, Integer reasonMoney, Integer ReasonStatus) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = builder.createQuery();
        Root<Reason> from = criteriaQuery.from(Reason.class);
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        List<Predicate> PD = new ArrayList<Predicate>();

        if (reasonCode != null) {
            PD.add( builder.like(from.<String>get("rCode").as(String.class), "%" + reasonCode + "%"));
        }
        if (reasonName != null) {
            PD.add(builder.like(from.<String>get("rName").as(String.class), "%" + reasonName + "%"));
        }
        if (reasontype != null && reasontype != 0) {
            PD.add(builder.equal(from.get("rType"), reasontype));
        }
        if (reasonMoney != null) {
            PD.add(builder.equal(from.get("rMoney"), reasonMoney));
        }
        if (ReasonStatus != null) {
            PD.add(builder.equal(from.get("rStatus"), ReasonStatus));
        }

        select.select(from).where(PD.toArray(new Predicate[]{}));

        if (columnSortName != null && !columnSortName.equals("")) {
            if (asc == null || asc) {
                select.orderBy(builder.asc(from.get(columnSortName)));
            } else {
                select.orderBy(builder.desc(from.get(columnSortName)));
            }

        }
        Query query = entityManager.createQuery(criteriaQuery);
        List<Reason> lstResult = query.getResultList();

        return lstResult;
    }

    @Override
    public List<Reason> getREasonByCode(String ResonCode) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = builder.createQuery();
        Root<Reason> from = criteriaQuery.from(Reason.class);
        CriteriaQuery<Object> select = criteriaQuery.select(from);
        List<Predicate> PD = new ArrayList<Predicate>();

        if (ResonCode != null) {
            PD.add(builder.like(from.<String>get("rCode").as(String.class), "%" + ResonCode + "%"));
        }
        select.select(from).where(PD.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        List<Reason> lstResult = query.getResultList();

        return lstResult;
    }

    @Override
    public List<Reason> getReasonsForLeave() {
        String hql = "SELECT r FROM " + Reason.class.getName() + " r WHERE r.rType = 3 or r.rType = 4 or r.rType = 6 or r.rType = 8 ";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Reason> getReasonByid(Integer rID) {
        String hql = "from "+ Reason.class.getName()+" as rs where rs.rID = " + rID;
        return entityManager.createQuery(hql).getResultList();
    }

}
