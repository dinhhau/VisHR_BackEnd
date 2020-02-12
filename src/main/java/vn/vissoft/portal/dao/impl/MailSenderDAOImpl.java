package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.MailsenderDAO;
import vn.vissoft.portal.entities.MailSender;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.TimeOff;
import vn.vissoft.portal.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class MailSenderDAOImpl implements MailsenderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean addMailsend(MailSender mailSender) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        entityManager.persist(mailSender);
        return true;
    }

    @Override
    public List<Object[]> getByTypeofMailCreate() {
        String hql = "select ur.fullName,ur.username ,msd.leave_date_begin,msd.leave_date_end" +
                ",rs.rName,msd.decription,msd.manager_lvl2,msd.approved,rs.rType  from "
                + MailSender.class.getName() + "  msd join " + User.class.getName() + " ur on msd.user_id = ur.id"
                + " join " + Reason.class.getName() + " rs on msd.reason = rs.rID"
                + " where msd.type_id = 1 and msd.status_mail =0";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getBytypeofMailChange() {
        String hql = "select ur.fullName,ur.username ,msd.leave_date_begin,msd.leave_date_end" +
                ",rs.rName,msd.decription,msd.manager_lvl2,msd.approved,msd.approved_date,msd.status_to,ur.email,msd.note  from "
                + MailSender.class.getName() + "  msd join " + User.class.getName() + " ur on msd.user_id = ur.id"
                + " join " + Reason.class.getName() + " rs on msd.reason = rs.rID"
                + " where msd.type_id = 2 and msd.status_mail =0";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<TimeOff> getTimeoffNotApproved() {
        String hql = "FROM TimeOff AS to WHERE to.rtStatus = 2 AND to.toStatus = 1";
        List<TimeOff> list = entityManager.createQuery(hql).getResultList();
        return list;
    }
}
