package com.curso.tdd.ejercicio.back;

import java.sql.SQLException;

public class ServicioLibros {

	public long alta(Libro libro) throws ValidationException, SQLException{
		// Implementar la logica de validacion
		if (libro.getAutor() == null && libro.getAutor().equals("")) {
			throw new ValidationException();
		}
		return -1;
	}

}
