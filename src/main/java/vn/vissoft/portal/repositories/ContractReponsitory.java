package vn.vissoft.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.vissoft.portal.entities.Contract;

import java.util.List;

public interface ContractReponsitory extends JpaRepository<Contract, Integer> {
    // Contract findContractsByCIdAndAndStatus(String id, int  );

    @Query(value = "SELECT * FROM contracts as a WHERE a.contract_id=:id", nativeQuery = true)
    Contract getById(@Param("id") int id);

    @Query(value = "SELECT * FROM contracts as a WHERE a.is_deleted=1", nativeQuery = true)
    List<Contract> getAll();

    Contract getByCno(String cno);
//    @Query(value = "SELECT * FROM contract as c where  c.contract_type like %:contract_type% and c.user_id like %:user_id% and c.contract_no like %:contract_no% and c.deptp like %:dept%", nativeQuery = true)
//    List<Contract> search(@Param("contract_type") int contract_type,@Param("user_id") int user_id,@Param("contract_no") int contract_no,@Param("dept") int dept);

}
