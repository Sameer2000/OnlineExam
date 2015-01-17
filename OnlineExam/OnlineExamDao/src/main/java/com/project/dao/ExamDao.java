package com.project.dao;

import java.sql.Date;
import java.util.List;

import com.project.enums.StreamType;
import com.project.model.Exam;

public interface ExamDao {
	
	public abstract Long saveExam(Exam exam);
	
	public abstract List<Exam> getExamList();
	
	public abstract Exam getExambyId(Long id);
	
	public abstract void updateExam(Exam exam);
	
	public abstract Exam getExambyStreamandDate(StreamType streamType, Date date);
	
	public abstract void deleteExam(long id);
	
}
