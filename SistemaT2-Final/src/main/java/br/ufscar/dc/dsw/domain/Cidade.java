package br.ufscar.dc.dsw.domain;


//import java.util.HashMap;
import java.util.HashSet;
import java.util.Set; //Classe do java que permite não repetição.

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//Classe mapeada para a tabela:
//create table Cidade(

//	);
@SuppressWarnings("serial")
@Entity
@Table(name = "Cidade")
public class Cidade extends AbstractEntity<Long>{

	@NotBlank(message="NotNull.cidade.nomeCidade") // Significa que a String não é nula, mas está vazia. 
	@Size(min = 3, max = 200, message = "{Size.cidade.nomeCidade}")
	@Column(nullable = false, unique = false, length = 200)
    private String nomeCidade;
	
	@OneToMany	(mappedBy = "cidade")//Uma cidade pode conter vários hotéis, e um hotel pode estar em apenas uma cidade.
	private Set<Hotel> hotelDaCidade;

	public Cidade() {
	}
	
	
	public Cidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
		this.hotelDaCidade = new HashSet<Hotel>(); //antes de add, usar método setCidade.
	}
	
	public Cidade(String nomeCidade, Set<Hotel> hotelDaCidade) {
		this.nomeCidade = nomeCidade;
		this.hotelDaCidade = hotelDaCidade;
	}
	
	@Override
	public Long getId() {
		return super.getId();
	}
	
	public String getCidade() {
		return this.nomeCidade;
	}
	
	public void setCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	
	public Set<Hotel> getHotelDaCidade() {
		return this.hotelDaCidade;
	}
	
	public void setHotelDaCidade(Set<Hotel> hotelDaCidade) {
		this.hotelDaCidade = hotelDaCidade;
	}
	
	public void addHotelDaCidade(Hotel addhotelNaCidade) { //Somente adiciona, não substitu.
		this.hotelDaCidade.add(addhotelNaCidade);
	}
}