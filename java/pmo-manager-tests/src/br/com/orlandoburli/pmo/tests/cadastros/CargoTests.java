package br.com.orlandoburli.pmo.tests.cadastros;

import static org.junit.Assert.*;

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
import br.com.orlandoburli.pmo.model.be.cadastros.CargoBe;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;
import br.com.orlandoburli.pmo.tests.builders.cadastros.CargoBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

@RunWith(JUnit4.class)
public class CargoTests {

	private DAOManager manager;
	private CargoBe cargoBe;

	@Test
	public void testaCadastroCargo() throws BeException {
		CargoVo gerente = CargoBuilder.criaCargoGerente();

		cargoBe.save(gerente);
	}

	@Test
	public void testaCadastroNomeNulo() {
		CargoVo gerente = CargoBuilder.criaCargo(null);

		try {
			cargoBe.save(gerente);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de nome obrigatorio (nulo)");
	}

	@Test
	public void testaCadastroNomeVazio() {
		CargoVo gerente = CargoBuilder.criaCargo("     ");

		try {
			cargoBe.save(gerente);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de nome obrigatorio (vazio)");
	}

	@Test
	public void testaCadastroNomeDuplicado() throws BeException {
		CargoVo gerente = CargoBuilder.criaCargoGerente();

		cargoBe.save(gerente);

		CargoVo gerente2 = CargoBuilder.criaCargoGerente();

		try {
			cargoBe.save(gerente2);
		} catch (BeException e) {
			assertEquals("O cargo \"" + gerente2.getNome() + "\" já existe cadastrado!", e.getMessage());
			return;
		}

		fail("Falha na validacao de cadastro duplicado");
	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		cargoBe = new CargoBe(manager);

	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
