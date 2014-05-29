package br.com.orlandoburli.pmo.tests.builders.cadastros;

import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import br.com.orlandoburli.pmo.model.vo.domains.Natureza;

public final class PessoaBuilder {

	public static PessoaVo criaPessoa(String nome, String natureza) {
		PessoaVo pessoa = new PessoaVo();

		pessoa.setNome(nome);
		pessoa.setNatureza(natureza);

		return pessoa;
	}
	
	public static PessoaVo criaPessoaOrlando() {
		return criaPessoa("Orlando Burli Junior", Natureza.FISICA);
	}
	
	
}
