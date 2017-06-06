import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class BBDD {
	java.sql.Statement stmt;
	String servidor = "jdbc:mysql://localhost/proyecto";
	String user = "root";
	String pass = "";
	String driver ="com.mysql.jdbc.Driver";
	java.sql.Connection conexion = null;
	String tabla;
	String campo;
	String valor;
	public BBDD() throws ClassNotFoundException{
		try{
			Class.forName(driver);
			this.conexion = DriverManager.getConnection(servidor, user, pass);
			System.out.println("conectado");
		}catch( SQLException e){
			System.out.println("Conexion fallada");
		}
	}
	
	public ResultSet buscar(){
		
		ResultSet rs = null;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM "+tabla+" WHERE "+campo+" LIKE '%"+valor+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
	}
	
    protected void close() throws Throwable{
        System.out.println("Finalizando el Objeto");
        super.finalize();
      }
}
