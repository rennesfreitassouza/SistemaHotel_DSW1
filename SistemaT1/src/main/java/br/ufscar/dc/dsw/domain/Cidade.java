package br.ufscar.dc.dsw.domain;

public class Cidade {
	
	private String nome;
	private String hotel;
	
	public Cidade(String nome) {
		this.nome = nome;
		this.hotel = null;
	}
	
	public String getCidade() {
		return this.nome;
	}
	
	public void setCidade(String nome) {
		this.nome = nome;
	}
	
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
	public String getHotel() {
		return this.hotel;
	}
	
	public String getNomeCidade() {
		return this.nome;
	}
}
