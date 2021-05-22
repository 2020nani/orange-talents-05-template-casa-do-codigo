package com.casacodigo.hernani.novolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.casacodigo.hernani.cadastrocategoria.Categoria;
import com.casacodigo.hernani.novoautor.Autor;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column(unique = true)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@Min(20)
	private BigDecimal preco;
	
	@NotBlank
	private String sumario;
	
	@Min(100)
	private Integer numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@NotNull
	@Future
	private LocalDate dataPublicacao;
	
	@NotNull
	@Valid
	@ManyToOne
    private Autor autor;
	
	@NotNull
	@Valid 
	@ManyToOne
	private Categoria categoria;
	
	@Deprecated
	public Livro() {

	}

	public Livro(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 500) String resumo,
			@Min(20) BigDecimal preco, @NotBlank String sumario, @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull @Valid Autor autor,
			@NotNull @Valid Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.sumario = sumario;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}
	
	

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", preco=" + preco + ", sumario="
				+ sumario + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", autor=" + autor + ", categoria=" + categoria + "]";
	}

	
	
	
}
