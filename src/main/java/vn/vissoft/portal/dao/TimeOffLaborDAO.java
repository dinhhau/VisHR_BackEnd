package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.TimeoffLabor;
import java.util.Date;
import java.util.List;

public interface TimeOffLaborDAO {

    List<TimeoffLabor> getAll();

    TimeoffLabor getByUserIdAndMonth(Integer userId, String toDate);

    void addTimeOffLabor(TimeoffLabor timeoffLabor);

    void updateTimeOffLabor(TimeoffLabor timeoffLabor);
}
