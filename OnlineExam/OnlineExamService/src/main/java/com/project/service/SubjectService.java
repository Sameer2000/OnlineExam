package com.project.service;

import java.util.List;

import com.project.model.Subjects;

public interface SubjectService {

	public abstract List<Subjects> getSubjects(String stream);
	
	public abstract Subjects getSubjectbyId(Long id);

}
