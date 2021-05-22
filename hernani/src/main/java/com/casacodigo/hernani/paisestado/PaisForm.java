package com.casacodigo.hernani.paisestado;

import javax.validation.constraints.NotBlank;

import com.casacodigo.hernani.beanscustomizado.UniqueValue;

public class PaisForm {
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Este pais ja esta cadastrado")
	private String nome;


	public String getNome() {
		return nome;
	}
	
	

}
