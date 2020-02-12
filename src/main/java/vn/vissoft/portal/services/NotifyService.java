package vn.vissoft.portal.services;

import org.springframework.scheduling.annotation.Async;
import vn.vissoft.portal.entities.Notify;

import java.util.List;

public interface NotifyService {

    Notify createNotify(Notify notify);

    List<Notify> getNotifyByReceiver(String code);

    Notify getNotifiesByNID(Integer id);

    @Async
    void remindUnreadReport();

}
