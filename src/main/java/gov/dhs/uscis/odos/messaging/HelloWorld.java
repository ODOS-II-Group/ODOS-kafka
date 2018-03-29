package gov.dhs.uscis.odos.messaging;

public class HelloWorld {
	private String message;
	
	public HelloWorld() {
	}
	
	public String getMessage() {
		return message;
	}
	
	public HelloWorld setMessage(String message) {
		this.message = message;
		return this;
	}
}
