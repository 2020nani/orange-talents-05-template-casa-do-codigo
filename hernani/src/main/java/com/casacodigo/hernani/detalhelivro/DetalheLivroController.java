package com.casacodigo.hernani.detalhelivro;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.casacodigo.hernani.novolivro.Livro;
import com.casacodigo.hernani.novolivro.LivroRepository;




@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/livro/{id}")
	public LivroDetalheResponse getLivroId(@PathVariable("id") Long id) {

		Livro livro = livroRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nao encontrado"));
		
		LivroDetalheResponse livroDto = new LivroDetalheResponse(livro);
		
		return livroDto;
		
	}

}