package com.project.serviceImpl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.DTO.ContactDTO;
import com.project.dao.ContactDao;
import com.project.entityToDTOconverter.ContactEntitytoDTOConverter;
import com.project.model.Contact;
import com.project.service.ContactService;

@Service("contactService")
public class ContactQueryImpl implements ContactService{

	@Autowired
	protected ContactDao contactDao;
	
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveContactQuery(Contact contact) {
		Date date = new Date();
		java.sql.Date sDate = new java.sql.Date(date.getTime());
		contact.setCreatedOn(sDate);
		Time t = new Time(sDate.getTime());
		contact.setCreatedTime(t);
		contactDao.saveContact(contact);
	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<ContactDTO> viewContactQuery() {
		return ContactEntitytoDTOConverter.getContactList(contactDao.viewQueries());
	}

}
