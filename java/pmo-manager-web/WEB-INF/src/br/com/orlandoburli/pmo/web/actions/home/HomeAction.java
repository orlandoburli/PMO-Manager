package br.com.orlandoburli.pmo.web.actions.home;

import java.util.List;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.pmo.model.be.acesso.MenuBe;
import br.com.orlandoburli.pmo.model.vo.acesso.MenuVo;
import br.com.orlandoburli.pmo.web.servlets.utils.Versao;

public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@OutjectSession("menus")
	private List<MenuVo> menus;

	public void execute() {

		DAOManager manager = DAOManager.getDAOManager();
		
		try {
			menus = new MenuBe(manager).getMenus();
			
		} catch (ListException e) {
			Log.error(e);
		} finally {
			manager.commit();
		}
		
		getRequest().setAttribute("versao", Versao.getInstance(getContext()));

		forward("web/pages/home.jsp");
	}

}
