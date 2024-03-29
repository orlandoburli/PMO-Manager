package br.com.orlandoburli.pmo.web.actions.login;

import javax.servlet.http.Cookie;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.framework.core.web.retorno.RetornoAction;
import br.com.orlandoburli.pmo.model.be.acesso.UsuarioBe;
import br.com.orlandoburli.pmo.model.be.acesso.exceptions.LoginInvalidoException;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;
import br.com.orlandoburli.pmo.web.servlets.utils.Versao;

public class LoginAction extends BaseAction {

	private static final String LOGIN_COOKIES = "login_cookie";

	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;

	private Integer lembrarSenha;

	@OutjectSession(Constants.Session.SESSION_USUARIO)
	private UsuarioVo usuario;

	@OutjectSession(Constants.Session.SESSION_PERFIL)
	private PerfilVo perfilsessao;

	@OutjectSession("tituloApp")
	private String tituloApp;

	public void execute() {
		this.setTituloApp("PMO Manager");

		// Se o cookie do email estiver salvo, retorna.
		if (getRequest() != null && getRequest().getCookies() != null) {
			for (Cookie cookie : getRequest().getCookies()) {
				if (cookie.getName().equalsIgnoreCase(LOGIN_COOKIES)) {
					getRequest().setAttribute(LOGIN_COOKIES, cookie.getValue());
				}
			}
		}

		getRequest().setAttribute("versao", Versao.getInstance(getContext()));

		forward("web/pages/acesso/login/login.jsp");

	}

	public void login() {
		DAOManager manager = DAOManager.getDAOManager();
		try {

			UsuarioVo usuario = new UsuarioBe(manager).login(login, senha);
			setUsuario(usuario);

			write(Utils.voToJson(new RetornoAction(true, "LOGIN_OK", "")));

			// Lembrar senha
			if (getLembrarSenha() != null && getLembrarSenha() == 1) {
				Cookie cookie = new Cookie(LOGIN_COOKIES, login);
				getResponse().addCookie(cookie);
			}

		} catch (LoginInvalidoException e) {
			write(Utils.voToJson(new RetornoAction(false, e.getMessage(), "login")));
		} catch (ListException e) {
			write(Utils.voToJson(new RetornoAction(false, e.getMessage(), "login")));
		} finally {
			manager.commit();
		}
	}

	public void load() {
		write(Utils.voToJson(new RetornoAction(true, "LOAD_OK", "")));
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getLembrarSenha() {
		return lembrarSenha;
	}

	public void setLembrarSenha(Integer lembrarSenha) {
		this.lembrarSenha = lembrarSenha;
	}

	public UsuarioVo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}

	public String getTituloApp() {
		return tituloApp;
	}

	public void setTituloApp(String tituloApp) {
		this.tituloApp = tituloApp;
	}
}
