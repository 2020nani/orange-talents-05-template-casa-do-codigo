package com.casacodigo.hernani.cadastrocategoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

	@Column(name = "nomeCategori", nullable = false, unique = true)
	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}


}
