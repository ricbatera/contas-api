package br.com.rdrtech.contas.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rdrtech.contas.domain.model.EntradaSaida;

@Repository
public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long> {
	public Optional<EntradaSaida> findByNome(String nome);
	
}
