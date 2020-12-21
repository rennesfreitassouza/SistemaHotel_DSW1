package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IPromoHotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.SiteReserva;

public class PromoHotelService {
	@Autowired
	IPromoHotelDAO dao;
	
	public void salvar(PromoHotel promohotel) {
		dao.save(promohotel);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true) 
	public PromoHotel buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<PromoHotel> buscarTodos() {
		return dao.findAll();
	}
	
	//TESTAR
//	@Transactional(readOnly = true)
//	public List<PromoHotel> buscarPorHotel(Hotel hotel) {
//		return dao.findByhotel(hotel); // Devolve todas as promoções de um hotel específico. R6
//	}
//	
//	@Transactional(readOnly = true)
//	public List<PromoHotel> buscarPorSiteReserval(SiteReserva sitereserva) {
//		return dao.findBysitereserva(sitereserva); // Devolve todas as promoções de um site específico. R8
//	}
}
