package com.tfreitas.oportunidades.apiController;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tfreitas.oportunidades.model.ClienteModel;
import com.tfreitas.oportunidades.repository.ClientesDao;
import com.tfreitas.oportunidades.service.ClienteService;

@RestController
@RequestMapping("/apiClientes")
public class ClienteController {
	
	private static final Logger logger = LogManager.getLogger(ClienteController.class);
	
	@Autowired
	private ClientesDao clientesDao;
	
	@Autowired
	private ClienteService clienteService;
	
	//listar todos os clientes
	@GetMapping
	@ResponseBody
	public List<ClienteModel> listarTodosClientes(){
		return clientesDao.findAll();
		
	}
	
	//obter cliente por id
	@GetMapping(value="{id}")
	public ClienteModel obterPorId(@PathVariable Long id) {
		return clienteService.obterPorId(id);
	}
	
	//salvar um novo cliente
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel salvarNovoCliente(@RequestBody ClienteModel cliente) {
		logger.debug("Salvando cliente");
		return clientesDao.save(cliente);
	}
	
	//atualizar um cliente
	@PostMapping
	public ClienteModel atualizarCliente(@RequestBody ClienteModel cliente) throws Exception {
		return clienteService.atualizarCliente(cliente);
	}
	
	//oferecaTambem - id de produto semelhante
	
	//ofereca de novo - apos tempo de duracao do produto

}
