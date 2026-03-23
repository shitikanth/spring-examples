package com.shitikanth.examples.beanfactory;

import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractFileValidator<C extends FileValidatorConfig> implements FileValidator {
	protected C config;

	AbstractFileValidator(C config) {
		this.config = config;
	}

	C getConfig() {
		return config;
	}

}
