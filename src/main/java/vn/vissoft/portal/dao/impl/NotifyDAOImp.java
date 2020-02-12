package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.NotifyDAO;
import vn.vissoft.portal.entities.Notify;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NotifyDAOImp implements NotifyDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Notify> getNotifyByNReceiver(String code) {
        return entityManager.createQuery("SELECT n FROM " + Notify.class.getName() + " n WHERE n.nReceiver LIKE '" + code + "' and n.statushide=1 ORDER BY n.nCreateDate DESC")
                .getResultList();
    }
}
