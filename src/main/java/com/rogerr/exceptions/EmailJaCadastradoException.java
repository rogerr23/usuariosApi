package com.rogerr.exceptions;

@SuppressWarnings("serial")
public class EmailJaCadastradoException extends RuntimeException {

	public String getMessage() {
		return "O email informado já está cadastrado. Tente outro.";
	}

}
