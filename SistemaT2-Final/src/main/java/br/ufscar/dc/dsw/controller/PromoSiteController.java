package br.ufscar.dc.dsw.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.service.spec.IPromoHotelService;
import br.ufscar.dc.dsw.service.spec.ISiteReservaService ;

@Controller
@RequestMapping("/sitereserva")
public class PromoSiteController {
	
	@Autowired
	private ISiteReservaService serviceS;
	
	@Autowired
	private IPromoHotelService serviceP;
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
	
	@GetMapping("/lista")
	public String listar(ModelMap model) {
					
		SiteReserva site = serviceS.buscarPorLogin(this.getUsuario().getLogin()); //busca site de reservas de acordo com usuario logado
		//System.out.println(hotel);
		model.addAttribute("listapromo",serviceP.findBySitereserva(site));
		//System.out.println(serviceP.findByHotel(hotel));
		
		return "sitereserva/lista";
	}

}