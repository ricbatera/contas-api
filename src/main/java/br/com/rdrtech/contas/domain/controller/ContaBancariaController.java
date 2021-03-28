package br.com.rdrtech.contas.domain.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rdrtech.contas.domain.dto.ContaBancariaDTO;
import br.com.rdrtech.contas.domain.request.ContaBancariaRequest;
import br.com.rdrtech.contas.domain.service.ContaBancariaService;

@CrossOrigin
@RestController
@RequestMapping("/contas-bancarias")
public class ContaBancariaController {

	@Autowired
	private ContaBancariaService repoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaBancariaDTO salvar(@Valid @RequestBody ContaBancariaRequest rq) {
		return repoService.salvar(rq);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContaBancariaDTO> alterar(@Valid @PathVariable Long id, @RequestBody ContaBancariaRequest r) {
		if (repoService.alterar(id, r) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repoService.alterar(id, r));
	}

	@GetMapping("/{id}")
	public ContaBancariaDTO buscarPorId(@PathVariable Long id) {
		return repoService.buscarPorId(id);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarContaBancaria(@PathVariable Long id) {
		repoService.deletarContaBancaria(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/listar")
	public List<ContaBancariaDTO> listarTodos(){
		return repoService.listarTodos();
	}

}
