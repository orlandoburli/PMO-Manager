package br.com.orlandoburli.pmo.model.dao.cadastros;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;

public class CargoDao extends BaseCadastroDao<CargoVo> {

	public CargoDao(DAOManager manager) {
		super(manager);
	}

}
