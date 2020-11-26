package src.br.ufscar.dc.dsw.bean;

import src.br.ufscar.dc.dsw.dao.*;
import src.br.ufscar.dc.dsw.domain.*;

import java.util.List;


public class ListagemPorCidadeBean {

	public List<Hotel> getCidades() {
		HotelDAO dao = new HotelDAO();
		return dao.getAll(true);
	}
	
}
