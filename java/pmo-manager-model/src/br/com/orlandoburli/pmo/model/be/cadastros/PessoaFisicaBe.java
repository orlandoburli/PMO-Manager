package br.com.orlandoburli.pmo.model.be.cadastros;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaFisicaDao;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.domains.Natureza;

public class PessoaFisicaBe extends BaseBe<PessoaFisicaVo, PessoaFisicaDao> {

	public PessoaFisicaBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(PessoaFisicaVo vo) throws BeException {
		super.doBeforeSave(vo);

		if (vo.getPessoa() != null) {
			if (!vo.getPessoa().getNatureza().equals(Natureza.FISICA)) {
				throw new SaveBeException("Pessoa não é do tipo FÍSICA!", "natureza");
			}
		}

		// Salva a pessoa antes
		new PessoaBe(getManager()).save(vo.getPessoa());

		// Seta o id da pessoa recebido
		vo.setIdPessoa(vo.getPessoa().getIdPessoa());
	}

}
