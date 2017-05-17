import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class BBDD {

	String servidor = "jdbc:mysql://localhost/proyecto";
	String user = "root";
	String pass = "";
	String driver ="com.mysql.jdbc.Driver";
	java.sql.Connection conexion = null;
	
	public void conexion() throws ClassNotFoundException{
		try{
			Class.forName(driver);
			this.conexion = DriverManager.getConnection(servidor, user, pass);
			System.out.println("conectado");
		}catch( SQLException e){
			System.out.println("Conexion fallada");
		}
	}
}
