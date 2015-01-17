package com.project.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.SubjectDao;
import com.project.enums.StreamType;
import com.project.model.Subjects;

@Repository("subjectDao")
public class SubjectDaoImpl implements SubjectDao{

	@Autowired
	protected SessionFactory factory;
	
	@Override
	public List<Subjects> getSubjects(String stream) {
		return factory.getCurrentSession().createCriteria(Subjects.class).add(Restrictions.eq("streamType", StreamType.valueOf(stream))).list();
	}

	@Override
	public Subjects getSubjectById(Long id) {
		return (Subjects)factory.getCurrentSession().get(Subjects.class, id);
	}

	
	
}
