package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.SiteReserva;

public interface ISiteReservaService {
	public void salvar(SiteReserva siteReserva);
	
	public void excluir(Long id);
	
	public SiteReserva buscarPorId(Long id);
	
	public List<SiteReserva> buscarTodos();
	
	public SiteReserva buscarPorLogin(String login);
	
	//boolean siteReservaTemPromo(Long id);
}
