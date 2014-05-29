package br.com.orlandoburli.pmo.tests.utils;

import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;
import br.com.orlandoburli.pmo.model.dao.acesso.PerfilDao;
import br.com.orlandoburli.pmo.model.dao.acesso.UsuarioDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaDao;

public class TesteUtils {

	public static void clearDB(DAOManager manager) throws DAOException {
		new UsuarioDao(manager).dropSequence().dropTable().checkTable();
		new PerfilDao(manager).dropSequence().dropTable().checkTable();
		new PessoaDao(manager).dropSequence().dropTable().checkTable();
	}
}
