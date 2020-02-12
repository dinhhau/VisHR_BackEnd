package vn.vissoft.portal.services;

import java.util.List;

import vn.vissoft.portal.entities.EmpWorkDetail;

public interface TotalLaborService {
    List<EmpWorkDetail> getDetailLaborByUserCode(String userCode, String date);

    List<Object[]> getTotalLaborCondition(int page, int pageSize, String columnSortName, Boolean asc, String userid, String dateSearch);
}
