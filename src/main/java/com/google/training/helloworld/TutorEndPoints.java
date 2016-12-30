//package com.google.training.helloworld;
//
//import com.google.api.server.spi.config.Api;
//import com.google.api.server.spi.config.ApiMethod;
//import com.google.api.server.spi.config.ApiMethod.HttpMethod;
//
///**
// * Defines endpoint functions APIs.
// */
//@Api(name = "tutorendpoints", version = "v1",
//scopes = {Constants.EMAIL_SCOPE },
//        clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
//        description = "API for tutor modules")
//
//public class TutorEndPoints {
//	
//	@ApiMethod(name = "authenticateTutor", path = "authenticateTutor",
//			httpMethod = HttpMethod.GET)
//	public boolean authenticateTutor(String userName, String password) {
//		// TODO : check if the tutor entry is in the datastoree
//		return true;
//	}
//	
//	@ApiMethod(name = "changePassword", path = "changePassword",
//			httpMethod = HttpMethod.PUT)
//	public boolean changePassword(String userName, String password) {
//		// TODO : update the password of the tutor
//		return true;
//	}
//	
//	@ApiMethod(name = "setUpTutorial", path = "setUpTutorial",
//			httpMethod = HttpMethod.PUT)
//	public boolean setUpTutorial(Tutorial tutorial) {
//		// TODO : add a tutorial entry in the datastore
//		return true;
//	}
//	
//
//
//}
