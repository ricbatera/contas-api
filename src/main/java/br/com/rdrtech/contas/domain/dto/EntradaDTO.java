package br.com.rdrtech.contas.domain.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EntradaDTO {
	private Integer id;
	private LocalDate dataEntrada;
	private String descricao;
	private String pagador;
	private Double valor;
	private Boolean recebido;
}
