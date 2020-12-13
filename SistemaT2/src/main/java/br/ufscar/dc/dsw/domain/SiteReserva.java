package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.Table;


//create table SiteReserva(
//		id bigint not null auto_increment,
//		url varchar(250) not null,
//		nome varchar(250) not null,
//		telefone varchar(14),
//		email varchar(200) not null,
//		senha varchar(20) not null,
//		primary key (id)
//	);

@Entity
@Table(name = "SiteReserva")
public class SiteReserva {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false, unique = false, length = 250)
    private String url;
	
	@Column(nullable= false, unique = false, length = 250)
    private String nome;
	
	@Column(nullable= true, unique = false, length = 14)
    private String telefone;
	
	@Column(nullable= false, unique = false, length = 200)
    private String email;
	
	@Column(nullable= false, unique = false, length = 20)
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
