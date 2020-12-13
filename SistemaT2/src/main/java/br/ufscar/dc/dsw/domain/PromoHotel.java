package br.ufscar.dc.dsw.domain;


//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

//create table PromoHotel(
//		id bigint not null auto_increment,
//		preco float not null,
//		iniciopromo date not null,
//		fimpromo date not null,
//		Hotel_id bigint not null,
//		Sitereserva_id bigint not null,
//		foreign key (Hotel_id) references Hotel(id) on delete cascade,
//		foreign key (Sitereserva_id) references SiteReserva(id) on delete cascade,
//		primary key (id)
//	);


@Entity
@Table(name = "PromoHotel")
public class PromoHotel{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false, unique=false)
    private float preco;
	
	@Column(nullable=false, unique=false, length=10)
    private String iniciopromo;
    
	@Column(nullable=false, unique=false, length=10)
	private String fimpromo;
    
	@ManyToOne //Um hotel, várias promoções. 
	@JoinColumn(name = "hotel_id") //Solicita para o JPA que ele crie uma coluna no DB que é chave estrangeira para id da tabela Hotel.
	private Hotel hotel; 
	
	@OneToMany(mappedBy = "Sitereserva_id")
    private SiteReserva sitereserva;

    public PromoHotel(Long id) {
        this.id = id;
    }

	public PromoHotel(float preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
		this.preco = preco;
	    this.iniciopromo = iniciopromo;
	    this.fimpromo = fimpromo;
	    this.hotel = hotel;
	    this.sitereserva = sitereserva;
	}
	
	public PromoHotel(Long id, float preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
	    this(preco, iniciopromo, fimpromo, hotel, sitereserva);
	    this.id = id;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getIniciopromo() {
        return iniciopromo;
    }

    public void setIniciopromo(String iniciopromo) {
        this.iniciopromo = iniciopromo;
    }
    
    public String getFimpromo() {
        return fimpromo;
    }

    public void setFimpromo(String fimpromo) {
        this.fimpromo = fimpromo;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public SiteReserva getSitereserva() {
        return sitereserva;
    }

    public void setSitereserva(SiteReserva sitereserva) {
        this.sitereserva = sitereserva;
    }
}
