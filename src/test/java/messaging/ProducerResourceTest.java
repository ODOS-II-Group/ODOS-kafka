package messaging;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;

public class ProducerResourceTest {
	private Logger LOG = Logger.getLogger(ProducerResourceTest.class);
	
	@Step("Test app is up")
	public void testEndpoint( ) {
		String endpoint;
		endpoint = getProperty() + "/api/helloworld/1";
		RestAssured.when().get(endpoint)
			.then().assertThat().statusCode(200);
	}
	
	private static String getProperty() {
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("gradle.properties"));
			if (properties.containsKey("testEnvValue")) {
				return properties.getProperty("testEnvValue");
			}
			
			return properties.getProperty("localEnvValue");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
