package com.shitikanth.examples.spring.requestscopeexample;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Optional;

@Component
@RequestScope
class ModuleProvider {

	private final Long moduleId;

	ModuleProvider(HttpServletRequest request) {
		String value = request.getHeader("X-OSFIN-MODULEID");
		if (value == null) {
			moduleId = null;
			return;
		}
		try {
			moduleId = Long.valueOf(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid module id");
		}
	}

	Optional<Long> getModuleId() {
		return Optional.ofNullable(this.moduleId);
	}
}
