package com.project.serviceImpl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.DTO.ExamDto;
import com.project.DTOtoEntityconverter.ExamDTOtoEntityConverter;
import com.project.dao.ExamDao;
import com.project.dao.InstituteDao;
import com.project.dao.StudentDao;
import com.project.model.Exam;
import com.project.service.ExamService;
import com.project.service.InstituteService;

@Service("examService")
public class ExamServiceImpl implements ExamService{

	@Autowired
	protected ExamDao examDao;
	
	@Autowired
	protected StudentDao studentDao;
	
	@Autowired
	protected InstituteDao instituteDao;
	
	@Autowired
	protected InstituteService instituteService;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long saveExam(ExamDto examDto) {
		try {
			instituteDao.updateInstituteKeys(instituteService.createInstituteKeys());
			return examDao.saveExam(ExamDTOtoEntityConverter.saveExam(examDto));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<Exam> getExamList() {
		return examDao.getExamList();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Exam getExambyId(Long id) {
		return examDao.getExambyId(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateExam(Exam exam) {
		examDao.updateExam(exam);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteExam(long id) {
		examDao.deleteExam(id);
	}
	
}
