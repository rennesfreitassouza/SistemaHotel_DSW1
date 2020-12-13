package br.ufscar.dc.dsw.domain;



import java.util.List;
import java.util.Set; //Classe do java que permite não repetição.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.Table;


//Classe mapeada para a tabela:
//create table Hotel(

//	);

@Entity
@Table(name = "Hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 18)
    private String cnpj;
	
	@Column(nullable = false, unique = false, length = 250)
    private String nome;
    
	//Uma cidade pode conter vários hotéis, e um hotel pode estar em várias cidades.
	@ManyToMany(targetEntity=Cidade.class, mappedBy = "hotelDaCidade") //a string é mapeada para o atributo chamado hotelDaCidade da classe Cidade.
	private Set<Cidade> cidades;
	
	@Column(nullable = false, unique = false, length = 200)
    private String email;
	
	@Column(nullable = false, unique = false, length = 20)
    private String senha;
	
	@OneToMany(mappedBy = "hotel") //a string é mapeada para o atributo chamado hotel da classe PromoHotel.
	private List<PromoHotel> promocoesDoHotel;

    public Hotel(Long id) {
        this.id = id;
    }
    
    public Hotel(Long id, String cnpj) {
    	this(id);
        this.cnpj = cnpj;
    }

	public Hotel(String cnpj, String nome, Set<Cidade> cidades, String email, String senha) {
		this.cnpj = cnpj;
	    this.nome = nome;
	    this.cidades = cidades;
	    this.email = email;
	    this.senha = senha;
	}
	
	public Hotel(Long id, String cnpj, String nome, Set<Cidade> cidades, String email, String senha) {
	    this(cnpj, nome, cidades, email, senha);
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
    
    public Set<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Set<Cidade> cidades) {
        this.cidades = cidades;
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

    public List<PromoHotel> getPromocoesDoHotel() {
        return promocoesDoHotel;
    }

    public void setPromocoesDoHotel(List<PromoHotel> promocoesDoHotel) {
        this.promocoesDoHotel = promocoesDoHotel;
    }
}
