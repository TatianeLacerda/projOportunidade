package com.tfreitas.oportunidades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfreitas.oportunidades.model.ProdutoModel;

@Repository
public interface ProdutosDao extends JpaRepository<ProdutoModel, Long> {
	
	Optional<ProdutoModel> findByNomeProdutoAndTempoDuracao(String nomeProduto, double tempoDuracao);
}
