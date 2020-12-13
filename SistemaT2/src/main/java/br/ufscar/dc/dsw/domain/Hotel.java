package br.ufscar.dc.dsw.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.Table;


//Classe mapeada para a tabela:
//create table Hotel(
//		id bigint not null auto_increment,
//		cnpj varchar(18) not null,
//		nome varchar(250) not null,
//		cidade varchar(250) not null,
//		email varchar(200) not null,
//		senha varchar(20) not null,
//		primary key (id)
//	);

@Entity
@Table(name = "Hotel")
public class Hotel {
	
	@OneToMany(mappedBy = "hotel") //a string é mapeada para o atributo hotel.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 18)
    private String cnpj;
	
	@Column(nullable = false, unique = false, length = 250)
    private String nome;
    
	@Column(nullable = false, unique = false, length = 250)
	private String cidade;
	
	@Column(nullable = false, unique = false, length = 200)
    private String email;
	
	@Column(nullable = false, unique = false, length = 20)
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
