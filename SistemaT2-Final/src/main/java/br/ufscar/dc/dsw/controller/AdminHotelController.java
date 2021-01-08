package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@Controller
@RequestMapping("/adminhoteis")
public class AdminHotelController {
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Hotel hotel) {
		return "admin/hotel/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("hoteis",service.buscarTodos());
		return "admin/hotel/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Hotel hotel, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "admin/hotel/cadastro";
		}
		hotel.setSenha(encoder.encode(hotel.getSenha()));
		service.salvar(hotel);
		attr.addFlashAttribute("sucess", "Hotel inserido com sucesso.");
		return "redirect:/adminhoteis/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("hotel", service.buscarPorId(id));
		return "admin/hotel/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Hotel hotel, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "admin/hotel/cadastro";
		}
		hotel.setSenha(encoder.encode(hotel.getSenha()));
		service.salvar(hotel);
		attr.addFlashAttribute("sucess", "Hotel editado com sucesso.");
		return "redirect:/adminhoteis/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.hotelTemPromo(id)) {
			model.addAttribute("fail", "Hotel não excluído. Possui promo(s) vinculada(s).");
		} else {
			service.excluir(id);
			model.addAttribute("sucess", "Hotel excluído com sucesso.");
		}
		return listar(model);
	}
}