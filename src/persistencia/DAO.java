package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
	protected Connection conexion = null;
	protected ResultSet resultado = null;
	protected Statement sentencia = null;

	private final String USER = "root", PASSWORD = "sg171136824", DATABASE = "perros", DRIVER = "com.mysql.jdbc.Driver";

	protected void conectorBase() throws Exception {
		try {
			Class.forName(DRIVER);
			String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE;
			conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
	};

	protected void desconectarBase() throws Exception {
		try {
			if (resultado != null) {
				resultado.close();
			}
			if (sentencia != null) {
				sentencia.close();
			}
			if (conexion != null) {
				conexion.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	protected void insertarModificarEliminar(String sql) throws Exception {
		try {
			conectorBase();
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		} finally {
			desconectarBase();
		}
	}
	
	protected void consultarBase(String sql) throws Exception {
		try {
			conectorBase();
			sentencia = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
		}catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
	}
}
