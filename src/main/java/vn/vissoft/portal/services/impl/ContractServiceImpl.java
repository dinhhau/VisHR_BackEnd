package vn.vissoft.portal.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.ContractDAO;
import vn.vissoft.portal.entities.Contract;
import vn.vissoft.portal.entities.ContractType;
import vn.vissoft.portal.entities.Department;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.repositories.ContractReponsitory;
import vn.vissoft.portal.services.ContractService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ContractServiceImpl implements ContractService {

    private static final Logger LOG = LoggerFactory.getLogger(ContractServiceImpl.class);

    @Autowired
    private ContractDAO contractDao;
    @Autowired
    private ContractReponsitory contractReponsitory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contract> getAllContract() {
        return contractDao.getAllContract();
    }

    @Override
    public List<Contract> getContractByMonth() {
        return contractDao.getContractByMonth();
    }
    @Override
    public void addCon(Contract contract) {
        contractDao.addCon(contract);
    }

    @Override
    public void delCon(int cId) {
       Contract contract = entityManager.find(Contract.class, cId);
       contract.setIsDeleted(0);
       updateCon(contract);
    }

    @Override
    public void updateCon(Contract contract) {
        contractDao.updateCon(contract);
    }

    @Override
    public Contract getAllById(int id) {
        return contractReponsitory.getById(id);
    }

    @Override
    public List<Contract> getSearch(Long contract_type, Long cUser, String contract_no, Long department, String startDate, String endDate,
                                    Integer status) {

        try {
            StringBuilder hql = new StringBuilder();
            hql.append("select c from Contract as c join User as u on u.id = c.cUser join" +
                    " Department as d on u.department = d.deptId where c.isDeleted = 1");

            if (contract_type != 0 && contract_type != null) {
                hql.append(" and c.ctype.ctId = " + contract_type);
            }
            if (cUser != 0 && cUser != null) {
                hql.append(" and u.id =" + cUser);
            }
            if (department != 0) {
                hql.append(" and d.deptId = " + department);
            }
            if (status != null) {
                hql.append(" and c.status = " + status);
            }
            if (startDate != null) {
                hql.append(" and c.startdate >= '"+ startDate+"'");
            }
            if (endDate != null) {
                hql.append(" and c.enddate <= '"+ endDate+ "'");
            }
            List<Contract> list = entityManager.createQuery(hql.toString()).getResultList();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.toString());
            return new ArrayList<>();
        }
    }

    @Override
    @Async
    public void checkStatus() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    .withZone(ZoneId.of("UTC+7"));
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String local = df.format(date);
            List<Contract> lst = getAllContract();
            for (Contract contract : lst) {
                if (contract.getEnddate() != null) {
                    String enddate = contract.getEnddate().toString();
                    Date datene = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getEnddate().toString());
                    Instant timeInstant = datene.toInstant();
                    Instant value = timeInstant.minus(30, ChronoUnit.DAYS);
                    if (formatter.format(value).equals(local)) {
                        contract.setStatus(2L);
                        updateCon(contract);
                    }
                    if (local.equals(enddate)) {
                        contract.setStatus(0L);
                        updateCon(contract);
                    }
                    if (date.compareTo(contract.getEnddate())  > 0) {
                        contract.setStatus(0L);
                        updateCon(contract);
                    }
                }
            }
        } catch (Exception e) {
            LOG.error(e.toString());
        }

    }

    @Override
    public Contract getByCode(String code) {
        return contractReponsitory.getByCno(code);
    }

    @Override
    public List<Contract> SearchContractByCondition(Integer contractTypeId, Integer userId, Integer deptId, String startDateFrom, String startDateTo,
                                                    String endDateFrom, String endDateTo) {
        return contractDao.SearchContractByCondition(contractTypeId, userId, deptId, startDateFrom, startDateTo, endDateFrom, endDateTo);
    }
}
