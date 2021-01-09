package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.ICidadeDAO;
import br.ufscar.dc.dsw.dao.IHotelDAO;
import br.ufscar.dc.dsw.dao.IPromoHotelDAO;
import br.ufscar.dc.dsw.dao.ISiteReservaDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;


import br.ufscar.dc.dsw.domain.*;

@SpringBootApplication
public class SistemaT2Application {
	
//	private static final Logger log = LoggerFactory.getLogger(SistemaT2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SistemaT2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ICidadeDAO cidadeDAO, IHotelDAO hotelDAO, IPromoHotelDAO promoHotelDAO, ISiteReservaDAO siteReservaDAO, IUsuarioDAO dao, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			Usuario u1 = new Usuario("Luis", "luis@admin.com", encoder.encode("luis"));
			//u1.setNome("Luis");
			//u1.setLogin("luis@admin.com");
			//u1.setSenha(encoder.encode("luis"));
			//u1.setRole("ROLE_USER");
			//u1.setEnabled(true);
			dao.save(u1);
			
			Usuario u2 = new Usuario("Rennes","rennes@admin.com", encoder.encode("rennes")) ;
			//u1.setNome("Rennes");
			//u2.setLogin("rennes@admin.com");
			//u2.setSenha(encoder.encode("rennes"));
			//u2.setRole("ROLE_ADMIN");
			//u2.setEnabled(true);
			dao.save(u2);		
			
			Cidade cidade1 = new Cidade("São Carlos");
			Cidade cidade2 = new Cidade("São Paulo");
			Cidade cidade3 = new Cidade("Uberaba");
			
			cidadeDAO.save(cidade1);			
			cidadeDAO.save(cidade2);			
			cidadeDAO.save(cidade3);
			
//			Set<Cidade> set1cidade = new HashSet<Cidade>();
//			Set<Cidade> set2cidade = new HashSet<Cidade>();
//			Set<Cidade> set3cidade = new HashSet<Cidade>();
			
//			set1cidade.add(cidade1); //Adiciona São Carlos a set1cidade.
//			
//			
//			set2cidade.add(cidade1);  //Adiciona São Carlos ao objeto.
//			set2cidade.add(cidade2); //Adiciona São Paulo a setcidade2
//			
//			set3cidade.add(cidade1); //Adiciona São Carlos ao objeto.
//			set3cidade.add(cidade2); //Adiciona São Paulo ao objeto.
//			set3cidade.add(cidade3); //Adiciona Uberaba ao objeto.
			
			
			Hotel hotel1 = new Hotel("55.789.390/0008-99", "Hotel Boa Viagem", cidade1, "hotel1@hotel.com", encoder.encode("hotel1"));
			Hotel hotel2 = new Hotel("71.150.470/0001-40", "Hotel Bela Vista", cidade2, "hotel2@hotel.com", encoder.encode("hotel2"));
			Hotel hotel3 = new Hotel("32.106.536/0001-82", "Hotel Bienvenido", cidade3, "hotel3@hotel.com", encoder.encode("hotel3"));
			
			//log.info("Salvando hotéis");
			hotelDAO.save(hotel1); //not a transient instance  anymore - Hotel Boa Viajem está em São Carlos
			hotelDAO.save(hotel2); //not a transient instance  anymore - Hotel Bela Vista está em São Paulo. 
			hotelDAO.save(hotel3); //not a transient instance  anymore - Hotel Bienvenido está em Uberaba.
			
			Set<Hotel> set1hotel = new HashSet<Hotel>();
			set1hotel.add(hotel1);

			Set<Hotel> set2hotel = new HashSet<Hotel>();
			set2hotel.add(hotel2);
			
			Set<Hotel> set3hotel = new HashSet<Hotel>();
			set3hotel.add(hotel3);
			
			//Não funciona (usar método setCidade da classe cidade antes):
//			cidade1.addHotelDaCidade(hotel3);
//			cidadeDAO.save(cidade1);
//			cidade2.addHotelDaCidade(hotel3);
//			cidadeDAO.save(cidade2);
//			cidade3.addHotelDaCidade(hotel3);
//			cidadeDAO.save(cidade3); 
//			São Carlos, São Paulo e Uberaba agora contém o Hotel Bienvenido.
			
			
			//Re-Inicializa o atributo hotelDaCidade dos objetos que representam as cidades com os objetos do tipo Set <hotel>:
			
