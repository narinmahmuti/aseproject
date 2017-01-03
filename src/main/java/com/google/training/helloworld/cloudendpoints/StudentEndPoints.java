package com.google.training.helloworld.cloudendpoints;

import java.util.List;

import javax.swing.text.WrappedPlainView;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.training.helloworld.entities.Student;
import com.google.training.helloworld.entities.Tutor;
import com.google.training.helloworld.entities.Tutorial;
import com.google.training.helloworld.utilities.Constants;
import com.googlecode.objectify.ObjectifyService;

/**
 * Defines endpoint functions APIs.
 */
@Api(name = "studentendpoints", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "API for student modules")
public class StudentEndPoints {

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "addStudentEntry", path = "addStudentEntry", httpMethod = HttpMethod.POST)
	public Student addStudentEntry(@Named("name") String name,
			@Named("email") String email, @Named("imkn") String imkn,
			@Named("pwd") String pwd,
			@Named("tutorialgroup") String tutorialgroup) {
		Student student = new Student(name, email, pwd, imkn, tutorialgroup);
		ObjectifyService.ofy().save().entity(student).now();
		return student;

	}

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "getStudent", path = "getStudent", httpMethod = HttpMethod.GET)
	public Student getStudent(@Named("imkn") String imkn) {
		// TODO : get Student based on some imkn
		return new Student();
	}

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "updatestudent", path = "updatestudent", httpMethod = HttpMethod.PUT)
	public Student updatestudent(@Named("deviceid") String deviceId,
			@Named("gcmregid") String gcmRegId) {
		// TODO : will be implemented once bulent finished the gcm registration
		return new Student();
	}

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "studentExist", path = "studentExist", httpMethod = HttpMethod.GET)
	public Student studentExist(@Named("imkn") String imkn,
			@Named("deviceid") String deviceId) {
		// TODO : check if the mapping imkn <=> deviceId exist in datastore
		return new Student();
	}

	@ApiMethod(name = "markAttendance", path = "markAttendance", httpMethod = HttpMethod.PUT)
	public Student markAttendance(@Named("imkn") String imkn,
			@Named("deviceid") String deviceId,
			@Named("randomkey") String randomKey,
			@Named("weeknumber") int weekNo) {
		// TODO : check for fraud and then mark attendance
		return new Student();
	}

	/* ==================Tutorial End Points=========================== */

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "setTutorial", path = "setTutorial", httpMethod = HttpMethod.POST)
	public Tutorial setTutorial(@Named("tutorialname") String tutorialName,
			@Named("tutorialtimings") String startTimings,
			@Named("duration") long duration,
			@Named("totalweeks") int totalWeeks,
			@Named("bonusweeks") int bonusWeeks) {
		Tutorial tutorial = new Tutorial(tutorialName, startTimings, duration,
				totalWeeks, bonusWeeks);
		ObjectifyService.ofy().save().entity(tutorial).now();
		return tutorial;
	}

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "getTutorial", path = "getTutorial", httpMethod = HttpMethod.GET)
	public Tutorial getTutorial(@Named("tutorialid") Long tutorialId) {
		// TODO : return tutorial based on the tutorial Id
		return new Tutorial();
	}

	/* ===================Tutor End Points============================ */

	@ApiMethod(name = "authenticateTutor", path = "authenticateTutor", httpMethod = HttpMethod.GET)
	public Tutor authenticateTutor(@Named("tutorusername") String userName,
			@Named("tutorpassword") String password) {
		List<Tutor> list = ObjectifyService.ofy().load().type(Tutor.class)
				.list();
		for (Tutor tutor : list) {
			if (tutor.tutorusername.equals(userName)
					&& tutor.tutorpassword.equals(password)) {
				return tutor;
			}
		}
		return null;
	}

	@ApiMethod(name = "changePassword", path = "changePassword", httpMethod = HttpMethod.PUT)
	public Tutor changePassword(@Named("tutorusername") String userName,
			@Named("tutoroldpassword") String oldPassword,
			@Named("tutornewpassword") String newPassword) {
		List<Tutor> list = ObjectifyService.ofy().load().type(Tutor.class)
				.list();
		for (Tutor tutor : list) {
			if (tutor.tutorpassword.equals(oldPassword)) {
				tutor.tutorpassword = newPassword;
				ObjectifyService.ofy().save().entity(tutor).now();
				return tutor;
			}
		}
		return null;
	}

	@ApiMethod(name = "addTutorData", path = "addTutorData", httpMethod = HttpMethod.POST)
	public List<Tutor> addTutorData() {
		List<Tutor> list = ObjectifyService.ofy().load().type(Tutor.class)
				.list();
		System.out.println("Trying to fetch the list in add tutor data");
		if (list.isEmpty()) {
			Tutor tutor1 = new Tutor("bulent", "abc123");
			Tutor tutor2 = new Tutor("narin", "def123");
			Tutor tutor3 = new Tutor("verena", "ghi123");
			ObjectifyService.ofy().save().entity(tutor1).now();
			list.add(tutor1);
			// ObjectifyService.ofy().save().entity(tutor2).now();
			// ObjectifyService.ofy().save().entity(tutor3).now();
		}

		return list;
	}

//	public static class WrappedBoolean {
//
//		private final Boolean result;
//
//		public WrappedBoolean(Boolean result) {
//			this.result = result;
//		}
//
//		public Boolean getResult() {
//			return result;
//		}
//	}

}
