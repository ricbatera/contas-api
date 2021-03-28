package br.com.rdrtech.contas.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.dto.EntradaSaidaDTO;
import br.com.rdrtech.contas.domain.exceptions.NegocioException;
import br.com.rdrtech.contas.domain.mapper.MapperConfig;
import br.com.rdrtech.contas.domain.model.EntradaSaida;
import br.com.rdrtech.contas.domain.repository.EntradaSaidaRepository;
import br.com.rdrtech.contas.domain.request.EntradaSaidaRequest;

@Service
public class EntradaSaidaService {
	@Autowired
	private EntradaSaidaRepository repo;
	@Autowired
	private MapperConfig mapper;
	
	public List<EntradaSaidaDTO> listarTodos(){
		List<EntradaSaida> listagem = repo.findAll();
		List<EntradaSaidaDTO> listaRetorno = listagem.stream()
				.map(item -> toDTO(item))
				.collect(Collectors.toList());
		return listaRetorno;
	}
	
	public EntradaSaidaDTO salvar(EntradaSaidaRequest novo) {
		Optional<EntradaSaida> recebido = repo.findByNome(novo.getNome());
		if(recebido.isPresent()) {
			throw new NegocioException("Esse tipo já existe!");
		}
			EntradaSaida novaEntrada = repo.save(toModel(novo));
			return toDTO(novaEntrada);
	}
	
	private EntradaSaidaDTO toDTO(EntradaSaida r) {
		return mapper.modelMapper().map(r, EntradaSaidaDTO.class);
	}

	private EntradaSaida toModel(EntradaSaidaRequest rq) {
		return mapper.modelMapper().map(rq, EntradaSaida.class);
	}

}