			cidade1.setHotelDaCidade(set1hotel); //Insere set1hotel no objeto chamadado cidade1 (persistir).
			cidadeDAO.save(cidade1); //not a transient instance  anymore
			//São Carlos agora contém o Hotel Bienvenido.
			
			cidade2.setHotelDaCidade(set2hotel); //Insere set2hotel no objeto chamdado cidade2 (persistir).
			cidadeDAO.save(cidade2); //not a transient instance  anymore
			//São Paulo  agora contém o Hotel Bela Vista.
			 
			cidade3.setHotelDaCidade(set3hotel); //Insere set3hotel no objeto chamdado cidade3 (persistir).
			cidadeDAO.save(cidade3); //not a transient instance  anymore
			//Uberaba agora contém o Hotel Bienvenido.
			
			hotel1.setCidade(cidade1); //
			hotelDAO.save(hotel1); //Atualiza bd (localização do Hotel Boa Viagem atualizada pra São Carlos.
			
			hotel2.setCidade(cidade2);
			hotelDAO.save(hotel2);//atualiza bd (localização do Hotel Bela Vista atualizada pra São Paulo.
			
			hotel3.setCidade(cidade3);
			hotelDAO.save(hotel3);//atualiza bd (localização do Hotel Bienvenido Uberaba).

			
//			//Dúvida não testada: listpromoTeste não pode ser vazia para invocar o método addPromocoesDoHotel da classe siteReserva.
//			//Invocar o método setPromocoesDoHotel da classe siteReserva antes?

	
			SiteReserva sitereserva1 =  new SiteReserva("www.sitereservabrasil.com", "Reserva Brasil'", "(16)1234-5678", "site1@siteres.com", encoder.encode("site1"));
			SiteReserva sitereserva2 =  new SiteReserva("www.siteboareserva.com", "Boa Reserva", "(16)1234-5688", "site2@siteres.com", encoder.encode("site2"));
			SiteReserva sitereserva3 =  new SiteReserva("www.sitebelareserva.com", "Bela Reserva", "(16)1234-5699", "site3@siteres.com", encoder.encode("site3"));

//			log.info("Salvando Site");
			siteReservaDAO.save(sitereserva1);
			siteReservaDAO.save(sitereserva2);
			siteReservaDAO.save(sitereserva3);


			PromoHotel promoHotel1 = new PromoHotel(BigDecimal.valueOf(220.5), "2020-11-11", "2020-12-11", hotel1, sitereserva1);
			PromoHotel promoHotel2 = new PromoHotel(BigDecimal.valueOf(430.5), "2020-11-11", "2020-12-11", hotel2, sitereserva2);
			PromoHotel promoHotel3 = new PromoHotel(BigDecimal.valueOf(355.5), "2020-11-11", "2020-12-11", hotel3, sitereserva3);

//			log.info("Salvando Promoção");
			promoHotelDAO.save(promoHotel1);
			promoHotelDAO.save(promoHotel2);
			promoHotelDAO.save(promoHotel3);

			List<PromoHotel> set1promoHotel1 = new ArrayList<PromoHotel>();
			List<PromoHotel> set2promoHotel2 = new ArrayList<PromoHotel>();
			List<PromoHotel> set3promoHotel3 = new ArrayList<PromoHotel>();
			
			set1promoHotel1.add(promoHotel1);
			set2promoHotel2.add(promoHotel2);
			set3promoHotel3.add(promoHotel3);

			
			//Não testado:
//			sitereserva1.addPromocoesDoHotel(promoHotel1);
//			sitereserva2.addPromocoesDoHotel(promoHotel2);
//			sitereserva3.addPromocoesDoHotel(promoHotel3);
			
			
			sitereserva1.setPromocoesDoHotel(set1promoHotel1);
			sitereserva2.setPromocoesDoHotel(set2promoHotel2);
			sitereserva3.setPromocoesDoHotel(set3promoHotel3);
			
//			log.info("Atualizando Promoção");
			promoHotelDAO.save(promoHotel1);
			promoHotelDAO.save(promoHotel2);
			promoHotelDAO.save(promoHotel3);
		};
	}
}
