package br.com.orlandoburli.pmo.tests.suites;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.orlandoburli.pmo.tests.acesso.MenuTests;
import br.com.orlandoburli.pmo.tests.acesso.ObjetoTests;
import br.com.orlandoburli.pmo.tests.acesso.PerfilTests;
import br.com.orlandoburli.pmo.tests.acesso.UsuarioTests;
import br.com.orlandoburli.pmo.tests.cadastros.CargoTests;
import br.com.orlandoburli.pmo.tests.cadastros.PessoaFisicaTests;
import br.com.orlandoburli.pmo.tests.cadastros.PessoaJuridicaTests;
import br.com.orlandoburli.pmo.tests.cadastros.PessoaTests;
import br.com.orlandoburli.pmo.tests.projetos.ProjetoTests;
import br.com.orlandoburli.pmo.tests.projetos.TermoAberturaInteressadoTests;
import br.com.orlandoburli.pmo.tests.projetos.TermoAberturaTests;
import br.com.orlandoburli.pmo.tests.reuniao.SalaReuniaoTests;

@RunWith(Suite.class)
@SuiteClasses({ MenuTests.class, ObjetoTests.class, PerfilTests.class, UsuarioTests.class, PessoaTests.class, PessoaFisicaTests.class, PessoaJuridicaTests.class, CargoTests.class, ProjetoTests.class, TermoAberturaTests.class, TermoAberturaInteressadoTests.class, SalaReuniaoTests.class })
public class AllPostgresTests {

	@BeforeClass
	public static void prepare() {
		try {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
