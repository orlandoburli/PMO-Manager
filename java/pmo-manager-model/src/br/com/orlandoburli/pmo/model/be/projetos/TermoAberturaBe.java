package br.com.orlandoburli.pmo.model.be.projetos;

import java.util.List;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.SaveBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.pmo.model.dao.projetos.TermoAberturaDao;
import br.com.orlandoburli.pmo.model.vo.projetos.StatusTermoAbertura;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;

public class TermoAberturaBe extends BaseBe<TermoAberturaVo, TermoAberturaDao> {

	public TermoAberturaBe(DAOManager manager) {
		super(manager);
	}

	/**
	 * Cria uma nova versão de um termo de abertura com base no termo informado
	 * 
	 * @param termo
	 * @return Termo com os dados copiados e a versao incrementada.
	 */
	public TermoAberturaVo novaVersao(TermoAberturaVo termo) {
		TermoAberturaVo termoNovo = new TermoAberturaVo();
		termoNovo.setProjeto(termo.getProjeto());
		termoNovo.setJustificativa(termo.getJustificativa());
		termoNovo.setObjetivos(termo.getObjetivos());

		termoNovo.setDescricaoProduto(termo.getDescricaoProduto());
		termoNovo.setGerente(termo.getGerente());
		termoNovo.setRequisitos(termo.getRequisitos());
		termoNovo.setRiscos(termo.getRiscos());
		termoNovo.setMarcos(termo.getMarcos());
		termoNovo.setInvestimento(termo.getInvestimento());
		termoNovo.setPatrocinador(termo.getPatrocinador());
		termoNovo.setStatusTermoAbertura(StatusTermoAbertura.EM_ELABORACAO);
		termoNovo.setVersao(termo.getVersao() + 1);
		termoNovo.setIdTermoReferencia(termo.getIdTermoAbertura());

		return termoNovo;
	}

	@Override
	public void doBeforeInsert(TermoAberturaVo vo) throws BeException {
		// Somente insere com o status EM ELABORAÇÃO.
		vo.setStatusTermoAbertura(StatusTermoAbertura.EM_ELABORACAO);

		// Verifica se existe uma versao anterior sem finalizar
		TermoAberturaVo filter = new TermoAberturaVo();
		filter.setIdProjeto(vo.getIdProjeto());

		List<TermoAberturaVo> list = getList(filter, null, null);

		for (TermoAberturaVo termo : list) {

			Log.info("Termo versao: " + termo.getVersao() + " IdProjeto: " + termo.getIdProjeto());

			if (termo.getStatusTermoAbertura().equals(StatusTermoAbertura.EM_ELABORACAO)) {
				throw new SaveBeException("Versão não pode ser criada, termo anterior ainda em elaboração!");
			} else if (termo.getStatusTermoAbertura().equals(StatusTermoAbertura.FINALIZADO)) {
				// Cancelar o termo anterior
				cancelar(termo);
			} else if (termo.getStatusTermoAbertura().equals(StatusTermoAbertura.CANCELADO)) {
				// OK, pode passar
			} else {
				throw new SaveBeException("Versão não pode ser criada, termo anterior com status desconhecido!");
			}
		}

		// Incrementa a versao
		vo.setVersao(list.size() + 1);

		super.doBeforeInsert(vo);
	}

	@Override
	public void doBeforeUpdate(TermoAberturaVo vo) throws BeException {
		super.doBeforeUpdate(vo);

		// Verifica se esta editando um termo ja cancelado

		TermoAberturaVo vo2 = get(vo);

		if (vo2.getStatusTermoAbertura().equals(StatusTermoAbertura.CANCELADO)) {
			throw new SaveBeException("Termo não pode ser alterado, já está cancelado!");
		} else if (vo2.getStatusTermoAbertura().equals(StatusTermoAbertura.FINALIZADO)) {

			if (!vo.getStatusTermoAbertura().equals(StatusTermoAbertura.CANCELADO)) {
				// A nao ser que esteja cancelando o termo, nao pode ser
				// alterado mais.
				throw new SaveBeException("Termo não pode ser alterado, já está finalizado!");
			}
		}
	}

	public void finalizar(TermoAberturaVo termo) throws BeException {
		synchronized (this) {
			termo.setStatusTermoAbertura(StatusTermoAbertura.FINALIZADO);

			save(termo);
		}
	}

	public void cancelar(TermoAberturaVo termo) throws BeException {
		synchronized (this) {
			termo.setStatusTermoAbertura(StatusTermoAbertura.CANCELADO);

			save(termo);
		}
	}

}