package vn.vissoft.portal.helper;

import vn.vissoft.portal.entities.Reason;
import vn.vissoft.portal.entities.User;

public class TimeOffResponse {

    private Integer rtID;

    private String rtCreateDate;

    private String rtLeaveDateBegin;

    private String rtLeaveDateEnd;

    private String rtApprovedDate;

    private Integer rtStatus;

    private String rtApprover;

    private User rtUser;

    private Reason rtReason;

    private String rtDescription;

    public Integer getRtID() {
        return rtID;
    }

    public void setRtID(Integer rtID) {
        this.rtID = rtID;
    }

    public String getRtCreateDate() {
        return rtCreateDate;
    }

    public void setRtCreateDate(String rtCreateDate) {
        this.rtCreateDate = rtCreateDate;
    }

    public String getRtLeaveDateBegin() {
        return rtLeaveDateBegin;
    }

    public void setRtLeaveDateBegin(String rtLeaveDateBegin) {
        this.rtLeaveDateBegin = rtLeaveDateBegin;
    }

    public String getRtLeaveDateEnd() {
        return rtLeaveDateEnd;
    }

    public void setRtLeaveDateEnd(String rtLeaveDateEnd) {
        this.rtLeaveDateEnd = rtLeaveDateEnd;
    }

    public String getRtApprovedDate() {
        return rtApprovedDate;
    }

    public void setRtApprovedDate(String rtApprovedDate) {
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
}
