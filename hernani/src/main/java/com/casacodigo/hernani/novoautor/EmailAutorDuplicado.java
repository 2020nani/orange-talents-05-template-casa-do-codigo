package com.casacodigo.hernani.novoautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailAutorDuplicado implements Validator {
	
	@Autowired
	private AutorRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm objeto = (AutorForm) target;
		
		boolean autorJaExiste = repository.existsByEmail(objeto.getEmail());
		 
		if(autorJaExiste) {
			errors.rejectValue("email", null, "O email " + objeto.getEmail() + " ja esta cadastrado");
		}
	}

}
