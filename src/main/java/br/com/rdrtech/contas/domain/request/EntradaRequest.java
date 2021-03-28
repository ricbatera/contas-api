package br.com.rdrtech.contas.domain.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EntradaRequest {
	@DateTimeFormat
	@NotNull
	private LocalDate dataEntrada;
	@NotNull
	private String descricao;
	@NotNull
	private String pagador;
	@NotNull
	private Double valor;
	@NotNull
	private Boolean recebido;
	@NotNull
	private Integer recorrencia;
	

}
