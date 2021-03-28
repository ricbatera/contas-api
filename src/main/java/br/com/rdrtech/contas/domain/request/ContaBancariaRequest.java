package br.com.rdrtech.contas.domain.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class ContaBancariaRequest {
	@NotBlank
	private String banco;
	@NotBlank
	private String agencia;
	@NotBlank
	private String conta;

}
