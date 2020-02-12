package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.ReportEmp;

import java.util.Date;
import java.util.List;

public interface ReportEmpDAO {
    List<ReportEmp> getAll();

    boolean addReportEmp(ReportEmp reportEmp);

    boolean Report_empExist(ReportEmp reportEmp);

    void updateReport_emp(ReportEmp reportEmp);

    void deleteReport_emp_byid(Integer report_emp_id);

    ReportEmp getRe_empbyReEmp_code(Integer re_emp_code);

    List<ReportEmp> searchReEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc, Integer userid, Integer reason, Integer hider, String fromDate);

    void confirmReport(Integer report_emp_id);
}
