package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.DepartmentDAO;
import vn.vissoft.portal.entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Department> getAllDept() {
        String hql = "FROM Department as d WHERE d.status = 1";
        return (List<Department>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Department getDeptById(Integer deptId) {
        String hql = "FROM Department AS d WHERE d.deptId =: deptId AND d.status = 1";
        List<Department> lstResult = entityManager.createQuery(hql).setParameter("deptId", deptId).getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }

    ;

    @Override
    public boolean deptExists(Department department) {
        // TODO Auto-generated method stub
        String hql = "FROM Department as d WHERE d.status = 1 AND d.deptCode = :deptCode";
        return entityManager.createQuery(hql).setParameter("deptCode", department.getDeptCode()).getResultList().size() > 0 ? true : false;
    }

    @Override
    public void addDept(Department department) {
        entityManager.persist(department);
    }

    @Override
    public void updateDept(Department department) {
        entityManager.merge(department);
    }

    @Override
    public void deleteByDeptId(Integer deptId) {
        Department deptResponses = getDeptById(deptId);
        deptResponses.setStatus(0);
        entityManager.merge(deptResponses);
    }

    @Override
    public List<Department> searchDeptByCondition(int page, int pageSize, String columnSortName, Boolean asc, String deptCode, String deptName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Department> from = criteriaQuery.from(Department.class);

        CriteriaQuery<Object> select = criteriaQuery.select(from);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(criteriaBuilder.equal(from.get("status"), 1));

        if (deptCode != null && !deptCode.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("deptCode"), "%" + deptCode + "%"));
        }

        if (deptName != null && !deptName.equals("")) {
            predicates.add(criteriaBuilder.like(from.get("deptName"), "%" + deptName + "%"));
        }

        select.select(from).where(predicates.toArray(new Predicate[]{}));


        Query query = entityManager.createQuery(criteriaQuery);


        List<Department> lstResult = query.getResultList();
        return lstResult;
    }

}
