package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.RegisterIODAO;
import vn.vissoft.portal.entities.Notify;
import vn.vissoft.portal.entities.Time_work;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Repository
public class RegisterIODAOImpl implements RegisterIODAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void UndoRequest(Integer ToID) throws ParseException {
        try {
            Date date = new Date();
            Time_work tw = getTimework_byID(ToID);
            Notify nf = new Notify();
            tw.setIs_deleted(1);
            nf.setnContent("Đơn đăng kí giờ đi làm của " + tw.getEmployee().getFullName() + " Đã bị thu hồi");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date nCreateDate = (Date) dateFormat.parse(date.toString());
            nf.setnCreateDate(nCreateDate);
            nf.setSourceType(1);
            nf.setnStatus(0);
            nf.setnReceiver(tw.getManager());
            nf.setnSender(tw.getEmployee());
            entityManager.merge(tw);
            entityManager.persist(nf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Time_work getTimework_byID(Integer twID) {
        String hql = " from  " + Time_work.class.getName() + " tw where tw.timeworkid = :rtID";
        List<Time_work> TWEmpsLst = entityManager.createQuery(hql).setParameter("rtID", twID).getResultList();
        if (TWEmpsLst != null && TWEmpsLst.size() > 0) {
            return TWEmpsLst.get(0);
        }
        return null;
    }
}
