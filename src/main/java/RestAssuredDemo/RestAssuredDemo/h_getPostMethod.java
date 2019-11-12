package RestAssuredDemo.RestAssuredDemo;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class h_getPostMethod {
	@SuppressWarnings("unchecked")
	public static void main(String arg[]) {
		JSONObject postDataRow = new JSONObject();
		postDataRow.put("title", "JSQ1");
		postDataRow.put("Name", "Sumit1");
		postDataRow.put("id", "7");

		given().contentType("application/json; charset=UTF-16").body(postDataRow.toJSONString())
				.post("http://localhost:3000/posts");
		System.out.println("done");
				
	}

}

