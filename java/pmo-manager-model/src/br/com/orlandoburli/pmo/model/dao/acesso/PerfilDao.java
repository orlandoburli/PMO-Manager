package br.com.orlandoburli.pmo.model.dao.acesso;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;

public class PerfilDao extends BaseCadastroDao<PerfilVo>{

	public PerfilDao(DAOManager manager) {
		super(manager);
	}

}
