package vn.vissoft.portal.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.portal.dao.ContractTypeDAO;
import vn.vissoft.portal.entities.ContractType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ContractTypeDAOImpl implements ContractTypeDAO {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<ContractType> getAllConType() {
        String hql = "FROM ContractType AS ct where ct.status=1 ";
        return (List<ContractType>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addConType(ContractType contractType) {
        entityManager.persist(contractType);
    }

    @Override
    public void updateConType(ContractType contractType) {
        entityManager.merge(contractType);
    }

    @Override
    public void deleteConType(Integer id) {
        ContractType contractType = entityManager.find(ContractType.class, id);
        contractType.setStatus(0);
        entityManager.merge(contractType);
    }
}
