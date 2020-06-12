package DemoTraining;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.config.XmlConfig;
import static org.hamcrest.Matchers.equalTo;

public class f_parsing_xml {

	@Test //setting up baeURI,basePath etc
	public static void example1() {
	        given().
	        config(RestAssured.config().xmlConfig(XmlConfig.xmlConfig().declareNamespace("test", "http://www.w3.org/1999/xlink")))
	        .when()
	        .get("http://www.thomas-bayer.com/sqlrest/PRODUCT/1")
	        .then()
	        .body("test.NAME.text()", equalTo("Chair Shoe")).log().all();
	}
}
