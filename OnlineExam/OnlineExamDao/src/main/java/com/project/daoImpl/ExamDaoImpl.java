package com.project.daoImpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ExamDao;
import com.project.enums.StreamType;
import com.project.model.Exam;

@Repository("examDao")
public class ExamDaoImpl implements ExamDao {

	@Autowired
	protected SessionFactory factory;

	@Override
	public Long saveExam(Exam exam) {
		return (Long) factory.getCurrentSession().save(exam);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Exam> getExamList() {
		List<Exam> list = factory.getCurrentSession()
				.createCriteria(Exam.class).list();
		return list;
	}

	@Override
	public Exam getExambyId(Long id) {
		return (Exam) factory.getCurrentSession().get(Exam.class, id);
	}

	@Override
	public void updateExam(Exam exam) {
		factory.getCurrentSession().update(exam);
	}

	@Override
	public Exam getExambyStreamandDate(StreamType streamType, Date date){
		try{
		Exam exam = (Exam) factory.getCurrentSession().createCriteria(Exam.class)
				.add(Restrictions.eq("streamType", streamType))
				.add(Restrictions.eq("examdate", date))
				.uniqueResult();
		Hibernate.initialize(exam.getQuestions());
		return exam;
		}
		catch(NullPointerException n){
			return null;
		}
	}

	@Override
	public void deleteExam(long id) {
		Exam exam = (Exam) factory.getCurrentSession().get(Exam.class, id);
		factory.getCurrentSession().delete(exam);
	}

}
