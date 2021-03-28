package br.com.rdrtech.contas.domain.exceptionshandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CamposInvalidos {

	private String nomeCampo;
	private String mensagemErro;
	
}
