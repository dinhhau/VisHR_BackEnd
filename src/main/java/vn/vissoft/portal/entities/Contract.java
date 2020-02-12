package vn.vissoft.portal.entities;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CONTRACTS")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTRACT_ID")
    private Integer cId;

    @ManyToOne
    @JoinColumn(name = "CONTRACT_TYPE")
    private ContractType ctype;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startdate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date enddate;


    @Column(name = "SALARY")
    private String sal;

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "CONTRACT_NO")
    private String cno;

    @Column(name = "IS_DELETED")
    private int isDeleted;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User cUser;


    public Contract() {

    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public ContractType getCtype() {
        return ctype;
    }

    public void setCtype(ContractType ctype) {
        this.ctype = ctype;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    //public ContractType getcContractType() {
    //return cContractType;
    // }

    // public void setcContractType(ContractType cContractType) {
    //  this.cContractType = cContractType;
    //}

    public User getcUser() {
        return cUser;
    }

    public void setcUser(User cUser) {
        this.cUser = cUser;
    }
}
