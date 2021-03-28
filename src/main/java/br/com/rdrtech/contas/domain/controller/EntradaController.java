package br.com.rdrtech.contas.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rdrtech.contas.domain.dto.EntradaDTO;
import br.com.rdrtech.contas.domain.request.EntradaRequest;
import br.com.rdrtech.contas.domain.service.EntradaService;

@CrossOrigin
@RestController
@RequestMapping("/entradas")
public class EntradaController {

	@Autowired
	private EntradaService repoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<EntradaDTO> salvar(@Valid @RequestBody EntradaRequest rq) {
		return repoService.salvar(rq);
	}
	@GetMapping("/listar")
	public List<EntradaDTO> listarTodos(){
		return repoService.listarTodos();
	}

}
