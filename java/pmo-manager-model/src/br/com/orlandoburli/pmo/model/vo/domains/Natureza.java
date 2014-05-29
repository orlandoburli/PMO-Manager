package br.com.orlandoburli.pmo.model.vo.domains;

import br.com.orlandoburli.framework.core.vo.BaseDomain;

public class Natureza extends BaseDomain {

	public static final String FISICA = "F";
	public static final String JURIDICA = "J";

	public static final String FISICA_DESCRITIVO = "Física";
	public static final String JURIDICA_DESCRITIVO = "Jurídica";

	@Override
	public String[] getValues() {
		return new String[] { FISICA, JURIDICA };
	}

	@Override
	public String[] getDescriptions() {
		return new String[] { FISICA_DESCRITIVO, JURIDICA_DESCRITIVO };
	}

}
