package br.ufscar.dc.dsw.dao;


import org.springframework.data.repository.CrudRepository;


import br.ufscar.dc.dsw.domain.Cidade;

@SuppressWarnings("unchecked")
public interface ICidadeDAO extends CrudRepository<Cidade, Long>{

	Cidade save(Cidade cidade);
	
	void deleteById(Long id);
}
