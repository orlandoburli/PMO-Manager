package br.com.orlandoburli.pmo.web.actions.login;

import br.com.orlandoburli.framework.core.utils.Constants;
import br.com.orlandoburli.framework.core.web.BaseAction;

public class LogoffAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public void execute() {
		getRequest().getSession().removeAttribute(Constants.Session.SESSION_USUARIO);
		redir("login.action");
	}
}