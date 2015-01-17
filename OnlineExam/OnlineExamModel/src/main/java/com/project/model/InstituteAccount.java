package com.project.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "instituteaccount")
public class InstituteAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "center_code", nullable = false, unique = true, length = 45)
	private String center_code;

	@Column(name = "center_password", nullable = false, length = 45)
	private String center_password;

	@Column(name = "center_name", nullable = false, length = 100)
	private String center_name;

	@Column(name = "contact", nullable = false, unique = true, length = 45)
	private String contact;

	@Column(name = "last_login", nullable = true, length = 45)
	private Timestamp last_login;

	@Column(name = "active", nullable = false, length = 45)
	private boolean active;

	@Column(name = "login_key", nullable = true, length = 45)
	private String login_key;

	@Column(name = "key_status", nullable = true, length = 45)
	private boolean key_status;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "FK_studentAccounts")
	@JoinColumn(name = "studentAccounts_id", nullable = false, unique = false)
	private List<StudentAccount> studentAccounts;

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@ForeignKey(name = "FK_address")
	@JoinColumn(name = "address_id", nullable = false, unique = true)
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<StudentAccount> getStudentAccounts() {
		return studentAccounts;
	}

	public void setStudentAccounts(List<StudentAccount> studentAccounts) {
		this.studentAccounts = studentAccounts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCenter_code() {
		return center_code;
	}

	public void setCenter_code(String center_code) {
		this.center_code = center_code;
	}

	public String getCenter_password() {
		return center_password;
	}

	public void setCenter_password(String center_password) {
		this.center_password = center_password;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

	public Timestamp getLast_login() {
		return last_login;
	}

	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLogin_key() {
		return login_key;
	}

	public void setLogin_key(String login_key) {
		this.login_key = login_key;
	}

	public boolean isKey_status() {
		return key_status;
	}

	public void setKey_status(boolean key_status) {
		this.key_status = key_status;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
