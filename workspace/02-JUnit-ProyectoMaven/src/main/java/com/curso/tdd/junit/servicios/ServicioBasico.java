package com.curso.tdd.junit.servicios;

public class ServicioBasico {

	private Validador validador;
	
	public ServicioBasico() {
		super();
	}

	//En TDD se sugiere la aplicacion de IoC para poder implementar UT
	public ServicioBasico(Validador validador) {
		super();
		this.validador = validador;
	}

	public void setValidador(Validador validador) {
		this.validador = validador;
	}

	public boolean registrarUsuario(String userName, String password) {
		// TODO Auto-generated method stub
		
		//Validacion
		boolean valido = validador.validarUserName(userName);
		
		
		if (!valido) {
			throw new ValidationException("El userName no es valido");
		}
		
		//Insercion en base de datos
		
		//Notificacion
		
		return userName.contains("victor");
	}

	/*private boolean validarUserName(String userName) {
		return !userName.contains("?");
	}*/

}
