package br.com.rdrtech.contas.domain.exceptionshandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
@Data
@JsonInclude(Include.NON_NULL)
public class Problema {

	private Integer codErro;
	private String mensagem;
	private OffsetDateTime dataHora;
	private List<CamposInvalidos> camposInvalidos;
}
