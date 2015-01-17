package com.project.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import com.project.enums.StreamType;

@Entity
@Table(name = "studentaccount")
public class StudentAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long student_id;

	@Column(name = "firstName", nullable = false, length = 45)
	private String firstName;

	@Column(name = "lastName", length = 45)
	private String lastName;

	@Column(name = "dob", nullable = false, length = 45)
	private Date dob;

	@Column(name = "contact")
	private String contact;

	@Column(name = "email")
	private String email;

	@Column(name = "last_login", nullable = true, length = 45)
	private Timestamp last_login;

	@Column(name = "registration_no", nullable = false, unique = true, length = 45)
	private String registration_no;

	@Column(name = "active", nullable = false, length = 45)
	private boolean active;

	@Column(name = "stream", nullable = false, length = 45)
	private StreamType stream;

	@OneToOne(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@ForeignKey(name = "FK_qualifications")
	@JoinColumn(name = "qualifications_id", nullable = true, unique = false)
	private Qualifications qualifications;

	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "FK_exam_id")
	@JoinColumn(name = "student_account_id", nullable = true)
	private Set<StudentExam> exams;

	public Qualifications getQualifications() {
		return qualifications;
	}

	public void setQualifications(Qualifications qualifications) {
		this.qualifications = qualifications;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getLast_login() {
		return last_login;
	}

	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}

	public String getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public StreamType getStream() {
		return stream;
	}

	public void setStream(StreamType stream) {
		this.stream = stream;
	}

	public Set<StudentExam> getExams() {
		return exams;
	}

	public void setExams(Set<StudentExam> exams) {
		this.exams = exams;
	}

}
