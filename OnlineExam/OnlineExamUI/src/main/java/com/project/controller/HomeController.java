package com.project.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.DTO.UserFormDTO;
import com.project.model.Contact;

public interface HomeController {

	public abstract ModelAndView home(UserFormDTO userFormDTO, Locale locale);

	public abstract ModelAndView contact(Contact contact, String msg);

	public abstract ModelAndView validate(UserFormDTO userFormDTO, HttpServletRequest request);

	public ModelAndView saveContactQuery(Contact contact);

}
