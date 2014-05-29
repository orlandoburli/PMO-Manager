package br.com.orlandoburli.pmo.model.be.acesso.exceptions;

import br.com.orlandoburli.framework.core.be.exceptions.BeException;

public class LoginInvalidoException extends BeException {

	private static final long serialVersionUID = 1L;

	public LoginInvalidoException(String message) {
		super(message);
	}

}
