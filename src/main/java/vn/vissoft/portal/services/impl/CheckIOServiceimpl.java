package vn.vissoft.portal.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.CheckIODAO;
import vn.vissoft.portal.entities.EmpTime;
import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.repositories.CheckIOReponsitory;
import vn.vissoft.portal.services.CheckIOService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckIOServiceimpl implements CheckIOService {

    private static final Logger LOG = LoggerFactory.getLogger(CheckIOServiceimpl.class);

    @Autowired
    private CheckIOReponsitory checkIOReponsitory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CheckIODAO checkIODao;

    public List<EmpWorkDetail> getAllCheck() {
        return checkIODao.getAllCheck();
    }

    @Override
    public void addCheck(EmpWorkDetail empworkdetail) {
        checkIODao.addCon(empworkdetail);
    }


    @Override
    public List<EmpWorkDetail> getSearch(EmpTime emp) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            StringBuilder hql = new StringBuilder();
            hql.append("select c from EmpWorkDetail as c where 1=1");
            if (!"".equals(emp.getId()) && emp.getId() != null) {
                hql.append(" and c.id like \'%" + emp.getId() + "%\'");
            }
            if (!"".equals(emp.getEname()) && emp.getEname() != null) {
                hql.append(" and c.ename like \'%" + emp.getEname() + "%\'");
            }
            if ((!"".equals(emp.getStartDate()) && emp.getStartDate() != null) &&
                    (!"".equals(emp.getEndDate()) && emp.getEndDate() != null)) {
                hql.append(" and c.workdate >= '" + simpleDateFormat.format(emp.getStartDate()) + "'"
                        + " and c.workdate <= '" + simpleDateFormat.format(emp.getEndDate()) + "'");
            }
            return entityManager.createQuery(hql.toString()).getResultList();
        } catch (Exception e) {
            LOG.error(e.toString());
            return new ArrayList<>();
        }
    }
}
