package vn.vissoft.portal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.vissoft.portal.dao.DashboardDAO;
import vn.vissoft.portal.entities.ApParam;
import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.EmpWorkDetail;
import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.ReportEmp;
import vn.vissoft.portal.entities.User;

@Transactional
@Repository
public class DashboardDAOImpl implements DashboardDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getBonusempinMonth() {
        String hql = "select ur.fullName,rp.note ,ur.image from  " + ReportEmp.class.getName() + " rp join "
                + User.class.getName() + " ur on rp.reUser=ur.id join " + Reason.class.getName()
                + " rs on rp.reReason = rs.rID join " + ApParam.class.getName()
                + " ap on rs.rType = ap.apID where ap.apID =1 and rp.reportstatushide =1 and( MONTH(NOW())-MONTH(rp.reportDate) =1 "
                + " OR MONTH(rp.reportDate)" + " = MONTH(NOW()) )" + "";

        return entityManager.createQuery(hql).getResultList();

    }

    @Override
    public List<Object[]> getLateWorkEmp() {
        String hql = "select ur.code, ur.fullName, rp.reportDate, rp.note AS workTimeLate from " + User.class.getName() + " ur ";
        hql = hql + " inner join " + ReportEmp.class.getName() + " rp on ur.id = rp.reUser inner join  "
                + Reason.class.getName() + " rs ";
        hql = hql + " on rp.reReason = rs.rID";
        hql = hql + " inner join " + ApParam.class.getName() + " ap on rs.rType = ap.apID ";
        hql = hql + " where  DAY(DATE(NOW())) =  DAY(rp.reportDate) and month(now()) = month(rp.reportDate) and rp.reportstatushide= 1";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getUserBirthdayByMounth() {
        return entityManager
                .createQuery("Select ur.username, ur.fullName ,ur.birthDay, YEAR(NOW()) - YEAR(ur.birthDay) "
                        + "as age,DAY(NOW()) - DAY(ur.birthDay) as Countdown from " + User.class.getName() + " ur "
                        + "where status = 1 and MONTH(NOW()) " + "= MONTH(ur.birthDay) order by date_format(ur.birthDay,'%m-%d') asc")
                .getResultList();
    }

    @Override
    public List<Contract> getContractsOLD() {
        String hql = "from " + Contract.class.getName()
                + " ct where  MONTH(ct.enddate) = MONTH(DATE(NOW())) and YEAR(ct.enddate) = YEAR(DATE(NOW())) and ct.isDeleted=1 ORDER BY ct.enddate DESC";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getBonusempinday() {
        String hql = "select ur.username,ur.fullName,count(rp.reUser) as countBn,ur.image from  "
                + ReportEmp.class.getName() + " rp join " + User.class.getName() + " ur on rp.reUser=ur.id join "
                + Reason.class.getName() + " rs on rp.reReason = rs.rID join " + ApParam.class.getName()
                + " ap on rs.rType = ap.apID where ap.apID =1 and rp.reportstatushide =1 and DAY(rp.reportDate)"
                + " = DAY(NOW())  group by rp.reUser order by countBn desc";

        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getBonusempinYear() {
        String hql = "select ur.username,ur.fullName,count(rp.reUser) as countBn,ur.image from  "
                + ReportEmp.class.getName() + " rp join " + User.class.getName() + " ur on rp.reUser=ur.id join "
                + Reason.class.getName() + " rs on rp.reReason = rs.rID join " + ApParam.class.getName()
                + " ap on rs.rType = ap.apID where ap.apID =1 and rp.reportstatushide =1 and YEAR(rp.reportDate)"
                + " = YEAR(NOW())  group by rp.reUser order by countBn desc";

        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getEmpworkCountLate(String usercoder) {
        String hql = "select count(empd.id) as DaysWorklate, empd.ename from " + EmpWorkDetail.class.getName()
                + " empd where MONTH(empd.workdate) = MONTH(NOW()) and empd.id = " + "'" + usercoder + "'"
                + " and empd.inlate > 0 ";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getEmpworkCountSoon(String usercoder) {
        String hql = "select count(empd.id) as DaysWorklate, empd.ename from " + EmpWorkDetail.class.getName()
                + " empd where MONTH(empd.workdate) = MONTH(NOW()) and empd.id = " + "'" + usercoder + "'"
                + " and empd.inlate = 0  and  empd.labor != 0";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getEmpworkCountTimeoff(String usercoder) {
        String hql = " select count(empd.id) as Timeoff, empd.ename from " + EmpWorkDetail.class.getName()
                + " empd where MONTH(empd.workdate) = MONTH(NOW()) and empd.id = " + "'" + usercoder + "'" + " and empd.labor = 0";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getEmpworkDetailLate(String usercoder) {
        String hql = "select empd.id,empd.ename,empd.workdate,empd.starttime,empd.inlate from "
                + EmpWorkDetail.class.getName() + " empd " + " where empd.id= " + "'" + usercoder + "'"
                + " and MONTH(empd.workdate) = MONTH(NOW()) and empd.inlate > 0  ";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getEmpworkDetailSoon(String usercode) {
        String hql = "select empd.id,empd.ename,empd.workdate,empd.starttime,empd.endtime,empd.labor from "
                + EmpWorkDetail.class.getName() + " empd " + " where empd.id= " + "'" + usercode + "'"
                + " and MONTH(empd.workdate) = MONTH(NOW()) and empd.inlate = 0 and empd.labor != 0  ";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getEmpworkDetailTimeoff(String usercode) {
        String hql = "select empd.id,empd.ename,empd.workdate,empd.labor from " + EmpWorkDetail.class.getName()
                + " empd where empd.id =" + "'" + usercode + "'" + " and MONTH(empd.workdate)=MONTH(NOW()) and empd.labor = 0";

        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Object[]> getTotalLabor(String usercode) {
        String hql = "select sum(round(empd.labor,2)),empd.ename from " + EmpWorkDetail.class.getName() + " empd where month(now()) = MONTH(empd.workdate) and empd.id=" + "'" + usercode + "'";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<EmpWorkDetail> getTotalLaborDetail(String usercode) {
        String hql = "from " + EmpWorkDetail.class.getName() + " empd where month(now()) = MONTH(empd.workdate) and empd.id=" + "'" + usercode + "'" + " order by empd.workdate asc ";
        return entityManager.createQuery(hql).getResultList();
    }
}
