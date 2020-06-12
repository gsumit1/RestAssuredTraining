package DemoTraining;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class c_parameter {
		//@Test
		public static void queryParam() {
			String a= 
			given().queryParam("id", "2").get("http://localhost:3000/testDemo").asString();
			System.out.println(a);
		}
		
		//@Test //code is not working
		public static void formParam() {
			given().formParam("id", "2").post("http://localhost:3000/testDemo");
			}
			
		
		//@Test
		public static void Param() {
			String a= 
			given().param("id", "2").get("http://localhost:3000/testDemo").asString();
			System.out.println(a);
		}
		
		
		//@Test //Example of multiple param
		public static void Param1() {
			ArrayList<String> list=new ArrayList<String>();
			list.add("testData");
			given().param("id", "2").param("listparam",list ).get("http://localhost:3000/testDemo").asString();
			given().param("id", "2").param("a", "test").param("listparam",list ).get("http://localhost:3000/testDemo").asString();			
		}
		
		//Example end point is not working
		@Test
		public static void pathParam() {
				given().pathParam("type", "json").param("section","Domains" ).get("http://api.fonts.com/{section}/{type}").then().statusCode(400);	
		}
		

		@Test 
		//Example end point is not working
		public static void contentType() {
				given().contentType(ContentType.JSON).param("section","Domains" ).get("http://api.fonts.com/{section}/{type}").then().statusCode(400);	
		}
		
		/*given().
        pathParam("hotelId", "My Hotel").
        pathParam("roomNumber", 23).
        when(). 
        post("/reserve/{hotelId}/{roomNumber}").
        then().*/
}
