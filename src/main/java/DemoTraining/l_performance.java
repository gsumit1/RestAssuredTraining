package DemoTraining;

import static io.restassured.RestAssured.given;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.lessThan;

public class l_performance {
	//@Test
	public static void example1() {
		long t= given().get("https://jsonplaceholder.typicode.com/posts").time();
		System.out.println("Time in ms "+t);
	}
	//@Test
	public static void example2() {
		long t= given().get("https://jsonplaceholder.typicode.com/posts").getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Time in ms "+t);
	}
	@Test
	public static void example3() {
		given().get("https://jsonplaceholder.typicode.com/posts").then().time(lessThan(100L));		
	}
}
