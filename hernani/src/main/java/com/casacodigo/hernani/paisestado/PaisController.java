package com.casacodigo.hernani.paisestado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	@Autowired
	private PaisRepository paisrepository;
	
	@PostMapping(value ="/pais")
	@Transactional
	public String criaPais(@RequestBody @Valid PaisForm paisform) {
		
		Pais pais = new Pais(paisform.getNome());
		paisrepository.save(pais);
		return pais.toString();
	}

}
