package com.tfreitas.oportunidades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tfreitas.oportunidades.model.PedidoItemModel;
import com.tfreitas.oportunidades.model.PedidoModel;
import com.tfreitas.oportunidades.repository.PedidosDao;

@Service
public class PedidoService {
	
	@Autowired
	private PedidosDao pedidosDao;
	
	//não permitir comprar duas vezes o mesmo item no mesmo pedido, apenas aumentar a quantidade
	public PedidoModel validarItemPedidoRepetido(PedidoModel pedido) {
		
		for (int i = 0; i < pedido.getItens().size(); i++) {
			for (int j = i+1; j < pedido.getItens().size(); j++) {
				PedidoItemModel item1 = pedido.getItens().get(i);
				PedidoItemModel item2 = pedido.getItens().get(j);
				if(item1.getProduto().getId() == item2.getProduto().getId()) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse item já está na lista, informe apenas a quantidade desejada");
				}
			}
		}
		return pedidosDao.save(pedido);
	}
}
