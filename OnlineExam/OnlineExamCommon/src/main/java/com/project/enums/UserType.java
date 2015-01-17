package com.project.enums;

public enum UserType {

	ADMIN(0, "admin"), INSTITUTE(1, "institute"), STUDENT(2, "student");

	private int code;

	private String message;

	UserType(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserType getUserType(Integer code) {
		if (code != null) {
			UserType[] userTypes = UserType.values();
			for (UserType users : userTypes) {
				if (users.code == code) {
					return users;
				}
			}
		}
		return null;
	}

}
