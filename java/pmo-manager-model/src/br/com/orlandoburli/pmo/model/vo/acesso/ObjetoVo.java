package br.com.orlandoburli.pmo.model.vo.acesso;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.Objeto.Colunas.*;

@Table(Dicionario.Objeto.TABELA_OBJETO)
public class ObjetoVo extends BaseVo {
	private static final long serialVersionUID = 1L;

	@Column(name = ID_OBJETO, dataType = DataType.INT, isKey = true)
	@NotNull
	@NotEmpty
	private Integer idObjeto;

	@Column(name = NOME, dataType = DataType.VARCHAR, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@MaxSize(100)
	private String nome;

	@Column(name = URL, dataType = DataType.VARCHAR, maxSize = 150)
	@NotNull
	@NotEmpty
	@MaxSize(150)
	private String url;
	
	public Integer getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
