package com.project.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.enums.StreamType;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;

public interface StudentDao {

	public abstract void saveStudent(InstituteAccount instituteAccount, StudentAccount studentAccount);
	
	public abstract List<StudentAccount> getStudentbyInsId(Long id);
	
	public abstract Set<StudentAccount> getStudentbyStream(String stream);
	
	public abstract StreamType checkRegistration(String registration);
	
	public abstract void saveStudentExam(StudentAccount studentAccount);
	
	public abstract StudentAccount getStudentByRegistration(String registration);
	
	public abstract Map<Integer, Integer> getStudentScore(StudentAccount s);
	
}
