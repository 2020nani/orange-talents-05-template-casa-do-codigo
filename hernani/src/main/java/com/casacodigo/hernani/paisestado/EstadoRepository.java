package com.casacodigo.hernani.paisestado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	boolean existsByNomeAndPaisNome(@NotBlank String nome, String nome2);

	Optional<Estado> findByNomeAndPaisId(String estadoNome, Long paisId);

	boolean existsByPaisId(Long paisId);

	boolean existsByNomeAndPaisId(String estadoNome, Long paisId);

	


	

}
