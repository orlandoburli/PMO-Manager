package br.com.orlandoburli.pmo.model.vo.cadastros;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FullTrim;
import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.Upper;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MinSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.domains.Natureza;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.Pessoa.Colunas.*;

@Table(Dicionario.Pessoa.TABELA_PESSOA)
public class PessoaVo extends BaseVo {

	@Column(name = ID_PESSOA, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idPessoa;

	@Column(name = NOME, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@MinSize(3)
	@Description("Nome")
	@FullTrim
	@Upper
	private String nome;

	@Column(name = NATUREZA, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(Natureza.class)
	@Description("Natureza")
	private String natureza;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
}
