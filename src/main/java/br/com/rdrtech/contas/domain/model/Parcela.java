package br.com.rdrtech.contas.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Parcela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valorUnit;
	private Integer parcelaNumero;
	private String situacao = "Aberta";
	@DateTimeFormat
	private LocalDate dataVenvimento;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "saida_id")
	private Saida saida;


	@Override
	public String toString() {
		return "Parcela [id=" + id + ", parcelaNumero=" + parcelaNumero + ", situacao=" + situacao + ", dataVenvimento="
				+ dataVenvimento + "]";
	}
	
	

}
