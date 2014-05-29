package br.com.orlandoburli.pmo.model.be.acesso;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.acesso.PerfilDao;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;

public class PerfilBe extends BaseBe<PerfilVo, PerfilDao> {

	public PerfilBe(DAOManager manager) {
		super(manager);
	}

}
