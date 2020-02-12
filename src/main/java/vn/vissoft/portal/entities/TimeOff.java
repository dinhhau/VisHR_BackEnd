package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "TIMEOFF")
public class TimeOff implements Serializable {

    @Id
    @Column(name = "RT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rtID;

    
    @Column(name = "CREATE_DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date rtCreateDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @Column(name = "LEAVE_DATE_BEGIN")
    private Date rtLeaveDateBegin;

    @Column(name = "LEAVE_DATE_END")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date rtLeaveDateEnd;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "APPROVED_DATE")
    private Date rtApprovedDate;

    @Column(name = "STATUS")
    @NotNull
    private Integer rtStatus;

    @Column(name = "APPROVER")
    private String rtApprover;

    @Column(name = "DESCRIPTION")
    private String rtDescription;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @NotNull
    private User rtUser;

    @ManyToOne
    @JoinColumn(name =  "REASON_ID")
    @NotNull
    private Reason rtReason;
    
    @Column(name = "TIMEOFF_STATUSHIDE")
    private Integer toStatus;

    @Column(name = "TOTAL_TIMEOFF")
    private Integer tot_Timeoff;


    @Column(name ="ID_LOG")
    private Integer to_log;


    @Column(name = "NOTE_TIMEOFF")
    private String note_timeoff;
    @Transient
    private String checkDuplicate;

    public String getNote_timeoff() {
        return note_timeoff;
    }

    public void setNote_timeoff(String note_timeoff) {
        this.note_timeoff = note_timeoff;
    }



    public Integer getTo_log() {
		return to_log;
	}

	public void setTo_log(Integer to_log) {
		this.to_log = to_log;
	}

	public void setTot_Timeoff(Integer tot_Timeoff) {
		this.tot_Timeoff = tot_Timeoff;
	}

	public int getTot_Timeoff() {
		return tot_Timeoff;
	}

	public Integer getToStatus() {
		return toStatus;
	}

	public void setToStatus(Integer toStatus) {
		this.toStatus = toStatus;
	}

	public Integer getRtID() {
        return rtID;
    }

    public void setRtID(Integer rtID) {
        this.rtID = rtID;
    }

    public Date getRtCreateDate() {
        return rtCreateDate;
    }

    public void setRtCreateDate(Date rtCreateDate) {
        this.rtCreateDate = rtCreateDate;
    }

    public Date getRtLeaveDateBegin() {
        return rtLeaveDateBegin;
    }

    public void setRtLeaveDateBegin(Date rtLeaveDateBegin) {
        this.rtLeaveDateBegin = rtLeaveDateBegin;
    }

    public Date getRtLeaveDateEnd() {
        return rtLeaveDateEnd;
    }

    public void setRtLeaveDateEnd(Date rtLeaveDateEnd) {
        this.rtLeaveDateEnd = rtLeaveDateEnd;
    }

    public Date getRtApprovedDate() {
        return rtApprovedDate;
    }

    public void setRtApprovedDate(Date rtApprovedDate) {
        this.rtApprovedDate = rtApprovedDate;
    }

    public Integer getRtStatus() {
        return rtStatus;
    }

    public void setRtStatus(Integer rtStatus) {
        this.rtStatus = rtStatus;
    }

    public String getRtApprover() {
        return rtApprover;
    }

    public void setRtApprover(String rtApprover) {
        this.rtApprover = rtApprover;
    }

    public User getRtUser() {
        return rtUser;
    }

    public void setRtUser(User rtUser) {
        this.rtUser = rtUser;
    }

    public Reason getRtReason() {
        return rtReason;
    }

    public void setRtReason(Reason rtReason) {
        this.rtReason = rtReason;
    }

    public String getRtDescription() {
        return rtDescription;
    }

    public void setRtDescription(String rtDescription) {
        this.rtDescription = rtDescription;
    }

    public String getCheckDuplicate() {
        return checkDuplicate;
    }

    public void setCheckDuplicate(String checkDuplicate) {
        this.checkDuplicate = checkDuplicate;
    }
}
