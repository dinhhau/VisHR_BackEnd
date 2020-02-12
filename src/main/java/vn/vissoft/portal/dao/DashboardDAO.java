package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.EmpWorkDetail;

import java.util.List;

public interface DashboardDAO {

	List<Object[]> getBonusempinMonth();

	List<Object[]> getBonusempinday();

	List<Object[]> getBonusempinYear();

	List<Object[]> getLateWorkEmp();

	List<Object[]> getUserBirthdayByMounth();

	List<Contract> getContractsOLD();

	List<Object[]> getEmpworkDetailLate(String usercoder);

	List<Object[]> getEmpworkDetailSoon(String usercode);

	List<Object[]> getEmpworkDetailTimeoff(String usercode);

	List<Object[]> getEmpworkCountLate(String usercoder);

	List<Object[]> getEmpworkCountSoon(String usercode);

	List<Object[]> getEmpworkCountTimeoff(String usercoder);

	List<Object[]> getTotalLabor(String usercode);

	List<EmpWorkDetail> getTotalLaborDetail(String usercode);





}
