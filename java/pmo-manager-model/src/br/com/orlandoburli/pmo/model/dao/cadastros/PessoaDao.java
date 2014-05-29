package br.com.orlandoburli.pmo.model.dao.cadastros;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;

public class PessoaDao extends BaseCadastroDao<PessoaVo>{

	public PessoaDao(DAOManager manager) {
		super(manager);
	}

}
