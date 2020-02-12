package vn.vissoft.portal.entities;

import javax.persistence.*;

import java.io.Serializable;

@Table
@Entity(name = "REASON")
public class Reason implements Serializable {

    @Id
    @Column(name = "REASON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rID;

    @Column(name = "REASON_CODE")
    private String rCode;

    @Column(name = "REASON_NAME")
    private String rName;
    
    @ManyToOne
    @JoinColumn(name = "REASON_TYPE")
    private ApParam rType;

    @Column(name = "MONEY")
    private Integer rMoney;
    
    @Column(name = "REASON_STATUS")
    private Integer rStatus;

    @Column(name = "DAY")
    private  Integer day;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }


    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public ApParam getrType() {
        return rType;
    }

    public void setrType(ApParam rType) {
        this.rType = rType;
    }

    public Integer getrMoney() {
        return rMoney;
    }

    public void setrMoney(Integer rMoney) {
        this.rMoney = rMoney;
    }

    public Integer getrStatus() {
        return rStatus;
    }

    public void setrStatus(Integer rStatus) {
        this.rStatus = rStatus;
    }
}
