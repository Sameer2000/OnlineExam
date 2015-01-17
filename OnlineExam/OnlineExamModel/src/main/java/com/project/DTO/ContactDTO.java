package com.project.DTO;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ContactDTO {

	private String email;

	private String message;

	private Date createdOn;

	private Time createdTime;

	private String time;

	/**/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Time getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Time createdTime) {
		this.createdTime = createdTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
