package br.com.orlandoburli.pmo.model.vo.acesso;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Domain;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Email;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotEmpty;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.NotNull;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.utils.Dicionario.Perfil;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.Usuario.Colunas.*;

@Table(Dicionario.Usuario.TABELA_USUARIO)
public class UsuarioVo extends BaseVo {

	@Column(name = ID_USUARIO, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idUsuario;

	@Column(name = NOME, maxSize = 200, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Nome")
	private String nome;

	@Column(name = LOGIN, maxSize = 50, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Login")
	private String login;

	@Column(name = EMAIL, maxSize = 200)
	@Email
	@Description("Email")
	private String email;

	@Column(name = SENHA, maxSize = 100, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Senha")
	private String senha;

	@Column(name = ATIVO, dataType = DataType.CHAR, maxSize = 1, isNotNull = true)
	@NotNull
	@NotEmpty
	@Domain(SimNao.class)
	private String ativo;

	@Column(name = ID_PERFIL, dataType = DataType.INT, isNotNull = true)
	@NotNull
	@NotEmpty
	@Description("Perfil")
	private Integer idPerfil;

	@Join(columnsLocal = { ID_PERFIL }, columnsRemote = { Perfil.Colunas.ID_PERFIL })
	private PerfilVo perfil;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public PerfilVo getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilVo perfil) {
		this.perfil = perfil;
	}
}
