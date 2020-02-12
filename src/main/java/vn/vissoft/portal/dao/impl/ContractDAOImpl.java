package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.ContractDAO;
import vn.vissoft.portal.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class ContractDAOImpl implements ContractDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contract> getSearchCno() {
        String hql = "select c.cno  from Contract as c";
        return (List<Contract>) entityManager.createQuery(hql).getResultList();
    }

    public List<Contract> getContractByMonth() {
        String hql = "from " + Contract.class.getName() + " c where (c.ctype.ctId = 3 OR c.ctype.ctId = 5) AND MONTH(c.startdate) = MONTH(NOW()) AND (c.status = 1 or c.status = 2) AND c.isDeleted = 1";
        List<Contract> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public List<Contract> getAllContract() {
        String hql = "from Contract as c WHERE c.isDeleted = 1 order by c.ctype, c.cno asc";
        return (List<Contract>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Contract> SearchContractByCondition(Integer contractTypeId, Integer userId, Integer deptId, String startDateFrom, String startDateTo,
                                                    String endDateFrom, String endDateTo) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<Contract> from = criteriaQuery.from(Contract.class);
//        Root<User> userRoot = criteriaQuery.from(User.class);

        Join<Contract, User> user = from.join("cUser", JoinType.INNER);
        Join<Contract, ContractType> contractType = from.join("ctype", JoinType.INNER);
//        Join<User, Department> department = user.join("department", JoinType.LEFT);

        CriteriaQuery<java.lang.Object> select = criteriaQuery.select(from);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(criteriaBuilder.equal(from.get("isDeleted"), 1));

        if (startDateFrom != null && endDateFrom != null) {
            predicates.add(criteriaBuilder.between(from.get("startdate"), startDateFrom, endDateFrom));
        }

        if (startDateFrom != null && endDateFrom != null) {
            predicates.add(criteriaBuilder.between(from.get("enddate"), startDateFrom, endDateFrom));
        }

        if (contractTypeId != null && !contractTypeId.equals("")) {
            predicates.add(criteriaBuilder.equal(contractType.get("ctId"), contractTypeId));
        }

        if (userId != null && !userId.equals("")) {
            predicates.add(criteriaBuilder.equal(user.get("id"), userId));
        }

//        if (deptId != null && !deptId.equals("")) {
//            predicates.add(criteriaBuilder.like(department.get("deptId"), "%" + deptId + "%"));
//        }

        select.select(from).where(predicates.toArray(new Predicate[]{}));
        Query query = entityManager.createQuery(criteriaQuery);
        List<Contract> lstResult = query.getResultList();
        return lstResult;
    }

    @Override
    public void addCon(Contract contract) {
        entityManager.persist(contract);
    }

    @Override
    public void delCon(int cId) {
        entityManager.remove(entityManager.find(Contract.class, cId));
    }

    @Override
    public void updateCon(Contract contract) {
        entityManager.merge(contract);
    }

}
