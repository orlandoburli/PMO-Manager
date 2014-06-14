package br.com.orlandoburli.pmo.model.vo.projetos;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.JoinWhen;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.dao.annotations.UniqueConstraint;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.utils.Dicionario.TermoAbertura;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.TermoAberturaInteressado.Colunas.*;

@Table(value = Dicionario.TermoAberturaInteressado.TABELA_TERMO_ABERTURA_INTERESSADO, constraints = { @UniqueConstraint(constraintName = Dicionario.TermoAberturaInteressado.UNIQUE_TERMO_INTERESSADO_PESSOA, columns = { ID_TERMO, ID_PESSOA }) })
public class TermoAberturaInteressadoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_INTERESSADO, dataType = DataType.INT, isAutoIncrement = true, isKey = true)
	private Integer idInteressado;

	@Column(name = ID_TERMO, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Termo")
	private Integer idTermo;

	@Column(name = ID_PESSOA, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Pessoa")
	private Integer idPessoa;

	@Column(name = FUNCAO, dataType = DataType.VARCHAR, maxSize = 150)
	@NotNull
	@NotEmpty
	@FullTrim
	@Description("Função")
	private String funcao;

	@Join(columnsLocal = { ID_TERMO }, columnsRemote = { TermoAbertura.Colunas.ID_TERMO }, joinWhen = JoinWhen.REQUESTED)
	private TermoAberturaVo termo;

	@Join(columnsLocal = { ID_PESSOA }, columnsRemote = { Dicionario.Pessoa.Colunas.ID_PESSOA }, tableAlias = "pessoa")
	private PessoaVo pessoa;

	public Integer getIdInteressado() {
		return idInteressado;
	}

	public void setIdInteressado(Integer idInteressado) {
		this.idInteressado = idInteressado;
	}

	public Integer getIdTermo() {
		return idTermo;
	}

	public void setIdTermo(Integer idTermo) {
		this.idTermo = idTermo;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public TermoAberturaVo getTermo() {
		return termo;
	}

	public void setTermo(TermoAberturaVo termo) {
		this.termo = termo;
	}

	public PessoaVo getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaVo pessoa) {
		this.pessoa = pessoa;
	}

}
