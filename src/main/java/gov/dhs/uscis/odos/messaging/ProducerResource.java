package gov.dhs.uscis.odos.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/api")
public class ProducerResource {
	private final Logger LOG = LoggerFactory.getLogger(ProducerResource.class);
	
	private MessageChannel messageChannel;
	
	public ProducerResource(ProducerChannel producerChannel) {
		this.messageChannel = producerChannel.messageChannel();
	}
	
	@GetMapping("/helloworld/{count}")
	@Timed
	public void produce(@PathVariable int count) {
		while (count > 0) {
			HelloWorld message = new HelloWorld().setMessage("Hello world! x" + count);
			LOG.info("Sending message: {}", message);
			messageChannel.send(MessageBuilder.withPayload(message).build());
			count--;
		}
	}
}
