package restAssured.Serilization;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
public class TestSerilization {
//@Test
public void serelizationTest() {
	Address a =new Address(25, "Sumit","Noida");
	given().contentType(ContentType.JSON).body(a).when().post("http://localhost:3000/profile").then().assertThat().statusCode(201);
	
}

@Test
public void deSerelizationTest() {
	//Address a =new Address(25, "Sumit","Noida");
	Address myList= given().contentType(ContentType.JSON).when().get("http://localhost:3000/profile?id=25").as(Address.class);
	System.out.println(myList.getId());
}
}
