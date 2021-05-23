package br.com.rdrtech.contas.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.model.Parcela;
import br.com.rdrtech.contas.domain.model.Saida;
import br.com.rdrtech.contas.domain.repository.ParcelaRepository;
import br.com.rdrtech.contas.domain.repository.SaidaRepository;

@Service
public class ParcelaService {
	@Autowired
	private ParcelaRepository repoConta;
	
	@Autowired
	private SaidaRepository repoSaida;

	public Parcela pagarParcela(Long id) {
		if (repoConta.existsById(id)) {
			Parcela existente = repoConta.findById(id).get();
			existente.setSituacao("Pago");
			return repoConta.save(existente);
		}
		return null;
	}
	
	public void pagarCartao(Long id, String data) {
		List<Saida> lista = repoSaida.findByRecursoEntradaSaidaId(id);
		lista.forEach(saida -> {
			List<Parcela> parcelas = saida.getParcelas();
			parcelas.forEach(parcela ->{
				if(parcela.getDataVenvimento().toString().equals(data)) {
					parcela.setSituacao("Pago");
				}
			});
		});
		repoSaida.saveAll(lista);
	}
	
	public void deleteAll() {
		repoConta.deleteAll();
	}
}
