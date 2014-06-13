package br.com.orlandoburli.pmo.web.actions.cadastro.pessoajuridica;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaJuridicaBe;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaJuridicaDao;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;
import br.com.orlandoburli.pmo.model.vo.domains.Natureza;

public class PessoaJuridicaCadastroAction extends BaseCadastroAction<PessoaJuridicaVo, PessoaJuridicaDao, PessoaJuridicaBe>{

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/cadastro/pessoajuridica/pessoajuridicacadastro.jsp";
	}

	@Override
	public void doBeforeSalvar(PessoaJuridicaVo vo, DAOManager manager) throws SaveBeException {
		super.doBeforeSalvar(vo, manager);

		vo.getPessoa().setNatureza(Natureza.JURIDICA);
	}

}
