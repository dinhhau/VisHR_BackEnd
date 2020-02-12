package vn.vissoft.portal.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table
@Entity(name = "EXTENAL_NOTIFY_LOG")
public class ExtenalNotify implements Serializable {

    @Id
    @Column(name = "ENL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enlId;

    @Column(name = "TYPE")
    private Integer enType;

    @Column(name = "STATUS")
    private Integer enStatus;

    @Column(name  = "SEND_DATE")
    private Date enSendDate;

    @Column(name = "CONTENT")
    private String enContent;

    @ManyToOne
    @JoinColumn(name = "TIMEOFF_ID")
    private TimeOff enTimeOff;

    public Integer getEnlId() {
        return enlId;
    }

    public void setEnlId(Integer enlId) {
        this.enlId = enlId;
    }

    public Integer getEnType() {
        return enType;
    }

    public void setEnType(Integer enType) {
        this.enType = enType;
    }

    public Integer getEnStatus() {
        return enStatus;
    }

    public void setEnStatus(Integer enStatus) {
        this.enStatus = enStatus;
    }

    public Date getEnSendDate() {
        return enSendDate;
    }

    public void setEnSendDate(Date enSendDate) {
        this.enSendDate = enSendDate;
    }

    public TimeOff getEnTimeOff() {
        return enTimeOff;
    }

    public void setEnTimeOff(TimeOff enTimeOff) {
        this.enTimeOff = enTimeOff;
    }

    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent;
    }

}
