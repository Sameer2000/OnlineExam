package com.project.dao;

import java.util.List;

import com.project.model.Contact;

public interface ContactDao {
	
	public abstract void saveContact(Contact contact);
	
	public abstract List<Contact> viewQueries();

}
