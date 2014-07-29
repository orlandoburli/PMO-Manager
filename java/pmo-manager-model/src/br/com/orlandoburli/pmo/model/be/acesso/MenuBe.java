package br.com.orlandoburli.pmo.model.be.acesso;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.pmo.model.dao.acesso.MenuDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.utils.PMOConstants;
import br.com.orlandoburli.pmo.model.vo.acesso.MenuVo;

public class MenuBe extends BaseBe<MenuVo, MenuDao> {

	public MenuBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeInsert(MenuVo vo) throws BeException {
		super.doBeforeInsert(vo);

		if (get(vo) != null) {
			throw new SaveBeException("Menu com o Id " + vo.getIdMenu() + " já cadastrado!", "idMenu");
		}
	}

	public void inicializarMenus() throws BeException {
		saveIfNotExists(criaMenu(PMOConstants.Menu.DASHBOARD, PMOConstants.Objeto.PAINEL, null, "Painel", "icon-dashboard", 0, null));
		saveIfNotExists(criaMenu(PMOConstants.Menu.ACESSO, null, null, "Acesso", "icon-users", 1, null));

		saveIfNotExists(criaMenu(PMOConstants.Menu.PARAMETROS, PMOConstants.Objeto.PARAMETRO_CONSULTA, PMOConstants.Objeto.PARAMETRO_CADASTRO, "Parâmetros", "", 1, PMOConstants.Menu.ACESSO));
		saveIfNotExists(criaMenu(PMOConstants.Menu.PERFIS, PMOConstants.Objeto.PERFIL_CONSULTA, PMOConstants.Objeto.PERFIL_CADASTRO, "Perfis", "", 2, PMOConstants.Menu.ACESSO));
		saveIfNotExists(criaMenu(PMOConstants.Menu.USUARIOS, PMOConstants.Objeto.USUARIO_CONSULTA, PMOConstants.Objeto.USUARIO_CADASTRO, "Usuários", "", 3, PMOConstants.Menu.ACESSO));

		saveIfNotExists(criaMenu(PMOConstants.Menu.CADASTROS, null, null, "Cadastros", "icon-credit", 2, null));
		saveIfNotExists(criaMenu(PMOConstants.Menu.CARGOS, PMOConstants.Objeto.CARGO_CONSULTA, PMOConstants.Objeto.CARGO_CADASTRO, "Cargos", "", 1, PMOConstants.Menu.CADASTROS));
		saveIfNotExists(criaMenu(PMOConstants.Menu.PESSOA_FISICA, PMOConstants.Objeto.PESSOA_FISICA_CONSULTA, PMOConstants.Objeto.PESSOA_FISICA_CADASTRO, "Pessoas Físicas", "", 2, PMOConstants.Menu.CADASTROS));
		saveIfNotExists(criaMenu(PMOConstants.Menu.PESSOA_JURIDICA, PMOConstants.Objeto.PESSOA_JURIDICA_CONSULTA, PMOConstants.Objeto.PESSOA_JURIDICA_CADASTRO, "Pessoas Jurídicas", "", 3, PMOConstants.Menu.CADASTROS));
		
		saveIfNotExists(criaMenu(PMOConstants.Menu.PROJETOS, null, null, "Projetos", "icon-office", 3, null));
		saveIfNotExists(criaMenu(PMOConstants.Menu.PROJETO, PMOConstants.Objeto.PROJETO_CONSULTA, PMOConstants.Objeto.PROJETO_CADASTRO, "Projetos", "icon-office", 1, PMOConstants.Menu.PROJETOS));

	}

	public void saveIfNotExists(MenuVo menu) throws BeException {
		if (get(menu) != null) {
			Log.info("Menu com o id " + menu.getIdMenu() + "encontrado, atualizando!");
			menu.setNew(false);
		}
		save(menu);
	}

	public MenuVo criaMenu(Integer idMenu, Integer idObjeto, Integer idObjetoSecundario, String nome, String classe, Integer ordem, Integer idMenuPai) {
		MenuVo menu = new MenuVo();

		menu.setIdMenu(idMenu);
		menu.setIdMenuPai(idMenuPai);
		menu.setIdObjeto(idObjeto);
		menu.setIdObjetoSecundario(idObjetoSecundario);
		menu.setClasse(classe);
		menu.setNome(nome);
		menu.setOrdem(ordem);

		return menu;
	}

	public List<MenuVo> getMenus() throws ListException {
		String sql = Dicionario.Menu.TABELA_MENU + "." + Dicionario.Menu.Colunas.ID_MENU_PAI + " IS NULL";
		List<MenuVo> rootMenus = getList(null, sql, Dicionario.Menu.TABELA_MENU + "." + Dicionario.Menu.Colunas.ORDEM);

		// Busca os sub-menus de cada um
		for (MenuVo root : rootMenus) {
			root.setSubMenus(getListChildren(root));
		}

		return rootMenus;
	}

	public List<MenuVo> getListChildren(MenuVo menuPai) throws ListException {
		MenuVo filter = new MenuVo();
		filter.setIdMenuPai(menuPai.getIdMenu());
		return getList(filter, null, Dicionario.Menu.TABELA_MENU + "." + Dicionario.Menu.Colunas.ORDEM);
	}

}
