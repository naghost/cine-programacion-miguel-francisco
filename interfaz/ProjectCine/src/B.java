import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Bbdd {
	
	//Usuario de la BD
    private String usuario = "root";
    //Contrase�a si tiene, si no tiene entonces dejar en blanco
    private String pass = ""; 
    //Servidor (localhost si lo tenemos local) o puede ser un servidor remoto
    private String host = "localhost";
    //Nombre de la base de datos a la cual queremos conectarnos
    private String nombre_BD = "proyecto"; 
 
    //Objeto del tipo conexion lo delcaramos nulo
    private Connection con = null;
    
    private Statement stmt;
    
    private PreparedStatement insModEli;

	public Bbdd() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection Conexion(){
		
		
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
	
	
	

}
