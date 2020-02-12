package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.User;

import java.util.List;

public interface BirthdayEmpService {
    List<User> getUserBirthdayByMounth();

    List<User> getUserByCondition(int page, int pageSize, String columnSortName, Boolean asc, String fromdate,
                                  String todate, Integer status);

    List<Object[]> getAgeEmp();

    List<Object[]> getBirthdaysoon();

    List<Object[]> getBirthdayrealtime();

    List<Object[]> getNotifybySourceType2();

    List<Object[]> getNotifybySourceType3();

    void checkBirtdaySoon();

    void checkBirtdayRealtime();

    List<User> SearchBirtday(int page, int pageSize, String columnSortName, Boolean asc, String fromdate, String todate);

}
