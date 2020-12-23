package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.service.spec.ICidadeService;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@Controller
@RequestMapping("/hoteis")
public class HotelController {
	//
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private ICidadeService serviceC;
	
	
		
	@GetMapping("/listarTodosHoteis") //
	public String listarTodosHoteis(ModelMap model) {
		model.addAttribute("hoteis",service.buscarTodos());
		//o método service.buscarTodos(); retorna todos os hotéis, então o método de model atribui o valor a um atributo de modelo chamado hoteis.
		return "hoteis/listarTodosHoteis"; // renderiza para a visão hoteis/listarTodosHoteis
	}

	@GetMapping("/listarTodosHoteisDaCidade")
	public String listarTodosHoteisDaCidade(@Valid Cidade cidade, BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			return "hoteis/erro"; //página de erros amigável
//		}
		List<Cidade>teste = serviceC.buscarTodas();
		model.addAttribute("hoteisDaCidade",service.buscarTodosHoteisDaCidade(teste.get(1))); //Lista todos os hotéis da cidade de Ibaté.
		return "hoteis/buscarTodosHoteisDaCidade";
	}
}
