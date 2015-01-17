package com.project.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.StateDao;
import com.project.model.States;

@Repository("stateDao")
public class StatesDaoImpl implements StateDao{

	@Autowired
	protected SessionFactory factory;
	
	@Override
	public List<States> getStates() {
		return factory.getCurrentSession().createCriteria(States.class).list();
	}

}
