package com.curso.tdd.junit.servicios;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class ServicioBasicoErroresControladosIT {

	// Subject Under Test
	private ServicioBasico sut = new ServicioBasico(new ValidadorBasic());

	@BeforeClass
	public static void initClass() {
		// Preparar el entorno comun para todos los metodos de Test (entorno cte)
	}

	@Before
	public void init() {
		// Preparar el entorno para cada metodo de Test (entorno cte)
	}

	@Test(expected=ValidationException.class)
	public void escenarioFalloDeValidacionAlRegistrarUsuario() {
		// Datos de prueba (cts)
		// - Datos de Entrada
		String userName = "?";
		String password = "victor";
		// - Resultado esperado = La excepcion

		// Agitar el SUT, posible recuperacion del resultado obtenido
		sut.registrarUsuario(userName, password);
	}
}
