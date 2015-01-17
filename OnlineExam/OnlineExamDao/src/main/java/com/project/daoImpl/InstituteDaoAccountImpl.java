package com.project.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.DTO.UserFormDTO;
import com.project.dao.InstituteDao;
import com.project.enums.UserType;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;
import com.project.model.UserAccount;

@Repository("instiuteDao")
public class InstituteDaoAccountImpl implements InstituteDao{

	@Autowired
	protected SessionFactory factory;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<InstituteAccount> getInstituteAccounts() {
		Criteria criteria = factory.getCurrentSession().createCriteria(InstituteAccount.class);
		List<InstituteAccount> institutes = criteria.list();
		return institutes;
	}

	@Override
	public void saveInstitute(InstituteAccount instituteAccount) {
		UserAccount newInstituteAccount = new UserAccount();
		newInstituteAccount.setInstituteAccount(instituteAccount);
		newInstituteAccount.setUsername(instituteAccount.getCenter_code());
		newInstituteAccount.setPassword(instituteAccount.getCenter_password());
		newInstituteAccount.setUserType(UserType.INSTITUTE);
		factory.getCurrentSession().persist(newInstituteAccount);
	}

	@Override
	public InstituteAccount validate(UserFormDTO adminForm) {
		UserAccount account = (UserAccount) factory.getCurrentSession().createCriteria(UserAccount.class)
		.add(Restrictions.eq("username", adminForm.getUsername()))
		.add(Restrictions.eq("password", adminForm.getPassword()))
		.uniqueResult();
		InstituteAccount instituteAccount = account.getInstituteAccount();
		Hibernate.initialize(instituteAccount.getStudentAccounts());
		return (account != null) ? instituteAccount : null;
	}

	@Override
	public void updateInstituteKeys(List<String> loginkey) {
		List<InstituteAccount> instituteAccounts = factory.getCurrentSession().createCriteria(InstituteAccount.class).list();
		int index = 0;
		for(InstituteAccount i : instituteAccounts){
			i.setLogin_key(loginkey.get(index));
			index++;
		}
	}

	@Override
	public List<String> getInstituteKeys() {
		List<String> keys = factory.getCurrentSession().createCriteria(InstituteAccount.class)
		.setProjection(Projections.property("login_key")).list();
		return keys;
	}

	@Override
	public boolean checkKeyCode(String keyCode) {
		InstituteAccount instituteAccount = (InstituteAccount) factory.getCurrentSession().createCriteria(InstituteAccount.class).add(Restrictions.eq("login_key", keyCode)).uniqueResult();
		return (instituteAccount != null) ? true : false;
	}

	@Override
	public List<StudentAccount> students(InstituteAccount instituteAccount) {
		return instituteAccount.getStudentAccounts();
	}

}
