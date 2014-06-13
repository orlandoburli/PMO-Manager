package br.com.orlandoburli.pmo.model.be.cadastros;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.cadastros.CargoDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;

public class CargoBe extends BaseBe<CargoVo, CargoDao> {

	public CargoBe(DAOManager manager) {
		super(manager);
	}

	public CargoVo getByNome(String nome) throws ListException {
		CargoVo filter = new CargoVo();
		filter.setNome(nome);

		List<CargoVo> list = getList(filter);

		if (list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	@Override
	public void doBeforeSave(CargoVo vo) throws BeException {
		super.doBeforeSave(vo);

		CargoVo byNome = getByNome(vo.getNome());

		if (byNome != null) {
			if (!byNome.getIdCargo().equals(vo.getIdCargo())) {
				throw new SaveBeException("O cargo \"" + vo.getNome() + "\" já existe cadastrado!", Dicionario.Cargo.Colunas.NOME);
			}
		}
	}

}
