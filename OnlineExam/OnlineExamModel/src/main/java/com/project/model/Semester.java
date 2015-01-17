package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "semester")
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "semesterno", nullable = false, length = 45)
	private int semesterno;

	@Column(name = "semesterStatus", nullable = false, length = 45)
	private boolean semesterStatus;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "student_subjects.semester")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Student_semester_subjects student_semester_subjects;

	public long getId() {
		return id;
	}

	public Student_semester_subjects getStudent_semester_subjects() {
		return student_semester_subjects;
	}

	public void setStudent_semester_subjects(
			Student_semester_subjects student_semester_subjects) {
		this.student_semester_subjects = student_semester_subjects;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSemesterno() {
		return semesterno;
	}

	public void setSemesterno(int semesterno) {
		this.semesterno = semesterno;
	}

	public boolean isSemesterStatus() {
		return semesterStatus;
	}

	public void setSemesterStatus(boolean semesterStatus) {
		this.semesterStatus = semesterStatus;
	}

}
