package vn.vissoft.portal.dao;

import org.springframework.scheduling.annotation.Async;
import vn.vissoft.portal.entities.User;

import java.util.List;

public interface BirthdayEmpDAO {
    List<User> getUserBirthdayByMounth();

    List<User> getUserByCondition(int page, int pageSize, String columnSortName, Boolean asc, String fromdate,
                                  String todate, Integer status);

    List<Object[]> getAgeEmp();

    @Async
    List<Object[]> getBirthdaysoon();

    @Async
    List<Object[]> getBirthdayrealtime();

    List<Object[]> getNotifybySourceType2();

    List<Object[]> getNotifybySourceType3();

    List<User> SearchBirtday(int page, int pageSize, String columnSortName, Boolean asc, String fromdate, String todate);


}
