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

import br.com.rdrtech.contas.domain.dto.RecursoEntradaSaidaDTO;
import br.com.rdrtech.contas.domain.request.RecursoEntradaSaidaRequest;
import br.com.rdrtech.contas.domain.service.RecursoEntradaSaidaService;

@CrossOrigin
@RestController
@RequestMapping("/recursos-entrada-saida")
public class RecursoEntradaSaidaController {
	
	@Autowired
	private RecursoEntradaSaidaService repoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RecursoEntradaSaidaDTO salvar(@Valid @RequestBody RecursoEntradaSaidaRequest rq) {
		return repoService.salvar(rq);
	}
	
	@GetMapping("/listar")
	public List<RecursoEntradaSaidaDTO> listar(){
		return repoService.listarTodos();
	}

}
