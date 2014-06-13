package br.com.orlandoburli.pmo.model.dao.cadastros;

import br.com.orlandoburli.framework.core.dao.BaseCadastroDao;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;

public class PessoaJuridicaDao extends BaseCadastroDao<PessoaJuridicaVo> {

	public PessoaJuridicaDao(DAOManager manager) {
		super(manager);
	}

}
