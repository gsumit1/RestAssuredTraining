package DemoTraining;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class j_getPostMethod {
	@SuppressWarnings("unchecked")
	public static void main(String arg[]) {
		JSONObject postDataRow = new JSONObject();
		postDataRow.put("title", "JSQ12");
		postDataRow.put("Name", "Sumit12");
		postDataRow.put("id", "103");

		given().contentType("application/json; charset=UTF-16").body(postDataRow)
				.post("http://localhost:3000/posts").then().statusCode(201);
		System.out.println("done");
				
	}

}

