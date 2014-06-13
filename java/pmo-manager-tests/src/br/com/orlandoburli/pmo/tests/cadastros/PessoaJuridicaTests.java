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
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaJuridicaBe;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import br.com.orlandoburli.pmo.tests.builders.cadastros.PessoaBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

@RunWith(JUnit4.class)
public class PessoaJuridicaTests {

	private DAOManager manager;
	private PessoaBe pessoaBe;
	private PessoaJuridicaBe pessoaJuridicaBe;
	private PessoaVo abaco;

	@Test
	public void testaCadastroPessoaJuridica() throws BeException {
		PessoaJuridicaVo pjAbaco = PessoaBuilder.criaPjAbaco(abaco);

		pessoaJuridicaBe.save(pjAbaco);

		PessoaJuridicaVo pjAbaco2 = pessoaJuridicaBe.get(pjAbaco);

		assertEquals(pjAbaco.getCnpj(), pjAbaco2.getCnpj());

		assertEquals(pjAbaco.getRazaoSocial(), pjAbaco2.getRazaoSocial());
	}

	@Test
	public void testaCadastroPessoaJuridicaRazaoSocialVazia() {
		PessoaJuridicaVo pjAbaco = PessoaBuilder.criaPjAbaco(abaco);

		pjAbaco.setRazaoSocial("       ");

		try {
			pessoaJuridicaBe.save(pjAbaco);
		} catch (BeException e) {
			assertEquals("Campo Razão Social é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de razao social vazia.");
	}

	@Test
	public void testaCadastroPessoaJuridicaCnpjVazio() {
		PessoaJuridicaVo pjAbaco = PessoaBuilder.criaPjAbaco(abaco);

		pjAbaco.setCnpj("xasdas");

		try {
			pessoaJuridicaBe.save(pjAbaco);
		} catch (BeException e) {
			assertEquals("Campo Cnpj é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de cnpj vazio.");
	}
	
	@Test
	public void testaCadastroPessoaJuridicaCnpjMaiorQue14() {
		PessoaJuridicaVo pjAbaco = PessoaBuilder.criaPjAbaco(abaco);

		pjAbaco.setCnpj("123456789012345");

		try {
			pessoaJuridicaBe.save(pjAbaco);
		} catch (BeException e) {
			assertEquals("O Tamanho máximo do campo Cnpj é de 14. Informado: 15", e.getMessage());
			return;
		}

		fail("Falha na validacao de cnpj maior que 14.");
	}
	
	@Test
	public void testaCadastroCnpjInvalido() {
		PessoaJuridicaVo pjAbaco = PessoaBuilder.criaPjAbaco(abaco);

		pjAbaco.setCnpj("123");

		try {
			pessoaJuridicaBe.save(pjAbaco);
		} catch (BeException e) {
			assertEquals("CNPJ inválido!", e.getMessage());
			return;
		}

		fail("Falha na validacao de cnpj invalido.");
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
		abaco = PessoaBuilder.criaPessoaAbaco();
		pessoaBe.save(abaco);

		pessoaJuridicaBe = new PessoaJuridicaBe(manager);
	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
