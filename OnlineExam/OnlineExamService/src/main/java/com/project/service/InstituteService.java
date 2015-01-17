package com.project.service;

import java.util.List;

import com.project.DTO.InstituteRegistrationDTO;
import com.project.DTO.StudentExamDTO;
import com.project.DTO.UserFormDTO;
import com.project.model.Exam;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;

public interface InstituteService {
	
	public abstract List<InstituteAccount> getInstituteList();
	
	public abstract void saveInstituteAccount(InstituteRegistrationDTO instituteRegistrationDTO);
	
	public abstract InstituteAccount validateAdmin(UserFormDTO adminForm);
	
	public abstract List<String> getInstituteKeys();
	
	public abstract List<String> createInstituteKeys();
	
	public abstract Exam validateStudent(StudentExamDTO studentExamDTO);
	
	public abstract List<StudentAccount> getStudentList(InstituteAccount instituteAccount);

}
