package com.shitikanth.examples.beanfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class DuplicateFileNameValidator extends AbstractFileValidator<DuplicateFileNameValidatorConfig> {

	@Autowired
	DuplicateFileNameChecker duplicateFileNameChecker;

	DuplicateFileNameValidator(DuplicateFileNameValidatorConfig config) {
		super(config);
	}

	@Override
	public FileValidationResult validate(String fileName) {
		if (duplicateFileNameChecker.isDuplicateFileName(fileName)) {
			return FileValidationResult.invalid("Duplicate file name");
		} else {
			return FileValidationResult.valid();
		}
	}
}

record DuplicateFileNameValidatorConfig() implements FileValidatorConfig {}