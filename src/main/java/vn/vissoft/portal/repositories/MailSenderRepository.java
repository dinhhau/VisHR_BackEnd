package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.vissoft.portal.entities.MailSender;

import javax.transaction.Transactional;

public interface MailSenderRepository extends JpaRepository<MailSender,Long> {
    @Modifying
    @Transactional
    @Query("update MailSender msd set msd.status_mail =:sttm where msd.type_id =:typee")
    public void UpdateMailStatus(@Param("sttm") Integer sstm , @Param("typee") Integer typpe);

    @Modifying
    @Transactional
    @Query("update MailSender msd set msd.status_mail =:sttm where msd.type_id =:typee")
    public void UpdateMailStatusU(@Param("sttm") Integer sstm , @Param("typee") Integer typpe);
}
