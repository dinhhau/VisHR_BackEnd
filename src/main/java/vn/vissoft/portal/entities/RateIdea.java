package vn.vissoft.portal.entities;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "RATES_IDEA")
public class RateIdea implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
    private Integer rateIdeaId;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CREATE_IDEA_ID")
    private CreateIdea createIdea;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "USER_ID")
    private User user;

//    @Column(name = "FEEDBACK")
    private String feedback;

//    @Column(name = "RATE_TYPE")
    private Integer rateType;

//    @Column(name = "STATUS")
    private Integer status;

    public Integer getRateIdeaId() {
        return rateIdeaId;
    }

    public void setRateIdeaId(Integer rateIdeaId) {
        this.rateIdeaId = rateIdeaId;
    }

    public CreateIdea getCreateIdea() {
        return createIdea;
    }

    public void setCreateIdea(CreateIdea createIdea) {
        this.createIdea = createIdea;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
