package br.ufscar.dc.dsw.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Classe mapeada para a tabela:
//create table Admin(

//	);

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
public class Usuario extends AbstractEntity<Long>{


	@Column(nullable = false, length = 256)
	private String nome;
	
	@NotBlank(message = "{NotBlank.admin.login}")
	@Size(max = 256, message = "{Size.admin.login}")
	@Column(nullable = false, unique = true, length = 256)
	private String login;
	
	@NotBlank(message = "{NotBlank.admin.senha}")
	@Size(max = 64, message = "{Size.admin.senha}")
	@Column(nullable = false, length = 64)
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
