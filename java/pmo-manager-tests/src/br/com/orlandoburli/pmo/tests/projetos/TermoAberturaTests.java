package br.com.orlandoburli.pmo.tests.projetos;

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
import br.com.orlandoburli.pmo.model.be.cadastros.CargoBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaFisicaBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaJuridicaBe;
import br.com.orlandoburli.pmo.model.be.projetos.ProjetoBe;
import br.com.orlandoburli.pmo.model.be.projetos.TermoAberturaBe;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.StatusTermoAbertura;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;
import br.com.orlandoburli.pmo.tests.builders.cadastros.CargoBuilder;
import br.com.orlandoburli.pmo.tests.builders.cadastros.PessoaBuilder;
import br.com.orlandoburli.pmo.tests.builders.projetos.ProjetoBuilder;
import br.com.orlandoburli.pmo.tests.builders.projetos.TermoAberturaBuilder;
import br.com.orlandoburli.pmo.tests.utils.TesteUtils;

public class TermoAberturaTests {

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

	@Test
	public void testaCadastroTermoAbertura() throws BeException {
		TermoAberturaVo termoV1 = TermoAberturaBuilder.criaTermo(projetoDemo1, andreCruz);

		termoAberturaBe.save(termoV1);

		assertNotNull(termoV1.getIdProjeto());

		assertEquals(new Integer(1), termoV1.getVersao());
	}

	@Test
	public void testaFinalizarTermoAbertura() throws BeException {
		TermoAberturaVo termoV1 = TermoAberturaBuilder.criaTermo(projetoDemo1, andreCruz);

		termoAberturaBe.save(termoV1);

		termoAberturaBe.finalizar(termoV1);
	}

	@Test
	public void testaNovaVersaoTermo() throws BeException {
		// Cria a primeira versao do termo
		TermoAberturaVo termoV1 = TermoAberturaBuilder.criaTermo(projetoDemo1, andreCruz);
		termoAberturaBe.save(termoV1);

		// Atualiza o termo para finalizado, para poder criar a segunda versao
		termoAberturaBe.finalizar(termoV1);

		assertNotNull(termoV1.getIdProjeto());

		TermoAberturaVo termoV2 = termoAberturaBe.novaVersao(termoV1);

		assertNotNull(termoV2.getIdProjeto());

		termoAberturaBe.save(termoV2);

		// Atualiza com os dados do banco de dados
		termoV1 = termoAberturaBe.get(termoV1);
		termoV2 = termoAberturaBe.get(termoV2);

		assertEquals(termoV1.getProjeto().getIdProjeto(), termoV2.getProjeto().getIdProjeto());
		assertEquals(termoV1.getGerente().getIdPessoa(), termoV2.getGerente().getIdPessoa());
		assertEquals(new Integer(termoV1.getVersao() + 1), termoV2.getVersao());
		assertEquals(termoV1.getJustificativa(), termoV2.getJustificativa());
		assertEquals(termoV1.getObjetivos(), termoV2.getObjetivos());
		assertEquals(termoV1.getDescricaoProduto(), termoV2.getDescricaoProduto());
		assertEquals(termoV1.getRequisitos(), termoV2.getRequisitos());
		assertEquals(termoV1.getRiscos(), termoV2.getRiscos());
		assertEquals(termoV1.getMarcos(), termoV2.getMarcos());
		assertEquals(termoV1.getInvestimento(), termoV2.getInvestimento());
		assertEquals(termoV1.getPatrocinador(), termoV2.getPatrocinador());

		assertEquals(termoV1.getIdTermoAbertura(), termoV2.getIdTermoReferencia());

		assertEquals(StatusTermoAbertura.CANCELADO, termoV1.getStatusTermoAbertura());
		assertEquals(StatusTermoAbertura.EM_ELABORACAO, termoV2.getStatusTermoAbertura());

		assertEquals(new Integer(2), termoV2.getVersao());

		termoV2.setDescricaoProduto("Produto Modificado.");

		// Finaliza o V2
		termoAberturaBe.finalizar(termoV2);

		// Cria a versao 3, baseada na V1
		TermoAberturaVo termoV3 = termoAberturaBe.novaVersao(termoV1);

		termoAberturaBe.save(termoV3);

		// Atualiza com os dados do banco de dados
		termoV1 = termoAberturaBe.get(termoV1);
		termoV2 = termoAberturaBe.get(termoV2);
		termoV3 = termoAberturaBe.get(termoV3);

		assertEquals(StatusTermoAbertura.CANCELADO, termoV1.getStatusTermoAbertura());
		assertEquals(StatusTermoAbertura.CANCELADO, termoV2.getStatusTermoAbertura());
		assertEquals(StatusTermoAbertura.EM_ELABORACAO, termoV3.getStatusTermoAbertura());

		assertEquals(termoV1.getDescricaoProduto(), termoV3.getDescricaoProduto());

	}

	@Test
	public void testaNovaVersaoSemFinalizar() throws BeException {
		TermoAberturaVo termoV1 = TermoAberturaBuilder.criaTermo(projetoDemo1, andreCruz);

		termoAberturaBe.save(termoV1);

		TermoAberturaVo termoV2 = termoAberturaBe.novaVersao(termoV1);

		try {
			termoAberturaBe.save(termoV2);
		} catch (BeException e) {
			assertEquals("Versão não pode ser criada, termo anterior ainda em elaboração!", e.getMessage());
			return;
		}

		fail("Falha no teste de nova versao sem finalizar");
	}

	@Test
	public void testaAlterarTermoFinalizado() throws BeException {
		TermoAberturaVo termoV1 = TermoAberturaBuilder.criaTermo(projetoDemo1, andreCruz);

		termoAberturaBe.save(termoV1);

		termoAberturaBe.finalizar(termoV1);

		try {
			termoAberturaBe.save(termoV1);
		} catch (BeException e) {
			return;
		}

		fail("Falha na validação de alterar termo finalizado.");
	}

	@Test
	public void testaAlterarTermoCancelado() throws BeException {
		TermoAberturaVo termoV1 = TermoAberturaBuilder.criaTermo(projetoDemo1, andreCruz);

		termoAberturaBe.save(termoV1);

		termoAberturaBe.cancelar(termoV1);

		try {
			termoAberturaBe.save(termoV1);
		} catch (BeException e) {
			return;
		}

		fail("Falha na validação de alterar termo cancelado.");
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

		criaDadosTeste();
	}

	@After
	public void finalizar() {
		manager.commit();
	}
}
