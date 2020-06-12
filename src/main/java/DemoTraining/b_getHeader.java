package DemoTraining;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class b_getHeader {
		@Test
		public static void listAnalysis() {
			Response response=given().get("http://localhost:3000/country");
			//Response response=given().get("http://localhost:3000/testDemo?id=1");

			for(Header a: response.getHeaders()) {
				System.out.println(a.getName()+">>>>>>>>>>>>>"+a.getValue());
			}
			System.out.println(response.getHeaders().get("ETag").getValue());
						
		}
}
