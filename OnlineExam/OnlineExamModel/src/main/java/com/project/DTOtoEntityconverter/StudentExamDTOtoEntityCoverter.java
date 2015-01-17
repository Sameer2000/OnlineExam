package com.project.DTOtoEntityconverter;

import java.util.HashSet;
import java.util.Set;

import com.project.DTO.ExamDummy;
import com.project.DTO.QuestionForm;
import com.project.model.Exam;
import com.project.model.Questions;
import com.project.model.StudentExam;

public class StudentExamDTOtoEntityCoverter {

	public static Set<StudentExam> saveStudentExam(ExamDummy examDummy, Exam exam){
		Set<StudentExam> studentExam = new HashSet<StudentExam>();
		StudentExam sExam;
		for(QuestionForm form: examDummy.getQuestionFormsList()){
			sExam = new StudentExam();
			sExam.setQuestion(form.getQuestion());
			sExam.setAnswer(form.getAnswer());
			sExam.setScore(0);
			studentExam.add(sExam);
		}
		for(StudentExam e : studentExam){
			for(Questions q : exam.getQuestions()){
				if(e.getAnswer().equals(q.getAnswer())){
					e.setScore(1);
				}
			}
		}
		return studentExam;
	}
	
}
