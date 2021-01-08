package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.SiteReserva;

public interface IPromoHotelService {
	
	public void salvar(PromoHotel promohotel);

	public void excluir(Long id);
	
	public PromoHotel buscarPorId(Long id);
	
	public List<PromoHotel> buscarTodos();
	
	public List<PromoHotel> findByHotel(Hotel hotel);
	
	public List<PromoHotel> findBySitereserva(SiteReserva sitereserva);
	
	public PromoHotel findByIniciopromo(String iniciopromo);
}
