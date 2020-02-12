package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.entities.Profile;

@Repository
public interface ProfileReponsitory extends JpaRepository<Profile, Integer> {

    Profile findByProfileId(Integer id);
}
