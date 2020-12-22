package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@Controller
@RequestMapping("/hoteis")
public class HotelController {
	
	
	@Autowired
	private IHotelService service;
		
	@GetMapping("/listarTodosHoteis")
	public String listarTodosHoteis(ModelMap model) {
		model.addAttribute("hoteis",service.buscarTodos());
		//service.buscarTodos(); retorna todos os hotéis, atribui a um atributo de modelo chamado hoteis
		return "hoteis/listarTodosHoteis"; // renderiza para a visão hoteis/listarTodosHoteis
	}

	@GetMapping("/listarTodosHoteisDaCidade")
	public String listarTodosHoteisDaCidade(@Valid Cidade cidade, BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			return "hoteis/erro"; //página de erros amigável
//		}
		
		model.addAttribute("hoteisDaCidade",service.buscarTodosHoteisDaCidade(cidade));
		return "hoteis/listarTodosHoteisDaCidade";
	}
}
