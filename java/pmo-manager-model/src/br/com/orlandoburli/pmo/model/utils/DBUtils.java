package br.com.orlandoburli.pmo.model.utils;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;
import br.com.orlandoburli.pmo.model.be.acesso.MenuBe;
import br.com.orlandoburli.pmo.model.be.acesso.ObjetoBe;
import br.com.orlandoburli.pmo.model.dao.acesso.MenuDao;
import br.com.orlandoburli.pmo.model.dao.acesso.ObjetoDao;
import br.com.orlandoburli.pmo.model.dao.acesso.PerfilDao;
import br.com.orlandoburli.pmo.model.dao.acesso.UsuarioDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.CargoDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaFisicaDao;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaJuridicaDao;
import br.com.orlandoburli.pmo.model.dao.reuniao.SalaReuniaoDao;

public final class DBUtils {

	public static void checkDaos() {
		DAOManager manager = DAOManager.getDAOManager();

		try {
			//
			new ObjetoDao(manager).checkTable();
			new MenuDao(manager).checkTable();
			new PerfilDao(manager).checkTable();
			new UsuarioDao(manager).checkTable();
			new CargoDao(manager).checkTable();
			
			new PessoaDao(manager).checkTable();
			new PessoaJuridicaDao(manager).checkTable();
			new PessoaFisicaDao(manager).checkTable();
			
			new SalaReuniaoDao(manager).checkTable();

			// Objetos padrao

			new ObjetoBe(manager).inicializarObjetos();

			// Menus padrao

			new MenuBe(manager).inicializarMenus();

		} catch (DAOException e) {
			e.printStackTrace();
		} catch (BeException e) {
			e.printStackTrace();
		} finally {
			manager.commit();
		}

	}
}
