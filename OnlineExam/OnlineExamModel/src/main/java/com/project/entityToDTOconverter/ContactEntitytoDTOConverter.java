package com.project.entityToDTOconverter;

import java.util.ArrayList;
import java.util.List;

import com.project.DTO.ContactDTO;
import com.project.model.Contact;

public class ContactEntitytoDTOConverter {
	
	public static final List<ContactDTO> getContactList(List<Contact> contacts){
		
		List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>();
		ContactDTO dto;
		for(Contact c: contacts){
			dto = new ContactDTO();
			dto.setCreatedOn(c.getCreatedOn());
			dto.setCreatedTime(c.getCreatedTime());
			dto.setEmail(c.getEmail());
			dto.setMessage(c.getMessage());
			contactDTOs.add(dto);
		}
		return contactDTOs;
	}

}
