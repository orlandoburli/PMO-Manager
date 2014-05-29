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
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaBe;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import br.com.orlandoburli.pmo.tests.builders.cadastros.PessoaBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PessoaTests {

	private DAOManager manager;
	private PessoaBe pessoaBe;

	@Test
	public void testaCadastroPessoa() throws BeException {
		PessoaVo orlando = PessoaBuilder.criaPessoaOrlando();

		pessoaBe.save(orlando);

		PessoaVo orlando2 = pessoaBe.get(orlando);

		assertEquals(orlando.getNome(), orlando2.getNome());

		assertEquals(orlando.getNatureza(), orlando2.getNatureza());
		
		assertEquals(orlando.getIdPessoa(), orlando2.getIdPessoa());
	}
	
	@Test
	public void testaCadastroPessoaNomeVazio() {
		PessoaVo orlando = PessoaBuilder.criaPessoaOrlando();
		
		orlando.setNome("      ");

		try {
			pessoaBe.save(orlando);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}
		
		fail("Falha no teste de nome vazio da pessoa.");
	}
	
	@Test
	public void testaCadastroPessoaNomeNulo() {
		PessoaVo orlando = PessoaBuilder.criaPessoaOrlando();
		
		orlando.setNome(null);

		try {
			pessoaBe.save(orlando);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}
		
		fail("Falha no teste de nome nulo da pessoa.");
	}
	
	@Test
	public void testaCadastroPessoaNaturezaVazio() {
		PessoaVo orlando = PessoaBuilder.criaPessoaOrlando();
		
		orlando.setNatureza("");

		try {
			pessoaBe.save(orlando);
		} catch (BeException e) {
			assertEquals("Campo Natureza é obrigatório!", e.getMessage());
			return;
		}
		
		fail("Falha no teste de natureza vazia da pessoa.");
	}
	
	@Test
	public void testaCadastroPessoaNaturezaNulo() {
		PessoaVo orlando = PessoaBuilder.criaPessoaOrlando();
		
		orlando.setNatureza(null);

		try {
			pessoaBe.save(orlando);
		} catch (BeException e) {
			assertEquals("Campo Natureza é obrigatório!", e.getMessage());
			return;
		}
		
		fail("Falha no teste de natureza nula da pessoa.");
	}
	
	@Test
	public void testaCadastroPessoaNaturezaErrada() {
		PessoaVo orlando = PessoaBuilder.criaPessoaOrlando();
		
		orlando.setNatureza("C");

		try {
			pessoaBe.save(orlando);
		} catch (BeException e) {
			assertEquals("Valor 'C' não permitido em Natureza! Valores permitidos são F, J.", e.getMessage());
			return;
		}
		
		fail("Falha no teste de natureza errada da pessoa.");
	}
	
	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		pessoaBe = new PessoaBe(manager);

	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
