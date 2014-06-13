package br.com.orlandoburli.pmo.model.vo.cadastros;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FilterOnly;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Upper;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Cnpj;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.utils.Dicionario.Pessoa;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.PessoaFisica.Colunas.ID_PESSOA;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.PessoaJuridica.Colunas.*;

@Table(Dicionario.PessoaJuridica.TABELA_PESSOA_JURIDICA)
public class PessoaJuridicaVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	public PessoaJuridicaVo() {
		super();
		this.pessoa = new PessoaVo();
	}

	@Column(name = ID_PESSOA, dataType = DataType.INT, isKey = true)
	private Integer idPessoa;

	@Column(name = CNPJ, dataType = DataType.VARCHAR, maxSize = 14, isNotNull = true)
	@NotNull
	@NotEmpty
	@FilterOnly(FilterOnly.NUMEROS)
	@MaxSize(14)
	@Cnpj
	@Description("Cnpj")
	private String cnpj;

	@Column(name = RAZAO_SOCIAL, dataType = DataType.VARCHAR, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@Upper
	@FullTrim
	@Description("Razão Social")
	private String razaoSocial;

	@Join(columnsLocal = { ID_PESSOA }, columnsRemote = { Pessoa.Colunas.ID_PESSOA })
	private PessoaVo pessoa;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public PessoaVo getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaVo pessoa) {
		this.pessoa = pessoa;
	}
}
