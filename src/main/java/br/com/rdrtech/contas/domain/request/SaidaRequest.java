package br.com.rdrtech.contas.domain.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import br.com.rdrtech.contas.domain.model.RecursoEntradaSaida;
import br.com.rdrtech.contas.domain.model.Responsavel;
import lombok.Data;
@Data
public class SaidaRequest {
	
	@NotBlank
	private String descricao;
	@DateTimeFormat
	private LocalDate dataCompra;
	@DateTimeFormat
	private LocalDate dataVencimento;
	private Boolean parcelada;
	@NotNull
	private Double valorTotal;
	@NotNull
	private Integer numParcelas;
	@NotBlank
	private String situacao;
	private Responsavel responsavel;
	private RecursoEntradaSaida recursoEntradaSaida;

}
