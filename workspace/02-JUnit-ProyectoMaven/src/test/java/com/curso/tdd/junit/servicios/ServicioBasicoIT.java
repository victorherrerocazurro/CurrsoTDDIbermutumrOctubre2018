package com.curso.tdd.junit.servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ServicioBasicoIT {

	@Parameters(name = "username = {0}, password = {1}, resultadoEsperado = {2}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ "victor", "victor", true }, 
			{ "juan", "victor", false },
			{ "victor", "juan", true }
		});
	}

	// Datos de prueba (cts)
	// - Datos de Entrada
	private String userName;
	private String password;
	// - Resultado esperado
	private boolean resultadoEsperado;

	public ServicioBasicoIT(String userName, String password, boolean resultadoEsperado) {
		super();
		this.userName = userName;
		this.password = password;
		this.resultadoEsperado = resultadoEsperado;
	}

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

	/**
	 * 1 - En el sistema se debera de poder registrar un usuario
	 * 
	 * 2a - El sistema deberá retornar un resultado positivo cuando se registre un
	 * usuario con username victor y password victor
	 * 
	 * 2b - El sistema ofrecera una interfaz web que aceptará el username y password
	 * mostrando al usuario un mensaje descriptivo con el resultado de la opracion
	 */
	// Cada una de las pruebas que queramos hacer al SUT
	@Test
	public void escenarioIdealRegistrarUsuarioTest() {
		// Agitar el SUT, posible recuperacion del resultado obtenido
		boolean resultadoObtenido = sut.registrarUsuario(userName, password);

		// Verificacion (asertos), compara el resultado botenido con el esperado
		assertEquals(resultadoEsperado, resultadoObtenido);
		
		assertThat("Asegurar que el resultado obtenido es igual al esperado", resultadoObtenido, equalTo(resultadoEsperado));
		
		// assertTrue(resultadoObtenido);

		// fail("Not yet implemented");
	}
}
