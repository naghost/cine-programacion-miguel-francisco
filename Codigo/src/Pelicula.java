import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Pelicula {

	public Date Estreno = new Date();
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
		
	
		
		
	}


	public void borrarPelicula() {
		// Start of user code for method borrarPelicula
		// End of user code
	}


	public void modificarPelicula() {
		// Start of user code for method modificarPelicula
		// End of user code
	}
	
	private Date Fecha(int dia, String mes, int ano) {
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
		String fecha = auxdia+"/"+auxmes+"/"+auxano;
		
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			auxfecha = formatoDeFecha.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fecha);
		System.out.println(auxfecha);
		return auxfecha;
	}
	
}
