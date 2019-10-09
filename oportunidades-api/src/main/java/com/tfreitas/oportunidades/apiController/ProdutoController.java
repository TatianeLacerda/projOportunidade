package com.tfreitas.oportunidades.apiController;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tfreitas.oportunidades.model.ProdutoModel;
import com.tfreitas.oportunidades.repository.ProdutosDao;
import com.tfreitas.oportunidades.service.ProdutoService;

@RestController
@RequestMapping("/apiProdutos")
public class ProdutoController {
	
	private static final Logger logger = LogManager.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutosDao produtosDao;
	
	@Autowired
	private ProdutoService produtoService;
	
	//listar todos os produtos
	@GetMapping
	@ResponseBody
	public List<ProdutoModel> listarTodosProdutos(){
		return produtosDao.findAll();
	}
	
	//salvar novos produtos - valida se já não existe produto com mesmo nome e tempoDur
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoModel salvarNovosProdutos(@RequestBody ProdutoModel produto) {
		logger.getLevel();
		logger.debug("Salvando Produto:", produto.getId() + produto.getNomeProduto());
		return produtoService.salvarNovosProdutos(produto);
	}
	
	//obter o produto por id
	@GetMapping(value="{id}")
	public ProdutoModel obterPorId(@PathVariable Long id) {
		return produtoService.obterPorId(id);
	}

}
