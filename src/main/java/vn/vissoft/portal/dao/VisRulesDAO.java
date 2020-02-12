package vn.vissoft.portal.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.entities.Visrules;

import javax.persistence.*;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public interface VisRulesDAO {
    boolean addVisrules(Visrules visrules);
    boolean VisrulesExist(Visrules visrules);

    void updateVisrules(Visrules visrules);

    void deleteVisrules(Integer ruleid);

    Visrules getVisrule_byid(Integer visid);

    List<Visrules> searchVisruleEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc, String rulecode);

    List<Visrules> getall();

    List<Visrules> getBycode(Integer VrlCode);


}
