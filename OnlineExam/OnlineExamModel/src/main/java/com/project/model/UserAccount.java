package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import com.project.enums.UserType;

@Entity
@Table(name = "useraccount")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "username", nullable = false, /*unique = true,*/ length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 45)
	private String password;

	
	@Column(name = "usertype")
	private UserType userType;

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@ForeignKey(name = "FK_student_account")
	@JoinColumn(name = "studentAccount_id", insertable = true, updatable = true)
	private StudentAccount studentAccount;

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@ForeignKey(name = "FK_admin_account")
	@JoinColumn(name = "adminAccount_id", insertable = true, updatable = true)
	private AdminAccount adminAccount;

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@ForeignKey(name = "FK_instituteAccount")
	@JoinColumn(name = "instituteAccount_id", insertable = true, updatable = true)
	private InstituteAccount instituteAccount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public StudentAccount getStudentAccount() {
		return studentAccount;
	}

	public void setStudentAccount(StudentAccount studentAccount) {
		this.studentAccount = studentAccount;
	}

	public AdminAccount getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(AdminAccount adminAccount) {
		this.adminAccount = adminAccount;
	}

	public InstituteAccount getInstituteAccount() {
		return instituteAccount;
	}

	public void setInstituteAccount(InstituteAccount instituteAccount) {
		this.instituteAccount = instituteAccount;
	}

}
