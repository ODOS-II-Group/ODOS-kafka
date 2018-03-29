package gov.dhs.uscis.odos.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	private final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);
	
	@StreamListener(ConsumerChannel.CHANNEL)
	public void consume(HelloWorld hello) {
		LOG.info("Received message: {}", hello.getMessage());
	}
}
