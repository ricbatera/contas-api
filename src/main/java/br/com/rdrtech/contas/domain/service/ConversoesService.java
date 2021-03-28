package br.com.rdrtech.contas.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class ConversoesService {
	
	public LocalDate somaMeses(LocalDate dataInicial, int meses) {
		String dataParaString = dataInicial.toString();
		String [] arrayVencimento = dataParaString.split("-");
		Integer ano = Integer.valueOf(arrayVencimento[0]);
		Integer mes = Integer.valueOf(arrayVencimento[1])-1;
		Integer dia = Integer.valueOf(arrayVencimento[2]);
		Calendar dataCalendar = Calendar.getInstance();		
		dataCalendar.set(Calendar.DAY_OF_MONTH, dia);
		dataCalendar.set(Calendar.MONTH, mes);
		dataCalendar.set(Calendar.YEAR, ano);
		int mesParaSetar = dataCalendar.get(Calendar.MONTH) + meses;
		dataCalendar.set(Calendar.MONTH, mesParaSetar);
		LocalDate dataRetorno = LocalDateTime.ofInstant(dataCalendar.toInstant(), dataCalendar.getTimeZone().toZoneId()).toLocalDate();
		return dataRetorno;
	}

}
