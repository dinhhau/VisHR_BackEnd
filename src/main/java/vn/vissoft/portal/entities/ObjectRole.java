package vn.vissoft.portal.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OBJECT_ROLE")
public class ObjectRole implements Serializable {


	@Id
	@Column(name = "OBJECT_ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orId;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role roleId;

	@ManyToOne
	@JoinColumn(name = "OBJECT_ID")
	private Object ObjectId;

	@Column(name = "status")
	private Integer status;

	public ObjectRole() {

	}

	public ObjectRole(Integer orId, Role orRole, Object ObjectId, int status) {
		this.orId = orId;
		this.roleId = orRole;
		this.ObjectId = ObjectId;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getOrId() {
		return orId;
	}

	public void setOrId(Integer orId) {
		this.orId = orId;
	}

	public Role getOrRole() {
		return roleId;
	}

	public void setOrRole(Role orRole) {
		this.roleId = orRole;
	}

	public Object getObjectId() {
		return ObjectId;
	}

	public void setObjectId(Object orObject) {
		this.ObjectId = orObject;
	}
}
