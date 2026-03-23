package com.shitikanth.examples.beanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
class FileValidatorFactory {
	final ApplicationContext context;

	FileValidatorFactory(ApplicationContext context) {
		this.context = context;
	}

	@SuppressWarnings("unchecked")
	<C extends FileValidatorConfig> AbstractFileValidator<C> create(C config) {
		var validatorClass = FileValidatorRegistry.getValidatorClass((Class<C>)config.getClass());
		return context.getAutowireCapableBeanFactory().getBean(validatorClass, config);
	}
}
