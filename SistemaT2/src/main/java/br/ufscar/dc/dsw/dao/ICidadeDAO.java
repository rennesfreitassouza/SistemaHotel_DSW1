package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Hotel;

import br.ufscar.dc.dsw.domain.Cidade;

@SuppressWarnings("unchecked")
public interface ICidadeDAO extends CrudRepository<Cidade, Long>{
	List<Cidade> findByCidade(Hotel hotel); // Devolve todas a cidades de um hotel específico.(?)

	Cidade save(Cidade cidade);
	
	void deletById(Long id);
}
