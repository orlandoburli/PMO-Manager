package br.com.orlandoburli.pmo.web.actions.acesso.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.pmo.model.be.acesso.PerfilBe;
import br.com.orlandoburli.pmo.model.be.acesso.UsuarioBe;
import br.com.orlandoburli.pmo.model.dao.acesso.UsuarioDao;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;

public class UsuarioCadastroAction extends BaseCadastroAction<UsuarioVo, UsuarioDao, UsuarioBe> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/acesso/usuario/usuariocadastro.jsp";
	}
	
	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, UsuarioVo vo, UsuarioBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);
		
		try {
			request.setAttribute("perfis", new PerfilBe(getManager()).getListAtivos());
		} catch (ListException e) {
			Log.error(e);
		}
	}
}
