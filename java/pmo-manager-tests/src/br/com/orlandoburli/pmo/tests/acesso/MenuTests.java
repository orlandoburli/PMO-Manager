package br.com.orlandoburli.pmo.tests.acesso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;
import br.com.orlandoburli.pmo.model.be.acesso.MenuBe;
import br.com.orlandoburli.pmo.model.vo.acesso.MenuVo;
import br.com.orlandoburli.pmo.tests.builders.acesso.MenuBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

@RunWith(JUnit4.class)
public class MenuTests {
	private DAOManager manager;
	private MenuBe be;

	@Test
	public void testaCadastroMenu() throws BeException {
		MenuVo menuCadastros = MenuBuilder.criaMenuCadastros();

		be.save(menuCadastros);
	}

	@Test
	public void testaInicializaMenus() throws BeException {
		for (int i = 0; i < 10; i++) {
			be.inicializarMenus();
		}
	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		be = new MenuBe(manager);

	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
