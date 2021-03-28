package br.com.rdrtech.contas.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.dto.CartaoCreditoDTO;
import br.com.rdrtech.contas.domain.exceptions.NegocioException;
import br.com.rdrtech.contas.domain.mapper.MapperConfig;
import br.com.rdrtech.contas.domain.model.CartaoCredito;
import br.com.rdrtech.contas.domain.repository.CartaoCreditoRepository;
import br.com.rdrtech.contas.domain.request.CartaoCreditoRequest;

@Service
public class CartaoCreditoService {
	@Autowired
	private CartaoCreditoRepository repoConta;

	@Autowired
	private MapperConfig mapper;

	public CartaoCreditoDTO salvar(CartaoCreditoRequest rq) {
		CartaoCredito recebida = toModel(rq);
		CartaoCredito consulta = repoConta.findByNumeroCartao(rq.getNumeroCartao());
		if(recebida.equals(consulta)) {
			throw new NegocioException("Já existe um cartao cadastrado com esse número");
		}
		CartaoCredito rSalvo = repoConta.save(recebida); 
		return toDTO(rSalvo);
	}

	public CartaoCreditoDTO alterar(Long id, CartaoCreditoRequest rq) {
		if (repoConta.existsById(id)) {
			CartaoCredito existente = repoConta.findById(id).get();
			CartaoCredito recebido = toModel(rq);
			BeanUtils.copyProperties(recebido, existente, "id");
			return toDTO(repoConta.save(existente));
		}
		return null;
	}

	public CartaoCreditoDTO buscarPorId(Long id) {
		return toDTO(repoConta.findById(id).orElseThrow(() -> new NegocioException("Responsável não existe!")));
	}
	

	public void deletarCartaoCredito(Long id) {
		Optional<CartaoCredito> r = repoConta.findById(id);
		if(r.isPresent()) {
			repoConta.deleteById(id);
		}else {
			r.orElseThrow(()-> new NegocioException("Responsável não existe"));
		}
	}

	public List<CartaoCreditoDTO> listarTodos(){
		List<CartaoCredito> responsaveis = repoConta.findAll();
		List<CartaoCreditoDTO> listaResposta =  responsaveis.stream()
		.map(resp -> toDTO(resp))
		.collect(Collectors.toList());
		return listaResposta;
	}
	
	private CartaoCreditoDTO toDTO(CartaoCredito r) {
		return mapper.modelMapper().map(r, CartaoCreditoDTO.class);
	}

	private CartaoCredito toModel(CartaoCreditoRequest rq) {
		return mapper.modelMapper().map(rq, CartaoCredito.class);
	}

}
