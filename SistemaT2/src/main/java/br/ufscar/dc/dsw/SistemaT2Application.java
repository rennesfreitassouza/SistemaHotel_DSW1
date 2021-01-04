package br.ufscar.dc.dsw;

import java.util.ArrayList;
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
	
//	private static final Logger log = LoggerFactory.getLogger(SistemaT2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SistemaT2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ICidadeDAO cidadeDAO, IHotelDAO hotelDAO, IPromoHotelDAO promoHotelDAO, ISiteReservaDAO siteReservaDAO) {
		return (args) -> {
			
			
			Cidade cidade1 = new Cidade("São Carlos");
			Cidade cidade2 = new Cidade("São Paulo");
			Cidade cidade3 = new Cidade("Uberaba");
			
			cidadeDAO.save(cidade1);			
			cidadeDAO.save(cidade2);			
			cidadeDAO.save(cidade3);
			
			Set<Cidade> set1cidade = new HashSet<Cidade>();
			Set<Cidade> set2cidade = new HashSet<Cidade>();
			Set<Cidade> set3cidade = new HashSet<Cidade>();
			
			set1cidade.add(cidade1); //Adiciona São Carlos a set1cidade.
			
			
			set2cidade.add(cidade1);  //Adiciona São Carlos ao objeto.
			set2cidade.add(cidade2); //Adiciona São Paulo a setcidade2
			
			set3cidade.add(cidade1); //Adiciona São Carlos ao objeto.
			set3cidade.add(cidade2); //Adiciona São Paulo ao objeto.
			set3cidade.add(cidade3); //Adiciona Uberaba ao objeto.
			
			
			Hotel hotel1 = new Hotel("55.789.390/0008-99", "Hotel Boa Viagem", set1cidade, "hotel1@hotel.com", "hotel1");
			Hotel hotel2 = new Hotel("71.150.470/0001-40", "Hotel Bela Vista", set2cidade, "hotel2@hotel.com", "hotel2");
			Hotel hotel3 = new Hotel("32.106.536/0001-82", "Hotel Bienvenido", set3cidade, "hotel3@hotel.com", "hotel3");
			
			//log.info("Salvando hotéis");
			hotelDAO.save(hotel1); //not a transient instance  anymore - Hotel Boa Viajem está em São Carlos e São Paulo.
			hotelDAO.save(hotel2); //not a transient instance  anymore - Hotel Bela Vista está em São Carlos. 
			hotelDAO.save(hotel3); //not a transient instance  anymore - Hotel Bienvenido está em Uberaba e São Pualo.
			
			Set<Hotel> set1hotel = new HashSet<Hotel>();
			set1hotel.add(hotel1);

			Set<Hotel> set2hotel = new HashSet<Hotel>();
			set2hotel.add(hotel2);
			
			Set<Hotel> set3hotel = new HashSet<Hotel>();
			set3hotel.add(hotel3);
			
//			cidade1.addHotelDaCidade(hotel1);
//			cidadeDAO.save(cidade1);
//			cidade2.addHotelDaCidade(hotel1);
//			cidadeDAO.save(cidade2); 
			//nomeHotel1 está nas cidades de São Carlos e São Paulo. (persistir)
			
			
			//ATUALIZAR OBJETOS DOS SETS: (NECESSÁRIO?)
			Set<Cidade> set1cidadeUP = new HashSet<Cidade>();
			Set<Cidade> set2cidadeUP = new HashSet<Cidade>();
			Set<Cidade> set3cidadeUP = new HashSet<Cidade>();
//	ATENÇÃO ORDEM (PRIMEIRO INICIALIZAR COM O  método setHotelDaCidade):	
			
			//Inicializa o atributo hotelDaCidade dos objetos que representam as cidades com o método set1hotel
			for (Cidade c : set3cidade) {
			    c.setHotelDaCidade(set3hotel); //Insere hotel3 nos objetos que estão no set3cidade (persistir).
			    
			    cidadeDAO.save(c); //not a transient instance  anymore
			    set3cidadeUP.add(c);
			} //São Carlos, São Paulo e Uberaba agora contém o Hotel Bienvenido.
			
			//ADD
			for (Cidade c : set2cidade) {
			    c.addHotelDaCidade(hotel2); //Insere hotel2 no objeto que está no set2cidade (persistir).
			    
			    cidadeDAO.save(c); //not a transient instance  anymore
			    set2cidadeUP.add(c);
			} //São Carlos e São Paulo agora contém o Hotel Bela Vista.
			
			
			//ADD
			for (Cidade c : set1cidade) {
			    c.addHotelDaCidade(hotel1); //atribui set1hotel nos objetos de cada cidade do Set set1cidade1. (persistir)
			    
			    cidadeDAO.save(c); //not a transient instance  anymore
			    set1cidadeUP.add(c);
			} //São Carlos agora contém o hotel Boa Viajem.
			

			//Re-inicializa o atributo cidades do objeto hotel1 com set1cidade (que agora possui os objetos atualizados).
			hotel1.setCidades(set1cidadeUP);
//			hotel1.addCidade(cidade2); //
			hotelDAO.save(hotel1);//atualiza bd (localização do Hotel Boa Viagem atualizada pra São Carlos.
			
			//Re-inicializa o atributo cidades do objeto hotel2 com set2cidade (que agora possui o objeto atualizado).
			hotel2.setCidades(set2cidadeUP);
//			hotel2.addCidade(cidade1); //
			hotelDAO.save(hotel2);//atualiza bd (localização do Hotel Bela Vista atualizada pra São Carlos e São Paulo.
			
			hotel3.setCidades(set3cidadeUP);
//			hotel2.addCidade(); //
			hotelDAO.save(hotel3);//atualiza bd (localização do Hotel Bienvenido atualizada pra São Carlos, São Paulo e Uberaba).
 
//			SiteReserva sitereserva =  new SiteReserva("www", "nome", "tel", "e-mail", "senha", listpromoTeste);
//			//Dúvida não testada: listpromoTeste não pode ser vazia para invocar o método addPromocoesDoHotel da classe siteReserva.
//			//Invocar o método setPromocoesDoHotel da classe siteReserva antes?
//			log.info("Salvando Site");
//			siteReservaDAO.save(sitereserva);
//			
//			log.info("Salvando Promoção");
//			PromoHotel promoHotel = new PromoHotel(1, "111", "222", hotel1, sitereserva);
//			promoHotelDAO.save(promoHotel);
//
//			
//			
		};
	}
}
