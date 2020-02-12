package vn.vissoft.portal.entities;

import java.util.Date;

public class ContractFind {

    Long ctype, cUser;
    private Long department;
    private String cno;
    private String startDate;
    private String endDate;
    private Integer status;
  // String  salarymin,salarymax;

    public Long getCtype() {
        return ctype;
    }

    public void setCtype(Long ctype) {
        this.ctype = ctype;
    }

    public Long getcUser() {
        return cUser;
    }

    public void setcUser(Long cUser) {
        this.cUser = cUser;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
