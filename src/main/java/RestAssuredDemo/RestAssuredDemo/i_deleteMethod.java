package RestAssuredDemo.RestAssuredDemo;

import static io.restassured.RestAssured.given;
public class i_deleteMethod {

	public static void main(String[] args) {
		
		int response = given().when().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().statusCode(200).and()
				.extract().jsonPath().getList("$").size();
		System.out.println(response);
		//delete();
	}
	
	public static void delete() {
		int response = given().when().get("http://localhost:3000/posts").then().assertThat().statusCode(200).and()
				.extract().jsonPath().getList("$").size();
		System.out.println(response);
		
		//individual
		given().when().delete("http://localhost:3000/posts/5").then().statusCode(200);
		
		
		//all
		for (int i = 6; i <= response; i++) {
			given().pathParam("id", i).when().delete("http://localhost:3000/posts/{id}").then().statusCode(200);
			System.out.println("deleted");} 
		}

}
