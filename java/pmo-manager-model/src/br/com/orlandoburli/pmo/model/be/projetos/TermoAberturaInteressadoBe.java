package br.com.orlandoburli.pmo.model.be.projetos;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaInteressadoDao;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaInteressadoVo;

public class TermoAberturaInteressadoBe extends BaseBe<TermoAberturaInteressadoVo, TermoAberturaInteressadoDao> {

	public TermoAberturaInteressadoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(TermoAberturaInteressadoVo vo) throws BeException {
		super.doBeforeSave(vo);

		TermoAberturaInteressadoVo filter = new TermoAberturaInteressadoVo();
		filter.setIdTermo(vo.getIdTermo());
		filter.setIdPessoa(vo.getIdPessoa());

		List<TermoAberturaInteressadoVo> list = getList(filter);

		boolean isDuplicated = false;

		if (vo.isNew() && list.size() > 0) {
			// Se for um novo registro, e achou, entao está duplicando.
			isDuplicated = true;
		} else {
			for (TermoAberturaInteressadoVo item : list) {
				if (!item.getIdInteressado().equals(vo.getIdInteressado())) {
					// Se achou um item, e o id é diferente, entao esta
					// duplicando.
					isDuplicated = true;
				}
			}
		}

		if (isDuplicated) {
			throw new SaveBeException("Interessado já vinculado a este termo!");
		}
	}

}
