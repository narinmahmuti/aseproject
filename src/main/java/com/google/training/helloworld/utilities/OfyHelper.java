package com.google.training.helloworld.utilities;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.training.helloworld.entities.Student;
import com.google.training.helloworld.entities.Tutor;
import com.google.training.helloworld.entities.Tutorial;
import com.googlecode.objectify.ObjectifyService;

public class OfyHelper implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ObjectifyService.register(Student.class);
		ObjectifyService.register(Tutor.class);
		ObjectifyService.register(Tutorial.class);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	

}
