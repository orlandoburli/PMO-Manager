package br.com.orlandoburli.pmo.tests.builders.projetos;

import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.StatusTermoAbertura;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;

public class TermoAberturaBuilder {

	public static TermoAberturaVo criaTermo(ProjetoVo projeto, String justificativa, String objetivos, String descricaoProduto, PessoaFisicaVo gerente, String requisitos, String riscos, String marcos, String investimento, String patrocinador, int statusTermoAbertura) {
		TermoAberturaVo termo = new TermoAberturaVo();

		termo.setProjeto(projeto);
		termo.setJustificativa(justificativa);
		termo.setObjetivos(objetivos);
		termo.setDescricaoProduto(descricaoProduto);
		termo.setGerente(gerente);
		termo.setRequisitos(requisitos);
		termo.setRiscos(riscos);
		termo.setMarcos(marcos);
		termo.setInvestimento(investimento);
		termo.setPatrocinador(patrocinador);
		termo.setStatusTermoAbertura(statusTermoAbertura);

		return termo;
	}

	public static TermoAberturaVo criaTermo(ProjetoVo projeto, PessoaFisicaVo gerente) {
		return criaTermo(projeto, "Justificativa do projeto demo1", "Objetivo aqui é testar unitariamente o sistema", "Projeto PMO", gerente, "Java J2SE 1.6 - Tomcat 7", "Risco de dar errado???", "Entrega inicial: hoje", "Investimento de tempo e trabalho.", "Tribunal de Contas", StatusTermoAbertura.EM_ELABORACAO);
	}
}
