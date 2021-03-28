package br.com.rdrtech.contas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rdrtech.contas.domain.model.Parcela;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Long> {

	
}
