package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Hotel;

import br.ufscar.dc.dsw.domain.Cidade;

@SuppressWarnings("unchecked")
public interface ICidadeDAO extends CrudRepository<Cidade, Long>{

	Cidade save(Cidade cidade);
	
	List<Hotel> findByHotelDaCidade(Hotel hotel);
	
	void deleteById(Long id);
}
