package br.com.rdrtech.contas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rdrtech.contas.domain.model.ContaBancaria;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

	public ContaBancaria findByConta(String conta);
	
}
