package br.com.orlandoburli.pmo.model.be.projetos;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaAprovacaoDao;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaAprovacaoVo;

public class TermoAberturaAprovacaoBe extends BaseBe<TermoAberturaAprovacaoVo, TermoAberturaAprovacaoDao> {

	public TermoAberturaAprovacaoBe(DAOManager manager) {
		super(manager);
	}

}
