package br.ufscar.dc.dsw.service.spec;

import java.util.List;


import br.ufscar.dc.dsw.domain.Cidade;

public interface ICidadeService {
	public void salvar(Cidade cidade);

	public void excluir(Long id);

//	//Necessário?
//	public Cidade buscarPorId(Long id);

	
	public List<Cidade> buscarTodas();
}
