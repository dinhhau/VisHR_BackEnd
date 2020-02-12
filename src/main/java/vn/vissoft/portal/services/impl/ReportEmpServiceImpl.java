package vn.vissoft.portal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.ReportEmpDAO;
import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.services.ReportEmpService;

import java.util.Date;
import java.util.List;

@Service
public class ReportEmpServiceImpl implements ReportEmpService {

    @Autowired
    ReportEmpDAO ReportEmpDAO;

    @Override
    public List<ReportEmp> getAll() {
        // TODO Auto-generated method stub
        return ReportEmpDAO.getAll();

    }

    @Override
    public synchronized boolean addReportEmp(ReportEmp reportEmp) {

        ReportEmpDAO.addReportEmp(reportEmp);
        reportEmp.setReportstatus(0);
        return true;


    }

    @Override
    public void updateReport_emp(ReportEmp reportEmp) {

        ReportEmpDAO.updateReport_emp(reportEmp);


    }

    @Override
    public List<ReportEmp> searchReEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc,
                                                  Integer fullname, Integer reason, Integer hider, String fromDate) {

        return ReportEmpDAO.searchReEmpByCondition(page, pageSize, columnSortName, asc, fullname, reason, hider, fromDate);
    }

    @Override
    public void deleteReport_emp_byid(Integer report_emp_id) {
        ReportEmpDAO.deleteReport_emp_byid(report_emp_id);

    }

    @Override
    public ReportEmp getRe_empbyReEmp_id(Integer re_emp_id) {
        return ReportEmpDAO.getRe_empbyReEmp_code(re_emp_id);

    }
    
    @Override
	public void confirmReport(Integer report_emp_id) {
		 ReportEmpDAO.confirmReport(report_emp_id);
		
	}


}
