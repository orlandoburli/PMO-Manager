package br.com.orlandoburli.pmo.model.be.reuniao;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.reuniao.SalaReuniaoDao;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;
import br.com.orlandoburli.pmo.model.vo.reuniao.SalaReuniaoVo;

public class SalaReuniaoBe extends BaseBe<SalaReuniaoVo, SalaReuniaoDao> {

	public SalaReuniaoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeSave(SalaReuniaoVo vo) throws BeException {
		super.doBeforeSave(vo);

		// A validacao abaixo so ocorre para duas salas ATIVAS com o mesmo nome.
		if (vo.getAtivo().equals(SimNao.SIM)) {

			SalaReuniaoVo filter = new SalaReuniaoVo();
			filter.setNome(vo.getNome());
			filter.setAtivo(SimNao.SIM);

			List<SalaReuniaoVo> list = getList(filter);

			if (list.size() > 0) {
				SalaReuniaoVo temp = list.get(0);
				
				if (vo.isNew() || !temp.getIdSalaReuniao().equals(vo.getIdSalaReuniao())) {
					throw new SaveBeException("Já existe uma sala com o nome \"" + vo.getNome() + "\"!");
				}
			}
		}
	}
}
