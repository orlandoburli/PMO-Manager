package br.com.orlandoburli.pmo.web.actions.utils.parametro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.pmo.model.be.utils.ParametroBe;
import br.com.orlandoburli.pmo.model.dao.utils.ParametroDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.utils.ParametroVo;

public class ParametroConsultaAction extends BaseConsultaAction<ParametroVo, ParametroDao, ParametroBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/utils/parametro/parametroconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/utils/parametro/parametroconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Parametro.TABELA_PARAMETRO + "." + Dicionario.Parametro.Colunas.ID_PARAMETRO;
	}

	@Override
	public void doBeforeFilter(ParametroVo filter, ParametroBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				filter.setIdParametro("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
