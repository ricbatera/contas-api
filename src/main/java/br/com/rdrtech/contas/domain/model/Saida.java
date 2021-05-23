package br.com.rdrtech.contas.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

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
public class Saida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String descricao;
	@DateTimeFormat
	private LocalDate dataCompra;
	private Boolean parcelada;
	@NotNull
	private Double valorTotal;
	
	
	@JsonManagedReference
	//@JsonIgnore
	@OneToMany(mappedBy = "saida")
	private List<Parcela> parcelas = new ArrayList<>();
	
	@ManyToOne
	private Responsavel responsavel;
	@ManyToOne
	private RecursoEntradaSaida recursoEntradaSaida;

}
