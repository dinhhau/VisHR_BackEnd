package vn.vissoft.portal.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTRACT_TYPE")
public class ContractType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TYPEC")
    private Integer ctId;

    @Column(name = "NAME")
    private String ctName;

    @Column(name = "RULE")

    private String rule;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "FILENAME")
       private String filename;
    @Column(name = "CONTRACT_CODE")
    private String Contract_code;

    public ContractType(String ctName, String rule, String filename, String Contract_code) {
        this.ctName = ctName;
        this.rule = rule;
        this.filename = filename;
        this.Contract_code = Contract_code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ContractType(Integer status) {
        this.status = status;
    }

    public ContractType() {

    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

   public String getFilename() {
       return filename;
    }

    public void setFilename(String filename) {
       this.filename = filename;
    }

    public String getContract_code() {
        return Contract_code;
    }

    public void setContract_code(String contract_code) {
        Contract_code = contract_code;
    }
}
