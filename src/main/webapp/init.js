/*
 * http://stackoverflow.com/questions/18260815/use-gapi-client-javascript-to-execute-my-custom-google-api
 * https://developers.google.com/appengine/docs/java/endpoints/consume_js
 * https://developers.google.com/api-client-library/javascript/reference/referencedocs#gapiclientload
 *
 */

/**
 * After the client library has loaded, this init() function is called. The
 * init() function loads the helloworldendpoints API.
 */

function init() {

	var rootpath = "//" + window.location.host + "/_ah/api";
	gapi.client.load('studentendpoints', 'v1', loadCallback, rootpath);
}


function loadCallback() {
	gapi.client.studentendpoints.addTutorData();
	enableButtons();
}

function enableButtons() {
	btn = document.getElementById("tutor_sign_in");
	btn.onclick = function() {
		tutorSignIn();
	};

	btn = document.getElementById("student_sign_up");
	btn.onclick = function() {
		studentSignUp();
	};
}

function studentSignUp() {
	window.location = "../user_sign_up_form.html"
}

function tutorSignIn() {
	window.location = "../tutor_sign_in.html"
}

