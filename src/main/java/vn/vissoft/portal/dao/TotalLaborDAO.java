package vn.vissoft.portal.dao;

import java.util.List;

import vn.vissoft.portal.entities.EmpWorkDetail;

public interface TotalLaborDAO {
    List<EmpWorkDetail> getDetailLaborByUserCode(String userCode, String date);

    List<Object[]> getTotalLaborCondition(int page, int pageSize, String columnSortName, Boolean asc, String userid, String dateSearch);
}
