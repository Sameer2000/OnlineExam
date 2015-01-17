package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.DTO.ExamDummy;
import com.project.DTO.UserFormDTO;
import com.project.DTO.ExamDto;
import com.project.DTO.InstituteRegistrationDTO;
import com.project.model.InstituteAccount;

public interface AdminController {
	
	public abstract ModelAndView adminLogin();
	
	public abstract ModelAndView adminHome();
	
	public abstract ModelAndView validateAdmin(UserFormDTO adminForm, HttpServletRequest request);
	
	public abstract ModelAndView examList();
	
	public abstract ModelAndView viewQuestions(String questionId);
	
	public abstract ModelAndView createExam(ExamDto examDto);

	public abstract ModelAndView addQuestions();
	
	public abstract ModelAndView completeExam(ExamDto examDto, HttpServletRequest request);
	
	public abstract ModelAndView instituteRegistration(InstituteRegistrationDTO instituteRegistrationDTO); 
	
	public abstract ModelAndView saveInstitute(InstituteRegistrationDTO instituteRegistrationDTO);
	
	public abstract ModelAndView deleteExam(long examId);
	
	public abstract ModelAndView viewQueries();
	
	public abstract ModelAndView logoutAdmin(HttpServletRequest request);
	
}
