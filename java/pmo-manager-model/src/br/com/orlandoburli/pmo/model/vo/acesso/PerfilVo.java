package br.com.orlandoburli.pmo.model.vo.acesso;

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
import static br.com.orlandoburli.pmo.model.utils.Dicionario.Perfil.Colunas.*;

@Table(Dicionario.Perfil.TABELA_PERFIL)
public class PerfilVo extends BaseVo {
	private static final long serialVersionUID = 1L;

	@Column(name = ID_PERFIL, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idPerfil;

	@Column(name = NOME, maxSize = 150, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(150)
	@Description("Nome")
	private String nome;

	@Column(name = ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	@Description("Ativo")
	private String ativo;

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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
