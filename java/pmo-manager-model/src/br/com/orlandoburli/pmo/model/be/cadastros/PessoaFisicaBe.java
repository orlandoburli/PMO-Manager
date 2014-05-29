package br.com.orlandoburli.pmo.model.be.cadastros;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaFisicaDao;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;

public class PessoaFisicaBe extends BaseBe<PessoaFisicaVo, PessoaFisicaDao>{

	public PessoaFisicaBe(DAOManager manager) {
		super(manager);
	}

}
