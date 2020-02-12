package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EVALUATE_KPI")
public class EvaluateKPI {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_POINT")
    private Double userPoint;

    @Column(name = "MANAGER_POINT")
    private Double managerPoint;

    @Column(name = "MANAGER_COMMENT")
    private String managerComment;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "KPI_ID")
    private KPI kpi;

    @Column(name = "CREATE_DATE")
    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date createDate;

    @Column(name = "STATUS")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Double userPoint) {
        this.userPoint = userPoint;
    }

    public Double getManagerPoint() {
        return managerPoint;
    }

    public void setManagerPoint(Double managerPoint) {
        this.managerPoint = managerPoint;
    }

    public String getManagerComment() {
        return managerComment;
    }

    public void setManagerComment(String managerComment) {
        this.managerComment = managerComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public KPI getKpi() {
        return kpi;
    }

    public void setKpi(KPI kpi) {
        this.kpi = kpi;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
