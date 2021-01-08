package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
		
	@GetMapping("/listarTodosHoteis") //USA MÉTODO GET
	public String listarTodosHoteis(ModelMap model) {
		model.addAttribute("hoteis",service.buscarTodos());
		//o método service.buscarTodos(); retorna todos os hotéis, então o método de model atribui o valor a um atributo de modelo chamado hoteis.
		return "hoteis/listarTodosHoteis"; // renderiza para a visão hoteis/listarTodosHoteis
	}
	
	@PostMapping("/listarTodosHoteis") //USA MÉTODO POST
	public String listarTodosHoteisPost(ModelMap model) {
		model.addAttribute("hoteis",service.buscarTodos());
		//o método service.buscarTodos(); retorna todos os hotéis, então o método de model atribui o valor a um atributo de modelo chamado hoteis.
		return "hoteis/listarTodosHoteis"; // renderiza para a visão hoteis/listarTodosHoteis
	}

	@GetMapping("/formParaBuscaDeHotelPorCidade")
	public String formParaBuscaDeHotelPorCidade(@RequestParam(required = false) String cidadeParaSelecionar, ModelMap model) {
		List<Cidade>cidades = serviceC.buscarTodas();
		model.addAttribute("cidadesParaSelecionar", cidades);
		
		if (cidadeParaSelecionar != null) {
			Cidade cidade = new Cidade();
			for (Cidade cidadeDaLista : cidades) {
				if (cidadeDaLista.getCidade().equals(cidadeParaSelecionar))
				{
					cidade = cidadeDaLista;
					break;
				}
			}
			model.addAttribute("hotelDaCidade", service.buscarTodosHoteisDaCidade(cidade));
		}
		
		return "hoteis/formParaBuscaDeHotelPorCidade"; //Renderiza para formParaBuscaDeHotelPorCidade.html
	}
}
