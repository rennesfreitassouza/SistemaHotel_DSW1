package br.ufscar.dc.dsw.domain;

public class Admin {

	private Long id;
	private String nome;
	private String login;
	private String senha;

	public Admin(Long id) {
		this.id = id;
	}

	public Admin(String nome, String login, String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;

	}

	public Admin(Long id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}
}