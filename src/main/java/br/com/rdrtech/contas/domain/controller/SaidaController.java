package br.com.rdrtech.contas.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rdrtech.contas.domain.dto.SaidaDTO;
import br.com.rdrtech.contas.domain.model.Saida;
import br.com.rdrtech.contas.domain.request.SaidaRequest;
import br.com.rdrtech.contas.domain.service.SaidaService;

@CrossOrigin
@RestController
@RequestMapping("/saidas")
public class SaidaController {
	
	@Autowired
	private SaidaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SaidaDTO salvar(@Valid @RequestBody SaidaRequest sr) {
		return service.salvar(sr);		
	}
	
	@GetMapping
	public List<Saida> listar(){
		return service.listar();
	}
	
	@DeleteMapping
	public ResponseEntity<?>delete(){
		service.deleteAll();
		return ResponseEntity.noContent().build();
	}
}
