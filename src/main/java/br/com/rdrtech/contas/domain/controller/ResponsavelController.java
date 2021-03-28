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

import br.com.rdrtech.contas.domain.dto.ResponsavelDTO;
import br.com.rdrtech.contas.domain.request.ResponsavelRequest;
import br.com.rdrtech.contas.domain.service.ResponsavelService;

@CrossOrigin
@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

	@Autowired
	private ResponsavelService repoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponsavelDTO salvar(@Valid @RequestBody ResponsavelRequest rq) {
		return repoService.salvar(rq);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponsavelDTO> alterar(@Valid @PathVariable Long id, @RequestBody ResponsavelRequest r) {
		if (repoService.alterar(id, r) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(repoService.alterar(id, r));
	}

	@GetMapping("/{id}")
	public ResponsavelDTO buscarPorId(@PathVariable Long id) {
		return repoService.buscarPorId(id);
	}

	@GetMapping("/inativar/{id}")
	public ResponsavelDTO inativar(@PathVariable Long id) {
		return repoService.inativar(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarResponsavel(@PathVariable Long id) {
		repoService.deletarResponsavel(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/listar")
	public List<ResponsavelDTO> listarTodos(){
		return repoService.listarTodos();
	}

}
