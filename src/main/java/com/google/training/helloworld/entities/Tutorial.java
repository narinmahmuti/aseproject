package com.google.training.helloworld;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Tutorial {

	@Id
	public int tutorialId;
	
	public String tutorialName;
	public String tutorialTimings; // start time of the tutorial for this tutorial group
	public long tutorialDuration; // duration of the tutorial for this group
	public int totalWeeks; // total no. of classes for this tutorial group
	public int requiredBonusClasses; // can do better using inheritance but not sure how objectify will behave
	
	public Tutorial(String tutotrialName,String startTime, long tutorialDuration, 
			int totalWeeks, int requiredClasses) {
		this.tutorialName = tutorialName;
		this.tutorialTimings = startTime;
		this.tutorialDuration = tutorialDuration;
		this.totalWeeks = totalWeeks;
		this.requiredBonusClasses = requiredClasses;
	}
	
}
