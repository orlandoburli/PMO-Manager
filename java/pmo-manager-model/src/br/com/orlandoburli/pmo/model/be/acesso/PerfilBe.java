package br.com.orlandoburli.pmo.model.be.acesso;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.acesso.PerfilDao;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;

public class PerfilBe extends BaseBe<PerfilVo, PerfilDao> {

	public PerfilBe(DAOManager manager) {
		super(manager);
	}

	public List<PerfilVo> getListAtivos() throws ListException {
		PerfilVo filter = new PerfilVo();
		filter.setAtivo(SimNao.SIM);
		
		return getList(filter);
	}

}
