package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table
@Entity(name = "NOTIFY")
public class Notify implements Serializable {

	@Id
	@Column(name = "NOTIFY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nID;

	@ManyToOne
	@JoinColumn(name = "SENDER")
	private User nSender;

	@Column(name = "RECEIVER")
	private String nReceiver;

	@Column(name = "CONTENT")
	private String nContent;

	@Column(name = "STATUS")
	private Integer nStatus;

	@Column(name = "STATUSHIDE")
	private Integer statushide;
	
	public Integer getStatushide() {
		return statushide;
	}

	public void setStatushide(Integer statushide) {
		this.statushide = statushide;
	}

	@Column(name = "CREATE_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date nCreateDate;

	// timeoff = 1, birthday = 2
	@Column(name = "SOURCE_TYPE")
	private Integer sourceType;

	public Integer getnID() {
		return nID;
	}

	public void setnID(Integer nID) {
		this.nID = nID;
	}

	public User getnSender() {
		return nSender;
	}

	public void setnSender(User nSender) {
		this.nSender = nSender;
	}

	public String getnReceiver() {
		return nReceiver;
	}

	public void setnReceiver(String nReceiver) {
		this.nReceiver = nReceiver;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Integer getnStatus() {
		return nStatus;
	}

	public void setnStatus(Integer nStatus) {
		this.nStatus = nStatus;
	}

	public Date getnCreateDate() {
		return nCreateDate;
	}

	public void setnCreateDate(Date nCreateDate) {
		this.nCreateDate = nCreateDate;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
}
