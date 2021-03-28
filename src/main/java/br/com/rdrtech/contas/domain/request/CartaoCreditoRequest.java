package br.com.rdrtech.contas.domain.request;

import java.time.OffsetDateTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class CartaoCreditoRequest {
	@NotBlank
	private String numeroCartao;
	@NotBlank
	private String nomeCartao;
	@NotNull
	private OffsetDateTime validade;
	@NotNull
	private Integer diaVencimento;

}
