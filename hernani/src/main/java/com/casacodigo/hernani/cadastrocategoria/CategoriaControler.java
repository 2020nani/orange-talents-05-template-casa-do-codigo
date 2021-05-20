package com.casacodigo.hernani.cadastrocategoria;

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
public class CategoriaControler {
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	@PostMapping(value="/categorias")
	@Transactional
	public String criarCategoria(@RequestBody @Valid CategoriaForm categoriaform) {
		Categoria categoria = new Categoria(categoriaform.getNome());
		entitymanager.persist(categoria);
		return categoria.toString();
		
	}

}
