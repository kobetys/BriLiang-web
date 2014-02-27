package springvalidator;

import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return ClassUtils.isAssignable(clazz, customerData.class);
	}
	@Override
	public void validate(Object target, Errors errors) {
		
	}
	
}
