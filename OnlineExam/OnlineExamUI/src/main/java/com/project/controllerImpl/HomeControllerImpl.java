package com.project.controllerImpl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.DTO.UserFormDTO;
import com.project.constants.Constants;
import com.project.controller.HomeController;
import com.project.model.Contact;
import com.project.model.InstituteAccount;
import com.project.service.ContactService;
import com.project.service.InsertDataService;
import com.project.service.InstituteService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeControllerImpl implements HomeController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	protected InstituteService instituteService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeControllerImpl.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("adminDetails") UserFormDTO userFormDTO, Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ModelAndView model = new ModelAndView("guest_home");
		return model;
	}

	@Override
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(@ModelAttribute("contact") Contact contact, @RequestParam(value = "msg", required = false) String msg) {
		return new ModelAndView("guest_contact", "msg", msg);
	}

	@Override
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("adminDetails") UserFormDTO adminForm, HttpServletRequest request) {
		InstituteAccount instituteAccount = instituteService.validateAdmin(adminForm);
		ModelAndView mv = new ModelAndView();
		if(instituteAccount != null){
			HttpSession instituteSession = request.getSession();
			instituteSession.setMaxInactiveInterval(0);
			instituteSession.setAttribute("institute", instituteAccount);
			mv.setViewName("redirect:/institute/home");
			return mv;
		}
		else{
			mv.setViewName("redirect:/");
			return mv;
		}
	}

	@RequestMapping(value = "/submitQuery", method = RequestMethod.POST)
	public ModelAndView saveContactQuery(@ModelAttribute("query") Contact contact) {
		contactService.saveContactQuery(contact);
		return new ModelAndView("redirect:/contact", "msg", Constants.CONTACT_SAVED);
	}
}
