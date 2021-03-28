package br.com.rdrtech.contas.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rdrtech.contas.domain.dto.EntradaSaidaDTO;
import br.com.rdrtech.contas.domain.request.EntradaSaidaRequest;
import br.com.rdrtech.contas.domain.service.EntradaSaidaService;

@CrossOrigin
@RestController
@RequestMapping("/entradas-saidas")
public class EntradaSaidaController {
	@Autowired
	private EntradaSaidaService service;
	
	@GetMapping("/listar")
	public List<EntradaSaidaDTO> listar(){
		return service.listarTodos();
	}
	
	@PostMapping
	public EntradaSaidaDTO salvar(@Valid @RequestBody EntradaSaidaRequest novo) {
		return service.salvar(novo);
	}

}
