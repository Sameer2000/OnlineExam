package com.project.dao;

import java.util.List;

import com.project.DTO.UserFormDTO;
import com.project.model.AdminAccount;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;

public interface InstituteDao {
	
	public abstract List<InstituteAccount> getInstituteAccounts();
	
	public abstract List<String> getInstituteKeys();
	
	public abstract void updateInstituteKeys(List<String> keys);
	
	public abstract void saveInstitute(InstituteAccount instituteAccount);
	
	public abstract InstituteAccount validate(UserFormDTO adminForm);
	
	public abstract boolean checkKeyCode(String keyCode);
	
	public abstract List<StudentAccount> students(InstituteAccount instituteAccount);

}
