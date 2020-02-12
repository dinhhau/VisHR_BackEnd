package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.ApParamDAO;
import vn.vissoft.portal.entities.ApParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ApParamDAOImpl implements ApParamDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApParam> getallParamByParType() {
        String hql = "from " + ApParam.class.getName() + " where par_type ='REASON_TYPE' and status=1";
        return (List<ApParam>) entityManager.createQuery(hql).getResultList();

    }

}
