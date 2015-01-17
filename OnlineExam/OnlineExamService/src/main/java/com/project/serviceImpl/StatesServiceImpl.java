package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.StateDao;
import com.project.model.States;
import com.project.service.StatesService;

@Service("statesService")
public class StatesServiceImpl implements StatesService {

	@Autowired
	protected StateDao stateDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<States> getStates() {
		return stateDao.getStates();
	}

}
