package vn.vissoft.portal.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "ASSET")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSET_ID")
    private Integer asset_id;

    @Column(name = "ASSET_CODE")
    private String asset_code;

    @Column(name = "ASSET_NAME")
    private String asset_name;

    @Column(name = "ASSET_DATE")
    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date asset_date;

    @Column(name = "MONEY")
    private Float money;

    @Column(name = "AMOUNT")
        private Integer asset_amount;

    public Integer getAsset_amount() {
        return asset_amount;
    }

    public void setAsset_amount(Integer asset_amount) {
        this.asset_amount = asset_amount;
    }

    @ManyToOne
    @JoinColumn(name = "ASSET_MANAGER")
    private User asset_manager;

    @ManyToOne
    @JoinColumn(name = "ASSET_USER")
    private User asset_user;


    @Column(name = "DEPRECIATION_PERIOD")
    private Integer depreciation_period;

    @Column(name = "IS_DELETED")
    private Integer is_deleted;

    @Column(name = "IMAGE")
    private String image;

    public User getAsset_user() {
        return asset_user;
    }

    public void setAsset_user(User asset_user) {
        this.asset_user = asset_user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Integer getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(Integer asset_id) {
        this.asset_id = asset_id;
    }

    public String getAsset_code() {
        return asset_code;
    }

    public void setAsset_code(String asset_code) {
        this.asset_code = asset_code;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public Date getAsset_date() {
        return asset_date;
    }

    public void setAsset_date(Date asset_date) {
        this.asset_date = asset_date;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public User getAsset_manager() {
        return asset_manager;
    }

    public void setAsset_manager(User asset_manager) {
        this.asset_manager = asset_manager;
    }

    public Integer getDepreciation_period() {
        return depreciation_period;
    }

    public void setDepreciation_period(Integer depreciation_period) {
        this.depreciation_period = depreciation_period;
    }
}
