package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.CreateIdeaDAO;
import vn.vissoft.portal.entities.CreateIdea;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class CreateIdeaDAOImpl implements CreateIdeaDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CreateIdea> getAllCreateIdea() {
        String hql = "FROM CreateIdea as ci WHERE ci.status = 1";
        List<CreateIdea> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public CreateIdea getCreateIdeaById(Integer id) {
        String hql = "FROM CreateIdea AS ci WHERE ci.id =: id AND ci.status = 1";
        List<CreateIdea> lstResult = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            return lstResult.get(0);
        }
        return null;
    }

    @Override
    public List<CreateIdea> getCreateIdeaByUserId(Integer userId) {
        String hql = "SELECT ci FROM CreateIdea AS ci JOIN User AS u ON ci.user = u.id WHERE u.id =: userId AND ci.status = 1";
        List<CreateIdea> lstResult = entityManager.createQuery(hql).setParameter("userId", userId).getResultList();
        return lstResult;
    }

    @Override
    public void addCreateIdea(CreateIdea createIdea) {
        entityManager.persist(createIdea);
    }

    @Override
    public void updateCreateIdea(CreateIdea createIdea) {
        entityManager.merge(createIdea);
    }

    @Override
    public void deleteCreateById(Integer id) {
        CreateIdea createIdea = entityManager.find(CreateIdea.class, id);
        createIdea.setStatus(0);
        entityManager.merge(createIdea);
    }
}
