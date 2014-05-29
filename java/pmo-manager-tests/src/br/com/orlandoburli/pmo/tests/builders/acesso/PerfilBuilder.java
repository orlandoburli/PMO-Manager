package br.com.orlandoburli.pmo.tests.builders.acesso;

import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;

public final class PerfilBuilder {

	public static PerfilVo criaPerfil(String nome, String ativo) {

		PerfilVo perfil = new PerfilVo();

		perfil.setNome(nome);
		perfil.setAtivo(ativo);

		return perfil;
	}

	public static PerfilVo criaPerfilAdmin() {
		return criaPerfil("Admin", SimNao.SIM);
	}
}
