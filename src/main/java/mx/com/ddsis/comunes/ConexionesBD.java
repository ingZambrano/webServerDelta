package mx.com.ddsis.comunes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class ConexionesBD {
	
	private static final Logger logger = Logger.getLogger(ConexionesBD.class);
	
	public static Connection getConnection(String instancia, String puerto, String usr, String pass, String catalogo){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://"+instancia+":"+puerto,usr, pass);
		} catch (SQLException e) {
			logger.error("Fallo la conexion",e);
			
		}
		return connection;
		
	}	
		
	public static void closeConnection(Connection conn,
			PreparedStatement pstmt, ResultSet rs, CallableStatement call) throws SQLException{

		if (pstmt != null) {
			pstmt.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (call != null) {
			call.close();
		}

	}


}
