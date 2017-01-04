package com.google.training.helloworld.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Tutor {

	
	@Id
	public Long Id;
	
	public String tutorusername;
	
	public String tutorpassword;
	
	public Tutor(String tutorUserName, String tutorPassword) {
		this.tutorusername = tutorUserName;
		this.tutorpassword = tutorPassword;
	}
	
	public Tutor() {
		
	}
}
