package com.tfreitas.oportunidades.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tfreitas.oportunidades.model.PedidoItemModel;
import com.tfreitas.oportunidades.model.PedidoModel;

public interface PedidosDao extends JpaRepository<PedidoModel, Long> {
	
	//não foi possivel usar esta, por causa do List<> validar***
	//Optional<PedidosDao> findByDataPedidoAndItens(Date dataPedido, List<PedidoItemModel> itens);
	
	
	//se eu coloco a data igual de um pedido existente na base, o metodo funciona
	//@Query(value="SELECT * FROM pedido_model WHERE data_pedido = ? and id = ?", nativeQuery=true)
	Optional<PedidoModel> findByDataPedidoAndId(Date dataPedido, Long id);

}
