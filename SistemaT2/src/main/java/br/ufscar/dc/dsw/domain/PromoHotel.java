package br.ufscar.dc.dsw.domain;




import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//create table PromoHotel(

//	);

@SuppressWarnings("serial")
@Entity
@Table(name = "PromoHotel")
public class PromoHotel extends AbstractEntity<Long>{
	
	@NotNull(message = "{NotBlank.promoHotel.preco}")
	@Column(nullable=false, unique=false)
    private double preco; //float e double não funcionam (?).
	
	@NotBlank(message = "{NotBlank.promoHotel.iniciopromo}")
	@Size(min = 10, max = 10, message = "{Size.promoHotel.iniciopromo}")
	@Column(nullable=false, unique=false, length=10)
    private String iniciopromo;

	@NotBlank(message = "{NotBlank.promoHotel.fimpromo}")
	@Size(min = 10, max = 10, message = "{Size.promoHotel.fimpromo}")
	@Column(nullable=false, unique=false, length=10)
	private String fimpromo;
    
	@ManyToOne //Várias promoções podem ser de um mesmo hotel.
	@JoinColumn(name = "hotel_id") //Solicita para o JPA que ele crie uma coluna no DB que é chave estrangeira para id da tabela Hotel.
								   //hotel_id passa a ser uma coluna na tabela PromoHotel, que é chave estrangeira para id da tabela Hotel.
	private Hotel hotel;
	
	
	@ManyToOne //Várias promoções podem ser atribuídas a um mesmo site de reservas.
	@JoinColumn(name = "sitereserva_id")
    private SiteReserva sitereserva;

	public PromoHotel() {
    }
	
//    public PromoHotel(Long id) {
//        this.id = id;
//    }

	public PromoHotel(double preco, String iniciopromo, String fimpromo, Hotel hotel) {
		this.preco = preco;
	    this.iniciopromo = iniciopromo;
	    this.fimpromo = fimpromo;
	    this.hotel = hotel;
	    this.sitereserva = new SiteReserva();
	}
	
	public PromoHotel(double preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
		this.preco = preco;
	    this.iniciopromo = iniciopromo;
	    this.fimpromo = fimpromo;
	    this.hotel = hotel;
	    this.sitereserva = sitereserva;
	}
	
	public PromoHotel(Long id, double preco, String iniciopromo, String fimpromo, Hotel hotel, SiteReserva sitereserva) {
	    this(preco, iniciopromo, fimpromo, hotel, sitereserva);
	    //this.id = id;
	}
	
//	public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
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
