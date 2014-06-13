package br.com.orlandoburli.pmo.web.actions.projetos.termoabertura;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseCadastroAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.framework.core.web.retorno.RetornoAction;
import br.com.orlandoburli.pmo.model.be.cadastros.PessoaFisicaBe;
import br.com.orlandoburli.pmo.model.be.projetos.TermoAberturaBe;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario.Pessoa;
import br.com.orlandoburli.pmo.model.utils.Dicionario.PessoaFisica;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;

public class TermoAberturaCadastroAction extends BaseCadastroAction<TermoAberturaVo, TermoAberturaDao, TermoAberturaBe> {

	private static final long serialVersionUID = 1L;

	private Integer idProjeto;

	@OutjectSession("projetoSelecionado")
	private ProjetoVo projetoSelecionado;

	@Override
	public String getJspCadastro() {
		return "web/pages/projetos/termoabertura/termoaberturacadastro.jsp";
	}

	@Override
	public void doBeforeVisualizar(HttpServletRequest request, HttpServletResponse response, TermoAberturaVo vo, TermoAberturaBe be, DAOManager manager) {
		super.doBeforeVisualizar(request, response, vo, be, manager);

		getRequest().setAttribute("titulo", "Termo de Abertura - " + getProjetoSelecionado().getNome());
		getRequest().setAttribute("subtitulo", "Cadastro de Termos de Abertura");
		getRequest().setAttribute("subMenu", "Projetos");
		getRequest().setAttribute("menuAtivo", "Termo de Abertura");

		// Gerentes
		try {
			request.setAttribute("pessoas", new PessoaFisicaBe(manager).getList(null, null, PessoaFisica.TABELA_PESSOA_FISICA + "_" + Pessoa.TABELA_PESSOA + "." + Pessoa.Colunas.NOME));
		} catch (ListException e) {
			Log.error(e);
		}
	}

	public void finalizar() {
		TermoAberturaVo vo = getNewVo();

		injectVo(vo);

		try {
			TermoAberturaBe be = getNewBe(getManager());
			
			vo = be.get(vo);

			be.finalizar(vo);

			write(new Gson().toJson(new RetornoAction(true, "Termo finalizado com sucesso!")));

		} catch (BeException e) {
			getManager().rollback();
			write(new Gson().toJson(new RetornoAction(false, e.getMessage(), e.getField())));

		} finally {
			getManager().commit();
		}
	}
	
	public void cancelar() {
		TermoAberturaVo vo = getNewVo();

		injectVo(vo);

		try {
			TermoAberturaBe be = getNewBe(getManager());

			vo = be.get(vo);
			
			be.cancelar(vo);

			write(new Gson().toJson(new RetornoAction(true, "Termo cancelado com sucesso!")));

		} catch (BeException e) {
			getManager().rollback();
			write(new Gson().toJson(new RetornoAction(false, e.getMessage(), e.getField())));

		} finally {
			getManager().commit();
		}
	}
	
	public void copiar() {
		TermoAberturaVo vo = getNewVo();

		injectVo(vo);

		try {
			TermoAberturaBe be = getNewBe(getManager());

			vo = be.get(vo);
			
			TermoAberturaVo novaVersao = be.novaVersao(vo);
			
			be.save(novaVersao);

			write(new Gson().toJson(new RetornoAction(true, "Nova versão gerada com sucesso!")));

		} catch (BeException e) {
			getManager().rollback();
			write(new Gson().toJson(new RetornoAction(false, e.getMessage(), e.getField())));

		} finally {
			getManager().commit();
		}
	}
	
	@Override
	public void excluir() {
		// DO NOTHING...
	}

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public ProjetoVo getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(ProjetoVo projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}

}
