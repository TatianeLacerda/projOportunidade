package com.tfreitas.oportunidades.apiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tfreitas.oportunidades.model.PedidoModel;
import com.tfreitas.oportunidades.service.PedidoService;

@RestController
@RequestMapping("/apiPedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	//efetuar compra e validar se item ja esta na sacola
	@PostMapping
	@ResponseBody
	public PedidoModel validaExistenciaDoItemNaSacolaEAdiciona(@RequestBody PedidoModel pedido) {
		return pedidoService.validarItemPedidoRepetido(pedido);
	}

}
