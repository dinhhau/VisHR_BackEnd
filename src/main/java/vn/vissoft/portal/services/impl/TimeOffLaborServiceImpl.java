package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.TimeOffLaborDAO;
import vn.vissoft.portal.entities.TimeoffLabor;
import vn.vissoft.portal.services.TimeOffLaborService;

import java.util.Date;
import java.util.List;

@Service
public class TimeOffLaborServiceImpl implements TimeOffLaborService {

    @Autowired
    private TimeOffLaborDAO timeOffLaborDAO;

    @Override
    public List<TimeoffLabor> getAll() {
        return timeOffLaborDAO.getAll();
    }

    @Override
    public TimeoffLabor getByUserIdAndMonth(Integer userId, String toDate) {
        return timeOffLaborDAO.getByUserIdAndMonth(userId, toDate);
    }

    @Override
    public void addTimeOffLabor(TimeoffLabor timeoffLabor) {
        timeOffLaborDAO.addTimeOffLabor(timeoffLabor);
    }

    @Override
    public void updateTimeOffLabor(TimeoffLabor timeoffLabor) {
        timeOffLaborDAO.updateTimeOffLabor(timeoffLabor);
    }
}
