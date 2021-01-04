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
	public String formParaBuscaDeHotelPorCidade(/*@RequestParam(required = false) String nomeInseridoDaCidade*/
					@RequestParam(required = false) String cidadeParaSelecionar, ModelMap model) {
//		if (result.hasErrors()) {
//			return "hoteis/erro"; //página de erros amigável
//		}
//		List<Cidade>teste = serviceC.buscarTodas();
		//COMO PEGAR O VALOR INSERIDO NO INPUT DO FORUMULARIO E ATRIBUIR PARA UM TRIBUTO DA VISÃO. ENVIAR POST-> OUTRA VISAO (OPERADOR TERNARIO)
		//model.addAttribute("nomeInseridoDaCidade", nomeInseridoDaCidade); //Lista todos os hotéis da cidade de Ibaté.
		List<Cidade>cidades = serviceC.buscarTodas();
		model.addAttribute("cidadesParaSelecionar", cidades); //Lista todos os hotéis da cidade de Ibaté.
		
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
	
	@PostMapping("/listarTodosHoteisDaCidade")
	public String listarTodosHoteisDaCidade(String nomeInseridoDaCidade, ModelMap model) {
//		if (result.hasErrors()) {
//			return "hoteis/erro"; //página de erros amigável
//		}
		//buscar o objeto cidade pelo nome. Listar todas e pesquisar na lista uma que contenha o nome igual a enviada pelo formulário.
		List<Cidade>listaCidadesCadastradas = serviceC.buscarTodas();
		Cidade cidade = new Cidade();
		for (Cidade cidadeDaLista : listaCidadesCadastradas) {
			if (cidadeDaLista.getCidade().equals(nomeInseridoDaCidade))
			{
				cidade = cidadeDaLista;
				break;
			}
		}
		if (cidade.getHotelDaCidade() != null)
			model.addAttribute("hoteisDaCidade", service.buscarTodosHoteisDaCidade(cidade)); //Lista todos os hotéis da cidade de Ibaté.
		return "hoteis/buscarTodosHoteisDaCidade"; //Renderizar PARA HTML APROPRIADO.
	}
}
