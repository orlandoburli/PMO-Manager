package br.com.orlandoburli.pmo.tests.projetos;

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
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.pmo.model.be.projetos.ProjetoBe;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;
import br.com.orlandoburli.pmo.tests.builders.projetos.ProjetoBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

@RunWith(JUnit4.class)
public class ProjetoTests {

	private DAOManager manager;
	private ProjetoBe projetoBe;

	@Test
	public void testaCadastroProjeto() throws BeException {
		ProjetoVo projetoDemo1 = ProjetoBuilder.criaProjetoDemo1();

		projetoBe.save(projetoDemo1);

		ProjetoVo projetoDemo2 = projetoBe.get(projetoDemo1);

		assertEquals(projetoDemo1.getNome(), projetoDemo2.getNome());
		assertEquals(projetoDemo1.getIdProjeto(), projetoDemo2.getIdProjeto());
		assertEquals(projetoDemo1.getDescricao(), projetoDemo2.getDescricao());
		assertEquals(projetoDemo1.getDataInicial(), projetoDemo2.getDataInicial());
		assertEquals(projetoDemo1.getDataFinal(), projetoDemo2.getDataFinal());
	}

	@Test
	public void testaCadastroNomeVazio() {
		ProjetoVo projetoDemo1 = ProjetoBuilder.criaProjetoDemo1();
		projetoDemo1.setNome("  ");

		try {
			projetoBe.save(projetoDemo1);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validação de nome vazio.");
	}

	@Test
	public void testaCadastroNomeNulo() {
		ProjetoVo projetoDemo1 = ProjetoBuilder.criaProjetoDemo1();
		projetoDemo1.setNome(null);

		try {
			projetoBe.save(projetoDemo1);
		} catch (BeException e) {
			assertEquals("Campo Nome é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validação de nome nulo.");
	}

	@Test
	public void testaCadastroDataFinalAntesDataInicial() {
		ProjetoVo projetoDemo1 = ProjetoBuilder.criaProjetoDemo1();
		projetoDemo1.setDataInicial(Utils.toCalendar("01/01/2014"));
		projetoDemo1.setDataFinal(Utils.toCalendar("01/01/2013"));

		try {
			projetoBe.save(projetoDemo1);
		} catch (BeException e) {
			assertEquals("A Data Final não pode ser posterior à Data Inicial!", e.getMessage());
			return;
		}

		fail("Falha na validação de datas.");
	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		projetoBe = new ProjetoBe(manager);
	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
