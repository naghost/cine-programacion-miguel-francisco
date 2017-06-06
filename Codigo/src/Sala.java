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
	public String [] campos = {"IDSalas","Nombre","Filas", "Columnas", "Audio","Video"};

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
	public void modificarSala(BBDD bd, String nombre2, int filas2, int columnas2, String audio2, String video2,int id) {
		
		  try {
	            String Query = "UPDATE salas SET Nombre='"+nombre2+"', Filas='"+filas2+"', Columnas='"+columnas2+"', Audio='"+audio2+"', Video='"+video2+"' WHERE IDSalas ="+id;         
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

	public void borrarSala(BBDD bd, int idUsed_sala) {
		java.sql.Statement stmt;
		ResultSet rs = null;
		String campo[] = new String[campos.length];
		
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM salas WHERE IDSalas="+idUsed_sala);
			
			while(rs.next()){
				for(int i = 0; i<this.campos.length;i++){
				campo[i]=rs.getString(this.campos[i]);
				}
			}
			int respuesta = JOptionPane.showConfirmDialog(null,"¿Estas seguro que quieres borrar el siguiente elemento? \n"+campo[1]+" "+campo[2]+" "+campo[3]+" "+campo[4]+" "+campo[5],"Eliminar pelicula",JOptionPane.YES_NO_OPTION);

			if(respuesta == 0){
				stmt = bd.conexion.createStatement();
				stmt.execute("DELETE FROM Salas WHERE IDSalas="+idUsed_sala);
				stmt.close();
				JOptionPane.showMessageDialog(null, "Los cambios se han realizado");
			}else{
				JOptionPane.showMessageDialog(null, "No se han realizado los cambios");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
