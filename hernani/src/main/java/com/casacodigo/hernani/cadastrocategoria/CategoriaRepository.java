package com.casacodigo.hernani.cadastrocategoria;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	boolean existsByNome(String nome);

}
