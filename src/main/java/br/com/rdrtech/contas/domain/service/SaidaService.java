package br.com.rdrtech.contas.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdrtech.contas.domain.dto.SaidaDTO;
import br.com.rdrtech.contas.domain.mapper.MapperConfig;
import br.com.rdrtech.contas.domain.model.Parcela;
import br.com.rdrtech.contas.domain.model.RecursoEntradaSaida;
import br.com.rdrtech.contas.domain.model.Responsavel;
import br.com.rdrtech.contas.domain.model.Saida;
import br.com.rdrtech.contas.domain.repository.ParcelaRepository;
import br.com.rdrtech.contas.domain.repository.RecursoEntradaSaidaRepository;
import br.com.rdrtech.contas.domain.repository.ResponsavelRepository;
import br.com.rdrtech.contas.domain.repository.SaidaRepository;
import br.com.rdrtech.contas.domain.request.SaidaRequest;

@Service
public class SaidaService {
	@Autowired
	private SaidaRepository repoSaida;
	@Autowired
	private ParcelaRepository repoParcela;
	@Autowired
	private ResponsavelRepository reporesp;
	@Autowired
	private RecursoEntradaSaidaRepository repoRecuEntSaida;
	@Autowired
	private MapperConfig mapper;

	public SaidaDTO salvar(SaidaRequest sr) {
		Saida saida = toModel(sr);
		saida = repoSaida.save(saida);
		Responsavel responsavel = reporesp.findById(sr.getResponsavel().getId()).get();
		RecursoEntradaSaida recurso = repoRecuEntSaida.findById(sr.getRecursoEntradaSaida().getId()).get();
		List<Parcela> parcelas = criaParcelas(sr.getNumParcelas(), sr.getValorTotal(), sr.getDataVencimento(), sr.getSituacao(), saida);
		saida.setParcelas(parcelas);
		saida.setRecursoEntradaSaida(recurso);
		saida.setResponsavel(responsavel);
		return toDTO(saida);
	}
	
	public List<Saida> listar(){
		return repoSaida.findAll();
	}
	
	public void deleteAll() {
		repoSaida.deleteAll();
	}
	
	public List<Parcela> criaParcelas(int parcelas, Double valor, LocalDate dataVencimento, String situacao, Saida saida) {
		List<Parcela>parcelasGeradas = new ArrayList<>();		
		BigDecimal valorParcela = new BigDecimal(valor).divide(new BigDecimal(parcelas),2, RoundingMode.HALF_EVEN);
		//Calendar hoje = Calendar.getInstance();
		Calendar vencimento = converteVencimento(dataVencimento);
		//if(vencimento.compareTo(hoje) >= 0) {			
			for (int i = 0; i < parcelas; i++) {
				LocalDate venc = LocalDateTime.ofInstant(vencimento.toInstant(), vencimento.getTimeZone().toZoneId()).toLocalDate();
				String valorParc = valorParcela.toString();
				Parcela parcela = new Parcela();
				parcela.setDataVenvimento(venc);
				parcela.setParcelaNumero(i+1);
				parcela.setValorUnit(Double.parseDouble(valorParc));
				parcela.setSituacao(situacao);
				parcela.setSaida(saida);
				parcela = repoParcela.save(parcela);
				parcelasGeradas.add(parcela);
				vencimento.set(Calendar.MONTH, (vencimento.get(Calendar.MONTH)+1));
			}
		//}
		return parcelasGeradas;
	}
	
	private Calendar converteVencimento(LocalDate vencimento) {
		String dataVencimento = vencimento.toString();
		String [] arrayVencimento = dataVencimento.split("-");
		Integer ano = Integer.valueOf(arrayVencimento[0]);
		Integer mes = Integer.valueOf(arrayVencimento[1])-1;
		Integer dia = Integer.valueOf(arrayVencimento[2]);
		Calendar vencimentoCalendar = Calendar.getInstance();		
		vencimentoCalendar.set(Calendar.DAY_OF_MONTH, dia);
		vencimentoCalendar.set(Calendar.MONTH, mes);
		vencimentoCalendar.set(Calendar.YEAR, ano);
		return vencimentoCalendar;
	}

	private SaidaDTO toDTO(Saida r) {
		return mapper.modelMapper().map(r, SaidaDTO.class);
	}

	private Saida toModel(SaidaRequest rq) {
		return mapper.modelMapper().map(rq, Saida.class);
	}

}
