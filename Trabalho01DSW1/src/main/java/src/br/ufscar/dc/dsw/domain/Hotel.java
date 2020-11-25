package src.br.ufscar.dc.dsw.domain;

public class Hotel {
	
	private String e_mail;
	private String senha;
	private String CNPJ;
	private String nomeHotel;
	private String cidade;
	
	public Hotel(String e_mail, String senha, String CNPJ, String nomeHotel, String cidade) {
		this.e_mail = e_mail;
		this.senha = senha;
		this.CNPJ = CNPJ;
		this.nomeHotel = nomeHotel;
		this.cidade = cidade;
	}
	
	public void setE_mail(String e_mail) {
		this.e_mail	= e_mail;
	}
	
	public String getE_mail() {
		return this.e_mail;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public String getCNPJ() {
		return this.CNPJ;
	}
	
	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}
	
	public String getNomeHotel() {
		return this.nomeHotel;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCidade() {
		return this.cidade;
	}
}
