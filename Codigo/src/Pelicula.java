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

	public String Estreno = new String();
	public String Titulo = new String();
	public String Director = new String();
	public String Genero = new String();
	public String Sinopsis = new String();
	public Integer ano = new Integer(0);
	public String [] campos = {"IDPelicula","Titulo","Genero", "Director", "Sinopsis","Estreno"};
	
	public void crearPelicula(BBDD bd,String titulo2, String director2, String genero2, int dia, String mes, int ano2, String sinopsis2) {
		this.Estreno = Fecha(dia, mes, ano2);
		this.Titulo = titulo2;
		this.Director = director2;
		this.Genero = genero2;
		this.Sinopsis = sinopsis2;
		
		   try {
	            String Query = "INSERT INTO peliculas VALUES(null, '"+this.Titulo+"', '"+this.Genero+"','"+this.Director+"','"+this.Sinopsis+"','"+this.Estreno+"'  )";
	          System.out.println(Query);
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.executeUpdate(Query);
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	        }
		

		
		
	}


	public void borrarPelicula(BBDD bd, Integer idUsed_peliculas) {
		java.sql.Statement stmt;
		ResultSet rs = null;
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM peliculas WHERE IDPelicula="+idUsed_peliculas);
			while(rs.next()){
				for(int i = 0; i<this.campos.length;i++){
					System.out.println(rs.getString(this.campos[i]));
				}
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void modificarPelicula(BBDD bd, String titulo2, String director2, String genero2, int dia, String mes, int ano2, String sinopsis2, int id) {
		this.Estreno = Fecha(dia, mes, ano2);
		this.Titulo = titulo2;
		this.Director = director2;
		this.Genero = genero2;
		this.Sinopsis = sinopsis2;
		
		  try {
	            String Query = "UPDATE peliculas SET Titulo='"+this.Titulo+"', Genero='"+this.Genero+"', Director='"+this.Director+"', Sinopsis='"+this.Sinopsis+"', Estreno='"+this.Estreno+"' WHERE IDPelicula ="+id;
	             
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
	
	private String Fecha(int dia, String mes, int ano) {
		String auxdia = String.valueOf(dia);
		String auxano = String.valueOf(ano);
		String [] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
		String auxmes = "";
		Date auxfecha = null ;
		for(int i = 0; i<meses.length;i++){
			if(mes.equals(meses[i])){
				if((i+1)>=10){
					auxmes = String.valueOf(i+1);
				}else{
					auxmes = "0"+String.valueOf(i+1);
				}
			}
		}
		String fecha = auxano+"/"+auxmes+"/"+auxdia;
		
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			auxfecha = formatoDeFecha.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fecha);
		System.out.println(auxfecha);
		return fecha;
	}
	
}
