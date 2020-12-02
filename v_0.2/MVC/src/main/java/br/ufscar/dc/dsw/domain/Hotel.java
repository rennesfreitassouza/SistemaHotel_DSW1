package br.ufscar.dc.dsw.domain;

public class Hotel {

    private Long id;
    private String cnpj;
    private String nome;
    private String cidade;
    private String email;
    private String senha;

    public Hotel(Long id) {
        this.id = id;
    }
    
    public Hotel(Long id, String cnpj) {
    	this(id);
        this.cnpj = cnpj;
    }

	public Hotel(String cnpj, String nome, String cidade, String email, String senha) {
		this.cnpj = cnpj;
	    this.nome = nome;
	    this.cidade = cidade;
	    this.email = email;
	    this.senha = senha;
	}
	
	public Hotel(Long id, String cnpj, String nome, String cidade, String email, String senha) {
	    this(cnpj, nome, cidade, email, senha);
	    this.id = id;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
