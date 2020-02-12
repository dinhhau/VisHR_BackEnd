package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.EvaluateKPIDAO;
import vn.vissoft.portal.entities.EvaluateKPI;
import vn.vissoft.portal.entities.KPI;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class EvaluateKPIDAOImpl implements EvaluateKPIDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<EvaluateKPI> getAllKPI() {
        String hql = "FROM EvaluateKPI AS e WHERE e.status = 1 ORDER BY e.id desc";
        List<EvaluateKPI> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public List<KPI> getAllByKPI() {
        String hql = "FROM KPI AS k ORDER BY k.id asc";
        List<KPI> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public List<EvaluateKPI> getKPIForManager(String manager) {
        String hql = "SELECT e FROM EvaluateKPI AS e JOIN User AS u ON e.user.id = u.id WHERE u.manager =: manager AND e.kpi.id = 7 AND e.status = 1 GROUP BY e.user.id";
        List<EvaluateKPI> list = entityManager.createQuery(hql).setParameter("manager", manager).getResultList();
        return list;
    }

    @Override
    public List<EvaluateKPI> getKPIForUser(Integer user) {
        String hql = "SELECT e FROM EvaluateKPI AS e JOIN User AS u ON e.user.id = u.id WHERE u.id =: user AND e.status = 1 ORDER BY e.kpi.id";
        List<EvaluateKPI> list = entityManager.createQuery(hql).setParameter("user", user).getResultList();
        return list;
    }

    @Override
    public List<EvaluateKPI> searchByName(String name) {
        String hql = "SELECT e FROM EvaluateKPI AS e JOIN User AS u ON e.user.id = u.id WHERE e.kpi.id = 7 AND u.fullName LIKE :name AND e.status = 1";
        List<EvaluateKPI> list = entityManager.createQuery(hql).setParameter("name", "%" + name + "%").getResultList();
        return list;
    }

    @Override
    public EvaluateKPI getKPIById(Integer id) {
        String hql = "SELECT e FROM EvaluateKPI AS e WHERE e.id =: id AND e.status = 1";
        List<EvaluateKPI> list = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void addEvaluateKPI(EvaluateKPI evaluateKPI) {
        entityManager.persist(evaluateKPI);
    }

    @Override
    public void updateEvalueteKPI(EvaluateKPI evaluateKPI) {
        EvaluateKPI evaluateKPI1 = entityManager.find(EvaluateKPI.class, evaluateKPI.getId());
        evaluateKPI1.setId(evaluateKPI.getId());
        if (evaluateKPI.getUserPoint() != null && evaluateKPI.getManagerPoint() == null) {
            evaluateKPI1.setUserPoint(evaluateKPI.getUserPoint());
            entityManager.merge(evaluateKPI1);
        } else {
            evaluateKPI1.setManagerPoint(evaluateKPI.getManagerPoint());
            evaluateKPI1.setManagerComment(evaluateKPI.getManagerComment());
            entityManager.merge(evaluateKPI1);
        }
    }

    @Override
    public void deleteEvaluateKPI(Integer id) {
        EvaluateKPI evaluateKPI = entityManager.find(EvaluateKPI.class, id);
        evaluateKPI.setStatus(0);
        entityManager.merge(evaluateKPI);
    }
}
