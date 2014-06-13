package br.com.orlandoburli.pmo.web.actions.cadastro.cargo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.pmo.model.be.cadastros.CargoBe;
import br.com.orlandoburli.pmo.model.dao.cadastros.CargoDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;

public class CargoConsultaAction extends BaseConsultaAction<CargoVo, CargoDao, CargoBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/cadastro/cargo/cargoconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/cadastro/cargo/cargoconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Cargo.TABELA_CARGO + "." + Dicionario.Cargo.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(CargoVo filter, CargoBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdCargo(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
