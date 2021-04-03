package br.com.rdrtech.contas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.model.Parcela;
import br.com.rdrtech.contas.domain.repository.ParcelaRepository;

@Service
public class ParcelaService {
	@Autowired
	private ParcelaRepository repoConta;

	public Parcela pagarParcela(Long id) {
		if (repoConta.existsById(id)) {
			Parcela existente = repoConta.findById(id).get();
			existente.setSituacao("Pago");
			return repoConta.save(existente);
		}
		return null;
	}
	
	public void deleteAll() {
		repoConta.deleteAll();
	}
}
