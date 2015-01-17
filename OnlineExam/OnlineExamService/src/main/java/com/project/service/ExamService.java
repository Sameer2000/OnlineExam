package com.project.service;

import java.util.List;
import java.util.Map;

import com.project.DTO.ExamDto;
import com.project.DTO.ExamDummy;
import com.project.model.Exam;

public interface ExamService {

	public abstract Long saveExam(ExamDto examDto);

	public abstract List<Exam> getExamList();

	public abstract Exam getExambyId(Long id);

	public abstract void updateExam(Exam exam);
	
	public abstract void deleteExam(long id);
	
}
