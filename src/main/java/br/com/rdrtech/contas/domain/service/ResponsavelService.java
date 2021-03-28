package br.com.rdrtech.contas.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.dto.ResponsavelDTO;
import br.com.rdrtech.contas.domain.enuns.StatusResponsavel;
import br.com.rdrtech.contas.domain.exceptions.NegocioException;
import br.com.rdrtech.contas.domain.mapper.MapperConfig;
import br.com.rdrtech.contas.domain.model.Responsavel;
import br.com.rdrtech.contas.domain.repository.ResponsavelRepository;
import br.com.rdrtech.contas.domain.request.ResponsavelRequest;

@Service
public class ResponsavelService {
	@Autowired
	private ResponsavelRepository repoResp;

	@Autowired
	private MapperConfig mapper;

	public ResponsavelDTO salvar(ResponsavelRequest rq) {
		Responsavel r = toModel(rq);
		r.setDataCadastro(OffsetDateTime.now());
		r.setStatus(StatusResponsavel.ATIVO);
		Responsavel rSalvo = repoResp.save(r);
		return toDTO(rSalvo);
	}

	public ResponsavelDTO alterar(Long id, ResponsavelRequest rq) {
		if (repoResp.existsById(id)) {
			Responsavel existente = repoResp.findById(id).get();
			Responsavel recebido = toModel(rq);
			BeanUtils.copyProperties(recebido, existente, "id", "dataCadastro", "status");
			return toDTO(repoResp.save(existente));
		}
		return null;
	}

	public ResponsavelDTO buscarPorId(Long id) {
		return toDTO(repoResp.findById(id).orElseThrow(() -> new NegocioException("Responsável não existe!")));
	}

	public ResponsavelDTO inativar(Long id) {
		Optional<Responsavel> r = repoResp.findById(id);
		if (r.isPresent()) {
			Responsavel resp = r.get();
			resp.setStatus(StatusResponsavel.INATIVO);
			return toDTO(repoResp.save(resp));
		}
		return toDTO(r.orElseThrow(() -> new NegocioException("Responsável não existe!")));

	}

	public void deletarResponsavel(Long id) {
		Optional<Responsavel> r = repoResp.findById(id);
		if(r.isPresent()) {
			repoResp.deleteById(id);
		}else {
			r.orElseThrow(()-> new NegocioException("Responsável não existe"));
		}
	}

	public List<ResponsavelDTO> listarTodos(){
		List<Responsavel> responsaveis = repoResp.findAll();
		List<ResponsavelDTO> listaResposta =  responsaveis.stream()
		.map(resp -> toDTO(resp))
		.collect(Collectors.toList());
		return listaResposta;
	}
	
	private ResponsavelDTO toDTO(Responsavel r) {
		return mapper.modelMapper().map(r, ResponsavelDTO.class);
	}

	private Responsavel toModel(ResponsavelRequest rq) {
		return mapper.modelMapper().map(rq, Responsavel.class);
	}

}
