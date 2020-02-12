package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.ReportEmp;

import java.util.Date;
import java.util.List;

public interface ReportEmpService {
    List<ReportEmp> getAll();

    boolean addReportEmp(ReportEmp reportEmp);

    void updateReport_emp(ReportEmp reportEmp);

    void deleteReport_emp_byid(Integer report_emp_id);

    List<ReportEmp> searchReEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc, Integer fullname, Integer reason, Integer hider, String fromDate);

    ReportEmp getRe_empbyReEmp_id(Integer re_emp_id);

    void confirmReport(Integer report_emp_id);
}

