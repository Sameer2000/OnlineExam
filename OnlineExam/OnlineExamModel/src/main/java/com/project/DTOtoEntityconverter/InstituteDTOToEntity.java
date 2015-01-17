package com.project.DTOtoEntityconverter;

import com.project.DTO.InstituteRegistrationDTO;
import com.project.model.Address;
import com.project.model.InstituteAccount;

public class InstituteDTOToEntity {
	
	private InstituteDTOToEntity(){}
	
	public static InstituteDTOToEntity getInstance(){
		return new InstituteDTOToEntity();
	}
	
	public static InstituteAccount getInstitute(InstituteRegistrationDTO instituteRegistrationDTO){
		InstituteAccount instituteAccount = new InstituteAccount();
		instituteAccount.setActive(true);
		instituteAccount.setCenter_code( "0"+ String.valueOf((int) (Math.random() * 100000)) );
		instituteAccount.setCenter_name(instituteRegistrationDTO.getCenter_name());
		instituteAccount.setCenter_password(instituteRegistrationDTO.getCenter_password());
		instituteAccount.setContact(instituteRegistrationDTO.getContact());
		instituteAccount.setKey_status(false);
		Address address = new Address();
		address.setAddress(instituteRegistrationDTO.getAddress());
		address.setPincode(instituteRegistrationDTO.getPincode());
		address.setStreet(instituteRegistrationDTO.getStreet());
		address.setState(instituteRegistrationDTO.getState());
		instituteAccount.setAddress(address);
		return instituteAccount;
	}

}
