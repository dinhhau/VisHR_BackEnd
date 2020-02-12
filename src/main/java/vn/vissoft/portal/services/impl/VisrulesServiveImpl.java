package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.VisRulesDAO;
import vn.vissoft.portal.entities.Visrules;
import vn.vissoft.portal.services.VisrulesService;

import java.util.List;

@Service
public class VisrulesServiveImpl implements VisrulesService {

    @Autowired
    VisRulesDAO visRulesDAO;

    @Override
    public boolean addVisrules(Visrules visrules) {
        if(visRulesDAO.VisrulesExist(visrules)){
            return false;
        }else
        visRulesDAO.addVisrules(visrules);
        return true;
    }

    @Override
    public void updateVisrules(Visrules visrules) {
        visRulesDAO.updateVisrules(visrules);
    }

    @Override
    public void deleteVisrules(Integer ruleid) {
        visRulesDAO.deleteVisrules(ruleid);
    }

    @Override
    public Visrules getVisrule_byid(Integer visid) {
        return visRulesDAO.getVisrule_byid(visid);
    }

    @Override
    public List<Visrules> searchVisruleEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc, String rulecode) {
        return visRulesDAO.searchVisruleEmpByCondition(page, pageSize, columnSortName, asc, rulecode);
    }

    @Override
    public List<Visrules> getall() {
        return visRulesDAO.getall();
    }

    @Override
    public List<Visrules> getBycode(Integer VrlCode) {
        return  visRulesDAO.getBycode(VrlCode);
    }
}
