package com.shitikanth.examples.spring.restclientexample.greeting;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group = "greeting", value = {GreetingClient.class})
public class GreetingClientConfig {

}
