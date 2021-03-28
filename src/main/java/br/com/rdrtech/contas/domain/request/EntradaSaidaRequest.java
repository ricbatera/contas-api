package br.com.rdrtech.contas.domain.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EntradaSaidaRequest {
	@NotBlank
	private String nome;

}
