package vn.vissoft.portal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.vissoft.portal.dao.DashboardDAO;
import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.services.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{
    @Autowired
    private DashboardDAO DashboardDAO;

    @Override
    public List<Object[]> getLateWorkEmp() {
        // TODO Auto-generated method stub
        return DashboardDAO.getLateWorkEmp();
    }

    @Override
    public List<Object[]> getBonusempinMonth() {
        // TODO Auto-generated method stub
        return DashboardDAO.getBonusempinMonth();
    }

    @Override
    public List<Object[]> getUserBirthdayByMounth() {
        // TODO Auto-generated method stub
        return DashboardDAO.getUserBirthdayByMounth();
    }

    @Override
    public List<Contract> getContractsOLD() {
        // TODO Auto-generated method stub
        return DashboardDAO.getContractsOLD();}

    @Override
    public List<Object[]> getBonusempinday() {
        // TODO Auto-generated method stub
        return DashboardDAO.getBonusempinday();
    }

    @Override
    public List<Object[]> getBonusempinYear() {
        // TODO Auto-generated method stub
        return DashboardDAO.getBonusempinYear();
    }


	@Override
	public List<Object[]> getEmpworkCountLate(String usercoder) {
		// TODO Auto-generated method stub
		return DashboardDAO.getEmpworkCountLate(usercoder);
	}

	@Override
	public List<Object[]> getEmpworkCountSoon(String usercode) {
		// TODO Auto-generated method stub
		return DashboardDAO.getEmpworkCountSoon(usercode);
	}

	@Override
	public List<Object[]> getEmpworkCountTimeoff(String usercoder) {
		// TODO Auto-generated method stub
		return DashboardDAO.getEmpworkCountTimeoff(usercoder);
	}

	@Override
	public List<Object[]> getEmpworkDetailLate(String usercoder) {
		// TODO Auto-generated method stub
		return DashboardDAO.getEmpworkDetailLate(usercoder);
	}

	@Override
	public List<Object[]> getEmpworkDetailSoon(String usercode) {
		// TODO Auto-generated method stub
		return DashboardDAO.getEmpworkDetailSoon(usercode);
	}

	@Override
	public List<Object[]> getEmpworkDetailTimeoff(String usercode) {
		// TODO Auto-generated method stub
		return DashboardDAO.getEmpworkDetailTimeoff(usercode);
	}

	@Override
	public List<Object[]> getTotalLabor(String usercode) {
		// TODO Auto-generated method stub
		return DashboardDAO.getTotalLabor(usercode);
	}

	@Override
	public List<EmpWorkDetail> getTotalLaborDetail(String usercode) {
		// TODO Auto-generated method stub
		return DashboardDAO.getTotalLaborDetail(usercode);
	}


}

