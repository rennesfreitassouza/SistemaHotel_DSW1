package br.ufscar.dc.dsw.domain;

public class PromoHotel {

    private Long id;
    private float preco;
    private String iniciopromo;
    private String fimpromo;
    private Hotel hotel;
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