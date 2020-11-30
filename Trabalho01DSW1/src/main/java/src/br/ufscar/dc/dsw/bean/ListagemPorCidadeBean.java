package src.br.ufscar.dc.dsw.bean;

import java.util.List;



import src.br.ufscar.dc.dsw.dao.HotelDAO;

import src.br.ufscar.dc.dsw.domain.Hotel;

public class ListagemPorCidadeBean {

	public List<Hotel> getHotelPorCidade() {
		HotelDAO dao = new HotelDAO();
		return dao.getAll();
	}
	
	public List<Hotel> getHotelPorCidade(String nome) {
		HotelDAO dao = new HotelDAO();
		List<Hotel> listaDeHoteisPorCidade;
		if (nome.length() > 0) {
			listaDeHoteisPorCidade = dao.getByNomeCidade(nome);
		} else {
			listaDeHoteisPorCidade = dao.getAll();
		}
		
		return listaDeHoteisPorCidade;
	}
}

