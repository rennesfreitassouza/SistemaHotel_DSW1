package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ISiteReservaDAO;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.service.spec.ISiteReservaService;

@Service
@Transactional(readOnly = false)
public class SiteReservaService implements ISiteReservaService{
	@Autowired
	ISiteReservaDAO dao;
	
	public void salvar(SiteReserva sitereserva) {
		dao.save(sitereserva);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public SiteReserva buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
	
	@Transactional(readOnly = true) 
	public SiteReserva buscarPorLogin(String login) {
		return dao.findByLogin(login);
	}


	@Transactional(readOnly = true)
	public List<SiteReserva> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public boolean siteReservaTemPromo(Long id) {
		return !dao.findById(id.longValue()).getPromocoesDoHotel().isEmpty();
	}
}
