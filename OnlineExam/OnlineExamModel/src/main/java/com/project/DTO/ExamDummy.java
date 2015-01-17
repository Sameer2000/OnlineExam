package com.project.DTO;

import java.util.ArrayList;
import java.util.List;

import com.project.model.Exam;
import com.project.model.Options;
import com.project.model.Questions;
import com.project.model.Subjects;

public class ExamDummy {

	private String subjectName;

	private int time;

	private List<QuestionForm> questionFormsList = new ArrayList<QuestionForm>();

	private QuestionForm form;

	private List<String> options;

	public void addQuestion(Exam exam, Subjects subjects, int time) {
		setSubjectName(subjects.getSubject_name());
		setTime(time);
		for (Questions q : exam.getQuestions()) {
			form = new QuestionForm();
			form.setQuestion(q.getQuestion());
			options = new ArrayList<String>();
			for (Options o : q.getOptions()) {
				options.add(o.getOptionName());
			}
			form.setOptions(options);
			questionFormsList.add(form);
		}
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public List<QuestionForm> getQuestionFormsList() {
		return questionFormsList;
	}

	public void setQuestionFormsList(List<QuestionForm> questionFormsList) {
		this.questionFormsList = questionFormsList;
	}

}
