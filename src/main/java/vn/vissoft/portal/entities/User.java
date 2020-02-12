
		package vn.vissoft.portal.entities;

		import com.fasterxml.jackson.annotation.JsonFormat;

		import javax.persistence.*;
		import com.fasterxml.jackson.annotation.JsonIgnore;
		import java.io.Serializable;
		import java.util.Date;
		import java.util.List;
@Entity
@Table(name="users", uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_CODE" }), @UniqueConstraint(columnNames = "USER_NAME") })
public class User implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer id;

	@Column(name = "USER_CODE")
	private String code;

	@Column(name = "USER_NAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL")
	private String email;


	@Column(name = "TIMEOFF_LABOR")
	private Integer toLbor;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "MANAGER")
	private String manager;

	@Column(name = "MANAGER_LEVEL2")
	private String managerLevel2;

	@Column(name = "BIRTH_DAY")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDay;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "GENDER")
	private Integer gender;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "IDENTITY_CARD_NUMBER")
	private String identityCardNumber;

	@Column(name = "ISSUE_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date issueDate;

	@Column(name = "issue_place")
	private String issuePlace;

	@Column(name = "HIREDATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date hiredate;

	@Column(name = "START_TIME_WORK")
	private String startTimeWork;

	public String getEndTimeWork() {
		return endTimeWork;
	}

	public void setEndTimeWork(String endTimeWork) {
		this.endTimeWork = endTimeWork;
	}

	@Column(name = "END_TIME_WORK")
	private String endTimeWork;

	@Column(name = "STATUS")
	private Integer status = 1;

	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "TITLE_ID")
	private Title title;

	@OneToMany(mappedBy = "user")
	private List<Profile> profile;

	@Column(name = "BANK_ACCOUNT_NUMBER")
	private String bankAccountNumber;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "BANK_BRANCH")
	private String bankBranch;

	public Integer getToLbor() {
		return toLbor;
	}

	public void setToLbor(Integer toLbor) {
		this.toLbor = toLbor;
	}

	@JsonIgnore
	public List<Profile> getProfile() {
		return profile;
	}

	@JsonIgnore
	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	}

	public String returnPassword() {
		return password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagerLevel2() {
		return managerLevel2;
	}

	public void setManagerLevel2(String managerLevel2) {
		this.managerLevel2 = managerLevel2;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdentityCardNumber() {
		return identityCardNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssuePlace() {
		return issuePlace;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getStartTimeWork() {
		return startTimeWork;
	}

	public void setStartTimeWork(String startTimeWork) {
		this.startTimeWork = startTimeWork;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
}

