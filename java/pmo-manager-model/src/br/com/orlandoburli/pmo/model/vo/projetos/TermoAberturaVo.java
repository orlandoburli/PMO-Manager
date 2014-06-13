package br.com.orlandoburli.pmo.model.vo.projetos;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotZero;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.JoinWhen;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.dao.annotations.UniqueConstraint;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.utils.Dicionario.PessoaFisica;
import br.com.orlandoburli.pmo.model.utils.Dicionario.Projeto;
import br.com.orlandoburli.pmo.model.utils.Dicionario.TermoAbertura;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.TermoAbertura.Colunas.*;

@Table(value = Dicionario.TermoAbertura.TABELA_TERMO_ABERTURA, constraints = { @UniqueConstraint(columns = { ID_PROJETO, VERSAO }, constraintName = TermoAbertura.UNIQUE_VERSAO) })
public class TermoAberturaVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_TERMO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idTermoAbertura;

	@Column(name = ID_PROJETO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Projeto")
	private Integer idProjeto;

	@Column(name = VERSAO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@NotZero
	@Description("Versão")
	private Integer versao;

	@Column(name = JUSTIFICATIVA, dataType = DataType.TEXT)
	@Description("Justificativa")
	private String justificativa;

	@Column(name = OBJETIVOS, dataType = DataType.TEXT)
	@Description("Objetivos")
	private String objetivos;

	@Column(name = DESCRICAO_PRODUTO, dataType = DataType.TEXT)
	@Description("Descrição do Produto")
	private String descricaoProduto;

	@Column(name = ID_PESSOA_GERENTE, dataType = DataType.INT)
	@Description("Gerente")
	private Integer idPessoaGerente;

	@Column(name = REQUISITOS, dataType = DataType.TEXT)
	@Description("Requisitos")
	private String requisitos;

	@Column(name = RISCOS, dataType = DataType.TEXT)
	@Description("Riscos")
	private String riscos;

	@Column(name = MARCOS, dataType = DataType.TEXT)
	@Description("Marcos")
	private String marcos;

	@Column(name = INVESTIMENTO, dataType = DataType.TEXT)
	@Description("Investimento")
	private String investimento;

	@Column(name = PATROCINADOR, dataType = DataType.TEXT)
	@Description("Patrocinador")
	private String patrocinador;

	@Column(name = STATUS_TERMO_ABERTURA, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(StatusTermoAbertura.class)
	@Description("Marcos")
	private Integer statusTermoAbertura;

	@Column(name = ID_TERMO_REFERENCIA, dataType = DataType.INT)
	private Integer idTermoReferencia;

	@Join(columnsLocal = { ID_PESSOA_GERENTE }, columnsRemote = { PessoaFisica.Colunas.ID_PESSOA }, tableAlias = "gerente")
	private PessoaFisicaVo gerente;

	@Join(columnsLocal = { ID_PROJETO }, columnsRemote = { Projeto.Colunas.ID_PROJETO })
	private ProjetoVo projeto;

	@Join(columnsLocal = { ID_TERMO_REFERENCIA }, columnsRemote = { ID_TERMO }, tableAlias = "referencia", joinWhen = JoinWhen.REQUESTED)
	private TermoAberturaVo termoReferenciado;

	// private List<TermoAberturaInteressadosVo>

	public String getStatusTermoAberturaDescritivo() {
		return new StatusTermoAbertura().getDescription(getStatusTermoAbertura());
	}

	public Integer getIdTermoAbertura() {
		return idTermoAbertura;
	}

	public void setIdTermoAbertura(Integer idTermoAbertura) {
		this.idTermoAbertura = idTermoAbertura;
	}

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getIdPessoaGerente() {
		return idPessoaGerente;
	}

	public void setIdPessoaGerente(Integer idPessoaGerente) {
		this.idPessoaGerente = idPessoaGerente;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getRiscos() {
		return riscos;
	}

	public void setRiscos(String riscos) {
		this.riscos = riscos;
	}

	public String getMarcos() {
		return marcos;
	}

	public void setMarcos(String marcos) {
		this.marcos = marcos;
	}

	public String getInvestimento() {
		return investimento;
	}

	public void setInvestimento(String investimento) {
		this.investimento = investimento;
	}

	public String getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}

	public Integer getStatusTermoAbertura() {
		return statusTermoAbertura;
	}

	public void setStatusTermoAbertura(Integer statusTermoAbertura) {
		this.statusTermoAbertura = statusTermoAbertura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PessoaFisicaVo getGerente() {
		return gerente;
	}

	public void setGerente(PessoaFisicaVo gerente) {
		this.gerente = gerente;

		if (this.gerente != null && this.gerente.getIdPessoa() != null) {
			this.setIdPessoaGerente(gerente.getIdPessoa());
		}
	}

	public ProjetoVo getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoVo projeto) {
		this.projeto = projeto;

		if (this.projeto != null && this.projeto.getIdProjeto() != null) {
			setIdProjeto(projeto.getIdProjeto());
		}
	}

	public Integer getIdTermoReferencia() {
		return idTermoReferencia;
	}

	public void setIdTermoReferencia(Integer idTermoReferencia) {
		this.idTermoReferencia = idTermoReferencia;
	}

	public TermoAberturaVo getTermoReferenciado() {
		return termoReferenciado;
	}

	public void setTermoReferenciado(TermoAberturaVo termoReferenciado) {
		this.termoReferenciado = termoReferenciado;
	}
}
