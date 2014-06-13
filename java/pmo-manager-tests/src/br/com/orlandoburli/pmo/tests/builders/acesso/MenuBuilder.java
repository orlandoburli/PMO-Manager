package br.com.orlandoburli.pmo.tests.builders.acesso;

import br.com.orlandoburli.pmo.model.vo.acesso.MenuVo;
import br.com.orlandoburli.pmo.model.vo.acesso.ObjetoVo;

public final class MenuBuilder {

	public static MenuVo criaMenu(Integer idMenu, String nome, Integer ordem, String classe, ObjetoVo objeto, MenuVo menuPai) {
		MenuVo menu = new MenuVo();
		menu.setIdMenu(idMenu);
		menu.setNome(nome);
		menu.setOrdem(ordem);
		menu.setClasse(classe);
		if (objeto != null) {
			menu.setObjeto(objeto);
			menu.setIdObjeto(objeto.getIdObjeto());
		}

		if (menuPai != null) {
			menu.setIdMenuPai(menuPai.getIdMenu());
			menu.setMenuPai(menuPai);
		}
		return menu;
	}

	public static MenuVo criaMenuCadastros() {
		return criaMenu(1010, "Cadastros", 0, "", null, null);
	}

	public static MenuVo criaMenuUsuarios(MenuVo menuCadastros, ObjetoVo objetoUsuarios) {
		return criaMenu(1020, "Usuários", 1, "", objetoUsuarios, menuCadastros);
	}
}
