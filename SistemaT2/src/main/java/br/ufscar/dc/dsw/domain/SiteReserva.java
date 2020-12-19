package br.ufscar.dc.dsw.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//create table SiteReserva(

//	);

@SuppressWarnings("serial")
@Entity
@Table(name = "SiteReserva")
public class SiteReserva extends Usuario{

	@NotBlank(message = "{NotBlank.siteReserva.url}")
	@Size(min = 3, max = 250, message = "{Size.siteReserva.url}")
	@Column(nullable= false, unique = false, length = 250)
    private String url;

//  atributo nome corresponde ao atributo login herdado de Usuario.	
//	@NotBlank(message = "{NotBlank.siteReserva.nome}")
//	@Size(min = 3, max = 250, message = "{Size.siteReserva.nome}")
//	@Column(nullable= false, unique = false, length = 250)
//    private String nome;
	
	@Column(nullable= true, unique = false, length = 14)
    private String telefone;

//  atributo email agora é herdado da classe Usuario	
//	@NotBlank(message = "{NotBlank.siteReserva.email}")
//	@Size(min = 3, max = 200, message = "{Size.siteReserva.email}")
//	@Column(nullable= false, unique = false, length = 200)
//    private String email;

//	atributo senha agora é herdado da classe Usuario	
//	@NotBlank(message = "{NotBlank.siteReserva.senha}")
//	@Size(min = 3, max = 20, message = "{Size.siteReserva.senha}")	
//	@Column(nullable= false, unique = false, length = 20)
//    private String senha;
	
	@OneToMany(mappedBy = "sitereserva") //a string é mapeada para o atributo sitereserva da classe PromoHotel.
	private List<PromoHotel> promocoesDoSiteReserva;

	public SiteReserva() {
    }
	
//    public SiteReserva(Long id) {
//        this.id = id;
//    }
	
    public SiteReserva(String url) {
        this.url = url;
    }
    
    public SiteReserva(String url, String nome, String telefone, String email, String senha, List<PromoHotel> promocoesDoSiteReserva) { 
    	super(nome, email, senha);
    	
    	this.url = url;
	    
	    this.telefone = telefone;
	    
	    this.promocoesDoSiteReserva = promocoesDoSiteReserva;
	}
    
	public SiteReserva(Long id, String url, String nome, String telefone, String email, String senha, List<PromoHotel> promocoesDoSiteReserva) {
	    this(url, nome, telefone, email, senha, promocoesDoSiteReserva);
	    //this.id = id;
	}
	
//	public Long getId() {
//	    return id;
//	}
//	
//	public void setId(Long id) {
//	    this.id = id;
//	}
	
	public String getUrl() {
	    return url;
	}
	
	public void setUrl(String url) {
	    this.url = url;
	}
	
	public String getNomeHotel() {
	    return getNome();
	}
	
	public void setNome(String nome) {
	    setNome(nome);
	}
	
	public String getTelefone() {
	    return telefone;
	}
	
	public void setTelefone(String telefone) {
	    this.telefone = telefone;
	}
	
	
	public String getEmail() {
	    return getLogin();
	}
	
	public void setEmail(String email) {
	    super.setLogin(email);
	}
	
	@Override
	public String getSenha(){
	    return super.getSenha();
	}
	
	@Override
	public void setSenha(String senha) {
	    super.setSenha(senha);
	}
	
    public List<PromoHotel> getPromocoesDoHotel() {
        return promocoesDoSiteReserva;
    }

    public void setPromocoesDoHotel(List<PromoHotel> promocoesDoSiteReserva) {
        this.promocoesDoSiteReserva = promocoesDoSiteReserva;
    }
    
    public void addPromocoesDoHotel(PromoHotel promocaoDoSiteReserva) {
        this.promocoesDoSiteReserva.add(promocaoDoSiteReserva);
    }
}
