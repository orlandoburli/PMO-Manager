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
import br.com.orlandoburli.pmo.model.be.acesso.UsuarioBe;
import br.com.orlandoburli.pmo.model.be.acesso.exceptions.EmailDuplicadoException;
import br.com.orlandoburli.pmo.model.be.acesso.exceptions.LoginDuplicadoException;
import br.com.orlandoburli.pmo.model.be.acesso.exceptions.LoginInvalidoException;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;
import br.com.orlandoburli.pmo.tests.builders.acesso.PerfilBuilder;
import br.com.orlandoburli.pmo.tests.builders.acesso.UsuarioBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UsuarioTests {

	private DAOManager manager;
	private UsuarioBe usuarioBe;
	private PerfilVo admin;

	@Test
	public void testaCadastroUsuario() throws BeException {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);

		usuarioBe.save(orlando);

		UsuarioVo orlando2 = usuarioBe.getByEmail(orlando.getEmail());

		assertEquals(orlando.getEmail(), orlando2.getEmail());

		assertEquals(orlando.getNome(), orlando2.getNome());

		assertEquals(orlando.getLogin(), orlando2.getLogin());

		assertEquals(orlando.getAtivo(), orlando2.getAtivo());
	}

	@Test
	public void testaCadastroNomeVazio() {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);
		orlando.setNome("");

		try {
			usuarioBe.save(orlando);
		} catch (BeException e) {
			assertEquals(e.getMessage(), "Campo Nome é obrigatório!");
			return;
		}

		fail("Validação de nome vazio falhou!");
	}

	@Test
	public void testaCadastroLoginVazio() {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);
		orlando.setLogin("");

		try {
			usuarioBe.save(orlando);
		} catch (BeException e) {
			assertEquals(e.getMessage(), "Campo Login é obrigatório!");
			return;
		}

		fail("Validação de login vazio falhou!");
	}

	@Test
	public void testaCadastroAtivoVazio() {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);
		orlando.setAtivo(null);

		try {
			usuarioBe.save(orlando);
		} catch (BeException e) {
			assertEquals(e.getMessage(), "Campo ativo é obrigatório!");
			return;
		}

		fail("Validação de ativo vazio falhou!");
	}

	@Test
	public void testaCadastroAtivoErrado() {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);
		orlando.setAtivo("X");

		try {
			usuarioBe.save(orlando);
		} catch (BeException e) {
			assertEquals(e.getMessage(), "Valor 'X' não permitido em ativo! Valores permitidos são S, N.");
			return;
		}

		fail("Validação de ativo errado falhou!");
	}

	@Test(expected = EmailDuplicadoException.class)
	public void testaCadastroEmailDuplicado() throws BeException {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);

		usuarioBe.save(orlando);

		UsuarioVo joao = UsuarioBuilder.criaJoao(admin);
		joao.setEmail(orlando.getEmail());

		usuarioBe.save(joao);

		fail("Cadastro duplicado de emails falhou!");
	}

	@Test(expected = LoginDuplicadoException.class)
	public void testaCadastroLoginDuplicado() throws BeException {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);

		usuarioBe.save(orlando);

		UsuarioVo joao = UsuarioBuilder.criaJoao(admin);
		joao.setLogin(orlando.getLogin());

		usuarioBe.save(joao);

		fail("Cadastro duplicado de emails falhou!");
	}
	
	@Test
	public void testaCadastroPerfilVazio() {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(null);

		try {
			usuarioBe.save(orlando);
		} catch (BeException e) {
			assertEquals(e.getMessage(), "Campo Perfil é obrigatório!");
			return;
		}

		fail("Validação de perfil vazio falhou!");
	}

	@Test
	public void testaLogin() throws BeException {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);

		usuarioBe.save(orlando);

		usuarioBe.login(orlando.getLogin(), orlando.getSenha());
	}

	@Test(expected = LoginInvalidoException.class)
	public void testaLoginInativo() throws BeException {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);

		orlando.setAtivo(SimNao.NAO);

		usuarioBe.save(orlando);

		usuarioBe.login(orlando.getLogin(), orlando.getSenha());
	}

	@Test(expected = LoginInvalidoException.class)
	public void testaLoginInvalido() throws BeException {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);

		usuarioBe.save(orlando);

		usuarioBe.login("xxx", orlando.getSenha());
	}

	@Test(expected = LoginInvalidoException.class)
	public void testaSenhaErrada() throws BeException {
		UsuarioVo orlando = UsuarioBuilder.criaOrlando(admin);

		usuarioBe.save(orlando);

		usuarioBe.login(orlando.getLogin(), "x123123");
	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException, BeException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		usuarioBe = new UsuarioBe(manager);

		admin = PerfilBuilder.criaPerfilAdmin();

		new PerfilBe(manager).save(admin);
	}

	@After
	public void finalizar() {
		manager.commit();
	}

}
