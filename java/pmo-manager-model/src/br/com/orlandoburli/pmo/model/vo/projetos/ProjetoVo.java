package br.com.orlandoburli.pmo.model.vo.projetos;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.Projeto.Colunas.*;

@Table(Dicionario.Projeto.TABELA_PROJETO)
public class ProjetoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_PROJETO, dataType = DataType.INT, isAutoIncrement = true, isKey = true)
	private Integer idProjeto;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(200)
	@Description("Nome")
	private String nome;
	
	@Column(name = DESCRICAO, dataType = DataType.TEXT)
	@Description("Descrição")
	private String descricao;
	
	@Column(name = DATA_INICIAL, dataType= DataType.DATE)
	@Description("Data Inicial")
	private Calendar dataInicial;
	
	@Column(name = DATA_FINAL, dataType = DataType.DATE)
	@Description("Data Final")
	private Calendar dataFinal;

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}
}
