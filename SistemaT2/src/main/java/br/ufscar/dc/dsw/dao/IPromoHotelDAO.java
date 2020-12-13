package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.SiteReserva;

@SuppressWarnings("unchecked")
public interface IPromoHotelDAO extends CrudRepository<PromoHotel, Long>{
	
	PromoHotel findById(long id);
	
	List<PromoHotel> findAll();
	
	List<PromoHotel> findByPromoHotel(Hotel hotel); // Devolve todas as promoções de um hotel específico.
	
	List<PromoHotel> findBySiteReserva(SiteReserva sitereserva); // Devolve todas as promoções de um site específico.
	PromoHotel save(PromoHotel promohotel); // faz as operações de save e update.
	
	void deletById(Long id);

}
