package br.ufscar.dc.dsw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.ICidadeDAO;
import br.ufscar.dc.dsw.dao.IHotelDAO;
import br.ufscar.dc.dsw.dao.IPromoHotelDAO;
import br.ufscar.dc.dsw.dao.ISiteReservaDAO;

import br.ufscar.dc.dsw.domain.*;

@SpringBootApplication
public class SistemaT2Application {
	
	private static final Logger log = LoggerFactory.getLogger(SistemaT2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SistemaT2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ICidadeDAO cidadeDAO, IHotelDAO hotelDAO, IPromoHotelDAO promoHotelDAO, ISiteReservaDAO siteReservaDAO) {
		return (args) -> {
			
			log.info("Salvando Cidade");
			Cidade cidade = new Cidade("São Carlos");
			cidadeDAO.save(cidade);
			
			
			//Set<Cidade> cidades, String email, String senha) {
			Set<Cidade> setcidade = new HashSet<Cidade>();
			setcidade.add(new Cidade("C1"));
			log.info("Salvando hotel");
			Hotel hotel = new Hotel("CNPJ", "nOME", setcidade, "email@email.com", "senha");
			hotelDAO.save(hotel);
			
			log.info("Salvando Site");
			SiteReserva sitereserva = new SiteReserva("www", "nome", "tel", "e-mail", "senha");
			siteReservaDAO.save(sitereserva);
			
			log.info("Salvando Promoção");
			PromoHotel promoHotel = new PromoHotel(1, "111", "222", hotel, sitereserva);
			promoHotelDAO.save(promoHotel);

			
		};
	}
}
