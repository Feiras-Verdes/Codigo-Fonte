package br.com.feirasverdes.backend.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizador")
public class Organizador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome", nullable = false, length = 200)
	private String nome;
	
	@Column(name="cpf", nullable = false, length = 200)
	private String cpf;
	
	@Column(name="cnpj", nullable = false, length = 200)
	private String cnpj;
	
	@Column(name="telefone", nullable = false, length = 200)
	private String telefone;
	
	@Column(name="usuario", nullable = false, length = 200)
	private String usuario;
	
	@Column(name="senha", nullable = false, length = 200)
	private String senha;
	
	private Endereco endereco;
	
	public Organizador() {
		super();
	}

	public Organizador(Long id, String nome, String cpf, String cnpj, String telefone, String usuario, String senha,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.usuario = usuario;
		this.senha = senha;
		this.endereco = endereco;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
}
