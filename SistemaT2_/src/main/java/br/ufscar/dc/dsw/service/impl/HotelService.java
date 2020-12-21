package br.ufscar.dc.dsw.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IHotelDAO;
import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@Service
@Transactional(readOnly = false)
public class HotelService implements IHotelService{
	
	@Autowired
	IHotelDAO dao;
	
	public void salvar(Hotel hotel) {
		dao.save(hotel);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true) 
	public Hotel buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Hotel> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Hotel> buscarTodosHoteisDaCidade(Cidade cidade) {
		return dao.findByCidades(cidade);
	}
}
