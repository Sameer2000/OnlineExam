package com.project.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.DTO.ExamDummy;
import com.project.model.Exam;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;

public interface StudentService {
	
	public abstract void saveStudent(InstituteAccount instituteAccount, StudentAccount studentAccount);
	
	public abstract List<StudentAccount> getStudentsnyInsId(Long id);
	
	public abstract Set<StudentAccount> getStudentbyStream(String stream);
	
	public abstract void saveStudentExam(ExamDummy examDummy, StudentAccount studentAccount, Exam exam);
	
	public abstract StudentAccount getStudentByRegistration(String reg);
	
	public abstract Map<Integer, Integer> getStudentScore(String studentRegNo);

}
