package restAssured;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import restAssured.model1;


public class MyTest {
	@Test
	public void getData() throws FileNotFoundException, IOException, ParseException{	     
		
		ArrayList<model1> rowData=new ArrayList<model1>();
		for (int i = 1; i <2; ++i){
			Response response = given().when().get("https://jsonplaceholder.typicode.com/posts/?id="+i).then()
					.assertThat().statusCode(200).and().extract().response();
			 String responseObject = response.body().asString().substring(1, response.body().asString().length()-1).trim();
			 //System.out.println(responseObject);
			 model1 test=(model1) data(responseObject, model1.class);
			 rowData.add(test);
		}
		System.out.println(rowData.get(0).getBody());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	 public static Object data(String responseString, Class className ) throws JsonParseException, JsonMappingException, IOException{
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
    return objectMapper.readValue(responseString, className);
    }
}


