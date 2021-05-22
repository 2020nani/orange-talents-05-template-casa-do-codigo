package com.casacodigo.hernani.paisestado;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EstadoController {
	private String[] message = {
			"Ja existe um Estado cadastrado neste País"	
	};
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping(value = "/estado")
	@Transactional
	public ResponseEntity<?> criaEstado(
			@RequestBody @Valid EstadoForm estadoform) {
		Estado estado = estadoform.converte(paisRepository, estadoRepository);
		
		if(estado == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe um Estado com este nome neste Pais");
			/**
			 * Retorno utilizando ResponseEntity
			 * return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
			 */
			
		}
		estadoRepository.save(estado);
		return ResponseEntity.ok(estado);
		
	}

	

}
