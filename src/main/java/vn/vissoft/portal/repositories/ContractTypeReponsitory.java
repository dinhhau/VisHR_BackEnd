package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vissoft.portal.entities.ContractType;

@Repository
public interface ContractTypeReponsitory extends JpaRepository<ContractType, Integer> {
//   @Query(value="select * from ContractType as u where u.ctEname like %:name% and u.contract_code like %:code% ", nativeQuery=true)
//    List<ContractType> getSearchContractTy(@Param("name" )String name,@Param("code")String code);
}
