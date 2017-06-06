import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


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
	
	//Usuario de la BD
    private String usuario = "root";
    //Contraseña si tiene, si no tiene entonces dejar en blanco
    private String passwd = ""; 
    //Servidor (localhost si lo tenemos local) o puede ser un servidor remoto
    private String host = "localhost";
    //Nombre de la base de datos a la cual queremos conectarnos
    private String nombre_BD = "proyecto"; 
 
    //Objeto del tipo conexion lo delcaramos nulo
    
    
	
    private java.sql.Connection con = null;
    
   
    private PreparedStatement insModEli;

    
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
			rs = stmt.executeQuery("SELECT * FROM "+tabla+" WHERE "+campo+" LIKE '%"+valor+"%'");
			
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
    
   
	
	
	 public boolean insModEli (String sentencia) {
		 
		 boolean error=false;
	    	
	    try {
	    	
	    	stmt = (Statement) con.createStatement();
	    	insModEli=(PreparedStatement) con.prepareStatement(sentencia);
	    	insModEli.executeUpdate();
	    	} catch(Exception e){
	    		
	    		error=true;
	    	}
	    
	    return error;
	    }
	
	
	public ResultSet seleccionar(String consulta) {
		
		
		ResultSet resultado=null;
		
		
		try {
		stmt = (Statement) con.createStatement();
   	resultado = stmt.executeQuery(consulta);
   	
   	
   	} catch(Exception e){
   		 
   		 resultado=null;
   	 }
		
   	
		return resultado;
	}
	
	public void desconexion (){
		
		
		try{
		con.close();
		}catch(Exception e){}
	}
	
	public java.sql.Connection Conexion(){
		
		
		 try{
	            Class.forName("com.mysql.jdbc.Driver").newInstance( );
	            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
	            con = DriverManager.getConnection(servidor,usuario,pass);
	            //System.out.println("conecta??");
	            return con;
	        }catch(Exception e){
	           // e.printStackTrace();
	           
	        	
	            return con;
	        
	        }
		 	
		
	}
		 	
		
	
	
}
