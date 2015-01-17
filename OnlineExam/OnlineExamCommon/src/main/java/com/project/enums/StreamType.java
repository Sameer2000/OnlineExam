package com.project.enums;

public enum StreamType {
	
	MCA(0, "mca"),
	BCA(1, "mca"),
	MBA(2, "mca"),
	BBA(3, "mca"),
	BTECH(4, "mca"),
	MTECH(5, "mca"),
	MA(6, "mca"),
	BA(7, "mca"),
	MSC(8, "mca"),
	BSC(9, "mca"),
	MCOM(10, "mca"),
	BCOM(11, "mca");
	
	private int code;
	
	private String message;
	
	StreamType(int code, String message){
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
	
	public StreamType getQualifications(Integer code){
		if(code != null){
			for(StreamType qualifications : StreamType.values()){
				return qualifications;
			}
		}
		return null;
	}

}
