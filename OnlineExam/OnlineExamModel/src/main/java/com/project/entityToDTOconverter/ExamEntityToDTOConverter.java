package com.project.entityToDTOconverter;

import com.project.DTO.ExamDto;
import com.project.model.Exam;
import com.project.model.Subjects;

public class ExamEntityToDTOConverter {
	
	
	public static ExamDto getExamDTO(Exam exam, Subjects subjects){
		ExamDto dto = new ExamDto();
		dto.setId(exam.getId());
		dto.setExamCode(exam.getExamCode());
		dto.setCreatedBy(exam.getCreatedBy());
		dto.setExamdate(exam.getExamdate());
		dto.setCreatedOn(exam.getCreatedOn());
		dto.setCreatedBy(exam.getCreatedBy());
		dto.setExamStatus(exam.getExamStatus().getMessage());
		dto.setStream(exam.getStreamType().getMessage());
		dto.setSubjectName(subjects.getSubject_name());
		dto.setTime(exam.getExamduration().toString());
		return dto;
	}

}
