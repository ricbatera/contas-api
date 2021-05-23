package br.com.rdrtech.contas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rdrtech.contas.domain.model.Saida;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long> {
	public List<Saida> findByRecursoEntradaSaidaId(Long id);
	
}
