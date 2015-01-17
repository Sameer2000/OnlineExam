package com.project.controllerImpl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.DTO.ExamDummy;
import com.project.DTO.StudentExamDTO;
import com.project.constants.Constants;
import com.project.controller.InstituteController;
import com.project.enums.StreamType;
import com.project.model.Exam;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;
import com.project.model.Subjects;
import com.project.service.ContactService;
import com.project.service.ExamService;
import com.project.service.InstituteService;
import com.project.service.StudentService;
import com.project.service.SubjectService;

@Controller
@RequestMapping("/institute/**")
public class InstituteControllerImpl implements InstituteController {

	@Autowired
	protected InstituteService instituteService;

	@Autowired
	protected StudentService studentService;

	@Autowired
	protected ExamService examService;
	
	@Autowired
	protected SubjectService subjectService;
	
	@Autowired
	protected ContactService contactService;

	@Override
	@RequestMapping(value = "/student-list", method = RequestMethod.GET)
	public ModelAndView studentList(HttpServletRequest request) {
		InstituteAccount instituteAccount = (InstituteAccount) request
				.getSession(false).getAttribute("institute");
		ModelAndView mv = new ModelAndView("institute_student_list");
		mv.addObject("students", instituteService.getStudentList(instituteAccount));
		return mv;
	}

	@Override
	@RequestMapping(value = "/student-exam", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView studentExam(
			@ModelAttribute("studentexam") StudentExamDTO examDTO, @RequestParam(value = "reg", required = false) String reg) {
		if(reg != null){
			Map<Integer, Integer> score = studentService.getStudentScore(reg);
			return new ModelAndView("institute_student_exam", "score", score);
		}
		return new ModelAndView("institute_student_exam");
	}

	@Override
	@RequestMapping(value = "/student-registration", method = RequestMethod.GET)
	public ModelAndView studentRegistration(
			@ModelAttribute("student_reg") StudentAccount studentAccount) {
		ModelAndView mv = new ModelAndView("institute_student-registration");
		mv.addObject("streams", StreamType.values());
		return mv;
	}

	@Override
	@RequestMapping(value = "/home", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView home() {
		return new ModelAndView("institute_home");
	}

	@Override
	@RequestMapping(value = "/save_student", method = RequestMethod.POST)
	public ModelAndView saveStudent(
			@ModelAttribute("student_reg") StudentAccount studentAccount,
			HttpServletRequest request) {
		InstituteAccount instituteAccount = (InstituteAccount) request
				.getSession(false).getAttribute("institute");
		studentService.saveStudent(instituteAccount, studentAccount);
		return new ModelAndView("redirect:/institute/student-list");
	}

	@Override
	@RequestMapping(value = "/submitExam", method = RequestMethod.POST)
	public void submitExam(@ModelAttribute("examForm") ExamDummy dummy, @RequestParam("reg") String reg, HttpServletRequest request) {
		Exam exam = (Exam)request.getSession(false).getAttribute("exam");
		studentService.saveStudentExam(dummy, studentService.getStudentByRegistration(reg), exam);
	}

	@Override
	@RequestMapping(value = "/validateStudent", method = RequestMethod.POST)
	public ModelAndView validateStudent(
			@ModelAttribute("studentexam") StudentExamDTO studentExamDTO,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Exam exam = instituteService.validateStudent(studentExamDTO);
		if (exam != null) {
			HttpSession session = request.getSession(false);
			session.setAttribute("exam", exam);
			int time = (exam.getExamduration().getHours() * 3600 );
			mv.setViewName("institute_start_exam");
			mv.addObject("subject", subjectService.getSubjectbyId(Long.valueOf(exam.getSubject())));
			mv.addObject("time", time);
			mv.addObject("reg", studentExamDTO.getRegistration());
			return mv;
		} else {
			mv.setViewName("redirect:/institute/student-exam");
			mv.addObject("err", Constants.LOGIN_ERR);
			return mv;
		}
	}

	@Override
	@RequestMapping(value = "/exam", method = RequestMethod.GET)
	public ModelAndView exam(@RequestParam(value = "time", required = false) String time,@RequestParam("reg")String reg, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("institute_exam");
		Exam exam = (Exam)request.getSession(false).getAttribute("exam");
		int t = Integer.parseInt(time);
		
		Subjects subject = subjectService.getSubjectbyId(Long.valueOf(exam.getSubject()));
		ExamDummy dummy = new ExamDummy();
		dummy.addQuestion(exam, subject, t);
		
		mv.addObject("time", t);
		mv.addObject("reg", reg);
		mv.addObject("exam", dummy);
		return mv;
	}

	@Override
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:");
	}

	

}
