package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.ExtenalNotify;
import vn.vissoft.portal.entities.TimeOff;

import javax.mail.Message;
import java.text.ParseException;
import java.util.List;

public interface ExtenalService {

    void sendMail(TimeOff timeOff, String subject, String text, String[] to, List<String> cc);

    void sendMailWarring(TimeOff timeOff, String subject, String text, String[] to);

    void sendMailEvaluateKPI(String text, String subject, String[] to);

    ExtenalNotify createExtenal(TimeOff timeOff, String content, int status) throws ParseException;

    void mailResetPassword(String text, String subject, String[] to);
}
