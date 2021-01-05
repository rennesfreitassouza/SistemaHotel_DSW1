package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.service.spec.ICidadeService;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@CrossOrigin
@RestController
public class HotelRestController {
	
	@Autowired
	private IHotelService serviceH;
	
	@Autowired
	private ICidadeService serviceC;
	
	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	private void parse(Hotel hotel, JSONObject json) {
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				hotel.setId(((Integer) id).longValue());
			} else {
				hotel.setId((Long) id);
			}
		}
		
		hotel.setNome((String) json.get("nome"));
		
	}
	
	@GetMapping(path = "/hoteis") //https://youtu.be/BsBwd5lh-8c?t=378
	public ResponseEntity<List<Hotel>> lista() {
		List<Hotel> lista = serviceH.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista); //Devolve uma lista de hotéis.
	}
	
	@GetMapping(path = "/hoteis/{id}") // Retorno Ok?
	public ResponseEntity<Hotel> lista(@PathVariable("id") long id){
		Hotel hotel = serviceH.buscarPorId(id);
		if (hotel == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(hotel);
	}
	
//	@GetMapping(path = "/hoteis/{nomeDaCidade}") // 
//	public ResponseEntity<List<Hotel>> lista(@PathVariable("nomeDaCidade") String nomeCidade){
//		List<Cidade> todas_Cidades = new ArrayList<Cidade>();
//		Cidade cidadeProcurada = new Cidade();
//		
//		todas_Cidades = serviceC.buscarTodas();
//		for (Cidade cidade : todas_Cidades) {
//			if(cidade.getCidade().equals(nomeCidade)) {
//				cidadeProcurada = cidade;
//				break;
//			}
//		}
//		
//		List<Hotel> lista = serviceH.buscarTodosHoteisDaCidade(cidadeProcurada);
//		if (lista.isEmpty()) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok(lista);
//	}
//	
//	@PostMapping(path = "/hoteis")
//	@ResponseBody
//	public ResponseEntity<Hotel> cria(@RequestBody JSONObject json) {
//		try {
//			if (isJSONValid(json.toString())) {
//				Hotel hotel = new Hotel();
//				parse(hotel, json);
//				serviceH.salvar(hotel);
//				return ResponseEntity.ok(hotel);
//			} else {
//				return ResponseEntity.badRequest().body(null);
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
//		}
//	}
//
//	@PutMapping(path = "/hoteis/{id}")
//	public ResponseEntity<Hotel> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json)  {
//		try {
//			if (isJSONValid(json.toString())) {
//				Hotel hotel = serviceH.buscarPorId(id);
//				if (hotel == null) {
//					return ResponseEntity.notFound().build();
//				}else {
//					parse(hotel, json);
//					serviceH.salvar(hotel);
//					return ResponseEntity.ok(hotel);
//				}
//			}	
//			else {
//					return ResponseEntity.badRequest().body(null);
//				}
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
//		}
//		
//	}
//	
//	@DeleteMapping(path = "/hoteis/{id}")
//	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {
//		Hotel hotel = serviceH.buscarPorId(id);
//		if (hotel == null) {
//			return ResponseEntity.notFound().build();
//		} else {
//			serviceH.excluir(id);
//			return ResponseEntity.noContent().build();
//		}
//	}
}
