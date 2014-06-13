package br.com.orlandoburli.pmo.web.actions.cadastro.pessoajuridica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaJuridicaBe;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaJuridicaDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;

public class PessoaJuridicaConsultaAction extends BaseConsultaAction<PessoaJuridicaVo, PessoaJuridicaDao, PessoaJuridicaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspConsulta() {
		return "web/pages/cadastro/pessoajuridica/pessoajuridicaconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/cadastro/pessoajuridica/pessoajuridicaconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.PessoaJuridica.TABELA_PESSOA_JURIDICA + "_" + Dicionario.Pessoa.TABELA_PESSOA + "." + Dicionario.Pessoa.Colunas.NOME;
	}

	@Override
	public void doBeforeFilter(PessoaJuridicaVo filter, PessoaJuridicaBe be, HttpServletRequest request, HttpServletResponse response) {
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
			} else if (getParametroPesquisa().equalsIgnoreCase("Cnpj")) {
				filter.setCnpj("%" + getPesquisarPor() + "%");
			}
		} else {
			filter.getPessoa().setNome("%" + getPesquisarPor() + "%");
		}
	}

}
