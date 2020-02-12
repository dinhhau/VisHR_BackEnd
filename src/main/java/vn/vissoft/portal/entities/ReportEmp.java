package vn.vissoft.portal.entities;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/* REPORT_EMP = re */

@Entity
@Table(name = "REPORT_EMP")
public class ReportEmp implements Serializable {
	@Id
	@Column(name = "REPORT_EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reID;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User reUser;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "mm/dd/yyyy HH:mm:ss")
	@Column(name = "CREATE_DATE")
	private Date reCreateDate;
	
	@Column(name = "REPORT_DATE")
	private String reportDate;

	@ManyToOne
	@JoinColumn(name = "REASON_ID")
	private Reason reReason;

	@Column(name = "REPORT_EMP_MONEY")
	private Integer reMoney;

	@ManyToOne
	@JoinColumn(name = "REPORT_TYPE")
	private ApParam reType;

	@Column(name = "REPORT_STATUS")
	private Integer reportstatus;

	@Column(name = "REPORT_STATUS_HIDE")
	private Integer reportstatushide;

	@Column(name = "note")
	private String note;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getReportstatushide() {
		return reportstatushide;
	}

	public void setReportstatushide(Integer reportstatushide) {
		this.reportstatushide = reportstatushide;
	}

	public Integer getReID() {
		return reID;
	}

	public Integer getReportstatus() {
		return reportstatus;
	}

	public void setReportstatus(Integer reportstatus) {
		this.reportstatus = reportstatus;
	}

	public void setReID(Integer reID) {
		this.reID = reID;
	}

	public Date getReCreateDate() {
		return reCreateDate;
	}

	public void setReCreateDate(Date reCreateDate) {
		this.reCreateDate = reCreateDate;
	}

	public Integer getReMoney() {
		return reMoney;
	}

	public void setReMoney(Integer reMoney) {
		this.reMoney = reMoney;
	}

	public ApParam getReType() {
		return reType;
	}

	public void setReType(ApParam reType) {
		this.reType = reType;
	}

	public User getReUser() {
		return reUser;
	}

	public void setReUser(User reUser) {
		this.reUser = reUser;
	}

	public Reason getReReason() {
		return reReason;
	}

	public void setReReason(Reason reReason) {
		this.reReason = reReason;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
}
