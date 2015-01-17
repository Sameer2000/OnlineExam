package com.project.DTOtoEntityconverter;

import java.sql.Date;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.project.DTO.ExamDto;
import com.project.enums.ExamStatus;
import com.project.enums.StreamType;
import com.project.model.Exam;
import com.project.model.Options;
import com.project.model.Questions;

public class ExamDTOtoEntityConverter {

	private ExamDTOtoEntityConverter() {
	}

	public static Exam saveExam(ExamDto examDto) throws ParseException {
		Exam exam = new Exam();
		exam.setActive(true);
		exam.setCreatedBy(examDto.getCreatedBy());
		exam.setCreatedOn(new Date(new java.util.Date().getTime()));
		exam.setExamCode(examDto.getCode());
		exam.setExamdate(examDto.getDate());
		exam.setExamduration(examDto.getSavedTime());
		exam.setExamStatus(ExamStatus.NOT_SUBMITTED);
		exam.setSubject(examDto.getSubjectName());
		exam.setStreamType(StreamType.valueOf(examDto.getStream()));
		return exam;
	}

	public static Exam updateExam(Exam exam,
			Map<List<String>, List<List<String>>> savedQuestions) {
		Set<Questions> questions = new HashSet<Questions>();
		Set<Options> options = new HashSet<Options>();

		Questions q = null;
		Options option = null;
		for (List<String> question : savedQuestions.keySet()) {
			for(String ques : question){
				q = new Questions();
				q.setQuestion(ques);
				questions.add(q);
			}
			for (List<String> savedOptions : savedQuestions.get(question)) {
				for(String opt : savedOptions){
					option = new Options();
					option.setOptionName(opt);
					options.add(option);
				}
			}
		}
		
		q.setOptions(options);
		exam.setQuestions(questions);
		return exam;
	}

}
