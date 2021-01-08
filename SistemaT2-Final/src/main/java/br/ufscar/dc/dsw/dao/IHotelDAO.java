package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;

@SuppressWarnings("unchecked")
public interface IHotelDAO extends CrudRepository<Hotel, Long>{
	
	Hotel findById(long id);
	
	List<Hotel> findAll();
	
	List<Hotel> findByCidades(Cidade cidade); // Devolve todas os hotéis de uma cidade.
	
	Hotel save (Hotel hotel); // faz as operações de save e update.
	
	void deleteById(Long id);
	
	Hotel findByLogin(String login);
	
	//Procurar todas as cidades dado um estado: https://youtu.be/BsBwd5lh-8c?t=214
//	@Query("select h from Hotel h where cidade = :cidade")
//	public List<Hotel> findByCidade(@Param("estado") Cidade cidade);
}
