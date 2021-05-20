package com.casacodigo.hernani.novolivro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casacodigo.hernani.cadastrocategoria.CategoriaRepository;
import com.casacodigo.hernani.novoautor.AutorRepository;

@RestController
public class LivroController {
	 @Autowired
     private LivroRepository livrorepository;
      
     @Autowired
     private AutorRepository autorrepository;
     
     @Autowired
     private CategoriaRepository categoriarepository;
     
     @GetMapping("/livros")
     public List<Livro> listaLivros(){
         return  livrorepository.findAll();
     }
      
  
      @PostMapping(value="/livros")
      @Transactional
      public String novoLivro(@RequestBody @Valid LivroForm livroform) {
    	 
		Livro livro = livroform.novoLivro(autorrepository, categoriarepository);
    	 livrorepository.save(livro);
    	 return livro.toString();
      }
      
}
	

