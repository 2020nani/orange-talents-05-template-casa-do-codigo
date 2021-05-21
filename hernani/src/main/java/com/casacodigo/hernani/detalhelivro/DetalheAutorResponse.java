package com.casacodigo.hernani.detalhelivro;

import com.casacodigo.hernani.novoautor.Autor;

public class DetalheAutorResponse {
			
		private String nome;

		private String email;

		private String descricao;


		public DetalheAutorResponse(Autor autor) {
			this.nome = autor.getNome();
			this.email = autor.getEmail();
			this.descricao = autor.getDescricao();
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
