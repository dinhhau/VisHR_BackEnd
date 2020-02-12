package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.TitleDAO;
import vn.vissoft.portal.entities.Title;
import vn.vissoft.portal.repositories.TitleRepository;
import vn.vissoft.portal.services.TitleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service(value = "TitleService")
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDAO titleDao;

    @Autowired
    private TitleRepository titlerp;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Title> getAllTitle() {
        String hql = "SELECT t FROM Title as t WHERE t.status=1";
        List<Title> lst = entityManager.createQuery(hql).getResultList();
        return lst;
    }

    @Override
    public void update(Title title) {
        titlerp.save(title);

    }

    @Override
    public void save(Title title) {
        titlerp.save(title);

    }

    @Override
    public List<Title> findTitle(String code, String name) {

        return titlerp.findTitle(code, name);
    }
}
