package vn.vissoft.portal.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOTAL_TIMEOFF_LOG")
public class TotaltimeOffLog {
	@Id
	@Column(name = "ID_LOG")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IDLOG;

	@Column(name = "TIMEOFF_LOG")
	private Integer ToLog;
	
	@Column(name = "CREATEDATE_LOG")
	private Date create_log;


	public Integer getIDLOG() {
		return IDLOG;
	}

	public void setIDLOG(Integer iDLOG) {
		IDLOG = iDLOG;
	}

	public Integer getToLog() {
		return ToLog;
	}

	public void setToLog(Integer toLog) {
		ToLog = toLog;
	}

	public Date getCreate_log() {
		return create_log;
	}

	public void setCreate_log(Date create_log) {
		this.create_log = create_log;
	}

	
}
