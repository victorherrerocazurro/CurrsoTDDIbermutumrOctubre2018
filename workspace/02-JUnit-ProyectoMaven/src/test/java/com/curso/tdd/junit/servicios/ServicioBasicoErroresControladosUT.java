package com.curso.tdd.junit.servicios;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ServicioBasicoErroresControladosUT {

	// Datos de prueba (cts)
	// - Datos de Entrada
	private String userName = "?";
	private String password = "victor";
	// - Resultado esperado = La excepcion

	@Mock
	private Validador validador;

	// Subject Under Test
	private ServicioBasico sut = new ServicioBasico();

	@BeforeClass
	public static void initClass() {
		// Preparar el entorno comun para todos los metodos de Test (entorno cte)
	}

	@Before
	public void init() {
		// Preparar el entorno para cada metodo de Test (entorno cte)
		sut.setValidador(validador);
		when(validador.validarUserName(userName)).thenReturn(false);
	}

	//@Test(expected = ValidationException.class)
	@Test
	public void escenarioFalloDeValidacionAlRegistrarUsuario() {

		// Agitar el SUT, posible recuperacion del resultado obtenido
		try {
			sut.registrarUsuario(userName, password);
			fail("Se deberia producir una excepcion de tipo ValidationException");
		} catch (ValidationException e) {
			verify(validador, times(1)).validarUserName(userName);
		}
	}
}
