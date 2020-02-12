package vn.vissoft.portal.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "EMP_WORK_DETAIL")
public class EmpWorkDetail implements Serializable {

    @Id
    @Column(name = "IDCOL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCol;

    @Column(name = "ID")
    private String id;

    @Column(name = "ENAME")
    private String ename;

    @Column(name = "NAME_DEPT")
    private String name_dept;

    @Column(name = "POSITION")
    private String pos;

    @Column(name = "WORK_DAY")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date workdate;

    @Column(name = "ST_DATE")
    private String stdate;

    @Column(name = "START_TIME")
    private String starttime;

    @Column(name = "END_TIME")
    private String endtime;

    @Column(name = "LABOR")
    private double labor;

    @Column(name = "TIME_WORK")
    private Double timework;

    public void setTimework(Double timework) {
        this.timework = timework;
    }

    @Column(name = "LABOR_ST")
    private Double laborst;

    @Column(name = "TIME_ST")
    private Double timest;

    // @Temporal(TemporalType.DATE)
    @Column(name = "IN_LATE")
    private Double inlate;

    // @Temporal(TemporalType.DATE)
    @Column(name = "OUT_SOON")
    private Double outsoon;

    @Column(name = "TC1")
    private Double tc1;

    @Column(name = "TC2")
    private Double tc2;

    @Column(name = "TC3")
    private Double tc3;

    @Column(name = "NAME_WORK_SHIFT")
    private String namwork;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "SYMBOL_ST")
    private String symnolst;

    //  @Temporal(TemporalType.DATE)
    @Column(name = "TOTAL_TIME")
    private Double totaltime;
    @Transient
    private String dateWork;
    @Column(name = "TOTAL_LABOR")
    private  Double totallabor;

    public Double getTotallabor() {
        return totallabor;
    }

    public void setTotallabor(Double totallabor) {
        this.totallabor = totallabor;
    }

    public String getDateWork() {
        Long date = workdate.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        dateWork = dateFormat.format(date);
        return dateWork;
    }

    public void setDateWork(String dateWork) {
        this.dateWork = dateWork;
    }

    public EmpWorkDetail() {
    }

    public int getIdCol() {
        return idCol;
    }

    public void setIdCol(int idCol) {
        this.idCol = idCol;
    }

    public void setLabor(double labor) {
        this.labor = labor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getName_dept() {
        return name_dept;
    }

    public void setName_dept(String name_dept) {
        this.name_dept = name_dept;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public String getStdate() {
        return stdate;
    }

    public void setStdate(String stdate) {
        this.stdate = stdate;
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

    public Double getLabor() {
        return labor;
    }

    public void setLabor(Double labor) {
        this.labor = labor;
    }

    public Double getTimework() {
        return timework;
    }

    public Double getLaborst() {
        return laborst;
    }

    public void setLaborst(Double laborst) {
        this.laborst = laborst;
    }

    public Double getTimest() {
        return timest;
    }

    public void setTimest(Double timest) {
        this.timest = timest;
    }

    public Double getInlate() {
        return inlate;
    }

    public void setInlate(Double inlate) {
        this.inlate = inlate;
    }

    public Double getOutsoon() {
        return outsoon;
    }

    public void setOutsoon(Double outsoon) {
        this.outsoon = outsoon;
    }

    public Double getTc1() {
        return tc1;
    }

    public void setTc1(Double tc1) {
        this.tc1 = tc1;
    }

    public Double getTc2() {
        return tc2;
    }

    public void setTc2(Double tc2) {
        this.tc2 = tc2;
    }

    public Double getTc3() {
        return tc3;
    }

    public void setTc3(Double tc3) {
        this.tc3 = tc3;
    }

    public String getNamwork() {
        return namwork;
    }

    public void setNamwork(String namwork) {
        this.namwork = namwork;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymnolst() {
        return symnolst;
    }

    public void setSymnolst(String symnolst) {
        this.symnolst = symnolst;
    }

    public Double getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(Double totaltime) {
        this.totaltime = totaltime;
    }
}
