package com.project.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@Embeddable
public class Student_subjects implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "FK_semester")
	@JoinColumn(name = "semester_id", nullable = false, unique = false)
	private Semester semester;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subjects_id", nullable = false, unique = false)
	private Subjects subjects;

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

}
