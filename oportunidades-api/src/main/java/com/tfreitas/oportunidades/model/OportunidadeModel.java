package com.tfreitas.oportunidades.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class OportunidadeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ofereca_de_novo",
		joinColumns = @JoinColumn(name = "id_produto"),
		inverseJoinColumns = @JoinColumn(name = "id_ofereca_de_novo"))
	private List<ProdutoModel> oferecaDeNovo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ofereca_tambem",
		joinColumns = @JoinColumn(name = "id_produto"),
		inverseJoinColumns = @JoinColumn(name = "id_ofereca_tambem"))
	private List<ProdutoModel> oferecaTambem;
	
	public List<ProdutoModel> getOferecaDeNovo() {
		return oferecaDeNovo;
	}
	public void setOferecaDeNovo(List<ProdutoModel> oferecaDeNovo) {
		this.oferecaDeNovo = oferecaDeNovo;
	}
	public List<ProdutoModel> getOferecaTambem() {
		return oferecaTambem;
	}
	public void setOferecaTambem(List<ProdutoModel> oferecaTambem) {
		this.oferecaTambem = oferecaTambem;
	}

}
