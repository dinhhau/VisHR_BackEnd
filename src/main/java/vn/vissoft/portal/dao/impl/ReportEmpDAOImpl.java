package vn.vissoft.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.dao.ReportEmpDAO;
import vn.vissoft.portal.entities.ReportEmp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class ReportEmpDAOImpl implements ReportEmpDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportEmp> getAll() {

		String hql = "from " + ReportEmp.class.getName() + " r where r.reportstatushide =1";

		return (List<ReportEmp>) entityManager.createQuery(hql).getResultList();

	}

	@Override
	@Transactional
	public boolean addReportEmp(ReportEmp reportEmp) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		reportEmp.setReportstatus(0);
		reportEmp.setReCreateDate(date);
		entityManager.persist(reportEmp);

		return true;
	}

	@Transactional
	@Override
	public boolean Report_empExist(ReportEmp reportEmp) {
		String hql = "from " + reportEmp.getClass().getName() + " as rpe where rpe.report_emp_id = :reportempid ";

		return entityManager.createQuery(hql).setParameter("reportempid", reportEmp.getReID()).getResultList()
				.size() > 0 ? true : false;
	}

	@Override
	@Transactional
	public void updateReport_emp(ReportEmp reportEmp) {
		// TODO Auto-generated method stub
		entityManager.flush();
		entityManager.merge(reportEmp);

	}

	@Override
	public ReportEmp getRe_empbyReEmp_code(Integer re_emp_code) {
		String hql = "from " + ReportEmp.class.getName() + " rpe where rpe.reID = :report_id";

		List<ReportEmp> reportEmpsLst = entityManager.createQuery(hql).setParameter("report_id", re_emp_code)
				.getResultList();
		if (reportEmpsLst != null && reportEmpsLst.size() > 0) {
			return reportEmpsLst.get(0);

		}
		return null;
	}

	@Override
	@Transactional
	public void deleteReport_emp_byid(Integer report_emp_id) {
		ReportEmp reportEmp = getRe_empbyReEmp_code(report_emp_id);
		reportEmp.setReportstatushide(0);
		entityManager.merge(reportEmp);

	}

	@Override
	@Transactional
	public List<ReportEmp> searchReEmpByCondition(int page, int pageSize, String columnSortName, Boolean asc,
			Integer userid, Integer reason, Integer hider, String fromDate) {

		String hql = "from " + ReportEmp.class.getName() + " rp";
		if (userid == null && reason == null && hider == null && fromDate == null) {
			hql = hql
					+ " where DATE_FORMAT(rp.reCreateDate,'%m-%Y') = DATE_FORMAT(DATE(NOW()),'%m-%Y') and rp.reportstatushide=1 order by rp.reportDate  desc";
		}
		if (userid != null && reason == null  && fromDate == null) {
			hql = hql + " where rp.reUser = " + userid + " and rp.reportstatushide=1 order by rp.reportDate  desc ";
		}
		if (userid == null && reason != null  && fromDate == null) {
			hql = hql + " where rp.reReason = " + reason + " and rp.reportstatushide=1 order by rp.reportDate  desc ";
		}
		if (userid == null && reason == null  && fromDate != null) {
			hql = hql + " where  DATE_FORMAT(rp.reportDate,'%m-%Y') = " +"DATE_FORMAT('" +fromDate+ "','%m-%Y')"+" and rp.reportstatushide=1 order by rp.reportDate  desc ";
		}
		if (userid != null && reason != null  && fromDate == null) {
			hql = hql +" where rp.reUser = " + userid+" and "+"rp.reReason = " + reason + " and rp.reportstatushide=1 order by rp.reportDate  desc ";
		}
		if (userid == null && reason != null  && fromDate != null) {
			hql = hql +" where rp.reReason = " + reason +" and  DATE_FORMAT(rp.reportDate,'%m-%Y') = " + " DATE_FORMAT('" +fromDate+ "','%m-%Y')"+" and rp.reportstatushide=1 order by rp.reportDate  desc ";
		}
		if (userid != null && reason == null  && fromDate != null) {
			hql = hql +" where rp.reUser = " + userid +" and  DATE_FORMAT(rp.reportDate,'%m-%Y') = " + " DATE_FORMAT('" +fromDate+ "','%m-%Y')"+" and rp.reportstatushide=1 order by rp.reportDate  desc ";
		}
		if (userid != null && reason != null  && fromDate != null) {
			hql = hql +" where rp.reUser = " + userid +" and  DATE_FORMAT(rp.reportDate,'%m-%Y') = " + " DATE_FORMAT('" +fromDate+ "','%m-%Y')"+" and rp.reReason = "+ reason +" and rp.reportstatushide=1 order by rp.reportDate  desc ";
		}
		List<ReportEmp> Lst = entityManager.createQuery(hql).getResultList();
		return Lst;
	}

	@Override
	@Transactional
	public void confirmReport(Integer report_emp_id) {
		ReportEmp reportEmp = getRe_empbyReEmp_code(report_emp_id);
		reportEmp.setReportstatus(1);
		entityManager.merge(reportEmp);

	}

}
