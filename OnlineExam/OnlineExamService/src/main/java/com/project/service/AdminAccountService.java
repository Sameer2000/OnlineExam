package com.project.service;

import com.project.DTO.UserFormDTO;
import com.project.model.AdminAccount;

public interface AdminAccountService {

	public abstract AdminAccount validateAdmin(UserFormDTO adminForm);

}
