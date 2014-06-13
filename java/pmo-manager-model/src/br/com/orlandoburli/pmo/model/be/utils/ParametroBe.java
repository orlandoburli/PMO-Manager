package br.com.orlandoburli.pmo.model.be.utils;

import br.com.orlandoburli.pmo.model.dao.utils.ParametroDao;
import br.com.orlandoburli.pmo.model.vo.utils.ParametroVo;
import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;

public class ParametroBe extends BaseBe<ParametroVo, ParametroDao>{

	public ParametroBe(DAOManager manager) {
		super(manager);
	}

}
