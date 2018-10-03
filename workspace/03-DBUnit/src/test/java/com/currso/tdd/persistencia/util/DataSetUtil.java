package com.currso.tdd.persistencia.util;

import java.io.FileOutputStream;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlWriter;

public class DataSetUtil {

	public static void main(String[] args) throws Exception {
		
		JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.apache.derby.jdbc.ClientDriver",
				"jdbc:derby://localhost:1527/dbunit", "user", "user");
		
		IDatabaseConnection connection = databaseTester.getConnection();
		
		QueryDataSet partialDataSet = new QueryDataSet(connection);
		
		//Especificar que tablas formaran parte del Dataset
		partialDataSet.addTable("PERSONAS");
		
		// Especificar la ubicación del fichero a generar
		FlatXmlWriter datasetWriter = new FlatXmlWriter(new FileOutputStream(args[0]));
		
		// Generar el fichero
		datasetWriter.write(partialDataSet);
	}
	
}
