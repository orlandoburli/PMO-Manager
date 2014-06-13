package br.com.orlandoburli.pmo.web.actions.acesso.perfil;

import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.pmo.model.be.acesso.PerfilBe;
import br.com.orlandoburli.pmo.model.dao.acesso.PerfilDao;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;

public class PerfilCadastroAction extends BaseCadastroAction<PerfilVo, PerfilDao, PerfilBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/acesso/perfil/perfilcadastro.jsp";
	}

}
