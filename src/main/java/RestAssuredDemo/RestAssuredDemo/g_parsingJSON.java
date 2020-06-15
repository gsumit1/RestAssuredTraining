package RestAssuredDemo.RestAssuredDemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;


public class g_parsingJSON {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Response response = given().when().get("https://jsonplaceholder.typicode.com/posts/?id=1").then()
				.assertThat().statusCode(200).and().extract().response();
		System.out.println(readMethod(response).get("id"));
		System.out.println(readMethod(response).get("title"));
		System.out.println(readMethod(response).get("body"));
	}

	
	public static JSONObject readMethod(Response response) throws FileNotFoundException, IOException, ParseException {
		JSONParser rowData = new JSONParser();
		Object obj = rowData.parse(response.asString());
		JSONArray array = (JSONArray) obj;
		JSONObject jsonObject = (JSONObject) array.get(0);
		/*
		JsonDataResponse data = new JsonDataResponse();
		String userId = jsonObject.get("userId").toString();
		data.setUserId(userId);
		String id = jsonObject.get("id").toString();
		data.setID(id);
		String job = (String) jsonObject.get("title");
		data.setTitle(job);
		String body = (String) jsonObject.get("body");
		data.setBody(body); 
		return (data);*/		
		return(jsonObject);
	}
}
