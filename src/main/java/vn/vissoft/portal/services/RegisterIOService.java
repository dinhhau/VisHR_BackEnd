package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Time_work;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface RegisterIOService {

    Time_work createOrupdateRegesterIO(Time_work time_work) throws ParseException;

    Date convertToUTC(Date date) throws ParseException;

    void UndoRequest(Integer ToID) throws ParseException;

    public List<Object[]> getListDate(Date dateStart , Date dateEnd);

    boolean getAllbyUserid(Integer userid, Date Datend) throws ParseException;


}
