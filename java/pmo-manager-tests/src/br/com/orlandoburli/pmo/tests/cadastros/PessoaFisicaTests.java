package br.com.orlandoburli.pmo.tests.cadastros;

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
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaFisicaBe;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import br.com.orlandoburli.pmo.tests.builders.cadastros.CargoBuilder;
import br.com.orlandoburli.pmo.tests.builders.cadastros.PessoaBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PessoaFisicaTests {

	private DAOManager manager;
	private PessoaBe pessoaBe;
	private PessoaVo orlando;
	private PessoaFisicaBe pessoaFisicaBe;
	private CargoVo gerente;

	@Test
	public void testaCadastroPessoaFisica() throws BeException {
		PessoaFisicaVo pfOrlando = PessoaBuilder.criaPfOrlando(orlando, gerente);

		pessoaFisicaBe.save(pfOrlando);

		PessoaFisicaVo pfOrlando2 = pessoaFisicaBe.get(pfOrlando);

		assertEquals(pfOrlando.getCpf(), pfOrlando2.getCpf());

		assertEquals(pfOrlando.getRg(), pfOrlando2.getRg());

		assertEquals(pfOrlando.getDataNascimento(), pfOrlando2.getDataNascimento());
	}

	@Test
	public void testaCadastroCpfInvalido() {
		PessoaFisicaVo pfOrlando = PessoaBuilder.criaPfOrlando(orlando, gerente);
		
		pfOrlando.setCpf("123");
		
		try {
			pessoaFisicaBe.save(pfOrlando);
		} catch (BeException e) {
			assertEquals("CPF inválido!", e.getMessage());
			return;
		}

		fail("Falha no teste de cpf invalido!");
	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException, BeException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		pessoaBe = new PessoaBe(manager);
		orlando = PessoaBuilder.criaPessoaOrlando();
		pessoaBe.save(orlando);

		pessoaFisicaBe = new PessoaFisicaBe(manager);

		gerente = CargoBuilder.criaCargoGerente();
		new CargoBe(manager).save(gerente);
	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
