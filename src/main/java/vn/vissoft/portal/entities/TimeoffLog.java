package vn.vissoft.portal.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "TIMEOFF_LOG")
public class TimeoffLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_TIMEOFF_ID")
    private Integer log_to_id;

    @Column(name = "USER_CODE")
    private String usercode;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "DEPT_NAME")
    private String deptname;

    @Column(name = "DAY_WORK")
    private Date daywork;

    @Column(name = "DECRIP_TIMEOFF")
    private String decriptimeoff;

    @Column(name = "LABOR")
    private Double labor;

    @Column(name = "STARTTIME")
    private String starttime;

    @Column(name = "endtime")
    private String endtime;

    @Column(name = "TIMEOFF_TYPE")
    private String timeoff_type;

    @Column(name = "CREATE_DATE")
    private String createdate;

    @Column(name = "HAVE_SALARY")
    private Integer haveSalary;

    @Column(name = "NO_SALARY")
    private Integer noSalary;

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getTimeoff_type() {
        return timeoff_type;
    }

    public void setTimeoff_type(String timeoff_type) {
        this.timeoff_type = timeoff_type;
    }

    public Integer getHaveSalary() {
        return haveSalary;
    }

    public void setHaveSalary(Integer haveSalary) {
        this.haveSalary = haveSalary;
    }

    public Integer getNoSalary() {
        return noSalary;
    }

    public void setNoSalary(Integer noSalary) {
        this.noSalary = noSalary;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }



    public Integer getLog_to_id() {
        return log_to_id;
    }

    public void setLog_to_id(Integer log_to_id) {
        this.log_to_id = log_to_id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Date getDaywork() {
        return daywork;
    }

    public void setDaywork(Date daywork) {
        this.daywork = daywork;
    }

    public String getDecriptimeoff() {
        return decriptimeoff;
    }

    public void setDecriptimeoff(String decriptimeoff) {
        this.decriptimeoff = decriptimeoff;
    }

    public Double getLabor() {
        return labor;
    }

    public void setLabor(Double labor) {
        this.labor = labor;
    }
}
