package com.project.dao;

import java.util.List;

import com.project.model.Subjects;

public interface SubjectDao {

	public abstract List<Subjects> getSubjects(String subject);
	
	public abstract Subjects getSubjectById(Long id);
	
}
