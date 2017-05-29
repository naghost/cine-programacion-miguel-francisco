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


	public void borrarPelicula() {
		// Start of user code for method borrarPelicula
		// End of user code
	}


	public void modificarPelicula() {
		// Start of user code for method modificarPelicula
		// End of user code
	}
	
	public ResultSet verPelicula(BBDD bd){
		java.sql.Statement stmt;
		ResultSet rs = null;
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Peliculas");
			
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
