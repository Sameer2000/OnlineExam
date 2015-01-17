package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.SubjectDao;
import com.project.model.Subjects;
import com.project.service.SubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	protected SubjectDao dao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<Subjects> getSubjects(String stream) {
		return dao.getSubjects(stream);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Subjects getSubjectbyId(Long id) {
		return dao.getSubjectById(id);
	}

}
