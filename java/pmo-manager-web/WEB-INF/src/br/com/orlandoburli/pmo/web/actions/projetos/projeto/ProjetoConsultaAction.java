package br.com.orlandoburli.pmo.web.actions.projetos.projeto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.pmo.model.be.projetos.ProjetoBe;
import br.com.orlandoburli.pmo.model.dao.projetos.ProjetoDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;

public class ProjetoConsultaAction extends BaseConsultaAction<ProjetoVo, ProjetoDao, ProjetoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/projetos/projeto/projetoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/projetos/projeto/projetoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Projeto.TABELA_PROJETO + "." + Dicionario.Projeto.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(ProjetoVo filter, ProjetoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdProjeto(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
