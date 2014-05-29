package br.com.orlandoburli.pmo.model.be.acesso;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.be.acesso.exceptions.EmailDuplicadoException;
import br.com.orlandoburli.pmo.model.be.acesso.exceptions.LoginDuplicadoException;
import br.com.orlandoburli.pmo.model.be.acesso.exceptions.LoginInvalidoException;
import br.com.orlandoburli.pmo.model.dao.acesso.UsuarioDao;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;

public class UsuarioBe extends BaseBe<UsuarioVo, UsuarioDao> {

	public UsuarioBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(UsuarioVo vo) throws BeException {
		super.doBeforeSave(vo);

		// Valida email duplicado
		UsuarioVo usuario2 = getByEmail(vo.getEmail());

		if (usuario2 != null) {
			if (vo.isNew()) {
				throw new EmailDuplicadoException("Esse email já existe cadastrado em outro usuário!");
			} else {
				if (!vo.getIdUsuario().equals(usuario2.getIdUsuario())) {
					throw new EmailDuplicadoException("Esse email já existe cadastrado em outro usuário!");
				}
			}
		}

		// Valida login duplicado

		UsuarioVo usuario3 = getByLogin(vo.getLogin());

		if (usuario3 != null) {
			if (vo.isNew()) {
				throw new LoginDuplicadoException("Esse login já existe cadastrado em outro usuário!");
			} else {
				if (!vo.getIdUsuario().equals(usuario3.getIdUsuario())) {
					throw new LoginDuplicadoException("Esse login já existe cadastrado em outro usuário!");
				}
			}
		}
	}

	public UsuarioVo getByEmail(String email) throws ListException {
		UsuarioVo filter = new UsuarioVo();
		filter.setEmail(email);

		List<UsuarioVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public UsuarioVo getByLogin(String login) throws ListException {
		UsuarioVo filter = new UsuarioVo();
		filter.setLogin(login);

		List<UsuarioVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	public UsuarioVo login(String login, String senha) throws LoginInvalidoException, ListException {

		UsuarioVo usuario = getByLogin(login);

		if (usuario == null) {
			throw new LoginInvalidoException("Usuário / Senha inválidos!");
		}

		if (usuario.getLogin().equalsIgnoreCase(login) && usuario.getSenha().equals(senha)) {
			if (usuario.getAtivo().equals(SimNao.SIM)) {
				return usuario;
			}
		}

		throw new LoginInvalidoException("Usuário / Senha inválidos!");
	}

}
