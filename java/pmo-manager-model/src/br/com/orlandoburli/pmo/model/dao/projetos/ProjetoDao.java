package br.com.orlandoburli.pmo.model.dao.projetos;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;

public class ProjetoDao extends BaseCadastroDao<ProjetoVo> {

	public ProjetoDao(DAOManager manager) {
		super(manager);
	}

}
