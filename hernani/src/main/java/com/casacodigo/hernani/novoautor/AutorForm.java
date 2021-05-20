package com.casacodigo.hernani.novoautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.casacodigo.hernani.beanscustomizado.UniqueValue;




public class AutorForm {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email(message = "Por favor digite um email valido")
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	
	@NotNull
	@NotBlank
	@Size(max=400,message = "")
	private String descricao;

	public AutorForm(
			 @NotBlank String nome,
			 @NotBlank @Email String email,
			 @NotBlank @Size String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converter() {
		
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return email;
	}



}