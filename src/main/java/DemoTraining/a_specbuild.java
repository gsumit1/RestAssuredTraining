package DemoTraining;

import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class a_specbuild {
	
	@Test
	public void test1() {
		RequestSpecification spec=new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us").build();
		//given().spec(spec).when().then().statusCode(200);
		given().spec(spec).when().get("/us/90210").then().statusCode(200);
		
	}
	
	//@Test
	public void test2() {
		ResponseSpecification spec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		given().when().get("http://api.zippopotam.us/us/90210").then().spec(spec).and().body("country", equalTo("United States"));
		
	}

}
