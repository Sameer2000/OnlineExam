package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.enums.StreamType;

@Entity
@Table(name = "qualifications")
public class Qualifications {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "streamType")
	private StreamType streamType;

	@Column(name = "institute_name", nullable = false, length = 100)
	private String institute_name;

	@Column(name = "universityName", nullable = false, length = 100)
	private String universityName;

	@Column(name = "year_of_passing", nullable = false, length = 45)
	private String year_of_passing;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StreamType getStreamType() {
		return streamType;
	}

	public void setStreamType(StreamType streamType) {
		this.streamType = streamType;
	}

	public String getInstitute_name() {
		return institute_name;
	}

	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getYear_of_passing() {
		return year_of_passing;
	}

	public void setYear_of_passing(String year_of_passing) {
		this.year_of_passing = year_of_passing;
	}

}
