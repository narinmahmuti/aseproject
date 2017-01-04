package com.google.training.helloworld.cloudendpoints;

import java.util.List;

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
		Student student = ObjectifyService.ofy().load().type(Student.class)
				.id(imkn).now();
		return student;
	}

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "updatestudent", path = "updatestudent", httpMethod = HttpMethod.PUT)
	public Student updatestudent(@Named("imkn") String imkn,
			@Named("deviceid") String deviceId,
			@Named("gcmregid") String gcmRegId) {
		Student student = ObjectifyService.ofy().load().type(Student.class)
				.id(imkn).now();
		student.deviceid = deviceId;
		student.gcmregid = gcmRegId;
		ObjectifyService.ofy().save().entity(student).now();
		return student;
	}

	// Declare this method as a method available externally through Endpoints
	@ApiMethod(name = "studentExist", path = "studentExist", httpMethod = HttpMethod.GET)
	public Student studentExist(@Named("imkn") String imkn,
			@Named("deviceid") String deviceId) {
		// TODO : check if the mapping imkn <=> deviceId exist in datastore
		Student student = ObjectifyService.ofy().load().type(Student.class)
				.id(imkn).now();
		if (deviceId.equals(student.deviceid)) {
			return student;
		} else {
			return null;
		}
	}

	@ApiMethod(name = "markAttendance", path = "markAttendance", httpMethod = HttpMethod.PUT)
	public Student markAttendance(@Named("imkn") String imkn,
			@Named("deviceid") String deviceId,
			@Named("randomkey") String randomKey,
			@Named("weeknumber") int weekNo) {
		// TODO : check for fraud and then mark attendance
		Student student = ObjectifyService.ofy().load().type(Student.class)
				.id(imkn).now();
		
		// logic for checking the frawd and marking the attendance
		return student;
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
		Tutorial tutorial = ObjectifyService.ofy().load().type(Tutorial.class)
				.id(tutorialId).now();
		return tutorial;
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
	public Tutor addTutorData(@Named("tutorusername") String username,
			@Named("tutorpassword") String password) {

		Tutor tutor = new Tutor(username, password);
		ObjectifyService.ofy().save().entity(tutor).now();

		return tutor;
	}

}
