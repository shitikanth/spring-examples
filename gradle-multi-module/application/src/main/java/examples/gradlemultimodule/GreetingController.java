package examples.gradlemultimodule;

import examples.gradlemultimodule.library.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {
	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GetMapping("/")
	String greeting(
		@RequestParam(name = "name", defaultValue = "World")
		String name
	) {
		return greetingService.greet(name);
	}
}
