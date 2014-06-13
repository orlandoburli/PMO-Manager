package br.com.orlandoburli.pmo.web.actions.cadastro.pessoafisica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaFisicaBe;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaFisicaDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;

public class PessoaFisicaConsultaAction extends BaseConsultaAction<PessoaFisicaVo, PessoaFisicaDao, PessoaFisicaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/cadastro/pessoafisica/pessoafisicaconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/cadastro/pessoafisica/pessoafisicaconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.PessoaFisica.TABELA_PESSOA_FISICA + "_" + Dicionario.Pessoa.TABELA_PESSOA + "." + Dicionario.Pessoa.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(PessoaFisicaVo filter, PessoaFisicaBe be, HttpServletRequest request, HttpServletResponse response) {
		if (getParametroPesquisa() != null) {
			if (getParametroPesquisa().equalsIgnoreCase("Codigo")) {
				Integer codigo = null;
				try {
					codigo = Integer.parseInt(getPesquisarPor());
				} catch (NumberFormatException e) {
				}
				filter.setIdPessoa(codigo);
			} else if (getParametroPesquisa().equalsIgnoreCase("Nome")) {
				filter.getPessoa().setNome("%" + getPesquisarPor() + "%");
			} else if (getParametroPesquisa().equalsIgnoreCase("CPF")) {
				filter.setCpf("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.getPessoa().setNome("%" + getPesquisarPor() + "%");
		}
	}

}
