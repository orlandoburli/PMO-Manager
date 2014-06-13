package br.com.orlandoburli.pmo.web.actions.acesso.perfil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.pmo.model.be.acesso.PerfilBe;
import br.com.orlandoburli.pmo.model.dao.acesso.PerfilDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;

public class PerfilConsultaAction extends BaseConsultaAction<PerfilVo, PerfilDao, PerfilBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/acesso/perfil/perfilconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/acesso/perfil/perfilconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Perfil.TABELA_PERFIL + "." + Dicionario.Perfil.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(PerfilVo filter, PerfilBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdPerfil(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
