package vn.vissoft.portal.entities;


import java.util.Date;

public class EmpTime {
    private String startday,startmonth,startyear,endday,endmonth,endyear ,id,ename;
    private Date startDate;
    private Date endDate;
    public EmpTime() {
    }

    public EmpTime(String startday, String startmonth, String startyear, String endday, String endmonth, String endyear, String id, String ename) {
        this.startday = startday;
        this.startmonth = startmonth;
        this.startyear = startyear;
        this.endday = endday;
        this.endmonth = endmonth;
        this.endyear = endyear;
        this.id = id;
        this.ename = ename;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEname() {
        return ename;
    }

    public String getStartday() {
        return startday;
    }

    public String getStartmonth() {
        return startmonth;
    }

    public String getStartyear() {
        return startyear;
    }

    public String getEndday() {
        return endday;
    }

    public String getEndmonth() {
        return endmonth;
    }

    public String getEndyear() {
        return endyear;
    }

    public String getId() {
        return id;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public void setStartmonth(String startmonth) {
        this.startmonth = startmonth;
    }

    public void setStartyear(String startyear) {
        this.startyear = startyear;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public void setEndmonth(String endmonth) {
        this.endmonth = endmonth;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
