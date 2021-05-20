package com.casacodigo.hernani.cadastrocategoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.casacodigo.hernani.beanscustomizado.UniqueValue;

public class CategoriaForm {

	@Column(name = "nomeCategori", nullable = false, unique = true)
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}


}
