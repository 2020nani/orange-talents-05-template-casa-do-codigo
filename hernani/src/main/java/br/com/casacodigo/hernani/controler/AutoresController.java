package br.com.casacodigo.hernani.controler;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.casacodigo.hernani.controler.form.AutorForm;
import br.com.casacodigo.hernani.modelo.Autor;

@RestController
public class AutoresController  {
	
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
