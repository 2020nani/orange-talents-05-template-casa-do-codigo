package com.casacodigo.hernani.detalhelivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import com.casacodigo.hernani.novolivro.Livro;

public class LivroDetalheResponse {
	
	private Long id;
	private String titulo;
	private String resumo;
	private BigDecimal preco;
	private String sumario;
	private Integer numeroPaginas;
	private String isbn;
	private String dataPublicacao;
    private DetalheAutorResponse autor;
	private String nomeCategoria;
	
	
	

	public LivroDetalheResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new DetalheAutorResponse(livro.getAutor());
		this.nomeCategoria = livro.getCategoria().getNome();
	}
	
	

	public Long getId() {
		return id;
	}



	public String getTitulo() {
		return titulo;
	}

	public DetalheAutorResponse getAutor() {
		return autor;
	}



	public String getResumo() {
		return resumo;
	}



	public BigDecimal getPreco() {
		return preco;
	}



	public String getSumario() {
		return sumario;
	}



	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}



	public String getIsbn() {
		return isbn;
	}



	public String getDataPublicacao() {
		return dataPublicacao;
	}



	public String getNomeCategoria() {
		return nomeCategoria;
	}

	
}
