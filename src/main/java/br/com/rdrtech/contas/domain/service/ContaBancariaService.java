package br.com.rdrtech.contas.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.dto.ContaBancariaDTO;
import br.com.rdrtech.contas.domain.exceptions.NegocioException;
import br.com.rdrtech.contas.domain.mapper.MapperConfig;
import br.com.rdrtech.contas.domain.model.ContaBancaria;
import br.com.rdrtech.contas.domain.repository.ContaBancariaRepository;
import br.com.rdrtech.contas.domain.request.ContaBancariaRequest;

@Service
public class ContaBancariaService {
	@Autowired
	private ContaBancariaRepository repoConta;

	@Autowired
	private MapperConfig mapper;

	public ContaBancariaDTO salvar(ContaBancariaRequest rq) {
		ContaBancaria recebida = toModel(rq);
		ContaBancaria consulta = repoConta.findByConta(rq.getConta());
		if(recebida.equals(consulta)) {
			throw new NegocioException("Já existe essa conta cadastrada com esse número");
		}
		ContaBancaria rSalvo = repoConta.save(recebida); 
		return toDTO(rSalvo);
	}

	public ContaBancariaDTO alterar(Long id, ContaBancariaRequest rq) {
		if (repoConta.existsById(id)) {
			ContaBancaria existente = repoConta.findById(id).get();
			ContaBancaria recebido = toModel(rq);
			BeanUtils.copyProperties(recebido, existente, "id");
			return toDTO(repoConta.save(existente));
		}
		return null;
	}

	public ContaBancariaDTO buscarPorId(Long id) {
		return toDTO(repoConta.findById(id).orElseThrow(() -> new NegocioException("Responsável não existe!")));
	}
	

	public void deletarContaBancaria(Long id) {
		Optional<ContaBancaria> r = repoConta.findById(id);
		if(r.isPresent()) {
			repoConta.deleteById(id);
		}else {
			r.orElseThrow(()-> new NegocioException("Responsável não existe"));
		}
	}

	public List<ContaBancariaDTO> listarTodos(){
		List<ContaBancaria> responsaveis = repoConta.findAll();
		List<ContaBancariaDTO> listaResposta =  responsaveis.stream()
		.map(resp -> toDTO(resp))
		.collect(Collectors.toList());
		return listaResposta;
	}
	
	private ContaBancariaDTO toDTO(ContaBancaria r) {
		return mapper.modelMapper().map(r, ContaBancariaDTO.class);
	}

	private ContaBancaria toModel(ContaBancariaRequest rq) {
		return mapper.modelMapper().map(rq, ContaBancaria.class);
	}

}
