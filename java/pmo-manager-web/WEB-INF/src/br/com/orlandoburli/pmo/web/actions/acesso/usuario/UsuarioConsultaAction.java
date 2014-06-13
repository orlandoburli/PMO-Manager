package br.com.orlandoburli.pmo.web.actions.acesso.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.pmo.model.be.acesso.UsuarioBe;
import br.com.orlandoburli.pmo.model.dao.acesso.UsuarioDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;

public class UsuarioConsultaAction extends BaseConsultaAction<UsuarioVo, UsuarioDao, UsuarioBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/acesso/usuario/usuarioconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/acesso/usuario/usuarioconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.Usuario.TABELA_USUARIO + "." + Dicionario.Usuario.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(UsuarioVo filter, UsuarioBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdUsuario(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.setNome("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.setNome("%" + getPesquisarPor() + "%");
		}
	}

}
