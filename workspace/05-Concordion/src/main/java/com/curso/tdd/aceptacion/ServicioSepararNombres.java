package com.curso.tdd.aceptacion;

public class ServicioSepararNombres {

	public Persona separar(String nombreCompleto) {
		
		String[] tmp = nombreCompleto.split(" ");
		
		return new Persona(tmp[0], tmp[1]);
	}

}
