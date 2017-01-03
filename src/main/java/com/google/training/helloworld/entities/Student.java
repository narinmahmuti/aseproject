package com.google.training.helloworld.entities;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.*;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Student {

	@Parent
	Key<Tutorial> tutorialgroup;

	@Id
	public String imkn;

	public String name;
	public String email;
	@Index
	public String pwd;
	@Index
	public String deviceid;
	@Index
	public String gcmregid;
	public int bonusweeks;
	public int totalweeks;
	public boolean ispresented;
	public String randomkey;

	public Student() {

	}

	/*
	 * */
	public Student(String name, String email, String pwd, String imkn,
			String tutorialId) {
		tutorialgroup = Key.create(Tutorial.class, tutorialId);
		this.name = name;
		this.email = email;
		this.imkn = imkn;
		this.pwd = pwd;
	}

}
