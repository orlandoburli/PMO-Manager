package br.com.orlandoburli.pmo.model.be.acesso.exceptions;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;

public class LoginDuplicadoException extends BeException {

	private static final long serialVersionUID = 1L;

	public LoginDuplicadoException(String message) {
		super(message);
	}

}
