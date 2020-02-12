package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vissoft.portal.entities.Notify;

import java.util.List;

public interface NotifyRepository extends JpaRepository<Notify, Integer> {

    Notify getNotifiesByNID(int id);

}
