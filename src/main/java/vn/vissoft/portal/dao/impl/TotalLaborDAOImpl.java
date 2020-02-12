package vn.vissoft.portal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import vn.vissoft.portal.dao.TotalLaborDAO;
import vn.vissoft.portal.entities.EmpWorkDetail;

@Repository
@Transactional
public class TotalLaborDAOImpl implements TotalLaborDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmpWorkDetail> getDetailLaborByUserCode(String userCode, String date) {
        String hql = "from " + EmpWorkDetail.class.getName() + " io where io.id like '%" + userCode
                + "%' and  DATE_FORMAT(io.workdate,'%m-%Y') =" + " '" + date + "'";
		System.out.println(hql);
        return entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public List<Object[]> getTotalLaborCondition(int page, int pageSize, String columnSortName, Boolean asc,
                                                 String userid, String dateSearch) {
//		String hql = "select io.id,io.ename,sum(io.labor) as summarylarbousers, MONTH(io.workdate) as daySum from "+EmpWorkDetail.class.getName()
//				+" io";

		String hql = "select io.id,io.ename,sum(io.labor) as summarylarbousers, DATE_FORMAT(io.workdate,'%m-%Y') as daySum from "
				+ EmpWorkDetail.class.getName() + " io";
		if (userid == null && dateSearch == null) {
			hql = hql
					+ " where MONTH(io.workdate)=  MONTH(NOW())  and YEAR(io.workdate) = YEAR(NOW())  group by io.id order by io.id asc";
		}
		if (dateSearch != null && userid == null) {
			hql = hql + " where DATE_FORMAT(io.workdate,'%m-%y') = " + "DATE_FORMAT('" + dateSearch
					+ "','%m-%y')  group by io.ename ";
		}
		if (userid != null && dateSearch == null) {
			hql = hql
					+ " where MONTH(io.workdate)=  MONTH(NOW())  and yEAR(io.workdate) = YEAR(NOW()) and io.id like '%"
					+ userid + "%'  group by io.ename ";
		}
		if (userid != null && dateSearch != null) {
			hql = hql + " where io.id like '%" + userid + "%' and DATE_FORMAT(io.workdate,'%m-%y')=" + "DATE_FORMAT('"
					+ dateSearch + "','%m-%y') group by io.ename ";
		}
		List<Object[]> Lst = entityManager.createQuery(hql).getResultList();
		return Lst;
	}


}
