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

import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.service.spec.ISiteReservaService;

@CrossOrigin
@RestController
public class SiteReservaRestController {
	
	@Autowired
	private ISiteReservaService service;
	
	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	private void parse(SiteReserva siteReserva, JSONObject json) {
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				siteReserva.setId(((Integer) id).longValue());
			} else {
				siteReserva.setId((Long) id);
			}
		}
		
		siteReserva.setNome((String) json.get("nome"));
		siteReserva.setEmail((String) json.get("login"));
		siteReserva.setSenha((String) json.get("senha"));
		siteReserva.setUrl((String) json.get("url"));
		siteReserva.setTelefone((String) json.get("telefone"));
	}
	
	@GetMapping(path = "/siterest") //https://youtu.be/BsBwd5lh-8c?t=378
	public ResponseEntity<List<SiteReserva>> lista() {
		List<SiteReserva> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista); // Devolve uma lista de sites
	}
	
	@GetMapping(path = "/siterest/{id}") // Retorno Ok
	public ResponseEntity<SiteReserva> lista(@PathVariable("id") long id){
		SiteReserva siteReserva = service.buscarPorId(id);
		if (siteReserva == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(siteReserva);
	}
	
	@PostMapping(path = "/siterest")
	@ResponseBody
	public ResponseEntity<SiteReserva> cria(@RequestBody JSONObject json) {

		try {
			if (isJSONValid(json.toString())) {
				SiteReserva siteReserva = new SiteReserva();
				parse(siteReserva, json);
				service.salvar(siteReserva);
				return ResponseEntity.ok(siteReserva);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		}catch (Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@PutMapping(path = "/siterest/{id}")
	public ResponseEntity<SiteReserva> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json)  {

		try {
			if (isJSONValid(json.toString())) {
				SiteReserva siteReserva = service.buscarPorId(id);
				if (siteReserva == null) {
					return ResponseEntity.notFound().build();
				}else {
					parse(siteReserva, json);
					service.salvar(siteReserva);
					return ResponseEntity.ok(siteReserva);
				}
			}	
			else {
					return ResponseEntity.badRequest().body(null);
				}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}		
	}
	
	@DeleteMapping(path = "/siterest/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {
		SiteReserva siteReserva = service.buscarPorId(id);
		if (siteReserva == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
}