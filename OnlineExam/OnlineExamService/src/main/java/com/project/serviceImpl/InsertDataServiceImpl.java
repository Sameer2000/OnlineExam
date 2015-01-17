package com.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.catalogs.AdminCatalog;
import com.project.dao.InsertDataDao;
import com.project.service.InsertDataService;

@Service("insertDataService")
public class InsertDataServiceImpl implements InsertDataService {

	@Autowired
	private InsertDataDao insertData;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insertData() {
		insertData.createAdmin(AdminCatalog.createAdmin());
	}

}
