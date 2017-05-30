import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Sala {
	
	private int idSala=0;
	private int filas=0;
	private int columnas =0;
	private String audio="";
	private String video ="";
	private String nombre="";
	

	public void añadirSala(BBDD bd, String nombre, int filas, int columnas, String audio, String video){
		this.nombre = nombre;
		this.filas = filas;
		this.columnas = columnas;
		this.audio = audio;
		this.video = video;
		   try {
	            String Query = "INSERT INTO salas VALUES(null,'"+this.nombre+"', "+this.filas+", "+this.columnas+",'"+this.audio+"','"+this.video+"')";
	          System.out.println(Query);
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.executeUpdate(Query);
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	        }
	}
	public ResultSet verSalas(BBDD bd){
		java.sql.Statement stmt;
		ResultSet rs = null;
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Salas");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
	}
	
}
