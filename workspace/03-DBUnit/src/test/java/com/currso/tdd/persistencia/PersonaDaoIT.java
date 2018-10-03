package com.currso.tdd.persistencia;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.xml.FlatXmlWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.currso.tdd.entidades.Persona;

public class PersonaDaoIT {

	private IDatabaseTester databaseTester;
	private PersonaDao sut = new PersonaDao();

	@Before
	public void init() throws Exception {
		databaseTester = new JdbcDatabaseTester("org.apache.derby.jdbc.ClientDriver",
				"jdbc:derby://localhost:1527/dbunit", "user", "user");

		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("init_personas.xml"));

		databaseTester.setDataSet(dataSet);

		databaseTester.onSetup();
	}

	@After
	public void tearDown() throws Exception {
		// will call default tearDownOperation
		databaseTester.onTearDown();
	}

	@Test
	public void test() throws Exception {

		// Datos de prueba (cts)
		// - Datos de Entrada
		Persona persona = new Persona("Pedro");

		// - Resultado esperado
		IDataSet dataSetExpected = new FlatXmlDataSetBuilder().build(new File("expected_after_insert.xml"));

		// Agitar el SUT, posible recuperacion del resultado obtenido
		sut.insertar(persona);

		// Dado que la ejecucion de la prueba no retorna nada, debemos consultar el
		// estado del entorno para verificar el algoritmo
		IDatabaseConnection connection = databaseTester.getConnection();

		QueryDataSet dataSetActual = new QueryDataSet(connection);
		dataSetActual.addTable("PERSONAS");

		// Verificacion (asertos), compara el resultado botenido con el esperado
		Assertion.assertEquals(dataSetExpected, dataSetActual);
	}

}
