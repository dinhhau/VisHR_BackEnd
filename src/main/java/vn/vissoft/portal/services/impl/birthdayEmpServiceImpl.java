package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.BirthdayEmpDAO;
import vn.vissoft.portal.entities.Notify;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.services.BirthdayEmpService;
import vn.vissoft.portal.services.NotifyService;
import vn.vissoft.portal.services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service
public class birthdayEmpServiceImpl implements BirthdayEmpService {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Date getDate = new Date();

    @Autowired
    private BirthdayEmpDAO birthdayEmpDAO;

    @Autowired
    NotifyService ntfS;

    @Autowired
    UserService userService;

    @Override
    public List<User> getUserBirthdayByMounth() {
        // TODO Auto-generated method stub
        return birthdayEmpDAO.getUserBirthdayByMounth();
    }

    @Override
    public List<User> getUserByCondition(int page, int pageSize, String columnSortName, Boolean asc, String fromdate,
                                         String todate, Integer status) {
        return birthdayEmpDAO.getUserByCondition(page, pageSize, columnSortName, asc, fromdate, todate, status);
    }

    @Override
    public List<Object[]> getAgeEmp() {

        return birthdayEmpDAO.getAgeEmp();
    }

    @Override
    public List<Object[]> getBirthdaysoon() {
        return birthdayEmpDAO.getBirthdaysoon();
    }

    @Override
    public List<Object[]> getBirthdayrealtime() {
        return birthdayEmpDAO.getBirthdayrealtime();

    }

    @Override
    @Async
    public void checkBirtdaySoon() {
        List<Object[]> lstBirtdaySoon = this.getBirthdaysoon();
        List<Object[]> listHaveMangementUser = userService.getEmailOfUserHr();
        if (lstBirtdaySoon.size() > 0) {
            for (Object[] list : lstBirtdaySoon) {
                Notify nf = new Notify();
                nf.setnContent("Ba ngày nữa là sinh nhật của: " + list[1]);
                nf.setnCreateDate(getDate);
                nf.setnStatus(0);
                nf.setSourceType(2);
                for (Object[] hr : listHaveMangementUser) {
                    nf.setnReceiver(hr[1].toString());
                }

                ntfS.createNotify(nf);
                System.out.println("trung"+nf.getnContent());
            }
        }
    }

    @Override
    @Async
    public void checkBirtdayRealtime() {
        List<Object[]> lstBirtdayRealTime = this.getBirthdayrealtime();

        if (lstBirtdayRealTime.size() > 0) {
            for (Object[] list : lstBirtdayRealTime) {
                Notify nf = new Notify();
                nf.setnContent("Hôm nay là sinh nhật của: " + list[1]);
                nf.setnCreateDate(getDate);
                nf.setnStatus(0);
                nf.setSourceType(3);
                nf.setnReceiver("00030");
                ntfS.createNotify(nf);
            }
        }

    }

    @Override
    public List<Object[]> getNotifybySourceType2() {

        return birthdayEmpDAO.getNotifybySourceType2();
    }

    @Override
    public List<Object[]> getNotifybySourceType3() {

        return birthdayEmpDAO.getNotifybySourceType3();
    }

    @Override
    public List<User> SearchBirtday(int page, int pageSize, String columnSortName, Boolean asc, String fromdate,
                                    String todate) {

        return birthdayEmpDAO.SearchBirtday(page, pageSize, columnSortName, asc, fromdate, todate);
    }
}
