package messaging;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ApiRunnerTest {
	@Steps
	ProducerResourceTest producerResourceTest;
	
	@Test
	public void testApi() {
		producerResourceTest.testEndpoint();
	}
}
