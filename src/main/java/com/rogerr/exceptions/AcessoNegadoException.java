package com.rogerr.exceptions;

@SuppressWarnings("serial")
public class AcessoNegadoException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Acesso negado. Verique as credencias informadas.";
	}

}
