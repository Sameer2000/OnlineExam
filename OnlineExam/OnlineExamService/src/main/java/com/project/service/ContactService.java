package com.project.service;


import java.util.List;

import com.project.DTO.ContactDTO;
import com.project.model.Contact;

public interface ContactService {

	public void saveContactQuery(Contact contact);
	
	public List<ContactDTO> viewContactQuery();
}
