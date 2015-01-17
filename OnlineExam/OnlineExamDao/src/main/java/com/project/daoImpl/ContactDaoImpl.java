package com.project.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ContactDao;
import com.project.model.Contact;

@Repository("contactDaoImpl")
public class ContactDaoImpl implements ContactDao {

	@Autowired
	protected SessionFactory factory;

	@Override
	public void saveContact(Contact contact) {
		factory.getCurrentSession().persist(contact);
	}

	@Override
	public List<Contact> viewQueries() {
		return factory.getCurrentSession().createCriteria(Contact.class).list();
	}

}
