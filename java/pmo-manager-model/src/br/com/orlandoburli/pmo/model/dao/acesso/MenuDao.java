package br.com.orlandoburli.pmo.model.dao.acesso;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.acesso.MenuVo;

public class MenuDao extends BaseCadastroDao<MenuVo> {

	public MenuDao(DAOManager manager) {
		super(manager);
	}

}
