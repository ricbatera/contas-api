package br.com.rdrtech.contas.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rdrtech.contas.domain.service.OperacoesSaidasService;

@CrossOrigin
@RestController
@RequestMapping("/operacoes-saida")
public class OperacoesSaidasController {
	
	@Autowired
	private OperacoesSaidasService operacoes;
	
	@PutMapping("/{id}")
	public String pagarConta() {
		operacoes.pagarConta();
		return "Feito";
	}

}
