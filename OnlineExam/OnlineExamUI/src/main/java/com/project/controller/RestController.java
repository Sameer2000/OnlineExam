package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RestController {

	public abstract String saveQuestion(String question, List<String> options,
			String isSubmit, Long id, String correct, HttpServletRequest request, HttpServletResponse response) throws IOException;

	public abstract String getSubjects(String stream)
			throws JsonProcessingException;
	
}
