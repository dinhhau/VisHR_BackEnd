package vn.vissoft.portal.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "CREATE_IDEA")
public class CreateIdea implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
    private Integer createIdeaId;

//    @Column(name = "CONTENT_IDEA")
    private String contentIdea;

//    @Column(name = "START_DATE")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;

//    @Column(name = "END_DATE")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;

//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
    private User user;

//    @Column(name = "STATUS")
    private Integer status;

    public Integer getCreateIdeaId() {
        return createIdeaId;
    }

    public void setCreateIdeaId(Integer createIdeaId) {
        this.createIdeaId = createIdeaId;
    }

    public String getContentIdea() {
        return contentIdea;
    }

    public void setContentIdea(String contentIdea) {
        this.contentIdea = contentIdea;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
