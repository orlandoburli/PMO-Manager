package br.com.orlandoburli.pmo.model.dao.acesso;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;

public class UsuarioDao extends BaseCadastroDao<UsuarioVo> {

	public UsuarioDao(DAOManager manager) {
		super(manager);
	}

}
