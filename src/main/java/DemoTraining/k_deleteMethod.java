package DemoTraining;

import static io.restassured.RestAssured.given;
public class k_deleteMethod {

	public static void main(String[] args) {
		
		given().when().delete("http://localhost:3000/posts/10").then().statusCode(200);
		
		//int response = given().when().get("https://jsonplaceholder.typicode.com/posts").jsonPath().getList("$").size();
		//System.out.println(response);
		//delete();
	}
	
	public static void delete() {
				
		//int response = given().when().get("http://localhost:3000/posts").jsonPath().getList("$").size();
		//System.out.println(response);
		
		//individual
		given().when().delete("http://localhost:3000/posts/6").then().statusCode(200);
		
		
	/*
		for (int i = 6; i <= response; i++) {
			given().pathParam("id", i).when().delete("http://localhost:3000/posts/{id}").then().statusCode(200);
			System.out.println("deleted");} 
		}*/
	
	}

}
