package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.TitleDAO;
import vn.vissoft.portal.entities.Title;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class TitleDAOImpl implements TitleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Title> getAllTitle() {
        String hql = "FROM Title as t WHERE t.status = 1 ORDER BY t.titleId asc";
        return (List<Title>) entityManager.createQuery(hql).getResultList();
    }
}
