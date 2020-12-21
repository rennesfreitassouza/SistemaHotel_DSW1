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
			//Set<Hotel> sethotelTeste = new HashSet<Hotel>(); teste de chamaada de nétodo addHotelDaCidade inválido.
			
			//log.info("Salvando Cidade sao carlso sem nenhum hotel");
			Cidade cidade = new Cidade("São Carlos");
			Cidade c2 = new Cidade("Ibaté");
			cidadeDAO.save(cidade);			
			cidadeDAO.save(c2);			
			
			Set<Cidade> setcidade = new HashSet<Cidade>();
			Set<Cidade> set2cidade = new HashSet<Cidade>();
			
			setcidade.add(cidade); 
			setcidade.add(c2); 			
			
			set2cidade.add(cidade);
			
			Hotel hotel = new Hotel("CNPJCNPJCNPJ", "nOMEHotel1", setcidade, "email@email.com", "senha");
			Hotel hotel2 = new Hotel("CNPJ2CNPJ2", "nOMEHotel2", set2cidade, "email2@email.com", "senha2");
			
			//log.info("Salvando hotéis");
			hotelDAO.save(hotel); //not a transient instance  anymore
			hotelDAO.save(hotel2); //not a transient instance  anymore
			
			Set<Hotel> sethotel = new HashSet<Hotel>();
			sethotel.add(hotel); // nomeHotel1
			
			//Adicona hotel aos dois objetos cidade que representam São Carlos e Ibaté.
			cidade.addHotelDaCidade(hotel);
			cidadeDAO.save(cidade);
			c2.addHotelDaCidade(hotel);
			cidadeDAO.save(c2); 
//			//nomeHotel1 está nas cidades de São Carlos e Ibaté. (persistir)
//			
			
			for (Cidade c : setcidade) {
			    c.setHotelDaCidade(sethotel); //add sethotel noX objetoX de cada cidade. (persistir)
			    cidadeDAO.save(c); //not a transient instance  anymore
			} 
			
			//Adicona hotel2 ao objeto cidade que representa São Carlos.
			for (Cidade c : set2cidade) {
			    c.addHotelDaCidade(hotel2); //Insere hotel2 no objeto cidade (persistir)
			    cidadeDAO.save(c); //not a transient instance  anymore
			} //nomeHotel2 está na cidade de São Carlos.
			
			
			//adicona os objetos cidades, com o atributo hotel atualizado, no objeto hotel.
			hotel.addCidade(cidade); //
			hotel.addCidade(c2); //
			hotelDAO.save(hotel);//atualiza bd (localização do nomeHotel1 atualizada pra São Carlos e Ibaté)
			
			//adicona o objeto nomeado cidade, com o atributo hotel atualizado, no objeto hotel2.
			hotel2.addCidade(cidade); //
			hotelDAO.save(hotel2);//atualiza bd (localização do nomeHotel2 atualizada pra São Carlos.
			
//			//R3:
//			//log.info("Listagem de todos os hotéis:");
//			List<Hotel> listaHoteis = hotelDAO.findAll();
//			for (Hotel hotelx : listaHoteis) {
//				//log.info("hotelDAO.findAll() = "+hotelx.getNome());// 
//			}
//			
//			//R4:
//			listaHoteis = hotelDAO.findByCidades(cidade); //Procura por hoteis na cidade de São carlos.			
//			for (Hotel hotelx : listaHoteis) {
//				//log.info("cidadeDAO.findByCidades(cidade) = "+hotelx.getNome());// retorna o hotel do objeto cidade passada como
//																				// parâmetro para cidadeDAO.findByCidades.
//			}
//			
//			List<Cidade> listacidades = cidadeDAO.findAll();
//			for (Cidade cidadex : listacidades) {
//				//log.info("cidadeDAO.findAll() = "+cidadex.getCidade());
//			}
//			List<PromoHotel> listpromoTeste = new ArrayList<PromoHotel>(); 
//			SiteReserva sitereserva =  new SiteReserva("www", "nome", "tel", "e-mail", "senha", listpromoTeste);
//			//Dúvida não testada: listpromoTeste não pode ser vazia para invocar o método addPromocoesDoHotel da classe siteReserva.
//			//Invocar o método setPromocoesDoHotel da classe siteReserva antes?
//			log.info("Salvando Site");
//			siteReservaDAO.save(sitereserva);
//			
//			log.info("Salvando Promoção");
//			PromoHotel promoHotel = new PromoHotel(1, "111", "222", hotel, sitereserva);
//			promoHotelDAO.save(promoHotel);
//
//			
//			
		};
	}
}
