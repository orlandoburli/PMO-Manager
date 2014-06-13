package br.com.orlandoburli.pmo.model.vo.projetos;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class StatusTermoAbertura extends BaseDomain {

	public static final Integer EM_ELABORACAO = 1;
	public static final Integer FINALIZADO = 2;
	public static final Integer CANCELADO = 3;

	public static final String EM_ELABORACAO_DESCRITIVO = "Em elaboração";
	public static final String FINALIZADO_DESCRITIVO = "Finalizado";
	public static final String CANCELADO_DESCRITIVO = "Cancelado";

	@Override
	public String[] getValues() {
		return new String[] { EM_ELABORACAO.toString(), FINALIZADO.toString(), CANCELADO.toString() };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { EM_ELABORACAO_DESCRITIVO, FINALIZADO_DESCRITIVO, CANCELADO_DESCRITIVO };
	}

}
