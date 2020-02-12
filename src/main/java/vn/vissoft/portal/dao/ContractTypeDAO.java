package vn.vissoft.portal.dao;

import vn.vissoft.portal.entities.ContractType;

import java.util.List;

public interface ContractTypeDAO {
    List<ContractType> getAllConType();

    void addConType(ContractType contractType);

    void updateConType(ContractType contractType);

    void deleteConType(Integer id);
}
