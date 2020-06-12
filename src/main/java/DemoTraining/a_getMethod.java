package DemoTraining;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
public class a_getMethod {
	//Understand the Basic get and with log
	//@Test 
	public  void example1() {
		given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
	}

	
	@Test 
	public  void example2() {
		given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200).log().all();
	}
	
}