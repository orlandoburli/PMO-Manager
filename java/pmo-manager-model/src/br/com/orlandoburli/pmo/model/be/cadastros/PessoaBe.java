package br.com.orlandoburli.pmo.model.be.cadastros;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaDao;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;

public class PessoaBe extends BaseBe<PessoaVo, PessoaDao> {

	public PessoaBe(DAOManager manager) {
		super(manager);
	}

}
