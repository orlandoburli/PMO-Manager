package br.com.orlandoburli.pmo.model.vo.reuniao;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.SalaReuniao.Colunas.*;

@Table(Dicionario.SalaReuniao.TABELA_SALA_REUNIAO)
public class SalaReuniaoVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	@Column(name = ID_SALA_REUNIAO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idSalaReuniao;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	@Description("Nome")
	private String nome;

	@Column(name = ATIVO, dataType = DataType.CHAR, isNotNull = true, maxSize = 1)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	public Integer getIdSalaReuniao() {
		return idSalaReuniao;
	}

	public void setIdSalaReuniao(Integer idSalaReuniao) {
		this.idSalaReuniao = idSalaReuniao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
}
