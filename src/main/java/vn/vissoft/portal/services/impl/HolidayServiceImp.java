package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.HolidayDAO;
import vn.vissoft.portal.entities.Holiday;
import vn.vissoft.portal.repositories.HolidayRepository;
import vn.vissoft.portal.services.HolidayService;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayServiceImp implements HolidayService {

    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    HolidayDAO holidayDAO;

    @Override
    public List<Holiday> getAllHolidays() {
        return holidayDAO.findAllHolidays();
    }

    @Override
    public Holiday createOrUpdateHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public void deleteHoliday(Holiday holiday) {
        holiday.setStatus(0);
        holidayRepository.save(holiday);
    }

    @Override
    public Optional<Holiday> findByIdHoliday(int hID) {
        return holidayRepository.findById(hID);
    }

    @Override
    public Holiday findByCode(String code) {
        return holidayRepository.findByHCode(code);
    }

    @Override
    public boolean checkCodeConflict(String code) {
        Holiday holiday = this.findByCode(code);
        if (holiday != null) {
            return false;
        } else {
            return true;
        }
    }
}
