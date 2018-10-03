package com.currso.tdd.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.currso.tdd.entidades.Persona;

public class PersonaDao {

	public void insertar(Persona persona) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dbunit", "user", "user");
			stmt = conn.createStatement();
			String sql = "INSERT INTO PERSONAS (NOMBRE) VALUES ('" + persona.getNombre() + "')";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}

}
