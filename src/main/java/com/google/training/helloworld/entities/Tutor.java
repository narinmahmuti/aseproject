package com.google.training.helloworld;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Tutor {

	
	@Id
	public Long Id;
	
	public String tutorUserName;
	
	public String tutorPassword;
	
	public Tutor(String tutorUserName, String tutorPassword) {
		this.tutorUserName = tutorUserName;
		this.tutorPassword = tutorPassword;
	}
}
