package vn.vissoft.portal.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VIS_RULES")
public class Visrules {

    @Id
    @Column(name = "RULE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruleid;

    @Column(name = "RULE_CODE")
    private String rulecode;

    @Column(name = "RULE_TITLE")
    private String ruletitle;

    @Column(name = "RULE_DECRIPTION")
    private String ruledecription;

    @Column(name = "RULE_NOTE")
    private String rulenote;

    @Column(name = "CREATE_DATE")
    private Date createdate;

    @Column(name = "status")
    private Integer status;

    public String getRulecode() {
        return rulecode;
    }

    public void setRulecode(String rulecode) {
        this.rulecode = rulecode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public String getRuletitle() {
        return ruletitle;
    }

    public void setRuletitle(String ruletitle) {
        this.ruletitle = ruletitle;
    }

    public String getRuledecription() {
        return ruledecription;
    }

    public void setRuledecription(String ruledecription) {
        this.ruledecription = ruledecription;
    }

    public String getRulenote() {
        return rulenote;
    }

    public void setRulenote(String rulenote) {
        this.rulenote = rulenote;
    }
}
