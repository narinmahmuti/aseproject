package com.google.training.helloworld.entities;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.*;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
public class Student {


	@Parent 
	Key<Tutorial> tutorial;  
	
	@Id
	public String imkn;
	
	public String studentName;
	public String studentEmail;
	@Index
	public String studentPassword;
	@Index
	public String studentDeviceId;
	@Index
	public String studentGCMRegId;
	public int studentExpectedWeek;
	public int studentTotalAttendedWeeks;
	public boolean studentPresented;
	public String studentCurrentRandomKey;
	
	public Student() {
		
	}
	
	/*
	 * */
	public Student(String name, String email, String pwd, String imkn, String tutorialId) {
		tutorial = Key.create(Tutorial.class, tutorialId);
		this.studentName = name;
		this.studentEmail = email;
		this.imkn = imkn;
		this.studentPassword = pwd;
	}

	
}
