package br.com.rdrtech.contas.domain.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class CartaoCreditoDTO {

	private Long id;
	private String nomeCartao;
	private String numeroCartao;
	private OffsetDateTime validade;
	private Integer diaVencimento;
}
