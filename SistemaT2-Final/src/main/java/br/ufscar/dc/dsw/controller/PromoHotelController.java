package br.ufscar.dc.dsw.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.service.spec.IPromoHotelService;
import br.ufscar.dc.dsw.service.spec.IHotelService;
import br.ufscar.dc.dsw.service.spec.ISiteReservaService;

@Controller
@RequestMapping("/hotel")
public class PromoHotelController {
	
	@Autowired
	private IHotelService serviceH;
	
	@Autowired
	private IPromoHotelService serviceP;
	
	@Autowired
	private ISiteReservaService serviceS;
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
	
	@GetMapping("/lista")
	public String listar(ModelMap model) {
					
		Hotel hotel = serviceH.buscarPorLogin(this.getUsuario().getLogin());
		//System.out.println(hotel);
		model.addAttribute("listapromo",serviceP.findByHotel(hotel));
		//System.out.println(serviceP.findByHotel(hotel));
		
		return "hotel/lista";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {
		
		PromoHotel promohotel = new PromoHotel();
		Hotel hotel = serviceH.buscarPorLogin(this.getUsuario().getLogin());
		promohotel.setHotel(hotel);
		model.addAttribute("promohotel",promohotel);
		
		return "hotel/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(ModelMap model, @Valid PromoHotel promohotel, BindingResult result, RedirectAttributes attr) {
		
		PromoHotel promodata = serviceP.findByIniciopromo(promohotel.getIniciopromo());
		System.out.println(promodata);
		
		if (promodata != null) {
				
			model.addAttribute("promohotel",promohotel);
			attr.addFlashAttribute("fail", "Ja existe promoção nessa data");
			return "redirect:/hotel/cadastrar";
		}
		else {
			Hotel hotel = serviceH.buscarPorLogin(this.getUsuario().getLogin());
			promohotel.setHotel(hotel);
			
			if (result.hasErrors()) {
				model.addAttribute("promohotel",promohotel);
				return "redirect:/hotel/cadastrar";
			}
	
			serviceP.salvar(promohotel);
			attr.addFlashAttribute("sucess", "Promoção inserida com sucesso");
			
		}
		return "redirect:/hotel/lista";
	}

	@ModelAttribute("sitereservas")
	public List<SiteReserva> listaSiteReserva() {
		return serviceS.buscarTodos();
	}
	


}
