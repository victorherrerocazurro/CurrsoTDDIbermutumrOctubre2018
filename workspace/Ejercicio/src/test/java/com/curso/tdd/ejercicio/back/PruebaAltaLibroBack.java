package com.curso.tdd.ejercicio.back;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

//- dar de alta un libro. 

public class PruebaAltaLibroBack {

	@Test
	public void test() {
		//Dato de prueba
		// Entrada
		// Creamos la clase Libro para aprovechar la OO
		Libro libro = new Libro("titulo","autor"); //null //new Libro("","");
		long idEsperado = -1;
		
		ServicioLibros sut = new ServicioLibros();
		
		//Nos retorna el id autogenerado en el sistema
		//Si hubiese problemas se retornaria una excepcion
		try {
			long idObtenido = sut.alta(libro);
			
			//verificaciones
			assertEquals(idEsperado, idObtenido);
			//Aqui dado que el alta del sistema incluye la insercion en BD, 
			//se deberia comprobar que se esta realizando de orma  correcta 
			
			//fail("Not yet implemented");
			
		} catch (ValidationException ve) {
			
		} catch (SQLException se) {
			
		}
		
		
	}

}
