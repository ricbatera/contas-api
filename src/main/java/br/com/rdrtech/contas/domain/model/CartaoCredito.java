package br.com.rdrtech.contas.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartaoCredito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String numeroCartao;
	@NotBlank
	private String nomeCartao;
	@NotNull
	private OffsetDateTime validade;
	@NotNull
	private int diaVencimento;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoCredito other = (CartaoCredito) obj;
		if (numeroCartao == null) {
			if (other.numeroCartao != null)
				return false;
		} else if (!numeroCartao.equals(other.numeroCartao))
			return false;
		return true;
	}
	
	
	
	
}
