package br.com.rdrtech.contas.domain.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class ResponsavelRequest {
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;

}
