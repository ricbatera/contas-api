package br.com.rdrtech.contas.domain.dto;

import java.time.OffsetDateTime;

import br.com.rdrtech.contas.domain.enuns.StatusResponsavel;
import lombok.Data;

@Data
public class ResponsavelDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private OffsetDateTime dataCadastro;
	private StatusResponsavel status;
}
