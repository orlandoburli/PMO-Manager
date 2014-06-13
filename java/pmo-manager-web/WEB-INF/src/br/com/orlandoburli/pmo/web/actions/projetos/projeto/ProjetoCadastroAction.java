package br.com.orlandoburli.pmo.web.actions.projetos.projeto;

import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.pmo.model.be.projetos.ProjetoBe;
import br.com.orlandoburli.pmo.model.dao.projetos.ProjetoDao;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;

public class ProjetoCadastroAction extends BaseCadastroAction<ProjetoVo, ProjetoDao, ProjetoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/projetos/projeto/projetocadastro.jsp";
	}

}
