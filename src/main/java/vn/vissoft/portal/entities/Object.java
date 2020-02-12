package vn.vissoft.portal.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OBJECT")
public class Object implements Serializable {
    @Id
    @Column(name = "OBJECT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ObjectId;

    @Column(name = "OBJECT_CODE")
    private String ObjectCode;

    @Column(name = "OBJECT_NAME")
    private String ObjectName;

    @Column(name = "object_url")
    private String ObjectUrl;

    @Column(name = "object_icon")
    private String object_icon;

    @Column(name = "status")
    private Integer status;

	public Object() {

	}

	public Object(String objectCode, String objectName, String objectUrl, String object_icon, Integer status) {
		ObjectCode = objectCode;
		ObjectName = objectName;
		ObjectUrl = objectUrl;
		this.object_icon = object_icon;
		this.status = status;
	}

	public Integer getObjectId() {
        return ObjectId;
    }

    public void setObjectId(Integer objectId) {
        ObjectId = objectId;
    }

    public String getObjectCode() {
        return ObjectCode;
    }

    public void setObjectCode(String objectCode) {
        ObjectCode = objectCode;
    }

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public String getObjectUrl() {
        return ObjectUrl;
    }

    public void setObjectUrl(String objectUrl) {
        ObjectUrl = objectUrl;
    }

    public String getObject_icon() {
        return object_icon;
    }

    public Integer getStatus() {
        return status;
    }

	public void setObject_icon(String object_icon) {
		this.object_icon = object_icon;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
