package com.project.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.DTO.UserFormDTO;
import com.project.dao.AdminAccountDao;
import com.project.model.AdminAccount;
import com.project.model.UserAccount;

@Repository("adminAccountDao")
public class AdminAccountDaoImpl implements AdminAccountDao{

	@Autowired
	protected SessionFactory factory;
	
	@Override
	public AdminAccount validate(UserFormDTO adminForm) {
		UserAccount account = (UserAccount) factory.getCurrentSession().createCriteria(UserAccount.class)
		.add(Restrictions.eq("username", adminForm.getUsername()))
		.add(Restrictions.eq("password", adminForm.getPassword()))
		.uniqueResult();
		return (account != null) ? account.getAdminAccount() : null;
	}

}
