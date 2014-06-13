package br.com.orlandoburli.pmo.tests.builders.projetos;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;

public class ProjetoBuilder {

	public static ProjetoVo criaProjeto(String nome, String descricao, Calendar dataInicial, Calendar dataFinal) {
		ProjetoVo projeto = new ProjetoVo();

		projeto.setNome(nome);
		projeto.setDescricao(descricao);

		projeto.setDataInicial(dataInicial);
		projeto.setDataFinal(dataFinal);

		return projeto;
	}

	public static ProjetoVo criaProjetoDemo1() {
		return criaProjeto("Projeto Demonstração 1", "Projeto escrito para testes", Utils.toCalendar("01/01/2014"), Utils.toCalendar("31/12/2014"));
	}
}
