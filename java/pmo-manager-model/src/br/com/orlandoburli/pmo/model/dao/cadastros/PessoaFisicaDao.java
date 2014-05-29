package br.com.orlandoburli.pmo.model.dao.cadastros;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;

public class PessoaFisicaDao extends BaseCadastroDao<PessoaFisicaVo>{

	public PessoaFisicaDao(DAOManager manager) {
		super(manager);
	}

}
