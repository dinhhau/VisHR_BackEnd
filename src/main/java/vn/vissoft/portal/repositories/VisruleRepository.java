package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vissoft.portal.entities.Visrules;

import java.util.List;

public interface VisruleRepository extends JpaRepository<Visrules,Long> {

    Visrules getAllByRuleid(Integer id);

    List<Visrules> getAllByRulecode(String VrlCode);


}
