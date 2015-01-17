package com.project.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_semester_subjects")
public class Student_semester_subjects {

	@EmbeddedId
	private Student_subjects student_subjects;

	public Student_subjects getStudent_subjects() {
		return student_subjects;
	}

	public void setStudent_subjects(Student_subjects student_subjects) {
		this.student_subjects = student_subjects;
	}

}
