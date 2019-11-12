package RestAssuredDemo.RestAssuredDemo;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class e_setup {
		@Test //setting up baeURI,basePath etc
		public static void example1() {
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
			RestAssured.basePath="/city";
			//RestAssured.proxy=8080;
			//RestAssured.authentication=basic("userName","password");
			given().get("/Hyderabad").then().statusCode(200).log().all();
		}
}
