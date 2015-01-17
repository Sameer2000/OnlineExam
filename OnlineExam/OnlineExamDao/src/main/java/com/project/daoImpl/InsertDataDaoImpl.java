package com.project.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.InsertDataDao;
import com.project.model.UserAccount;

@Repository(value = "insertDataDao")
public class InsertDataDaoImpl implements InsertDataDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void createAdmin(UserAccount userAccount) {
		sessionFactory.getCurrentSession().persist(userAccount);
	}

}
