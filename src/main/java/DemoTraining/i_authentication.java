package DemoTraining;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
public class i_authentication {

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
