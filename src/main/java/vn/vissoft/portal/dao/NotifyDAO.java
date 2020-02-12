package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.Notify;

import java.util.List;

public interface NotifyDAO {

    List<Notify> getNotifyByNReceiver(String code);

}
