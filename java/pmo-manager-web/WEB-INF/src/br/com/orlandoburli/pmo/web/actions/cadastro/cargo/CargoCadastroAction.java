package br.com.orlandoburli.pmo.web.actions.cadastro.cargo;

import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.pmo.model.be.cadastros.CargoBe;
import br.com.orlandoburli.pmo.model.dao.cadastros.CargoDao;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;

public class CargoCadastroAction extends BaseCadastroAction<CargoVo, CargoDao, CargoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/cadastro/cargo/cargocadastro.jsp";
	}

}
