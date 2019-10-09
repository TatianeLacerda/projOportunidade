package com.tfreitas.oportunidades.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tfreitas.oportunidades.model.ProdutoModel;
import com.tfreitas.oportunidades.repository.ProdutosDao;

@Service
public class ProdutoService {
		
	@Autowired
	private ProdutosDao produtosDao;

	public ProdutoModel obterPorId(Long id) {
		Optional<ProdutoModel> op = produtosDao.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public ProdutoModel salvarNovosProdutos(ProdutoModel produto) {
		Optional<ProdutoModel> produtoExistente = produtosDao.findByNomeProdutoAndTempoDuracao(produto.getNomeProduto(), produto.getTempoDuracao());
		if(produtoExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um produto cadastrado com esse mesmo nome e tempo de duração");
		}
		return produtosDao.save(produto);
	}

}
