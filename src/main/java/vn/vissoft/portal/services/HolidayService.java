package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Holiday;

import java.util.List;
import java.util.Optional;

public interface HolidayService {

    List<Holiday> getAllHolidays();

    Holiday createOrUpdateHoliday(Holiday holiday);

    void deleteHoliday(Holiday holiday);

    Optional<Holiday> findByIdHoliday(int hID);

    Holiday findByCode(String code);

    boolean checkCodeConflict(String code);

}
