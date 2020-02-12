package vn.vissoft.portal.dao;

import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.entities.Time_work;

import java.text.ParseException;
import java.util.List;

@Transactional
public interface RegisterIODAO {

    void UndoRequest(Integer ToID) throws ParseException;

    Time_work getTimework_byID(Integer twID);


}
