package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.Department;

import java.util.Date;
import java.util.List;

public interface ContractService {

    List<Contract> getAllContract();

    List<Contract> getContractByMonth();

    void addCon(Contract contract);

    void delCon(int cId);

    void updateCon(Contract contract);

    Contract getAllById(int id);

    List<Contract> getSearch(Long contract_type, Long cUser, String contrat_no, Long dept, String startDate, String endDate,
                             Integer status);

    void checkStatus();

    Contract getByCode(String code);

    List<Contract> SearchContractByCondition(Integer contractTypeId, Integer userId, Integer deptId, String startDateFrom, String startDateTo,
                                             String endDateFrom, String endDateTo);
}
