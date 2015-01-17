package com.project.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.DTO.ExamDummy;
import com.project.DTOtoEntityconverter.StudentExamDTOtoEntityCoverter;
import com.project.dao.StudentDao;
import com.project.model.Exam;
import com.project.model.InstituteAccount;
import com.project.model.StudentAccount;
import com.project.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	protected StudentDao studentDao;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveStudent(InstituteAccount instituteAccount, StudentAccount studentAccount) {
		studentAccount.setRegistration_no(String.valueOf((int) (Math.random() * 1000) ));
		studentDao.saveStudent(instituteAccount, studentAccount);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<StudentAccount> getStudentsnyInsId(Long institute_id) {
		return studentDao.getStudentbyInsId(institute_id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Set<StudentAccount> getStudentbyStream(String stream) {
		return studentDao.getStudentbyStream(stream);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveStudentExam(ExamDummy examDummy, StudentAccount studentAccount, Exam exam) {
		studentAccount.setExams(StudentExamDTOtoEntityCoverter.saveStudentExam(examDummy, exam));
		studentDao.saveStudentExam(studentAccount);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public StudentAccount getStudentByRegistration(String reg) {
		return studentDao.getStudentByRegistration(reg);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Map<Integer, Integer> getStudentScore(String studentRegNo) {
		return studentDao.getStudentScore(studentDao.getStudentByRegistration(studentRegNo));
	}

}
