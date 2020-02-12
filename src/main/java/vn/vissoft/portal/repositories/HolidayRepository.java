package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vissoft.portal.entities.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

    Holiday findByHCode(String hCode);

}
