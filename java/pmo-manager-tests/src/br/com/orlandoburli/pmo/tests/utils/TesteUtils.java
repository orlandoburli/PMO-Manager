package br.com.orlandoburli.pmo.tests.utils;

import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;
import br.com.orlandoburli.pmo.model.dao.acesso.MenuDao;
import br.com.orlandoburli.pmo.model.dao.acesso.ObjetoDao;
import br.com.orlandoburli.pmo.model.dao.acesso.PerfilDao;
import br.com.orlandoburli.pmo.model.dao.acesso.UsuarioDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.CargoDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaFisicaDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaJuridicaDao;
import br.com.orlandoburli.pmo.model.dao.projetos.ProjetoDao;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaAprovacaoDao;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaDao;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaInteressadoDao;

public class TesteUtils {

	public static void clearDB(DAOManager manager) throws DAOException {
		new CargoDao(manager).dropSequence().dropTable().checkTable();
		new MenuDao(manager).dropSequence().dropTable().checkTable();
		new ObjetoDao(manager).dropSequence().dropTable().checkTable();
		new UsuarioDao(manager).dropSequence().dropTable().checkTable();
		new PerfilDao(manager).dropSequence().dropTable().checkTable();
		new PessoaDao(manager).dropSequence().dropTable().checkTable();
		new PessoaFisicaDao(manager).dropSequence().dropTable().checkTable();
		new PessoaJuridicaDao(manager).dropSequence().dropTable().checkTable();
		new ProjetoDao(manager).dropSequence().dropTable().checkTable();
		new TermoAberturaDao(manager).dropSequence().dropTable().checkTable();
		new TermoAberturaInteressadoDao(manager).dropSequence().dropTable().checkTable();
		new TermoAberturaAprovacaoDao(manager).dropSequence().dropTable().checkTable();
	}
}
