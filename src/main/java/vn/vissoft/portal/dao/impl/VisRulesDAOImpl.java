package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.VisRulesDAO;
import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.entities.Visrules;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class VisRulesDAOImpl implements VisRulesDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean addVisrules(Visrules visrules) {
        Date date = Calendar.getInstance().getTime();
        visrules.setStatus(1);
        visrules.setCreatedate(date);
        entityManager.persist(visrules);
        return true;
    }

    @Override
    public boolean VisrulesExist(Visrules visrules) {
        String hql = " from " + Visrules.class.getName() +" vrl where vrl.rulecode=:rulecode";
        return entityManager.createQuery(hql).setParameter("rulecode",visrules.getRulecode()).getResultList().size()>0?true:false;
    }

    @Override
    @Transactional
    public void updateVisrules(Visrules visrules) {
        entityManager.flush();
        entityManager.merge(visrules);
    }

    @Override
    @Transactional
    public void deleteVisrules(Integer ruleid) {
        Visrules visrules = getVisrule_byid(ruleid);
        visrules.setStatus(0);
        entityManager.merge(visrules);

    }

    @Override
    public Visrules getVisrule_byid(Integer visid) {
        String hql = "from " + Visrules.class.getName() + " vrl where vrl.ruleid =:ruleeid";
        List<Visrules> getbyid = entityManager.createQuery(hql).setParameter("ruleeid", visid).getResultList();
        if (getbyid != null && getbyid.size() > 0) {
            return getbyid.get(0);

        }
        return null;
    }

    @Override
    public List<Visrules> searchVisruleEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc, String rulecode) {
        String hql = "from " + Visrules.class.getName() + " vrl where vrl.status=1";


        if (rulecode != null) {
            hql = hql + " and vrl.rulecode =" + "'"+rulecode+"'";
            System.out.println(hql);
        }

        List<Visrules> vrlList = entityManager.createQuery(hql).getResultList();
        return vrlList;
    }

    @Override
    public List<Visrules> getall() {
        String hql = "from " + Visrules.class.getName() + " r where r.status =1 order by r.createdate desc";

        return (List<Visrules>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Visrules> getBycode(Integer VrlCode) {
        String hql = " from " + Visrules.class.getName() +" vrl where vrl.rulecode='"+VrlCode+"'";
        return entityManager.createQuery(hql).getResultList();
    }

}
