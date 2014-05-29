package br.com.orlandoburli.pmo.tests.suites;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.orlandoburli.pmo.tests.acesso.PerfilTests;
import br.com.orlandoburli.pmo.tests.acesso.UsuarioTests;
import br.com.orlandoburli.pmo.tests.cadastros.PessoaTests;

@RunWith(Suite.class)
@SuiteClasses({ PerfilTests.class, UsuarioTests.class, PessoaTests.class })
public class AllPostgresTests {

	public static void prepare() {
		try {
			System.getProperties().load(new FileInputStream("teste-postgres.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
