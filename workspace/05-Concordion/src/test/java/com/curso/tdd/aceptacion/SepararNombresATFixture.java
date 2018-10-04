package com.curso.tdd.aceptacion;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class SepararNombresATFixture {

	public ResultadoTestSepararNombres partir(String nombreCompleto) {
		
		ServicioSepararNombres sut = new ServicioSepararNombres();
		
		Persona datosObtenidos = sut.separar(nombreCompleto);
		
		return new ResultadoTestSepararNombres(datosObtenidos.getNombre(), datosObtenidos.getApellido());
	}

	class ResultadoTestSepararNombres {
		public String nombre;
		public String apellido;
		public ResultadoTestSepararNombres(String nombre, String apellido) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
		}
	}
	
}
