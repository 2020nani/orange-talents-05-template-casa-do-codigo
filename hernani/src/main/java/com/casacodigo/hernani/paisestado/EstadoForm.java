package com.casacodigo.hernani.paisestado;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EstadoForm {
	@NotBlank
	private String nome;
	
	@NotNull
	private Long paisId;

	public EstadoForm(@NotBlank String nome, @NotBlank Long paisId) {
		super();
		this.nome = nome;
		this.paisId = paisId;
	}

	public Estado converte(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.findById(paisId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Nao existe Pais com este Id"));
	
		boolean estado = estadoRepository.existsByNomeAndPaisNome(nome, pais.getNome());
		
		if(estado) {
			return null;
		}
		
		return new Estado(this.nome, pais);
	}

}
