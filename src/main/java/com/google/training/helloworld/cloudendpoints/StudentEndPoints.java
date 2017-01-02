package com.google.training.helloworld.cloudendpoints;

import java.util.List;

import javax.swing.text.WrappedPlainView;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.training.helloworld.entities.Student;
import com.google.training.helloworld.entities.Tutor;
import com.google.training.helloworld.entities.Tutorial;
import com.google.training.helloworld.utilities.Constants;
import com.googlecode.objectify.ObjectifyService;

/**
 * Defines endpoint functions APIs.
 */
@Api(name = "studentendpoints", version = "v1",
scopes = {Constants.EMAIL_SCOPE },
clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
description = "API for student modules")

public class StudentEndPoints {


	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "addStudentEntry", path = "addStudentEntry",
			httpMethod = HttpMethod.POST)
	public WrappedBoolean addStudentEntry(String name, String email, String imkn, String pwd, String grouptutorial) {
		Student student = new Student(name, email, pwd, imkn, grouptutorial);
		ObjectifyService.ofy().save().entity(student).now();
		
		return new WrappedBoolean(true);

	}


	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "getStudent", path = "getStudent",
			httpMethod = HttpMethod.GET)
	public Student getStudent() {
		// TODO : get Student based on some id may be imkn 
		return new Student();
	}


	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "updatestudent", path = "updatestudent",
			httpMethod = HttpMethod.PUT)
	public WrappedBoolean updatestudent(String deviceId, String gcmRegId) {
		// TODO : will be implemented once bulent finished the gcm registration on android
		return new WrappedBoolean(true);
	}
	
	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "studentExist", path = "studentExist",
			httpMethod = HttpMethod.GET)
	public WrappedBoolean studentExist(String imkn, String deviceId) {
		// TODO : check if the mapping imkn <=> deviceId exist in datastore
		return new WrappedBoolean(true);
	}

	@ApiMethod(name = "markAttendance", path = "markAttendance",
			httpMethod = HttpMethod.PUT)
	public WrappedBoolean markAttendance(String imkn, String deviceId, String randomKey, int weekNo) {
		// TODO : check for fraud and then mark attendance
		return new WrappedBoolean(true);
	}
	
	/*==================Tutorial End Points===========================*/
	
	
	// Declare this method as a method available externally through Endpoints
		@ApiMethod(name = "setTutorial", path = "setTutorial",
				httpMethod = HttpMethod.POST)
		public String setTutorial(String tutorialName, String startTimings, long duration, int totalWeeks, int bonusWeeks) {
			Tutorial tutorial =  new  Tutorial(tutorialName, startTimings, duration, totalWeeks, bonusWeeks);
			ObjectifyService.ofy().save().entity(tutorial).now();
			return "Tutorial Added Successfully";
		}
		
	

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "getTutorial", path = "getTutorial",
			httpMethod = HttpMethod.GET)
	public Student getTutorial(int tutorialId) {
		// TODO : return tutorial based on the tutorial Id
 		return null;
	}
	
	/*===================Tutor End Points============================*/
	

	@ApiMethod(name = "authenticateTutor", path = "authenticateTutor",
			httpMethod = HttpMethod.GET)
	public WrappedBoolean authenticateTutor(String userName, String password) {
		// TODO : check if the tutor entry is in the datastoree
		// query for all the tutors and check if there exist an entry for the given values
		List<Tutor> list = ObjectifyService.ofy().load().type(Tutor.class).list();
		for (Tutor tutor : list) {
			if (tutor.tutorUserName.equals(userName) 
					&& tutor.tutorPassword.equals(password)) {
				return new WrappedBoolean(true);
			}
		}
		return new WrappedBoolean(false);
	}
	
	@ApiMethod(name = "changePassword", path = "changePassword",
			httpMethod = HttpMethod.PUT)
	public WrappedBoolean changePassword(String userName, String oldPassword, String newPassword) {
		List<Tutor> list = ObjectifyService.ofy().load().type(Tutor.class).list();
		for (Tutor tutor : list) {
			if (tutor.tutorPassword.equals(oldPassword)) {
				tutor.tutorPassword = newPassword;
				ObjectifyService.ofy().save().entity(tutor).now();
				return new WrappedBoolean(true);
			}
		}
		return new WrappedBoolean(false);
	}
	
//	@ApiMethod(name = "setUpTutorial", path = "setUpTutorial",
//			httpMethod = HttpMethod.PUT)
//	public boolean setUpTutorial(Tutorial tutorial) {
//		// TODO : add a tutorial entry in the datastore
//		return true;
//	}
	
	@ApiMethod(name = "addTutorData", path = "addTutorData",
			httpMethod = HttpMethod.POST)
	public WrappedBoolean addTutorData() {
		List<Tutor> list = ObjectifyService.ofy().load().type(Tutor.class).list();
		System.out.println("Trying to fetch the list in add tutor data");
		if (list.isEmpty()) {
			Tutor tutor1 = new Tutor("bulent", "abc123");
			Tutor tutor2 = new Tutor("narin", "def123");
			Tutor tutor3 = new Tutor("verena", "ghi123");
			ObjectifyService.ofy().save().entity(tutor1).now();
			//ObjectifyService.ofy().save().entity(tutor2).now();
			//ObjectifyService.ofy().save().entity(tutor3).now();
		}
		
		return new WrappedBoolean(true);
	}
	
	 public static class WrappedBoolean {

	        private final Boolean result;

	        public WrappedBoolean(Boolean result) {
	            this.result = result;
	        }

	        public Boolean getResult() {
	            return result;
	        }
	    }
	
	

	
}
