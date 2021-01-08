package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;

public interface IHotelService {
	public void salvar(Hotel hotel);

	public void excluir(Long id);

	public Hotel buscarPorId(Long id);

	public List<Hotel> buscarTodos();
	
	public List<Hotel> buscarTodosHoteisDaCidade(Cidade cidade);
	
	public Hotel buscarPorLogin(String login);
	
	boolean hotelTemPromo(Long id);
}
