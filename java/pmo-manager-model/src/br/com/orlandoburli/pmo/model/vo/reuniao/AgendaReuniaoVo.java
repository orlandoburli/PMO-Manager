package br.com.orlandoburli.pmo.model.vo.reuniao;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.AgendaReuniao.Colunas.*;

@Table(Dicionario.AgendaReuniao.TABELA_AGENDA_REUNIAO)
public class AgendaReuniaoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_AGENDA_REUNIAO, dataType = DataType.INT )
	private Integer idAgendaReuniao;

	@Column(name = ID_SALA_REUNIAO, dataType = DataType.INT)
	private Integer idSalaReuniao;

	private Calendar dataHoraInicio;

	private Calendar dataHoraFim;

	private String assunto;
	
	private Integer idPessoaResponsavel;
	
	private PessoaFisicaVo pessoaResponsavel;

	public Integer getIdAgendaReuniao() {
		return idAgendaReuniao;
	}

	public void setIdAgendaReuniao(Integer idAgendaReuniao) {
		this.idAgendaReuniao = idAgendaReuniao;
	}

	public Integer getIdSalaReuniao() {
		return idSalaReuniao;
	}

	public void setIdSalaReuniao(Integer idSalaReuniao) {
		this.idSalaReuniao = idSalaReuniao;
	}

	public Calendar getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Calendar dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Calendar getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Calendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Integer getIdPessoaResponsavel() {
		return idPessoaResponsavel;
	}

	public void setIdPessoaResponsavel(Integer idPessoaResponsavel) {
		this.idPessoaResponsavel = idPessoaResponsavel;
	}

	public PessoaFisicaVo getPessoaResponsavel() {
		return pessoaResponsavel;
	}

	public void setPessoaResponsavel(PessoaFisicaVo pessoaResponsavel) {
		this.pessoaResponsavel = pessoaResponsavel;
	}
}
