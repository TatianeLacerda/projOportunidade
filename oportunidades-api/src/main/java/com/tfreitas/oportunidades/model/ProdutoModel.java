package com.tfreitas.oportunidades.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private Long idProdutoSemelhante;
	private String nomeProduto;
	private double tempoDuracao;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "semelhantes",
		joinColumns = @JoinColumn(name = "id_produto"),
		inverseJoinColumns = @JoinColumn(name = "id_semelhante"))
	private List<ProdutoModel> semelhantes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getTempoDuracao() {
		return tempoDuracao;
	}
	public void setTempoDuracao(double tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}
	public List<ProdutoModel> getSemelhantes() {
		return semelhantes;
	}
	public void setSemelhantes(List<ProdutoModel> semelhantes) {
		this.semelhantes = semelhantes;
	}	

}
