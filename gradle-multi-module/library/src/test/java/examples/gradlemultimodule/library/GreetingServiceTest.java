package examples.gradlemultimodule.library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GreetingServiceTest {
	@Test
	void testGreeting() {
		GreetingService greetingService = new GreetingService();
		assertEquals("Hello World!", greetingService.greet("World"));
	}
}