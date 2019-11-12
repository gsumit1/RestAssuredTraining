package RestAssuredDemo.RestAssuredDemo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.meta.When;
import org.hamcrest.Matchers;
public class a_getMethod {
	
	//@Test //Basic get method
	public  void example1() {
		given().get("https://jsonplaceholder.typicode.com/posts").then()
				.statusCode(200);
		
	}

	
	@Test //Basic get with log
	public  void example2() {
		given().get("https://jsonplaceholder.typicode.com/posts").then()
				.statusCode(200).log().all();
		
	}
	
	
	//@Test //json path- hamcrest assert
	public  void example4() {
		given().get("https://jsonplaceholder.typicode.com/posts/3").then().log().all()
				.body("title",equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"));
		
	}
	
	//@Test //json path assert number
	public  void example5() {
		given().get("https://jsonplaceholder.typicode.com/posts/3").then().log().all()
				.body("userId",equalTo(1));
		
	}
	
	//@Test //reponse in array
	public  void example6() {
		given().get("http://localhost:3000/country").then().body("RestResponse.result.name[0]",equalTo("Brunei Darussalam"));
	}
	
	
	//@Test //root
	@SuppressWarnings("deprecation")
	public  void example7() {
		given().get("http://localhost:3000/country").then().root("RestResponse.result").body("name[0]",equalTo("Brunei Darussalam"));
	}
	
	
	/*
	@SuppressWarnings("deprecation")
	//@Test //root & detachRoot code is not working
	public  void example8() {
		given().get("http://localhost:3000/country")
		.then()
		.root("RestResponse.result")
		.body("name[0]",equalTo("Brunei Darussalam"))
		.detachRoot("result")
		.body("result.name",equalTo("Hungary"));
	}*/
	
	@Test //capture the response as string
	public  void example3() {
		String response = given().get("https://jsonplaceholder.typicode.com/posts/3").asString();
		System.out.println(response);
	}
		
	//@Test //capture the response as inputstream
	public  void inputStream() {
		InputStream response = get("https://jsonplaceholder.typicode.com/posts").asInputStream();
		System.out.println(response.toString());
	}
	
	
	//@Test //path
	public  void jsonPath1() {
		String response = 
				given().get("https://jsonplaceholder.typicode.com/photos/1")
				.path("url");
		System.out.println(response.toString());
	}
	
	/*Extract values from the response or return the response instance itself. 
	This is useful for example if you want to use values from the
    response in subsequent requests.*/

	//@Test 
	public  void jsonPath() {
		String response = 
				given().get("https://jsonplaceholder.typicode.com/photos/1")
				.then()
				.contentType(ContentType.JSON)
				.body("albumId",equalTo(1))
				.extract()
				.path("url");
		System.out.println(response);
		given().relaxedHTTPSValidation().get(response).then().statusCode(200);
	}
		
	/*
	 * JsonPath is an alternative to using XPath for easily getting values from a Object document. It follows the
	 * Groovy <a href="http://docs.groovy-lang.org/latest/html/documentation/#_gpath">GPath</a> syntax when getting an object from the document. You can regard it as an alternative to XPath for JSON.
	 * E.g. given the following Object document:
	 * */
	
	//@Test
	public  void jsonPath2() {
		String response = 
				given().get("https://jsonplaceholder.typicode.com/photos/10").jsonPath().getString("thumbnailUrl");
		System.out.println(response.toString());
	}
	
	//@Test
	public  void listAnalysis() {
		List<Object> response=given().get("http://localhost:3000/country").jsonPath().getList("RestResponse.result.name");
		for(Object a: response) {
			System.out.println(a.toString());
		}
	}
	
	//The entire response object including headers, cookies and body etc.
	//@Test
	public  void responseObject() {
		Response response = given().when().get("https://jsonplaceholder.typicode.com/photos/10").then()
				.assertThat().statusCode(200).and().extract().response();
		
		System.out.println(response.contentType());
		System.out.println(response.path("url"));
		System.out.println(response.statusCode());
	}
}
