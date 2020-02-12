package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.CheckIODAO;
import vn.vissoft.portal.entities.EmpWorkDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CheckIODAOImpl implements CheckIODAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmpWorkDetail> getAllCheck() {
        String hql ="from " + EmpWorkDetail.class.getName() +" empd where empd.stdate != 'Onsite' order by empd.workdate desc ";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addCon(EmpWorkDetail empWorkDetail) {
        entityManager.merge(empWorkDetail);
    }
}
