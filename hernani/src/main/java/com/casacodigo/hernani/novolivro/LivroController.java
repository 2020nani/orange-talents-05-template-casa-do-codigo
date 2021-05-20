package com.casacodigo.hernani.novolivro;

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

import com.casacodigo.hernani.cadastrocategoria.CategoriaRepository;
import com.casacodigo.hernani.novoautor.AutorRepository;

@RestController
public class LivroController {
      @PersistenceContext
      private EntityManager entitymanager;
      
     @Autowired
     private AutorRepository autorrepository;
     
     @Autowired
     private CategoriaRepository categoriarepository;
      
  
      @PostMapping(value="/livros")
      @Transactional
      public String novoLivro(@RequestBody @Valid LivroForm livroform) {
    	 
		Livro livro = livroform.novoLivro(autorrepository, categoriarepository);
    	 entitymanager.persist(livro);
    	 return livro.toString();
      }
	
}
