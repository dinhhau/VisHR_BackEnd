package vn.vissoft.portal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "EMP_WORK_DETAIL")
public class EmpWorkSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "WORK_DAY")
    private Date wor;

    @Column(name = "START_TIME")
    private Time starttime;

    @Column(name = "END_TIME")
    private Time endtime;

    @Column(name = "WORK_ID")
    private Integer workid;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userid;

    public EmpWorkSummary(Date wor, User userid, Time starttime, Time endtime, Integer workid) {
        super();
        this.wor = wor;
        this.starttime = starttime;
        this.endtime = endtime;
        this.workid = workid;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWor() {
        return wor;
    }

    public void setWor(Date wor) {
        this.wor = wor;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public User getCioUser() {
        return userid;
    }

    public void setCioUser(User cioUser) {
        this.userid = cioUser;
    }
}
