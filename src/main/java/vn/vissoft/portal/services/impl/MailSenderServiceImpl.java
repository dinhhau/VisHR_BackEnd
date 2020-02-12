package vn.vissoft.portal.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.MailsenderDAO;
import vn.vissoft.portal.entities.MailSender;
import vn.vissoft.portal.services.MailSenderSevice;

@Service
public class MailSenderServiceImpl implements MailSenderSevice {

    @Autowired
    private MailsenderDAO mailsenderDAO;


    @Override
    public boolean addMailsend(MailSender mailSender) {
        mailSender.setStatus_mail(0);
        mailsenderDAO.addMailsend(mailSender);
        return true;
    }
}
