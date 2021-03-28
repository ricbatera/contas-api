package br.com.rdrtech.contas.domain.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class ContaBancariaDTO {
	private Long id;
	private String numeroCartao;
	private String nomeCartao;
	private OffsetDateTime vencimento;
	private int diaVencimento;
}
