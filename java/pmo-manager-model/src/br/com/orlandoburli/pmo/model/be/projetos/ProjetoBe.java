package br.com.orlandoburli.pmo.model.be.projetos;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.projetos.ProjetoDao;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;

public class ProjetoBe extends BaseBe<ProjetoVo, ProjetoDao> {

	public ProjetoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(ProjetoVo vo) throws BeException {
		super.doBeforeSave(vo);

		if (vo.getDataInicial() != null && vo.getDataFinal() != null) {
			if (vo.getDataInicial().after(vo.getDataFinal())) {
				throw new SaveBeException("A Data Final não pode ser posterior à Data Inicial!", "dataInicial");
			}
		}
	}

}
