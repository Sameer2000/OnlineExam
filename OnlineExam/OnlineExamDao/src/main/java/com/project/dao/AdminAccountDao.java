package com.project.dao;

import com.project.DTO.UserFormDTO;
import com.project.model.AdminAccount;
import com.project.model.UserAccount;

public interface AdminAccountDao {
	
	public abstract AdminAccount validate(UserFormDTO adminForm);

}
