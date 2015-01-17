package com.project.daoImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.StudentDao;
import com.project.enums.StreamType;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;
import com.project.model.StudentExam;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	protected SessionFactory factory;

	@Override
	public void saveStudent(InstituteAccount instituteAccount,
			StudentAccount studentAccount) {
		instituteAccount.getStudentAccounts().add(studentAccount);
		factory.getCurrentSession().update(instituteAccount);
	}

	@Override
	public List<StudentAccount> getStudentbyInsId(Long id) {
		InstituteAccount instituteAccount = (InstituteAccount) factory
				.getCurrentSession().createCriteria(InstituteAccount.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		return instituteAccount.getStudentAccounts();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<StudentAccount> getStudentbyStream(String stream) {
		List<StudentAccount> studentAccounts = factory.getCurrentSession()
				.createCriteria(StudentAccount.class)
				.add(Restrictions.eq("stream", StreamType.valueOf(stream)))
				.list();
		Set<StudentAccount> students = new HashSet<StudentAccount>();
		for (StudentAccount s : studentAccounts) {
			students.add(s);
		}
		return students;
	}

	@Override
	public StreamType checkRegistration(String registration) {
		StreamType streamType = (StreamType) factory.getCurrentSession()
				.createCriteria(StudentAccount.class)
				.add(Restrictions.eq("registration_no", registration))
				.setProjection(Projections.property("stream"))
				.uniqueResult();
		return streamType;
	}

	@Override
	public void saveStudentExam(StudentAccount studentAccount) {
		factory.getCurrentSession().update(studentAccount);
	}

	@Override
	public StudentAccount getStudentByRegistration(String registration) {
		return (StudentAccount) factory.getCurrentSession().createCriteria(StudentAccount.class).add(Restrictions.eq("registration_no", registration)).uniqueResult();
	}

	@Override
	public Map<Integer, Integer> getStudentScore(StudentAccount s) {
		int total = s.getExams().size();
		int score = 0;
		for(StudentExam e : s.getExams()){
			score = score + e.getScore();
		}
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		result.put(total, score);
		return result;
	}
}
