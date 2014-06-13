package br.com.orlandoburli.pmo.web.actions.cadastro.pessoafisica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.pmo.model.be.cadastros.CargoBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaFisicaBe;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaJuridicaBe;
import br.com.orlandoburli.pmo.model.dao.cadastros.PessoaFisicaDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.domains.Natureza;

public class PessoaFisicaCadastroAction extends BaseCadastroAction<PessoaFisicaVo, PessoaFisicaDao, PessoaFisicaBe> {

	private static final long serialVersionUID = 1L;

	@Override
	public String getJspCadastro() {
		return "web/pages/cadastro/pessoafisica/pessoafisicacadastro.jsp";
	}

	@Override
	public void doBeforeSalvar(PessoaFisicaVo vo, DAOManager manager) throws SaveBeException {
		super.doBeforeSalvar(vo, manager);

		vo.getPessoa().setNatureza(Natureza.FISICA);
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, PessoaFisicaVo vo, PessoaFisicaBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		try {
			request.setAttribute("cargos", new CargoBe(getManager()).getList(null, null, Dicionario.Cargo.TABELA_CARGO + "." + Dicionario.Cargo.Colunas.NOME));
			request.setAttribute("unidades", new PessoaJuridicaBe(getManager()).getList(null, null, Dicionario.PessoaJuridica.TABELA_PESSOA_JURIDICA + "_" + Dicionario.Pessoa.TABELA_PESSOA + "." + Dicionario.Pessoa.Colunas.NOME));
		} catch (ListException e) {
			Log.error(e);
		}
	}
}
