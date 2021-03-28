package br.com.rdrtech.contas.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.dto.RecursoEntradaSaidaDTO;
import br.com.rdrtech.contas.domain.exceptions.NegocioException;
import br.com.rdrtech.contas.domain.mapper.MapperConfig;
import br.com.rdrtech.contas.domain.model.EntradaSaida;
import br.com.rdrtech.contas.domain.model.RecursoEntradaSaida;
import br.com.rdrtech.contas.domain.repository.EntradaSaidaRepository;
import br.com.rdrtech.contas.domain.repository.RecursoEntradaSaidaRepository;
import br.com.rdrtech.contas.domain.request.RecursoEntradaSaidaRequest;

@Service
public class RecursoEntradaSaidaService {
	@Autowired
	private RecursoEntradaSaidaRepository repo;
	
	@Autowired
	private EntradaSaidaRepository repoEntradaSaida;
	
	@Autowired
	private MapperConfig mapper;

	public RecursoEntradaSaidaDTO salvar(RecursoEntradaSaidaRequest rq) {
		EntradaSaida es = repoEntradaSaida.findById(rq.getEntradaSaida().getId())
				.orElseThrow(()-> new NegocioException("Não existe o tipo de Entrada/Saida cadastrado"));
		RecursoEntradaSaida recebida = toModel(rq);
		RecursoEntradaSaida consulta = repo.findByDescricao(recebida.getDescricao());
		if(recebida.equals(consulta)) {
			throw new NegocioException("Já existe um cartao cadastrado com esse número");
		}
		recebida.setEntradaSaida(es);
		RecursoEntradaSaida rSalvo = repo.save(recebida); 
		return toDTO(rSalvo);
	}
	
	private RecursoEntradaSaidaDTO toDTO(RecursoEntradaSaida r) {
		return mapper.modelMapper().map(r, RecursoEntradaSaidaDTO.class);
	}

	private RecursoEntradaSaida toModel(RecursoEntradaSaidaRequest rq) {
		return mapper.modelMapper().map(rq, RecursoEntradaSaida.class);
	}

	public List<RecursoEntradaSaidaDTO> listarTodos(){
		List<RecursoEntradaSaida> listagem = repo.findAll();
		List<RecursoEntradaSaidaDTO> listaRetorno = listagem.stream()
				.map(item -> toDTO(item))
				.collect(Collectors.toList());
		return listaRetorno;
	}

}
