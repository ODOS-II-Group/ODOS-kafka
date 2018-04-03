package messaging;

import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;

public class ProducerResourceTest {
	@Step("Test app is up")
	public void testEndpoint( ) {
		RestAssured.when().get("http://localhost:8111/api/helloworld/1")
			.then().assertThat().statusCode(200);
	}
}
