package br.ufscar.dc.dsw.bean;

import java.util.List;



import br.ufscar.dc.dsw.dao.CidadeDAO;
import br.ufscar.dc.dsw.dao.HotelDAO;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;

public class ListagemPorCidadeBean {

	public List<Cidade> getHotelPorCidade() {
		CidadeDAO dao = new CidadeDAO();
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

