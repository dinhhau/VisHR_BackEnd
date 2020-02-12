package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.ContractType;

import java.util.List;

public interface ContractTypeService {
    List<ContractType> getAllConType();

    void addConType(ContractType contractType);

    void updateConType(ContractType contractType);

    void deleteConType(Integer id);

    List<ContractType> getSearchConTy(String ctNme, String Contract_code);
}
