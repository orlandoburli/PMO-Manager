package br.com.orlandoburli.pmo.tests.reuniao;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.dao.exceptions.DAOException;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.pmo.model.be.reuniao.SalaReuniaoBe;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;
import br.com.orlandoburli.pmo.model.vo.reuniao.SalaReuniaoVo;
import br.com.orlandoburli.pmo.tests.builders.reuniao.SalaReuniaoBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

public class SalaReuniaoTests {

	private DAOManager manager;
	private SalaReuniaoBe salaReuniaoBe;

	@Test
	public void testaCadastro() throws BeException {
		salaReuniaoBe.save(SalaReuniaoBuilder.criaSalaPrincipal());

		salaReuniaoBe.save(SalaReuniaoBuilder.criaSalaTI());
	}

	@Test
	public void testaCadastroNomeVazio() {
		SalaReuniaoVo sala = SalaReuniaoBuilder.criaSalaPrincipal();

		sala.setNome("");

		try {
			salaReuniaoBe.save(sala);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de campo nome vazio");
	}

	@Test
	public void testaCadastroNomeNulo() {
		SalaReuniaoVo sala = SalaReuniaoBuilder.criaSalaPrincipal();

		sala.setNome(null);

		try {
			salaReuniaoBe.save(sala);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de campo nome nulo");
	}

	@Test
	public void testaCadastroNomeMaiorQue100() {
		SalaReuniaoVo sala = SalaReuniaoBuilder.criaSalaPrincipal();

		sala.setNome(Utils.fillString("Sala Teste", "X", 101, 1));

		try {
			salaReuniaoBe.save(sala);
		} catch (BeException e) {
			assertEquals("O Tamanho máximo do campo Nome é de 100. Informado: 101", e.getMessage());
			return;
		}

		fail("Falha na validacao de campo nome maior que 100");
	}

	@Test
	public void testaCadastroCampoAtivoErrado() {
		SalaReuniaoVo sala = SalaReuniaoBuilder.criaSalaPrincipal();

		sala.setAtivo("X");

		try {
			salaReuniaoBe.save(sala);
		} catch (BeException e) {
			assertEquals("Valor 'X' não permitido em Ativo! Valores permitidos são S, N.", e.getMessage());
			return;
		}

		fail("Falha na validacao de campo ativo errado");
	}

	@Test
	public void testaCadastroCampoAtivoVazio() {
		SalaReuniaoVo sala = SalaReuniaoBuilder.criaSalaPrincipal();

		sala.setAtivo("");

		try {
			salaReuniaoBe.save(sala);
		} catch (BeException e) {
			assertEquals("Campo Ativo é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de campo ativo vazio");
	}

	@Test
	public void testaCadastroCampoAtivoNulo() {
		SalaReuniaoVo sala = SalaReuniaoBuilder.criaSalaPrincipal();

		sala.setAtivo(null);

		try {
			salaReuniaoBe.save(sala);
		} catch (BeException e) {
			assertEquals("Campo Ativo é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validacao de campo ativo nulo");
	}

	@Test
	public void testaCadastroNomeDuplicado() throws BeException {
		SalaReuniaoVo sala1 = SalaReuniaoBuilder.criaSalaPrincipal();

		salaReuniaoBe.save(sala1);

		SalaReuniaoVo sala2 = SalaReuniaoBuilder.criaSalaPrincipal();

		try {
			salaReuniaoBe.save(sala2);
		} catch (BeException e) {
			assertEquals("Já existe uma sala com o nome \"" + sala2.getNome() + "\"!", e.getMessage());
			return;
		}

		fail("Falha na validação do nome duplicado");
	}

	@Test
	public void testaCadastroNomeDuplicado2() throws BeException {
		SalaReuniaoVo sala1 = SalaReuniaoBuilder.criaSalaPrincipal();

		salaReuniaoBe.save(sala1);

		SalaReuniaoVo sala2 = SalaReuniaoBuilder.criaSalaPrincipal();
		sala2.setAtivo(SimNao.NAO);

		salaReuniaoBe.save(sala2);

		sala1.setAtivo(SimNao.NAO);
		salaReuniaoBe.save(sala1);

		sala2.setAtivo(SimNao.SIM);
		salaReuniaoBe.save(sala2);
	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		salaReuniaoBe = new SalaReuniaoBe(manager);

	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
