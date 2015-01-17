package com.project.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.utils.CreateExamKey;
import com.project.DTO.InstituteRegistrationDTO;
import com.project.DTO.StudentExamDTO;
import com.project.DTO.UserFormDTO;
import com.project.DTOtoEntityconverter.InstituteDTOToEntity;
import com.project.dao.ExamDao;
import com.project.dao.InstituteDao;
import com.project.dao.StudentDao;
import com.project.enums.StreamType;
import com.project.model.Exam;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;
import com.project.service.InstituteService;

@Service("instituteService")
public class InstituteAccountServiceImpl implements InstituteService {

	@Autowired
	protected InstituteDao instiuteDao;
	
	@Autowired
	protected StudentDao studentDao;
	
	@Autowired
	protected ExamDao examDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<InstituteAccount> getInstituteList() {
		return instiuteDao.getInstituteAccounts();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveInstituteAccount(InstituteRegistrationDTO instituteRegistrationDTO) {
		InstituteDTOToEntity.getInstance();
		instiuteDao.saveInstitute(InstituteDTOToEntity.getInstitute(instituteRegistrationDTO));
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public InstituteAccount validateAdmin(UserFormDTO adminForm) {
		return instiuteDao.validate(adminForm);
	}

	@Override
	public List<String> createInstituteKeys() {
		List<String> keys = new ArrayList<String>();
		keys.add(CreateExamKey.createKey());
		return keys;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<String> getInstituteKeys() {
		return instiuteDao.getInstituteKeys();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Exam validateStudent(StudentExamDTO studentExamDTO) {
		boolean instituteStatus = instiuteDao.checkKeyCode(studentExamDTO.getKeycode());
		StreamType studentStream = studentDao.checkRegistration(studentExamDTO.getRegistration());
		Exam exam = examDao.getExambyStreamandDate( studentStream, new Date( new java.util.Date().getTime() ));
		return (instituteStatus && (exam != null)) ? exam : null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<StudentAccount> getStudentList(InstituteAccount instituteAccount) {
		return instiuteDao.students(instituteAccount);
	}


}
