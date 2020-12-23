package br.ufscar.dc.dsw.domain;



import java.util.List;
import java.util.Set; //Classe do java que permite não repetição.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//Classe mapeada para a tabela:
//create table Hotel(

//	);

@SuppressWarnings("serial")
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
    
	//Uma cidade pode conter vários hotéis, e um hotel pode estar em várias cidades.
	@ManyToMany(targetEntity=Cidade.class, mappedBy = "hotelDaCidade") //a string é mapeada para o atributo chamado hotelDaCidade da classe Cidade.
	private Set<Cidade> cidades;

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

	public Hotel(String cnpj, String nome, Set<Cidade> cidades, String email, String senha) {
		super(nome,email,senha);
		
		this.cnpj = cnpj;
	    this.cidades = cidades;
	    
	    
	}
	
	public Hotel(Long id, String cnpj, String nome, Set<Cidade> cidades, String email, String senha) {
	    this(cnpj, nome, cidades, email, senha);
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
    
    public Set<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Set<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public void addCidade(Cidade hotelEstaNaCidade) { //Atenção para o uso, somente adiciona, não substitui.
        this.cidades.add(hotelEstaNaCidade);
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
