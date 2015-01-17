package com.project.controllerImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.controller.RestController;
import com.project.model.Exam;
import com.project.model.Options;
import com.project.model.Questions;
import com.project.model.Subjects;
import com.project.service.ExamService;
import com.project.service.SubjectService;

@org.springframework.web.bind.annotation.RestController()
@RequestMapping("/rest/**")
public class RestControllerImpl implements RestController {

	@Autowired
	protected SubjectService subjectService;

	@Autowired
	protected ExamService examService;
	
	public Set<Questions> questions = new HashSet<Questions>();

	@Override
	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	public @ResponseBody
	String saveQuestion(
			@RequestParam(value = "question", required = false) String question,
			@RequestParam(value = "options", required = false) List<String> option,
			@RequestParam(value = "q", required = false) String isSubmit,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "correct", required = false) String correct,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		Questions q = new Questions();
		Options op = null;
		q.setQuestion(question);
		Set<Options> optsList = new HashSet<Options>();
		int index = 0;
		String answer = "";
		for(String o : option){
			index++;
			if(index == (Integer.parseInt(correct))){
				answer = o;
			}
			op = new Options();
			op.setOptionName(o);
			optsList.add(op);
		}
		q.setOptions(optsList);
		q.setAnswer(answer);
		if (isSubmit == null) {
			questions.add(q);
			return String.valueOf(questions.size());
		} else {
			questions.add(q);
			Exam exam = examService.getExambyId(id);
			exam.setQuestions(questions);
			examService.updateExam(exam);
			questions = null;
			q = null;
			optsList = null;
			response.sendRedirect(request.getContextPath()+"/admin/examlist");
			return "";
		}
	}

	@Override
	@RequestMapping(value = "/subjects/{stream}", method = RequestMethod.GET)
	public @ResponseBody String getSubjects(@PathVariable("stream") String stream) throws JsonProcessingException {
		// TODO Auto-generated method stub
		List<Subjects> subjects = subjectService.getSubjects(stream);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(subjects);
	}

}
