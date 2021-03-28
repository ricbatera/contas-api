package br.com.rdrtech.contas.domain.request;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import br.com.rdrtech.contas.domain.model.EntradaSaida;
import lombok.Data;

@Data
public class RecursoEntradaSaidaRequest {
	private Long id;
	@NotBlank
	private String descricao;
	private String numeroCartao;
	private String nomeCartao;
	private OffsetDateTime validade;
	private int diaVencimento;
	private String banco;
	private String agencia;
	private String conta;
	private EntradaSaida entradaSaida;
}
