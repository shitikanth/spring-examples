package com.shitikanth.examples.spring.requestscopeexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
class GreetingController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

	@Autowired
	GreetingService greetingService;

	@Autowired
	ModuleProvider moduleProvider;

	@GetMapping(produces = "text/plain")
	String greeting(GreetingParams params) {
		var moduleId = moduleProvider.getModuleId();
		if (moduleId.isPresent()) {
			LOGGER.info("Module id: {}", moduleId.get());
		} else {
			LOGGER.info("Module id not found");
		}
		return greetingService.getGreeting(params.getName());
	}
}
