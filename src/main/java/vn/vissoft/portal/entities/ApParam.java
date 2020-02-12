package vn.vissoft.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AP_PARAM")
public class ApParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer apID;

    @Column(name = "PAR_TYPE")
    private String parType;

    @Column(name = "PAR_CODE")
    private String parCode;

    @Column(name = "PARAM_VALUE")
    private String parValue;

    @Column(name = "STATUS")
    private Integer status;

    public Integer getAP_id() {
        return apID;
    }

    public void setAP_id(Integer aP_id) {
        apID = aP_id;
    }

    public String getPar_type() {
        return parType;
    }

    public void setPar_type(String par_type) {
        this.parType = par_type;
    }

    public String getPar_code() {
        return parCode;
    }

    public void setPar_code(String par_code) {
        this.parCode = par_code;
    }

    public String getPar_value() {
        return parValue;
    }

    public void setPar_value(String par_value) {
        this.parValue = par_value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
