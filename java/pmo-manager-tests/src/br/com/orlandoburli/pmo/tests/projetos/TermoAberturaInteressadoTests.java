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
import br.com.orlandoburli.pmo.model.be.cadastros.CargoBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaFisicaBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaJuridicaBe;
import br.com.orlandoburli.pmo.model.be.projetos.ProjetoBe;
import br.com.orlandoburli.pmo.model.be.projetos.TermoAberturaBe;
import br.com.orlandoburli.pmo.model.be.projetos.TermoAberturaInteressadoBe;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaInteressadoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;
import br.com.orlandoburli.pmo.tests.builders.cadastros.CargoBuilder;
import br.com.orlandoburli.pmo.tests.builders.cadastros.PessoaBuilder;
import br.com.orlandoburli.pmo.tests.builders.projetos.ProjetoBuilder;
import br.com.orlandoburli.pmo.tests.builders.projetos.TermoAberturaBuilder;
import br.com.orlandoburli.pmo.tests.builders.projetos.TermoAberturaInteressadoBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

@RunWith(JUnit4.class)
public class TermoAberturaInteressadoTests {

	private DAOManager manager;
	private ProjetoBe projetoBe;
	private TermoAberturaBe termoAberturaBe;
	private CargoBe cargoBe;
	private PessoaFisicaBe pessoaFisicaBe;
	private PessoaJuridicaBe pessoaJuridicaBe;
	private ProjetoVo projetoDemo1;
	private PessoaFisicaVo orlando;
	private PessoaFisicaVo andreCruz;
	private PessoaFisicaVo natalina;
	private CargoVo analista;
	private CargoVo gerente;
	private CargoVo secretario;
	private TermoAberturaVo termoV1;
	private TermoAberturaInteressadoBe termoAberturaInteressadoBe;

	@Test
	public void testaCadastro() throws BeException {
		TermoAberturaInteressadoVo interessadoAndre = TermoAberturaInteressadoBuilder.criaInteressado(termoV1, andreCruz.getPessoa(), andreCruz.getCargo().getNome());

		termoAberturaInteressadoBe.save(interessadoAndre);
	}

	@Test
	public void testaCadastroSemPessoa() {
		TermoAberturaInteressadoVo interessadoAndre = TermoAberturaInteressadoBuilder.criaInteressado(termoV1, null, andreCruz.getCargo().getNome());

		try {
			termoAberturaInteressadoBe.save(interessadoAndre);
		} catch (BeException e) {
			assertEquals("Campo Pessoa é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validação sem pessoa.");
	}

	@Test
	public void testaCadastroSemFuncaoNulo() {
		TermoAberturaInteressadoVo interessadoAndre = TermoAberturaInteressadoBuilder.criaInteressado(termoV1, andreCruz.getPessoa(), null);

		try {
			termoAberturaInteressadoBe.save(interessadoAndre);
		} catch (BeException e) {
			assertEquals("Campo Função é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validação sem função (nulo).");
	}

	@Test
	public void testaCadastroSemFuncaoVazio() {
		TermoAberturaInteressadoVo interessadoAndre = TermoAberturaInteressadoBuilder.criaInteressado(termoV1, andreCruz.getPessoa(), "   ");

		try {
			termoAberturaInteressadoBe.save(interessadoAndre);
		} catch (BeException e) {
			assertEquals("Campo Função é obrigatório!", e.getMessage());
			return;
		}

		fail("Falha na validação sem função (vazio).");
	}

	@Test
	public void testaCadastroInteressadoDuplicado() throws BeException {
		TermoAberturaInteressadoVo interessadoAndre = TermoAberturaInteressadoBuilder.criaInteressado(termoV1, andreCruz.getPessoa(), andreCruz.getCargo().getNome());

		termoAberturaInteressadoBe.save(interessadoAndre);

		TermoAberturaInteressadoVo interessadoAndre2 = TermoAberturaInteressadoBuilder.criaInteressado(termoV1, andreCruz.getPessoa(), andreCruz.getCargo().getNome());

		try {
			termoAberturaInteressadoBe.save(interessadoAndre2);
		} catch (BeException e) {
			assertEquals("Interessado já vinculado a este termo!", e.getMessage());
			return;
		}

		fail("Falha na validação do interessado duplicado.");
	}

	public void criaDadosTeste() throws BeException {
		analista = CargoBuilder.criaCargoAnalista();
		gerente = CargoBuilder.criaCargoGerente();
		secretario = CargoBuilder.criaCargoSecretario();

		cargoBe.save(analista);
		cargoBe.save(gerente);
		cargoBe.save(secretario);

		// Cria as pessoas fisicas
		orlando = PessoaBuilder.criaPfOrlando(PessoaBuilder.criaPessoaOrlando(), analista);
		andreCruz = PessoaBuilder.criaPfAndreCruz(PessoaBuilder.criaPessoaAndreCruz(), gerente);
		natalina = PessoaBuilder.criaPfNatalina(PessoaBuilder.criaPessoaNatalina(), secretario);

		pessoaFisicaBe.save(orlando);
		pessoaFisicaBe.save(andreCruz);
		pessoaFisicaBe.save(natalina);

		// Cria as Pessoas Juridicas
		PessoaJuridicaVo abaco = PessoaBuilder.criaPjAbaco(PessoaBuilder.criaPessoaAbaco());
		PessoaJuridicaVo tce = PessoaBuilder.criaPjTCE(PessoaBuilder.criaPessoaTCE());

		pessoaJuridicaBe.save(abaco);
		pessoaJuridicaBe.save(tce);

		// Cria o projeto
		projetoDemo1 = ProjetoBuilder.criaProjetoDemo1();

		projetoBe.save(projetoDemo1);

		termoV1 = TermoAberturaBuilder.criaTermo(projetoDemo1, andreCruz);
		termoAberturaBe.save(termoV1);

	}

	@Before
	public void initialize() throws FileNotFoundException, IOException, DAOException, BeException {

		// Load properties
		if (System.getProperty("sql.builder.class") == null || System.getProperty("sql.builder.class").trim().equals("")) {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		}

		manager = DAOManager.getDAOManager();

		TesteUtils.clearDB(manager);

		projetoBe = new ProjetoBe(manager);
		termoAberturaBe = new TermoAberturaBe(manager);
		cargoBe = new CargoBe(manager);
		pessoaFisicaBe = new PessoaFisicaBe(manager);
		pessoaJuridicaBe = new PessoaJuridicaBe(manager);
		termoAberturaInteressadoBe = new TermoAberturaInteressadoBe(manager);

		criaDadosTeste();
	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
