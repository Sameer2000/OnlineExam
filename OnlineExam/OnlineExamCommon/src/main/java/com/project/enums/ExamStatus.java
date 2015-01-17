package com.project.enums;

public enum ExamStatus {

	NOT_SUBMITTED(0, "not submitted"), SUBMITTED(1, "submitted");

	private int code;

	private String message;

	ExamStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public ExamStatus getExamStatus(int code) {
		for (ExamStatus status : ExamStatus.values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}

}
