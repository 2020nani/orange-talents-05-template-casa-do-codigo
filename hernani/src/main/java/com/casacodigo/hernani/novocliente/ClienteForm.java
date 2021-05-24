package com.casacodigo.hernani.novocliente;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.casacodigo.hernani.beanscustomizado.CpfOuCnpj;
import com.casacodigo.hernani.beanscustomizado.PaisPossuiEstado;
import com.casacodigo.hernani.beanscustomizado.UniqueValue;
import com.casacodigo.hernani.paisestado.Estado;
import com.casacodigo.hernani.paisestado.EstadoRepository;
import com.casacodigo.hernani.paisestado.Pais;
import com.casacodigo.hernani.paisestado.PaisRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

@PaisPossuiEstado
public class ClienteForm {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@CpfOuCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank 
	private String complemento;
	
	@NotBlank 
	private String cidade;
	
	@NotNull
	private Long paisId;
	
	@JsonProperty(required = false)
	private String estadoNome;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long paisId, String estadoNome, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoNome = estadoNome;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getPaisId() {
		return paisId;
	}



	public String getEstadoNome() {
		return estadoNome;
	}

	

	public Cliente converte(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		Estado estado = null;
		Pais pais = paisRepository.findById(paisId).get();
		Assert.state(pais!=null,"Você esta querendo cadastrar um cliente com um País que nao existe no banco "+paisId);
		
		boolean estadoExiste = estadoRepository.existsByNomeAndPaisId(estadoNome, paisId);
	   
		if(estadoExiste) {
		estado = estadoRepository.findByNomeAndPaisId(estadoNome, paisId).get();
		Assert.state(estado!=null,"Você esta querendo cadastrar um cliente com um País que nao existe no banco "+paisId);
		}else {
		Assert.state(estadoNome.equals("")==true,"O pais selecionado nao possui estado cadastrado "+paisId);  
		}
	
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
	}
	
	
}
