package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.TimeOffLaborDAO;
import vn.vissoft.portal.entities.TimeoffLabor;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class TimeOffLaborDAOImpl implements TimeOffLaborDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<TimeoffLabor> getAll() {
        String hql= "FROM TimeoffLabor";
        List<TimeoffLabor> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public TimeoffLabor getByUserIdAndMonth(Integer userId, String toDate) {
        String hql = "FROM TimeoffLabor AS tl WHERE tl.user.id =: userId AND MONTH(tl.timeOffDate) =: toDate";
        List<TimeoffLabor> list = entityManager.createQuery(hql).setParameter("userId", userId).setParameter("toDate", Integer.parseInt(toDate)).getResultList();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void addTimeOffLabor(TimeoffLabor timeoffLabor) {
        entityManager.persist(timeoffLabor);
    }

    @Override
    public void updateTimeOffLabor(TimeoffLabor timeoffLabor) {
        entityManager.merge(timeoffLabor);
    }
}
