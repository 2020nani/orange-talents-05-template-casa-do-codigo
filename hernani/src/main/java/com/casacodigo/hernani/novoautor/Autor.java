package com.casacodigo.hernani.novoautor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Autor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	@Email(message = "Por favor digite um email valido")
	private String email;

	@NotBlank
	@Size(max = 400, message = "")
	private String descricao;
	
	private LocalDateTime instanteCriado = LocalDateTime.now();
	
	@Deprecated
	public Autor() {
		super();
	}

	public Autor(
			 @NotBlank  String nome,
			 @NotBlank @Email String email,
			 @NotBlank @Size String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", instanteCriado=" + instanteCriado + "]";
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	
	
	

}
