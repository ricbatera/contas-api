package br.com.rdrtech.contas.domain.dto;

import java.time.OffsetDateTime;

import br.com.rdrtech.contas.domain.model.EntradaSaida;
import lombok.Data;

@Data
public class RecursoEntradaSaidaDTO {
	private Long id;
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
