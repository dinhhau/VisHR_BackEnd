package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="title")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TITLE_ID")
    private Integer titleId;

    @Column(name = "TITLE_CODE")
    private String titleCode;

    @Column(name = "TITLE_NAME")
    private String titleName;

    @Column(name = "STATUS")
    private Integer status = 1;

    @OneToMany(mappedBy = "title")
    private List<User> users;

    public Title() {}

    public Title(Integer titleId, String titleCode, String titleName, Integer status) {
        this.titleId = titleId;
        this.titleCode = titleCode;
        this.titleName = titleName;
        this.status = status;
    }

    @JsonIgnore
    public List<User> getUsers() {
        return users;
    }

    @JsonIgnore
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
