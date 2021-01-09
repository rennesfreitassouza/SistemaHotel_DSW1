package br.ufscar.dc.dsw.domain;



import java.util.HashSet;
import java.util.List;
import java.util.Set; //Classe do java que permite não repetição.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//Classe mapeada para a tabela:
//create table Hotel(

//	);

@SuppressWarnings("serial")
@JsonIgnoreProperties(value = { "cidades", "promocoesDoHotel" }) 
@Entity
@Table(name = "Hotel")
public class Hotel extends Usuario{

	@NotBlank(message = "{NotBlank.hotel.cnpj}") 
	@Size(min = 10, max = 18, message = "{Size.hotel.cnpj}")	
	@Column(nullable = false, unique = true, length = 18)
    private String cnpj;
//herdado	
//	@NotBlank(message = "{NotBlank.hotel.nome}")
//	@Size(min = 3, max = 250, message = "{Size.hotel.nome}")
//	@Column(nullable = false, unique = false, length = 250)
//    private String nome;
    
	//Uma cidade pode conter vários hotéis. Um hotel (Ibis São Carlos <> Ibis Araraquara)
	//pode estar em apenas uma Cidade.
	@ManyToOne
	@JoinColumn (name = "cidade_hotelDaCidade") //a string é mapeada para o atributo chamado hotelDaCidade da classe Cidade.
	private Cidade cidade = new Cidade();

	//herdado
//	@NotBlank(message = "{NotBlank.hotel.email}")
//	@Size(min = 3, max = 200, message = "{Size.hotel.email}")	
//	@Column(nullable = false, unique = false, length = 200)
//    private String email;
//	herdado
//	@NotBlank(message = "{NotBlank.hotel.senha}")
//	@Size(min = 3, max = 20, message = "{Size.hotel.senha}")
//	@Column(nullable = false, unique = false, length = 20)
//    private String senha;
	
	@OneToMany(mappedBy = "hotel") //a string é mapeada para o atributo chamado hotel da classe PromoHotel.
	private List<PromoHotel> promocoesDoHotel;

	public Hotel() {
    }
//	
//    public Hotel(Long id) {
//        this.id = id;
//    }
    
//    public Hotel(String cnpj) {
//        this.cnpj = cnpj;
//    }

	public Hotel(String cnpj, String nome, Cidade cidade, String email, String senha) {
		super(nome,email,senha);
		
		this.cnpj = cnpj;
	    this.cidade = cidade;   
	}
	
	public Hotel(Long id, String cnpj, String nome, Cidade cidade, String email, String senha) {
	    this(cnpj, nome, cidade, email, senha);
	    //this.id = id;
	}
	

//
//    public void setId(Long id) {
//        this.id = id;
//    }
	
	@Override
	public Long getId() {
		return super.getId();
	}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String getNome() {
        return super.getNome();
    }
    
    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public String getEmail() {
        return super.getLogin();
    }

    public void setEmail(String email) {
        super.setLogin(email);
    }
    
    @Override
    public String getSenha() {
        return super.getSenha();
    }
    
    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    public List<PromoHotel> getPromocoesDoHotel() {
        return promocoesDoHotel;
    }

    public void setPromocoesDoHotel(List<PromoHotel> promocoesDoHotel) {
        this.promocoesDoHotel = promocoesDoHotel;
    }
}
