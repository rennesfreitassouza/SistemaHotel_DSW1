package br.ufscar.dc.dsw.domain;

public class SiteReserva {
    private Long id;
    private String url;
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    public SiteReserva(Long id) {
        this.id = id;
    }
	
    public SiteReserva(Long id, String url) {
    	this(id);
        this.url = url;
    }
    
    public SiteReserva(String url, String nome, String telefone, String email, String senha) { 
	    this.url = url;
	    this.nome = nome;
	    this.telefone = telefone;
	    this.email = email;
	    this.senha = senha;
	}
    
	public SiteReserva(Long id, String url, String nome, String telefone, String email, String senha) {
	    this(url, nome, telefone, email, senha);
	    this.id = id;
	}
	
	public Long getId() {
	    return id;
	}
	
	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getUrl() {
	    return url;
	}
	
	public void setUrl(String url) {
	    this.url = url;
	}
	
	public String getNome() {
	    return nome;
	}
	
	public void setNome(String nome) {
	    this.nome = nome;
	}
	
	public String getTelefone() {
	    return telefone;
	}
	
	public void setTelefone(String telefone) {
	    this.telefone = telefone;
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