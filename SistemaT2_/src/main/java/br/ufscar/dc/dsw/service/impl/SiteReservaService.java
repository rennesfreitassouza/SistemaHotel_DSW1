package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ISiteReservaDAO;
import br.ufscar.dc.dsw.domain.SiteReserva;

public class SiteReservaService {
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
	public List<SiteReserva> buscarTodos() {
		return dao.findAll();
	}
}
