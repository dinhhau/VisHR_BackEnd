package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Visrules;

import java.util.List;

public interface VisrulesService {

    boolean addVisrules(Visrules visrules);


    void updateVisrules(Visrules visrules);

    void deleteVisrules(Integer ruleid);

    Visrules getVisrule_byid(Integer visid);

    List<Visrules> searchVisruleEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc, String rulecode);
    List<Visrules> getall();

    List<Visrules> getBycode(Integer VrlCode);
}
