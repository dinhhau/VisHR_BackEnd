package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query("update User ur set ur.toLbor =:ttlb where ur.id =:urID"
    )
    public void UpdateTotalLabor(@Param("ttlb") Integer ttlb, @Param("urID") Integer urID);


    @Modifying
    @Transactional
    @Query(" update User ur set ur.startTimeWork =:stTW , ur.endTimeWork =:eTW where ur.id =:urID"
    )
    public void UpdateTimeWork(@Param("stTW") String Starttimework, @Param("urID") Integer urID, @Param("eTW") String endTimework);


    @Modifying
    @Transactional
    @Query(" update User ur set ur.startTimeWork = '08:45' , ur.endTimeWork ='18:00' where ur.id =:urID"
    )
    public void UndoTimeWork(@Param("urID") Integer urID);
}
