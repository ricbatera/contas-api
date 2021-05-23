package br.com.rdrtech.contas.domain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rdrtech.contas.domain.service.ParcelaService;

@CrossOrigin
@RestController
@RequestMapping("/parcelas")
public class ParcelaController {

	@Autowired
	private ParcelaService repoService;
	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@Valid @PathVariable Long id) {
		if (repoService.pagarParcela(id) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/pagar-cartao/{id}/{data}")
	public ResponseEntity<?> pagarCartao(@PathVariable Long id, @PathVariable String data ){
		repoService.pagarCartao(id, data);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?>delete(){
		repoService.deleteAll();
		return ResponseEntity.noContent().build();
	}

}
