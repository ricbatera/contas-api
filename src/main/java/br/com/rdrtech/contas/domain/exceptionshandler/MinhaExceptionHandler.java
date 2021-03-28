package br.com.rdrtech.contas.domain.exceptionshandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.rdrtech.contas.domain.exceptions.NegocioException;

@ControllerAdvice // essa anotação redireciona para cá todas as Exceptions de validação dos controllers
public class MinhaExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NegocioException.class) // anotação para interceptar nossas próprias exceptions
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Problema problema = new Problema();
		problema.setCodErro(status.value());
		problema.setDataHora(OffsetDateTime.now());
		problema.setMensagem(ex.getMessage());
		
		return super.handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<CamposInvalidos> camposInvalidos = new ArrayList<>();
		
		for(ObjectError erro: ex.getAllErrors()){
			String mensagem = erro.getDefaultMessage();
			String nome = ((FieldError) erro).getField();
			camposInvalidos.add(new CamposInvalidos(nome, mensagem));
		}
		
		Problema problema = new Problema();
		problema.setDataHora(OffsetDateTime.now());
		problema.setCodErro(status.value());
		problema.setMensagem("Um ou mais campos estão inválidos.");
		problema.setCamposInvalidos(camposInvalidos);
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
	
}
