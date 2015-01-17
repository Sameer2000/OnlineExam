package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.DTO.ExamDummy;
import com.project.DTO.StudentExamDTO;
import com.project.model.Contact;
import com.project.model.Exam;
import com.project.model.StudentAccount;

public interface InstituteController {

	public abstract ModelAndView studentList(HttpServletRequest request);

	public abstract ModelAndView home();

	public abstract ModelAndView studentExam(StudentExamDTO examDTO, String reg);

	public abstract void submitExam(ExamDummy dummy, String reg, HttpServletRequest request);

	public abstract ModelAndView studentRegistration(
			StudentAccount studentAccount);

	public abstract ModelAndView saveStudent(StudentAccount studentAccount,
			HttpServletRequest request);

	public abstract ModelAndView exam(String time, String reg, HttpServletRequest request);

	public abstract ModelAndView validateStudent(StudentExamDTO studentExamDTO,
			HttpServletRequest request);

	public abstract ModelAndView logout(HttpServletRequest request); 
	
}
