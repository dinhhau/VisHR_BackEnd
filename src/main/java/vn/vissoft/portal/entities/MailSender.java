package vn.vissoft.portal.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAILSENDER")
public class MailSender {

    @Id
    @Column(name = "ID_MAIL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mail;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user_id;

    @Column(name= "CREATE_DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date create_date;

    @Column(name = "LEAVE_DATE_BEGIN")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date leave_date_begin;

    @Column(name = "LEAVE_DATE_END")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date leave_date_end;

    @Column(name = "APPROVED")
    private String approved;

    @Column(name = "DECRIPTION")
    private String decription;

    @Column(name = "STATUS_MAIL")
    private Integer status_mail;

    @ManyToOne
    @JoinColumn(name = "REASON_ID")
    private Reason reason;

    @Column(name = "TOTAL_TIMEOFF")
    private Integer total_timeoff;

    @Column(name = "APPROVED_DATE")
    private Date approved_date;

    @Column(name = "TYPE_ID")
    private Integer type_id;

    @Column(name = "STATUS_TO")
    private Integer status_to;

    @Column(name = "MANAGER_LEVEL2")
    private String manager_lvl2;

    @Column(name = "NOTE")
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getManager_lvl2() {
        return manager_lvl2;
    }

    public void setManager_lvl2(String manager_lvl2) {
        this.manager_lvl2 = manager_lvl2;
    }

    public Integer getStatus_to() {
        return status_to;
    }

    public void setStatus_to(Integer status_to) {
        this.status_to = status_to;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Date getApproved_date() {
        return approved_date;
    }

    public void setApproved_date(Date approved_date) {
        this.approved_date = approved_date;
    }

    public Integer getId_mail() {
        return id_mail;
    }

    public void setId_mail(Integer id_mail) {
        this.id_mail = id_mail;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLeave_date_begin() {
        return leave_date_begin;
    }

    public void setLeave_date_begin(Date leave_date_begin) {
        this.leave_date_begin = leave_date_begin;
    }

    public Date getLeave_date_end() {
        return leave_date_end;
    }

    public void setLeave_date_end(Date leave_date_end) {
        this.leave_date_end = leave_date_end;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getStatus_mail() {
        return status_mail;
    }

    public void setStatus_mail(Integer status_mail) {
        this.status_mail = status_mail;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public Integer getTotal_timeoff() {
        return total_timeoff;
    }

    public void setTotal_timeoff(Integer total_timeoff) {
        this.total_timeoff = total_timeoff;
    }
}
