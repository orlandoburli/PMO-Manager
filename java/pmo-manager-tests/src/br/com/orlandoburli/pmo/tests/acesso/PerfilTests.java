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
import br.com.orlandoburli.pmo.model.be.acesso.PerfilBe;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;
import br.com.orlandoburli.pmo.tests.builders.acesso.PerfilBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PerfilTests {

	private DAOManager manager;
	private PerfilBe be;

	@Test
	public void testaCadastroPerfil() throws BeException {
		PerfilVo admin = PerfilBuilder.criaPerfilAdmin();

		be.save(admin);

		PerfilVo admin2 = be.get(admin);

		assertNotNull(admin2);

		assertEquals(admin.getNome(), admin2.getNome());

		assertEquals(admin.getAtivo(), admin2.getAtivo());

		assertEquals(admin.getIdPerfil(), admin2.getIdPerfil());
	}

	@Test
	public void testaCadastroPerfilNomeVazio() {
		PerfilVo admin = PerfilBuilder.criaPerfilAdmin();
		
		admin.setNome("   ");
		
		try {
			be.save(admin);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
		}
	}
	
	@Test
	public void testaCadastroPerfilNomeNulo() {
		PerfilVo admin = PerfilBuilder.criaPerfilAdmin();
		
		admin.setNome(null);
		
		try {
			be.save(admin);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
		}
	}
	
	@Test
	public void testaCadastroPerfilAtivoVazio() {
		PerfilVo admin = PerfilBuilder.criaPerfilAdmin();
		
		admin.setAtivo("");
		
		try {
			be.save(admin);
		} catch (BeException e) {
			assertEquals("Campo Ativo é obrigatório!", e.getMessage());
		}
	}
	
	@Test
	public void testaCadastroPerfilAtivoNulo() {
		PerfilVo admin = PerfilBuilder.criaPerfilAdmin();
		
		admin.setAtivo(null);
		
		try {
			be.save(admin);
		} catch (BeException e) {
			assertEquals("Campo Ativo é obrigatório!", e.getMessage());
		}
	}
	
	@Test
	public void testaCadastroPerfilAtivoErrado() {
		PerfilVo admin = PerfilBuilder.criaPerfilAdmin();
		
		admin.setAtivo("X");
		
		try {
			be.save(admin);
		} catch (BeException e) {
			assertEquals("Valor 'X' não permitido em Ativo! Valores permitidos são S, N.", e.getMessage());
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

		be = new PerfilBe(manager);

	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
