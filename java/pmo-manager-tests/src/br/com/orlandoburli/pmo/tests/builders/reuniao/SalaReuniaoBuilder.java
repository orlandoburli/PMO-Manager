package br.com.orlandoburli.pmo.tests.builders.reuniao;

import br.com.orlandoburli.pmo.model.vo.domains.SimNao;
import br.com.orlandoburli.pmo.model.vo.reuniao.SalaReuniaoVo;

public class SalaReuniaoBuilder {

	public static SalaReuniaoVo criaSalaReuniao(String nome, String ativo) {
		SalaReuniaoVo sala = new SalaReuniaoVo();
		sala.setNome(nome);
		sala.setAtivo(ativo);
		return sala;
	}

	public static SalaReuniaoVo criaSalaPrincipal() {
		return criaSalaReuniao("Sala Principal", SimNao.SIM);
	}
	
	public static SalaReuniaoVo criaSalaTI() {
		return criaSalaReuniao("Sala TI", SimNao.SIM);
	}
}
