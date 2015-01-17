package com.project.controllerImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.DTO.ContactDTO;
import com.project.DTO.ExamDummy;
import com.project.DTO.UserFormDTO;
import com.project.DTO.ExamDto;
import com.project.DTO.InstituteRegistrationDTO;
import com.project.controller.AdminController;
import com.project.entityToDTOconverter.ExamEntityToDTOConverter;
import com.project.enums.StreamType;
import com.project.model.AdminAccount;
import com.project.model.Exam;
import com.project.service.AdminAccountService;
import com.project.service.ContactService;
import com.project.service.ExamService;
import com.project.service.InstituteService;
import com.project.service.StatesService;
import com.project.service.SubjectService;

@Controller
@RequestMapping("/admin/**")
public class AdminControllerImpl implements AdminController{

	@Autowired
	protected AdminAccountService adminAccountService;
	
	@Autowired
	protected ExamService examService;
	
	@Autowired
	protected InstituteService instituteService;
	
	@Autowired
	protected StatesService statesService;
	
	@Autowired
	protected SubjectService subjectService;
	
	@Autowired
	protected ContactService contactService;
	
	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView adminLogin(){
		return new ModelAndView("admin_login");
	}
	
	@Override
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validateAdmin(@ModelAttribute("adminDetails") UserFormDTO adminForm, HttpServletRequest request){
		AdminAccount adminAccount = adminAccountService.validateAdmin(adminForm);
		ModelAndView mv = new ModelAndView();
		if(adminAccount != null){
			HttpSession adminSession = request.getSession();
			adminSession.setMaxInactiveInterval(0);
			adminSession.setAttribute("username", adminAccount.getName());
			mv.addObject("institutes", instituteService.getInstituteList());
			mv.setViewName("redirect:/admin/home");
			return mv;
		}
		else{
			mv.setViewName("redirect:/admin/");
			return mv;
		}
	}
	
	@Override
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView mv = new ModelAndView("admin_home");
		mv.addObject("institutes", instituteService.getInstituteList());
		return mv;
	}

	@Override
	@RequestMapping(value = "/examlist", method = RequestMethod.GET)
	public ModelAndView examList() {
		ModelAndView mv = new ModelAndView("admin_exam_list");
		List<ExamDto> dtos = new ArrayList<ExamDto>();
		List<Exam> exams = examService.getExamList();
		for(Exam e : exams){
			ExamDto eDto = ExamEntityToDTOConverter.getExamDTO(e, subjectService.getSubjectbyId(Long.valueOf(e.getSubject())) );
			dtos.add(eDto);
		}
		mv.addObject("exams", dtos);
		return mv;
	}
	
	@Override
	@RequestMapping(value = "/createExam", method = RequestMethod.GET)
	public ModelAndView createExam(@ModelAttribute("exam") ExamDto examDto) {
		ModelAndView mv = new ModelAndView("admin_create_exam");
		String code = String.valueOf((int) (Math.random() * 100000));
		mv.addObject("code", code);
		mv.addObject("stream", StreamType.values());
		return mv;
	}

	@Override
	@RequestMapping(value = "/add_questions", method = RequestMethod.GET)
	public ModelAndView addQuestions() {
		return new ModelAndView("admin_add_questions");
	}


	@Override
	@RequestMapping(value = "/completeExam", method = RequestMethod.POST)
	public ModelAndView completeExam(@ModelAttribute("exam")ExamDto examDto, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin_add_questions");
		examDto.setCreatedBy(request.getSession(false).getAttribute("username").toString());
		Long id = examService.saveExam(examDto);
		mv.addObject("id", id);
		return mv;
	}
	
	@Override
	@RequestMapping(value = "/institute_registration", method = RequestMethod.GET)
	public ModelAndView instituteRegistration(@ModelAttribute("institute_reg") InstituteRegistrationDTO instituteRegistrationDTO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin_institute_registration");
		mv.addObject("states", statesService.getStates());
		return mv;
	}

	@Override
	@RequestMapping(value = "/save_institute", method = RequestMethod.POST)
	public ModelAndView saveInstitute(@ModelAttribute("institute_reg") InstituteRegistrationDTO instituteRegistrationDTO) {
		ModelAndView mv = new ModelAndView();
		instituteService.saveInstituteAccount(instituteRegistrationDTO);
		mv.addObject("institutes", instituteService.getInstituteList());
		return new ModelAndView("redirect: /home");
	}

	@Override
	@RequestMapping(value = "/viewQuestions", method = RequestMethod.GET)
	public ModelAndView viewQuestions(@RequestParam(value = "", required = false) String questionId) {
		ModelAndView mv = new ModelAndView();
		return null;
	}

	@Override
	@RequestMapping(value = "/deleteExam", method = RequestMethod.GET)
	public ModelAndView deleteExam(@RequestParam("id")long examId) {
		examService.deleteExam(examId);
		return new ModelAndView("redirect:/admin/examlist");
	}

	@Override
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutAdmin(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/admin/");
	}

	@Override
	@RequestMapping(value = "/viewQueries", method = RequestMethod.GET)
	public ModelAndView viewQueries() {
		return new ModelAndView("admin_queries", "queries", contactService.viewContactQuery());
	}

	

}
