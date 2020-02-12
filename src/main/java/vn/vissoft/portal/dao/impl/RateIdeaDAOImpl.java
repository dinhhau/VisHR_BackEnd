package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.RateIdeaDAO;
import vn.vissoft.portal.entities.CreateIdea;
import vn.vissoft.portal.entities.RateIdea;
import vn.vissoft.portal.entities.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class RateIdeaDAOImpl implements RateIdeaDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<RateIdea> getAllRateIdea() {
        String hql = "FROM RateIdea as ri WHERE ri.status = 1";
        List<RateIdea> list = entityManager.createQuery(hql).getResultList();
        return list;
    }

    @Override
    public List<RateIdea> getRateIdeaById(Integer id) {
        String hql = "FROM RateIdea AS ri WHERE ri.rateIdeaId =: id AND ri.status = 1";
        List<RateIdea> lstResult = entityManager.createQuery(hql).setParameter("id", id).getResultList();
        return lstResult;
    }

    @Override
    public List<RateIdea> getRateIdeaByUserId(Integer userId) {
        String hql = "SELECT ri FROM RateIdea AS ri JOIN User AS u ON ri.user = u.id WHERE u.id =: userId AND ri.status = 1";
        List<RateIdea> lstResult = entityManager.createQuery(hql).setParameter("userId", userId).getResultList();
        return lstResult;
    }

    @Override
    public List<RateIdea> getRateIdeaByCreateIdeaId(Integer createIdeaId) {
        String hql = "SELECT ri FROM RateIdea AS ri JOIN CreateIdea AS ci ON ri.createIdea = ci.id WHERE ci.id =:createIdeaId AND ri.status = 1";
        List<RateIdea> lstResult = entityManager.createQuery(hql).setParameter("createIdeaId", createIdeaId).getResultList();
        return lstResult;
    }

    @Override
    public Optional<RateIdea> getRateIdeaByUserIdAndCreateIdeaId(Integer userId, Integer createIdeaId) {
        String hql = "SELECT ri FROM CreateIdea AS ci JOIN RateIdea AS ri ON ci.createIdeaId = ri.createIdea.createIdeaId JOIN User AS u ON ri.user.id = u.id WHERE u.id =: userId AND ci.createIdeaId =: createIdeaId AND ri.status = 1";
        return entityManager.createQuery(hql)
                .setParameter("userId", userId).setParameter("createIdeaId", createIdeaId)
                .getResultList().stream().findFirst();
    }

    @Override
    public void addRateIdea(RateIdea rateIdea, Integer userId, Integer createIdeaId) {
        User user = entityManager.find(User.class, userId);
        CreateIdea createIdea = entityManager.find(CreateIdea.class, createIdeaId);
        rateIdea.setUser(user);
        rateIdea.setCreateIdea(createIdea);
        entityManager.persist(rateIdea);
    }

    @Override
    public void updateRateIdea(RateIdea rateIdea) {
        entityManager.merge(rateIdea);
    }

    @Override
    public void deleteRateIdea(Integer id) {
        RateIdea rateIdea = entityManager.find(RateIdea.class, id);
        rateIdea.setStatus(0);
        entityManager.merge(rateIdea);
    }
}
