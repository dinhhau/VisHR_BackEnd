package vn.vissoft.portal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.vissoft.portal.dao.TotalLaborDAO;
import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.services.TotalLaborService;
@Service
public class TotalLaborServiceImpl implements TotalLaborService{

	@Autowired
	private TotalLaborDAO totalLaborDAO;


	@Override
	public List<Object[]> getTotalLaborCondition(int page, int pageSize, String columnSortName, Boolean asc,
			String userid, String dateSearch) {
		
		return totalLaborDAO.getTotalLaborCondition(page, pageSize, columnSortName, asc, userid, dateSearch);
	}


	@Override
	public List<EmpWorkDetail> getDetailLaborByUserCode(String userCode, String date) {
		// TODO Auto-generated method stub
		return totalLaborDAO.getDetailLaborByUserCode(userCode, date);
	}

}
