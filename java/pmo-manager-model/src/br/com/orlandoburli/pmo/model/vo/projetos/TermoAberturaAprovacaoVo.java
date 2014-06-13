package br.com.orlandoburli.pmo.model.vo.projetos;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.utils.Dicionario.TermoAbertura;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.TermoAberturaAprovacao.Colunas.*;

@Table(Dicionario.TermoAberturaAprovacao.TABELA_TERMO_ABERTURA_APROVACAO)
public class TermoAberturaAprovacaoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

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

	@Column(name = DATA, dataType = DataType.DATE)
	private Calendar data;

	@Column(name = FUNCAO, dataType = DataType.VARCHAR, maxSize = 150)
	private String funcao;

	@Join(columnsLocal = { ID_TERMO }, columnsRemote = { TermoAbertura.Colunas.ID_TERMO })
	private TermoAberturaVo termo;

	@Join(columnsLocal = { ID_PESSOA }, columnsRemote = { Dicionario.Pessoa.Colunas.ID_PESSOA })
	private PessoaVo pessoa;

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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
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
