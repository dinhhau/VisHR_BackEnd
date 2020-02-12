package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.Department;

import java.util.Date;
import java.util.List;

public interface ContractDAO {
    List<Contract> getAllContract();

    List<Contract> getSearchCno();

    List<Contract> getContractByMonth();

    void addCon(Contract contract);

    void delCon(int cId);

    void updateCon(Contract contract);

    List<Contract> SearchContractByCondition(Integer contractTypeId, Integer userId, Integer deptId, String startDateFrom, String startDateTo,
                                             String endDateFrom, String endDateTo);
}
