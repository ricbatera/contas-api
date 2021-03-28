package br.com.rdrtech.contas.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.dto.EntradaDTO;
import br.com.rdrtech.contas.domain.mapper.MapperConfig;
import br.com.rdrtech.contas.domain.model.Entrada;
import br.com.rdrtech.contas.domain.repository.EntradaReository;
import br.com.rdrtech.contas.domain.request.EntradaRequest;

@Service
public class EntradaService {
	@Autowired
	private EntradaReository repo;
	@Autowired
	private ConversoesService conversoes;

	@Autowired
	private MapperConfig mapper;

	public List<EntradaDTO> salvar(EntradaRequest rq) {
		List<Entrada>entradas = new ArrayList<>();
		for (int i = 0; i < rq.getRecorrencia(); i++) {
			Entrada recebida = toModel(rq);
			LocalDate teste = conversoes.somaMeses(recebida.getDataEntrada(), i);
			System.out.println(teste);
			recebida.setDataEntrada(teste);
			entradas.add(recebida);			
		}
		repo.saveAll(entradas);
		
		return entradas.stream()
				.map(entrada -> toDTO(entrada))
				.collect(Collectors.toList());
	}
	

	public List<EntradaDTO> listarTodos(){
		List<Entrada> responsaveis = repo.findAll();
		List<EntradaDTO> listaResposta =  responsaveis.stream()
		.map(resp -> toDTO(resp))
		.collect(Collectors.toList());
		return listaResposta;
	}
	
	private EntradaDTO toDTO(Entrada r) {
		return mapper.modelMapper().map(r, EntradaDTO.class);
	}

	private Entrada toModel(EntradaRequest rq) {
		return mapper.modelMapper().map(rq, Entrada.class);
	}

}
