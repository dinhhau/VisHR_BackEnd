package vn.vissoft.portal.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.NotifyDAO;
import vn.vissoft.portal.entities.Notify;
import vn.vissoft.portal.repositories.NotifyRepository;
import vn.vissoft.portal.services.NotifyService;
import vn.vissoft.portal.services.TimeOffService;

import java.util.Date;
import java.util.List;

@Service
public class NotifyServiceImp implements NotifyService {

    @Autowired
    NotifyRepository notifyRepository;

    @Autowired
    TimeOffService timeOffService;

    @Autowired
    NotifyDAO notifyDao;

    @Override
    public Notify createNotify(Notify notify) {
        return notifyRepository.save(notify);
    }

    @Override
    public List<Notify> getNotifyByReceiver(String code) {
        return notifyDao.getNotifyByNReceiver(code);
    }

    @Override
    public Notify getNotifiesByNID(Integer id) {
        return notifyRepository.getNotifiesByNID(id);
    }

    @Override
    @Async
    public void remindUnreadReport() {
        List<Object[]> numberUnreadReport = timeOffService.getTheUnreadReport();
        if (numberUnreadReport.size() > 0) {
            for (Object[] list : numberUnreadReport) {
                Notify notify = new Notify();
                notify.setnStatus(0);
                notify.setnContent("Nhắc nhở bạn có " + list[0] + " yêu cầu xin nghỉ chưa được duyệt");
                notify.setnCreateDate(new Date());
                notify.setSourceType(1);
                notify.setnReceiver(list[1].toString());

                this.createNotify(notify);
            }
        }
    }
}
