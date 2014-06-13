package br.com.orlandoburli.pmo.web.actions.utils.parametro;

import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.pmo.model.be.utils.ParametroBe;
import br.com.orlandoburli.pmo.model.dao.utils.ParametroDao;
import br.com.orlandoburli.pmo.model.vo.utils.ParametroVo;

public class ParametroCadastroAction extends BaseCadastroAction<ParametroVo, ParametroDao, ParametroBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/utils/parametro/parametrocadastro.jsp";
	}

}
