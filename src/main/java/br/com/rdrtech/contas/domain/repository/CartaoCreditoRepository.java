package br.com.rdrtech.contas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rdrtech.contas.domain.model.CartaoCredito;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {

	public CartaoCredito findByNumeroCartao(String conta);
	
}
