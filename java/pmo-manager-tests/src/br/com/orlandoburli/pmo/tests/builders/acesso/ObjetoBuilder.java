package br.com.orlandoburli.pmo.tests.builders.acesso;

import br.com.orlandoburli.pmo.model.vo.acesso.ObjetoVo;

public final class ObjetoBuilder {

	public static ObjetoVo criaObjeto(Integer idObjeto, String nome, String url) {
		ObjetoVo objeto = new ObjetoVo();
		
		objeto.setIdObjeto(idObjeto);
		objeto.setNome(nome);
		objeto.setUrl(url);
		
		return objeto;
	}
	
	public static ObjetoVo criaObjetoCadastroUsuario() {
		return criaObjeto(1000, "Cadastro de Usuários", "usuariocadastro.action");
	}
	
	public static ObjetoVo criaObjetoConsultaUsuario() {
		return criaObjeto(1010, "Consulta de Usuários", "usuarioconsulta.action");
	}
}
