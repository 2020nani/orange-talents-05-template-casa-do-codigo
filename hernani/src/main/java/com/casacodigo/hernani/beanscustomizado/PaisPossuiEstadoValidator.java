package com.casacodigo.hernani.beanscustomizado;

import com.casacodigo.hernani.novocliente.ClienteForm;
import com.casacodigo.hernani.paisestado.Estado;
import com.casacodigo.hernani.paisestado.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class PaisPossuiEstadoValidator implements ConstraintValidator<PaisPossuiEstado, ClienteForm > {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean isValid(ClienteForm value, ConstraintValidatorContext context) {
        boolean talvezPaisTemEstado = estadoRepository.existsByPaisId(value.getPaisId());
        Optional<Estado> talvezEstadoNome = estadoRepository.findByNomeAndPaisId(value.getEstadoNome(), value.getPaisId());
      
      if (talvezPaisTemEstado) {
           return talvezEstadoNome.isPresent();
       }else {
           return talvezEstadoNome.isEmpty();
       }
        
    }

}