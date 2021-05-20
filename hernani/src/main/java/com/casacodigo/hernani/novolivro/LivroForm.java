package com.casacodigo.hernani.novolivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.casacodigo.hernani.beanscustomizado.UniqueValue;
import com.casacodigo.hernani.cadastrocategoria.Categoria;
import com.casacodigo.hernani.cadastrocategoria.CategoriaRepository;
import com.casacodigo.hernani.novoautor.Autor;
import com.casacodigo.hernani.novoautor.AutorRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LivroForm {

	@NotBlank
	@Size(max = 100)
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Ja existe um livro cadastrado com este titulo")
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
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Ja existe um livro cadastrado com este isbn")
	private String isbn;

	@Future
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy", iso = ISO.DATE_TIME)/*utilizado formato url-encoded */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataPublicacao;

	@NotNull
	private Long categoriaId;

	@NotNull
	private Long autorId;

	public LivroForm(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 500) String resumo,
			@Min(20) BigDecimal preco, @NotBlank String sumario, @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Long categoriaId, @NotNull Long autorId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.sumario = sumario;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}
	
	/*
	 * campo set da dataPublicacao foi gerado pois o jackson nao conseguia deserializar o formato da data
	 */

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro novoLivro(AutorRepository autorrepository, CategoriaRepository categoriarepository) {
		Autor autor = autorrepository.findById(autorId).get();
		Categoria categoria = categoriarepository.findById(categoriaId).get();
		return new Livro(titulo, resumo, preco, sumario, numeroPaginas, isbn, dataPublicacao, autor, categoria);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

}
