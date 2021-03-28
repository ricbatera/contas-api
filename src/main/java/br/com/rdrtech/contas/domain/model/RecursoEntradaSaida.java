package br.com.rdrtech.contas.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

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
public class RecursoEntradaSaida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String descricao;
	private String numeroCartao;
	private String nomeCartao;
	private OffsetDateTime validade;
	private int diaVencimento;
	private String banco;
	private String agencia;
	private String conta;
	@ManyToOne
	@JoinColumn(name ="id_tipo_entrada_saida")
	private EntradaSaida entradaSaida;
	private Double saldoTotal;
	private Double recebidos;
	private Double pagos;
	private Double aReceber;
	private Double aPagar;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + diaVencimento;
		result = prime * result + ((entradaSaida == null) ? 0 : entradaSaida.hashCode());
		result = prime * result + ((nomeCartao == null) ? 0 : nomeCartao.hashCode());
		result = prime * result + ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
		result = prime * result + ((validade == null) ? 0 : validade.hashCode());
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
		RecursoEntradaSaida other = (RecursoEntradaSaida) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diaVencimento != other.diaVencimento)
			return false;
		if (entradaSaida == null) {
			if (other.entradaSaida != null)
				return false;
		} else if (!entradaSaida.equals(other.entradaSaida))
			return false;
		if (nomeCartao == null) {
			if (other.nomeCartao != null)
				return false;
		} else if (!nomeCartao.equals(other.nomeCartao))
			return false;
		if (numeroCartao == null) {
			if (other.numeroCartao != null)
				return false;
		} else if (!numeroCartao.equals(other.numeroCartao))
			return false;
		if (validade == null) {
			if (other.validade != null)
				return false;
		} else if (!validade.equals(other.validade))
			return false;
		return true;
	}
	
	
	
}
