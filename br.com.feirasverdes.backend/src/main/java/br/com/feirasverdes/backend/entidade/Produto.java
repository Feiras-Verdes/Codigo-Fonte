package br.com.feirasverdes.backend.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Column(name="nome", nullable = false, length = 200)
	private String nome;
	
	@Column(name="descricao", nullable = false, length = 200)
	private String descricao;
	
	@Column(name="preco", nullable = false, length = 200)
	private String preco;
	
	private Feirante feirante;

	public Produto() {
		super();
	}

	public Produto(Long id, String nome, String descricao, String preco, Feirante feirante) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.feirante = feirante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Feirante getFeirante() {
		return feirante;
	}

	public void setFeirante(Feirante feirante) {
		this.feirante = feirante;
	}
	
	
	
}
