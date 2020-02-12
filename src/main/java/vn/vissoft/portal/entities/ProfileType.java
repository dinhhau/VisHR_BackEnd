package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.fileupload.FileUpload;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROFILE_TYPE")
public class ProfileType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_TYPE_ID")
    private Integer profileTypeId;

    @Column(name = "PROFILE_TYPE_CODE")
    private String profileTypeCode;

    @Column(name = "PROFILE_TYPE_NAME")
    private String profileTypeName;

    @Column(name = "IS_REQUIRED")
    private Integer is_required;

    @Column(name = "IS_MULTIPLE")
    private Integer is_multiple;

    @Column(name = "STATUS")
    private Integer status = 1;

    @OneToMany(mappedBy = "profileType")
    private List<Profile> profiles;

    @JsonIgnore
    public List<Profile> getProfiles() {
        return profiles;
    }

    @JsonIgnore
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public Integer getProfileTypeId() {
        return profileTypeId;
    }

    public void setProfileTypeId(Integer profileTypeId) {
        this.profileTypeId = profileTypeId;
    }

    public String getProfileTypeCode() {
        return profileTypeCode;
    }

    public void setProfileTypeCode(String profileTypeCode) {
        this.profileTypeCode = profileTypeCode;
    }

    public String getProfileTypeName() {
        return profileTypeName;
    }

    public void setProfileTypeName(String profileTypeName) {
        this.profileTypeName = profileTypeName;
    }

    public Integer getIs_required() {
        return is_required;
    }

    public void setIs_required(Integer is_required) {
        this.is_required = is_required;
    }

    public Integer getIs_multiple() {
        return is_multiple;
    }

    public void setIs_multiple(Integer is_multiple) {
        this.is_multiple = is_multiple;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
