package com.app.utils;
import java.util.UUID;


public class CreateExamKey {
	
	private CreateExamKey() {}
	
	public static String createKey(){
		return UUID.randomUUID().toString();
	}

}
