package com.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.DTO.UserFormDTO;
import com.project.dao.AdminAccountDao;
import com.project.model.AdminAccount;
import com.project.service.AdminAccountService;

@Service("adminAccountService")
public class AdminAccountServiceImpl implements AdminAccountService{
	
	@Autowired
	AdminAccountDao adminAccountDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public AdminAccount validateAdmin(UserFormDTO adminForm) {
		return adminAccountDao.validate(adminForm);
	}

}
