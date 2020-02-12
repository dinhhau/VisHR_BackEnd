package vn.vissoft.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.vissoft.portal.entities.MailSender;
import vn.vissoft.portal.entities.TimeOff;

import javax.transaction.Transactional;
import java.util.List;

public interface MailsenderDAO  {

    boolean addMailsend(MailSender mailSender);

    List<Object[]>  getByTypeofMailCreate();

    List<Object[]> getBytypeofMailChange();

    List<TimeOff> getTimeoffNotApproved();
}
