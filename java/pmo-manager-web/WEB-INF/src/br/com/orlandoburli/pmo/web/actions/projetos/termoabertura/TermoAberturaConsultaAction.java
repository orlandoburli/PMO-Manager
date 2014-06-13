package br.com.orlandoburli.pmo.web.actions.projetos.termoabertura;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.be.exceptions.persistence.ListException;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.web.BaseConsultaAction;
import br.com.orlandoburli.framework.core.web.filters.OutjectSession;
import br.com.orlandoburli.pmo.model.be.projetos.ProjetoBe;
import br.com.orlandoburli.pmo.model.be.projetos.TermoAberturaBe;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaDao;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;

public class TermoAberturaConsultaAction extends BaseConsultaAction<TermoAberturaVo, TermoAberturaDao, TermoAberturaBe> {

	private static final long serialVersionUID = 1L;

	private Integer idProjeto;

	@OutjectSession("projetoSelecionado")
	private ProjetoVo projetoSelecionado;

	@Override
	public String getJspConsulta() {
		return "web/pages/projetos/termoabertura/termoaberturaconsulta.jsp";
	}

	@Override
	public String getJspGridConsulta() {
		return "web/pages/projetos/termoabertura/termoaberturaconsulta_grid.jsp";
	}

	@Override
	public String getOrderFields() {
		return Dicionario.TermoAbertura.TABELA_TERMO_ABERTURA + "." + Dicionario.TermoAbertura.Colunas.VERSAO + " DESC";
	}

	@Override
	public void doBeforeExecute() {
		super.doBeforeExecute();

		if (getIdProjeto() != null) {
			try {
				setProjetoSelecionado(new ProjetoBe(getManager()).get(getIdProjeto()));
			} catch (ListException e) {
				Log.error(e);
			}
		}

		if (getProjetoSelecionado() == null) {
			return;
		}

		getRequest().setAttribute("titulo", "Termo de Abertura - " + getProjetoSelecionado().getNome());
		getRequest().setAttribute("subtitulo", "Consulta de Termos de Abertura");
		getRequest().setAttribute("subMenu", "Projetos");
		getRequest().setAttribute("menuAtivo", "Termo de Abertura");
	}

	@Override
	public void doBeforeFilter(TermoAberturaVo filter, TermoAberturaBe be, HttpServletRequest request, HttpServletResponse response) {
		// ??
		Integer versao = null;

		try {
			versao = Integer.parseInt(getPesquisarPor().trim());
		} catch (NullPointerException | NumberFormatException e) {
			versao = null;
		}

		filter.setVersao(versao);
		filter.setIdProjeto(getProjetoSelecionado().getIdProjeto());
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
