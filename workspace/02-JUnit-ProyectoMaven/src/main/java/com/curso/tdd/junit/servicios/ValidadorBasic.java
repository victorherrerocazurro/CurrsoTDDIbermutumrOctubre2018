package com.curso.tdd.junit.servicios;

public class ValidadorBasic implements Validador {

	public boolean validarUserName(String userName) {
		return !userName.contains("?");
	}

}
