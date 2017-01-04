package com.google.training.helloworld.entities;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Tutorial {
	
	@Id
	public Long tutorialid;
	
	public String tutorialname;
	public String tutorialtimings; // start time of the tutorial for this tutorial group
	public long duration; // duration of the tutorial for this group
	public int totalweeks; // total no. of classes for this tutorial group
	public int bonusweeks; // can do better using inheritance but not sure how objectify will behave
	
	
	public Tutorial() {
		
	}
	
	public Tutorial(String tutorialName,String startTime, long tutorialDuration, 
			int totalWeeks, int requiredClasses) {
		this.tutorialname = tutorialName;
		this.tutorialtimings = startTime;
		this.duration = tutorialDuration;
		this.totalweeks = totalWeeks;
		this.bonusweeks = requiredClasses;
	}
	
	
	
}
