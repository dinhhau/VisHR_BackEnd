package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vissoft.portal.entities.PasswordResetToken;

public interface TokenRepository extends JpaRepository<PasswordResetToken, Integer> {

    PasswordResetToken findByToken(String token);
}
