package br.com.rdrtech.contas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rdrtech.contas.domain.model.RecursoEntradaSaida;

@Repository
public interface RecursoEntradaSaidaRepository extends JpaRepository<RecursoEntradaSaida, Long> {
	public RecursoEntradaSaida findByDescricao(String descricao);
	
}
