package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vissoft.portal.entities.ExtenalNotify;

public interface ExtenalRepository extends JpaRepository<ExtenalNotify, Integer> {
}
