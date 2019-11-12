package RestAssuredDemo.RestAssuredDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.http.ContentType;

public class k_authentication {
	
	/*
	 * REST assured also supports several authentication schemes, for example OAuth, digest, certificate, form and preemptive basic authentication. 
	 * You can either set authentication for each request:
		given().auth().basic("username", "password"). ..
	but you can also define authentication for all requests:
	RestAssured.authentication = basic("username", "password");
	
	There are two types of basic authentication, preemptive and "challenged basic authentication".
	Preemptive Basic Authentication
	This will send the basic authentication credential even before the server gives an unauthorized response in certain situations, 
	thus reducing the overhead of making an additional connection. This is typically what you want to use in most situations unless you're testing the servers 
	ability to challenge. 
	
	Example: given().auth().preemptive().basic("username", "password").when().get("/secured/hello").then().statusCode(200);

	Challenged Basic Authentication
	When using "challenged basic authentication" REST Assured will not supply the credentials unless the server has explicitly asked for it. 
	This means that REST Assured will make an additional request to the server in order to be challenged and then follow 
	up with the same request once more but this time setting the basic credentials in the header.

	given().auth().basic("username", "password").when().get("/secured/hello").then().statusCode(
	 */
	
	@Test
	public static void auth() {	
		given()
		.relaxedHTTPSValidation()
		.auth().
		basic("eslsvc", "W0rkgppw2")
		.when()
		.get("https://entsvjws-test1.test.intranet/entservices/services/GetAvailability")
		.then()
		.statusCode(200);
				

		
	}

	//@Test
	public static void auth1() {
		String s=
		given(). 
		contentType(ContentType.HTML).auth().form("AB36194", "XXXXX", new FormAuthConfig("/users/login", "username", "password")).when()
        .get("http://localhost:3000")
        .then().extract().response().asString().toString();
        System.out.println(s);
      }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
