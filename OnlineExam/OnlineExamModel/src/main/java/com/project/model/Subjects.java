package com.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import com.project.enums.StreamType;

@Entity
@Table(name = "subjects")
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "subject_name", nullable = false, length = 45)
	private String subject_name;

	@Column(name = "subject_code", nullable = false, length = 45, unique = true)
	private String subject_code;

	@Column(name = "streamType", updatable = true)
	private StreamType streamType;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "student_subjects.subjects")
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "FK_subjects")
	private Set<Student_semester_subjects> semester_subjects;

	public Set<Student_semester_subjects> getSemester_subjects() {
		return semester_subjects;
	}

	public void setSemester_subjects(
			Set<Student_semester_subjects> semester_subjects) {
		this.semester_subjects = semester_subjects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public StreamType getStreamType() {
		return streamType;
	}

	public void setStreamType(StreamType streamType) {
		this.streamType = streamType;
	}

}
