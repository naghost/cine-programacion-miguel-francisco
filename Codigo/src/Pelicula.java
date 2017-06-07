import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Pelicula {

	public Date Estreno = new Date();
	public String Titulo = new String();
	public String Director = new String();
	public String Genero = new String();
	public String Sinopsis = new String();
	public Integer ano = new Integer(0);
	public String [] campos = {"IDPelicula","Titulo","Genero", "Director", "Sinopsis","Estreno"};
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	
	public void crearPelicula(BBDD bd,String titulo2, String director2, String genero2, String sinopsis2, Date estreno2) {
		this.Estreno = estreno2;
		this.Titulo = titulo2;
		this.Director = director2;
		this.Genero = genero2;
		this.Sinopsis = sinopsis2;
		String fecha = sdf.format(Estreno);
		
		   try {
	            String Query = "INSERT INTO peliculas VALUES(null, '"+this.Titulo+"', '"+this.Genero+"','"+this.Director+"','"+this.Sinopsis+"','"+fecha+"'  )";
	          System.out.println(Query);
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.executeUpdate(Query);
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa","Resultado Operacion",JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos","Resultado Operacion",JOptionPane.ERROR_MESSAGE);
	        }
		

		
		
	}

	public void borrarPelicula(BBDD bd, int idUsed_peliculas) {
		java.sql.Statement stmt;
		ResultSet rs = null;
		String campo[] = new String[campos.length];
		
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM peliculas WHERE IDPelicula="+idUsed_peliculas);
			
			while(rs.next()){
				for(int i = 0; i<this.campos.length;i++){
				campo[i]=rs.getString(this.campos[i]);
				}
			}
			int respuesta = JOptionPane.showConfirmDialog(null,"¿Estas seguro que quieres borrar el siguiente elemento? \n"+campo[1]+" "+campo[2]+" "+campo[3]+" "+campo[4]+" "+campo[5],"Eliminar pelicula",JOptionPane.YES_NO_OPTION);

			if(respuesta == 0){
				stmt = bd.conexion.createStatement();
				stmt.execute("DELETE FROM peliculas WHERE IDPelicula="+idUsed_peliculas);
				
				
			}else{
				JOptionPane.showMessageDialog(null, "No se han realizado los cambios");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public void modificarPelicula(BBDD bd, String titulo2, String director2, String genero2,  String sinopsis2, int id, Date estreno2) {
		this.Estreno = estreno2;
		this.Titulo = titulo2;
		this.Director = director2;
		this.Genero = genero2;
		this.Sinopsis = sinopsis2;
		String fecha = sdf.format(Estreno);
		  try {
	            String Query = "UPDATE peliculas SET Titulo='"+this.Titulo+"', Genero='"+this.Genero+"', Director='"+this.Director+"', Sinopsis='"+this.Sinopsis+"', Estreno='"+fecha+"' WHERE IDPelicula ="+id;         
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.executeUpdate(Query);
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	        }
		
		
	}
	
	public ResultSet verPelicula(BBDD bd){
		java.sql.Statement stmt;
		ResultSet rs = null;
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM peliculas");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
	}
	

	
}
