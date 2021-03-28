package br.com.rdrtech.contas.domain.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.rdrtech.contas.domain.model.Parcela;
import br.com.rdrtech.contas.domain.model.RecursoEntradaSaida;
import br.com.rdrtech.contas.domain.model.Responsavel;
import lombok.Data;

@Data
public class SaidaDTO {
	
	private Long id;	
	private String descricao;
	@DateTimeFormat
	private LocalDate dataCompra;
	private Boolean parcelada;
	private Double valorTotal;
	private Responsavel responsavel;
	private RecursoEntradaSaida recursoEntradaSaida;
	private List<Parcela> parcelas;

}
