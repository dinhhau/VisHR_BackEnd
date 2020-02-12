package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.TimeOff;

import java.util.List;

public interface ReasonRepository extends JpaRepository<Reason, Integer> {

//    @Modifying
//    @Transactional
//    @Query("from Reason as rs where  rs.rType =:Rtype"
//    )
//    Reason getReason(@Param("Rtype") Integer Rtype);

}
