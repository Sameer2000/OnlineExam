package com.project.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import com.project.enums.ExamStatus;
import com.project.enums.StreamType;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "examCode", unique = true, length = 45)
	private String examCode;

	@Column(name = "streamType", nullable = false, length = 45)
	private StreamType streamType;

	@Column(name = "subject_id", nullable = false, length = 45)
	private String subject;

	@Column(name = "examStatus", nullable = false, length = 45)
	private ExamStatus examStatus;

	@Column(name = "active", nullable = false, length = 45)
	private boolean active;

	@Column(name = "examdate", nullable = false, length = 45, unique = true)
	private Date examdate;

	@Column(name = "duration", nullable = true)
	private Time examduration;

	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@ForeignKey(name = "FK_questions")
	@JoinColumn(name = "exam_id", nullable = false)
	private Set<Questions> questions;

	@Column(name = "createdOn", nullable = false, length = 45)
	private Date createdOn;

	@Column(name = "createdBy", nullable = false, length = 45)
	private String createdBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StreamType getStreamType() {
		return streamType;
	}

	public void setStreamType(StreamType streamType) {
		this.streamType = streamType;
	}

	public ExamStatus getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(ExamStatus examStatus) {
		this.examStatus = examStatus;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getExamdate() {
		return examdate;
	}

	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

	public Set<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public Time getExamduration() {
		return examduration;
	}

	public void setExamduration(Time examduration) {
		this.examduration = examduration;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
