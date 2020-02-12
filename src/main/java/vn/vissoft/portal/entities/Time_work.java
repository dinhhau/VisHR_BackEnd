package vn.vissoft.portal.entities;


import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIME_WORK")
public class Time_work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIME_WORK_ID")
    private Integer timeworkid;

    @Column(name = "START_DATE")
    private Date sDate;

    @Column(name = "END_DATE")
    private  Date eDate;

    @Column(name = "START_TIME_WORK")
    private String stTimework;

    @Column(name = "END_TIME_WORK")
    private String eTimework;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE")
    private User employee;



    @Column(name = "MANAGER")
    private String manager;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "APPROVED_DATE")
    private Date approved_date;

    @Column(name = "CREATE_DATE")
    private Date create_date;

    @Column(name = "IS_DELETED")
    private Integer is_deleted;

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getApproved_date() {
        return approved_date;
    }

    public void setApproved_date(Date approved_date) {
        this.approved_date = approved_date;
    }

    public Integer getTimeworkid() {
        return timeworkid;
    }

    public void setTimeworkid(Integer timeworkid) {
        this.timeworkid = timeworkid;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public String getStTimework() {
        return stTimework;
    }

    public void setStTimework(String stTimework) {
        this.stTimework = stTimework;
    }

    public String geteTimework() {
        return eTimework;
    }

    public void seteTimework(String eTimework) {
        this.eTimework = eTimework;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
