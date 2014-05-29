package br.com.orlandoburli.pmo.tests.builders.acesso;

import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;

public final class UsuarioBuilder {

	public static UsuarioVo criaUsuario(String nome, String email, String login, String senha, String ativo, PerfilVo perfil) {
		UsuarioVo usuario = new UsuarioVo();

		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setAtivo(ativo);
		
		if (perfil != null) {
			usuario.setIdPerfil(perfil.getIdPerfil());
			usuario.setPerfil(perfil);
		}
		
		return usuario;
	}

	public static UsuarioVo criaOrlando(PerfilVo perfil) {
		return criaUsuario("Orlando Burli Junior", "orlando.burli@gmail.com", "oburli", "123123", SimNao.SIM, perfil);
	}

	public static UsuarioVo criaJoao(PerfilVo perfil) {
		return criaUsuario("Joao Antonio", "joao@gmail.com", "joao", "asdqwe", SimNao.SIM, perfil);
	}
}
