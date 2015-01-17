package com.project.DTO;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ExamDto {

	private long id;

	private String code;

	private String examCode;

	private String stream;

	private String subjectName;

	private String createdBy;

	private Date date;

	private Date examdate;

	private String time;

	private Date createdOn;

	private String examStatus;

	private String examduration;

	private static final String TIME_FORMAT = "HH:mm";

	public static final SimpleDateFormat timeFormat = new SimpleDateFormat(
			TIME_FORMAT, Locale.getDefault());

	public Time getSavedTime() throws ParseException {
		return new Time(timeFormat.parse(getTime()).getTime());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public static SimpleDateFormat getTimeformat() {
		return timeFormat;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public Date getExamdate() {
		return examdate;
	}

	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getExamduration() {
		return examduration;
	}

	public void setExamduration(String examduration) {
		this.examduration = examduration;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
