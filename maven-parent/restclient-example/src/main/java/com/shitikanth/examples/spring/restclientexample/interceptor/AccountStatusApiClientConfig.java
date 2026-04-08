package com.shitikanth.examples.spring.restclientexample.interceptor;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AccountStatusApiClientProperties.class)
class AccountStatusApiClientConfig {
	@Bean
	AccountStatusApiClient accountStatusApiClient(
			RestClient.Builder builder, AccountStatusApiClientProperties properties) {
		var client = builder.baseUrl(properties.getBaseUrl())
				.requestInterceptors(interceptors -> {
					interceptors.add(new AddStandardHeadersRequestInterceptor());
				})
				.build();
		var adapter = RestClientAdapter.create(client);
		HttpServiceProxyFactory factory =
				HttpServiceProxyFactory.builderFor(adapter).build();
		return factory.createClient(AccountStatusApiClient.class);
	}
}
