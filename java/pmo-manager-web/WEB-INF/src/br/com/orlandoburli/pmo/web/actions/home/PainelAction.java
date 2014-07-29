package br.com.orlandoburli.pmo.web.actions.home;

import br.com.orlandoburli.framework.core.web.BaseAction;

public class PainelAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	public void execute() {
		
		forward("web/pages/painel.jsp");

	}
}
