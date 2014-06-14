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
import br.com.orlandoburli.pmo.model.be.acesso.ObjetoBe;
import br.com.orlandoburli.pmo.model.utils.PMOConstants;
import br.com.orlandoburli.pmo.model.vo.acesso.ObjetoVo;
import br.com.orlandoburli.pmo.tests.builders.acesso.ObjetoBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ObjetoTests {
	private DAOManager manager;
	private ObjetoBe be;

	@Test
	public void testaCadastroObjeto() throws BeException {
		ObjetoVo cadastroUsuario = ObjetoBuilder.criaObjetoCadastroUsuario();

		be.save(cadastroUsuario);

		ObjetoVo objeto2 = be.get(cadastroUsuario);

		assertEquals(cadastroUsuario.getIdObjeto(), objeto2.getIdObjeto());

		assertEquals(cadastroUsuario.getNome(), objeto2.getNome());
	}

	@Test
	public void testaCadastroObjetoIdVazio() {
		ObjetoVo cadastroUsuario = ObjetoBuilder.criaObjetoCadastroUsuario();

		cadastroUsuario.setIdObjeto(null);

		try {
			be.save(cadastroUsuario);
		} catch (BeException e) {
			assertEquals("Campo idObjeto é obrigatório!", e.getMessage());
			return;
		}

		fail();
	}

	@Test
	public void testaCadastroObjetoNomeVazio() {
		ObjetoVo cadastroUsuario = ObjetoBuilder.criaObjetoCadastroUsuario();

		cadastroUsuario.setNome("     ");

		try {
			be.save(cadastroUsuario);
		} catch (BeException e) {
			assertEquals("Campo nome é obrigatório!", e.getMessage());
			return;
		}

		fail();
	}

	@Test
	public void testaCadastroObjetoNomeNulo() {
		ObjetoVo cadastroUsuario = ObjetoBuilder.criaObjetoCadastroUsuario();

		cadastroUsuario.setNome(null);

		try {
			be.save(cadastroUsuario);
		} catch (BeException e) {
			assertEquals("Campo nome é obrigatório!", e.getMessage());
			return;
		}

		fail();
	}

	@Test
	public void testaCadastroObjetoIdRepetido() throws BeException {
		ObjetoVo cadastroUsuario = ObjetoBuilder.criaObjetoCadastroUsuario();

		be.save(cadastroUsuario);

		ObjetoVo cadastroUsuario2 = ObjetoBuilder.criaObjetoCadastroUsuario();

		try {
			be.save(cadastroUsuario2);
		} catch (BeException e) {
			assertEquals("Objeto com o Id " + cadastroUsuario2.getIdObjeto() + " já cadastrado!", e.getMessage());
			return;
		}

		fail();
	}

	@Test
	public void testaInicializar() throws BeException {
		be.inicializarObjetos();
		be.inicializarObjetos();

		// Consulta de Perfis de Acesso

		ObjetoVo consultaPerfil = be.get(PMOConstants.Objeto.PERFIL_CONSULTA);
		assertEquals(new Integer(PMOConstants.Objeto.PERFIL_CONSULTA), consultaPerfil.getIdObjeto());
		assertEquals("Consulta de Perfis de Acesso", consultaPerfil.getNome());
		assertEquals("perfilconsulta.action", consultaPerfil.getUrl());

		// Cadastro de Usuarios

		ObjetoVo cadastroUsuario = be.get(PMOConstants.Objeto.USUARIO_CADASTRO);
		assertEquals(new Integer(PMOConstants.Objeto.USUARIO_CADASTRO), cadastroUsuario.getIdObjeto());
		assertEquals("Cadastro de Usuários", cadastroUsuario.getNome());
		assertEquals("usuariocadastro.action", cadastroUsuario.getUrl());
	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
//			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
			System.getProperties().load(new FileInputStream("teste-oracle.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		be = new ObjetoBe(manager);

	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
