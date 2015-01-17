package com.app.src;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.daoImpl.StudentDaoImpl;
import com.project.model.StudentAccount;
import com.project.model.StudentExam;


public class TestData {
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/app/src/spring-servlet.xml");
		StudentDaoImpl stud = (StudentDaoImpl)ctx.getBean("dao");
		SessionFactory factory = (SessionFactory)ctx.getBean("sessionFactory");
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		StudentAccount s = (StudentAccount)session.createCriteria(StudentAccount.class)
		//.setProjection(Projections.rowCount())
		.add(Restrictions.eq("student_id", Long.valueOf(2)))
		.uniqueResult();
		t.commit();
		session.close();
		System.out.println("count : "+s.getExams().size());
		int sc = 0;
		for(StudentExam e : s.getExams()){
			System.out.println("sc vaue: "+sc);
			sc = sc + e.getScore();
		}
		System.out.println("total score: "+sc);
	}
	

}
