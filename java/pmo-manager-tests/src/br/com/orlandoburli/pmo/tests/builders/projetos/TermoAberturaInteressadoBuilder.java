package br.com.orlandoburli.pmo.tests.builders.projetos;

import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaInteressadoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;

public class TermoAberturaInteressadoBuilder {

	public static TermoAberturaInteressadoVo criaInteressado(TermoAberturaVo termo, PessoaVo pessoa, String funcao) {
		TermoAberturaInteressadoVo interessado = new TermoAberturaInteressadoVo();

		if (termo != null) {
			interessado.setTermo(termo);
			interessado.setIdTermo(termo.getIdTermoAbertura());
		}
		
		if (pessoa != null) {
			interessado.setPessoa(pessoa);
			interessado.setIdPessoa(pessoa.getIdPessoa());
		}
		
		interessado.setFuncao(funcao);

		return interessado;
	}
}
