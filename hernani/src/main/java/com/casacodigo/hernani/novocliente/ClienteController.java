package com.casacodigo.hernani.novocliente;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casacodigo.hernani.paisestado.EstadoRepository;
import com.casacodigo.hernani.paisestado.PaisRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	
	@PostMapping(value = "/cliente")
	@Transactional
	public String criarCliente(@RequestBody @Valid ClienteForm clienteform) {
		Cliente cliente = clienteform.converte(estadoRepository, paisRepository);
		clienteRepository.save(cliente);
		return cliente.toString();
	}

}
