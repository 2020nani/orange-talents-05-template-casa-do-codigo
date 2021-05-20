package com.casacodigo.hernani.novoautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AutorControler  {
	
	@PersistenceContext
	private EntityManager entitymanager;

	@PostMapping(value="/autores")
	@Transactional
	public String criarAutor(@RequestBody @Valid AutorForm autorform) {
		Autor autor = autorform.converter();
		entitymanager.persist(autor);
		return autor.toString();
		
	}

}
