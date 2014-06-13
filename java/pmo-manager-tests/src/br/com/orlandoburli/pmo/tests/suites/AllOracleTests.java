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

@RunWith(Suite.class)
@SuiteClasses({ MenuTests.class, ObjetoTests.class, PerfilTests.class, UsuarioTests.class, PessoaTests.class, PessoaFisicaTests.class, PessoaJuridicaTests.class, CargoTests.class })
public class AllOracleTests {

	@BeforeClass
	public static void prepare() {
		try {
			System.getProperties().load(new FileInputStream("teste-oracle.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
