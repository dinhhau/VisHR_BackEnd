package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIMEOFF_LABOR")
public class TimeoffLabor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer tlID;
	
	@Column(name = "TO_LABOR")
	private Integer totaltoL;

	@Column(name = "timeOff_haveSalary")
	private Integer timeOffHaveSalary;

	@Column(name = "timeOff_noSalary")
	private Integer timeOffNoSalary;

	@Column(name = "TIMEOFF_DATE")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date timeOffDate;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public Integer getTlID() {
		return tlID;
	}

	public void setTlID(Integer tlID) {
		this.tlID = tlID;
	}

	public Integer getTotaltoL() {
		return totaltoL;
	}

	public void setTotaltoL(Integer totaltoL) {
		this.totaltoL = totaltoL;
	}

	public Integer getTimeOffHaveSalary() {
		return timeOffHaveSalary;
	}

	public void setTimeOffHaveSalary(Integer timeOffHaveSalary) {
		this.timeOffHaveSalary = timeOffHaveSalary;
	}

	public Integer getTimeOffNoSalary() {
		return timeOffNoSalary;
	}

	public void setTimeOffNoSalary(Integer timeOffNoSalary) {
		this.timeOffNoSalary = timeOffNoSalary;
	}

	public Date getTimeOffDate() {
		return timeOffDate;
	}

	public void setTimeOffDate(Date timeOffDate) {
		this.timeOffDate = timeOffDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
