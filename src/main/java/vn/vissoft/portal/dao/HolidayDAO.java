package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.Holiday;

import java.util.List;

public interface HolidayDAO {

    List<Holiday> findAllHolidays();

}
