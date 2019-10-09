package com.tfreitas.oportunidades.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfreitas.oportunidades.model.ClienteModel;
import com.tfreitas.oportunidades.repository.ClientesDao;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesDao clientesDao;

	public ClienteModel atualizarCliente(ClienteModel cliente) throws Exception {
		if(cliente.getId() == 0) {
			throw new Exception("Especifique o id do cliente que será atualizado");
		}
		return clientesDao.save(cliente);
	}

	public ClienteModel obterPorId(Long id) {
		Optional<ClienteModel> op = clientesDao.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

}
