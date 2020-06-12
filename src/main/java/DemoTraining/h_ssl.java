package DemoTraining;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class h_ssl {
	  
	/*
	https request if the server is using an invalid certificate, then we need to use relaxedHTTPSValidation.
	By default SSLContext protocol is SSL. 
	To change to another protocol use an overloaded versionen of relaxedHTTPSValidation. 
	For example: given().relaxedHTTPSValidation("TLS").when().get("https://some_server.com") */
	
	//@Test
	public static void ssl() {
		String response = 
				given().get("https://jsonplaceholder.typicode.com/photos/1")
				.then()
				.contentType(ContentType.JSON)
				.body("albumId",equalTo(1))
				.extract()
				.path("url");
		System.out.println(response.toString());
		given().get(response).then().statusCode(200);
	}
	
	@Test
	public static void ssl1() {
		String response = 
				given().get("https://jsonplaceholder.typicode.com/photos/1")
				.then()
				.contentType(ContentType.JSON)
				.body("albumId",equalTo(1))
				.extract()
				.path("url");
		System.out.println(response.toString());
		given().relaxedHTTPSValidation().get(response).then().statusCode(200);
	}

}
