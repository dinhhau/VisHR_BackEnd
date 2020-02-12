package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.HolidayDAO;
import vn.vissoft.portal.entities.Holiday;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HolidayDAOImp implements HolidayDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Holiday> findAllHolidays() {
        String hql = "SELECT h FROM " + Holiday.class.getName() + " h WHERE h.status = 1 ";
        return entityManager.createQuery(hql).getResultList();
    }
}
