package br.ufscar.dc.dsw;

import java.util.HashSet;
import java.util.List;
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

			log.info("Salvando Cidade sao carlso sem nenhum hotel");
			Cidade cidade = new Cidade("São Carlos");
			Cidade c2 = new Cidade("Ibaté");
			//cidadeDAO.save(cidade);			
			
			Set<Cidade> setcidade = new HashSet<Cidade>();
			
			setcidade.add(cidade); 
			setcidade.add(c2); 			
			
			Hotel hotel = new Hotel("CNPJ", "nOME", setcidade, "email@email.com", "senha");
			
			log.info("Salvando hotel");
			hotelDAO.save(hotel); //not a transient instance  anymore
			
			//Adiconar hotel aos objetos cidades.
			Set<Hotel> sethotel = new HashSet<Hotel>();
			sethotel.add(hotel);
			
			for (Cidade c : setcidade) {
			    c.setHotelDaCidade(sethotel); //Insere hotel noX objetoX de cada cidade c1 e c2. (persistir)
			    cidadeDAO.save(c); //not a transient instance  anymore
			}
			
			
			//Agora inserir os objetos cidades, com o atributo hotel atualizado, no objeto hoteil.
			hotel.setCidades(setcidade); //
			hotelDAO.save(hotel);//atualiza
			
		
//			List<Hotel> listcidade2 = cidadeDAO.findByHotelDaCidade(hotel);
//			
//			for (Hotel hotelx : listcidade2) {
//				log.info("cidadeDAO.findByHotelDaCidade(hotel) = "+hotelx.getNome());
//			}

			
			List<Hotel> listaHoteis = hotelDAO.findByCidades(c2);			
			for (Hotel hotelx : listaHoteis) {
				log.info("cidadeDAO.findByCidades(cidade) = "+hotelx.getNome());
			}
			
			log.info("Salvando Site");
			SiteReserva sitereserva = new SiteReserva("www", "nome", "tel", "e-mail", "senha");
			siteReservaDAO.save(sitereserva);
			
			log.info("Salvando Promoção");
			PromoHotel promoHotel = new PromoHotel(1, "111", "222", hotel, sitereserva);
			promoHotelDAO.save(promoHotel);

			log.info("Imprimindo cidade:");
			log.info(cidade.getCidade());
		};
	}
}
