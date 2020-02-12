package vn.vissoft.portal.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vissoft.portal.dao.ContractTypeDAO;
import vn.vissoft.portal.entities.ContractType;
import vn.vissoft.portal.repositories.ContractTypeReponsitory;
import vn.vissoft.portal.services.ContractTypeService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractTypeServiceimpl implements ContractTypeService {

    private static final Logger LOG = LoggerFactory.getLogger(ContractServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ContractTypeReponsitory contractTypeReponsitory;
    @Autowired
    private ContractTypeDAO contractTypeDao;

    @Override
    public void addConType(ContractType contractType) {
        contractTypeDao.addConType(contractType);
    }

    public void updateConType(ContractType contractType) {
        contractTypeDao.updateConType(contractType);
    }

    @Override
    public List<ContractType> getSearchConTy(String ctName, String Contract_code) {
        try {
            StringBuilder hql = new StringBuilder();
            hql.append("select c from ContractType as c where c.status=1");
            if (!"".equals(ctName)) {
                hql.append(" and c.ctName like \'%" + ctName + "%\'");
            }
            if (!"".equals(Contract_code)) {
                hql.append(" and c.Contract_code like \'%" + Contract_code + "%\'");
            }
            List<ContractType> list = entityManager.createQuery(hql.toString()).getResultList();
            return list;
        } catch (Exception e) {
            LOG.error(e.toString());
            return new ArrayList<>();
        }

    }

    public List<ContractType> getAllConType() {
        return contractTypeDao.getAllConType();
    }

    @Override
    public void deleteConType(Integer id) {
        contractTypeDao.deleteConType(id);
    }
}
