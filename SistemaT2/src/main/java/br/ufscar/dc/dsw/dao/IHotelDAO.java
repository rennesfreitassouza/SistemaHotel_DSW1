package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Hotel;

@SuppressWarnings("unchecked")
public interface IHotelDAO extends CrudRepository<Hotel, Long>{
	
	Hotel findById(long id);
	
	List<Hotel> findAll();
	
	
	Hotel save (Hotel hotel); // faz as operações de save e update.
	
	void deletById(Long id);

}
