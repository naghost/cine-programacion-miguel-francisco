import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Sesion {


	public Date fechaHora = new Date();

	public Integer IDPrecio = new Integer(0);

	public Integer IDPelicula = new Integer(0);

	public Integer IDSala = new Integer(0);

	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    GregorianCalendar fechaCalend = new GregorianCalendar();


	public void crearSesion(BBDD bd, int idpelicula2, int idsala2, String precio, Date fechainicio, Date fechafin, boolean l, boolean m, boolean x, boolean j, boolean v, boolean s, boolean d, int hora, int minutos) {
		do{
			System.out.println("Entro");
		fechaCalend.setTime(fechainicio);
		//obtener dia de la semana con gregorian calendar
		int dia = obtenerDia();
		String fechai = sdf.format(fechainicio)+" "+hora+":"+minutos;
		int idprecio = obtenerPrecio(precio, bd);
		if((dia ==2 && l == true) || (dia ==3 && m == true) || (dia ==4 && x == true) || (dia ==5 && j == true) || (dia ==6 && v == true) || (dia ==7 && v == true) || (dia ==1 && d == true)){
		 try {
	            String Query = "INSERT INTO sesiones VALUES(null, "+idsala2+", "+idpelicula2+","+idprecio+",'"+fechai+"'  )";
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.execute(Query);
	            st.close();
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa","Resultado Operacion",JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos","Resultado Operacion",JOptionPane.ERROR_MESSAGE);
	        }
		}
		fechainicio = sumarDia(fechainicio);
		
		}while(fechainicio.compareTo(fechafin)<0);

	}
	
	public void crearSesion(BBDD bd, int idpelicula2, int idsala2, String precio, Date fechainicio, Date fechafin, int hora, int minutos) {
		
		do{
			String fechai = sdf.format(fechainicio)+" "+hora+":"+minutos;
			int idprecio = obtenerPrecio(precio, bd);
		 try {
	            String Query = "INSERT INTO sesiones VALUES(null, "+idsala2+", "+idpelicula2+","+idprecio+",'"+fechai+"'  )";
	      
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.execute(Query);
	            st.close();
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa","Resultado Operacion",JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos","Resultado Operacion",JOptionPane.ERROR_MESSAGE);
	        }
			
			fechainicio = sumarDia(fechainicio);
		}while(fechainicio.compareTo(fechafin)<0);
	}

	public void crearSesion(BBDD bd, int idpelicula2, int idsala2, String precio, Date fechainicio, int hora, int minutos) {
		String fechai = sdf.format(fechainicio)+" "+hora+":"+minutos;
			int idprecio = obtenerPrecio(precio, bd);
		 try {
	            String Query = "INSERT INTO sesiones VALUES(null, "+idsala2+", "+idpelicula2+","+idprecio+",'"+fechai+"'  )";
	      
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.execute(Query);
	            st.close();
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa","Resultado Operacion",JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos","Resultado Operacion",JOptionPane.ERROR_MESSAGE);
	        }
		
	}

	private int obtenerPrecio(String precio, BBDD bd) {
		int i=0 ;
		try {
            String Query = "SELECT IDPrecio FROM precios WHERE Nombre='"+precio+"'";
            java.sql.Statement st = bd.conexion.createStatement();
            ResultSet rs = st.executeQuery(Query);
            while(rs.next()){
    			i = rs.getInt("IDPrecio");
    		}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos","Resultado Operacion",JOptionPane.ERROR_MESSAGE);
        }
		
		return i;
	}

	private int obtenerDia() {
		int diaSemana = fechaCalend.get(Calendar.DAY_OF_WEEK);
		// 1 Domingo 2 Lunes 3 Martes 4 Miercoles 5 Jueves 6 viernes 7 sabado
		return diaSemana;
	}

	private Date sumarDia(Date fecha){

	      Calendar calendar = Calendar.getInstance();

	      calendar.setTime(fecha); // Configuramos la fecha que se recibe

	      calendar.add(Calendar.DAY_OF_YEAR, 1);  // numero de horas a añadir, o restar en caso de horas<0

	      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	

	 }

	protected void borrarSesion(Integer id, BBDD bd) {
			
		
		java.sql.Statement stmt;
		ResultSet rs = null;
		String camp[] = new String[4];
		
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM sesiones WHERE IDSesion="+id);
			while(rs.next()){
				String auxcampo = "Nombre";
				String tabla = "salas";
				String campo = "IDSalas";
				int id2 = rs.getInt("IDSala");
			
				camp[0] = obtenerNombre(bd,  tabla, campo, id2,  auxcampo);
				
				auxcampo = "Titulo";
				tabla = "peliculas";
 				campo = "IDPelicula";
 				id2 = rs.getInt("IDPelicula");
				camp[1] = obtenerNombre(bd,  tabla, campo, id2,  auxcampo);
				
				auxcampo = "Nombre";
				tabla = "precios";
 				campo = "IDPrecio";
 				id2 = rs.getInt("IDPrecio");
				camp[2] = obtenerNombre(bd,  tabla, campo, id2,  auxcampo);
			
				camp[3] = rs.getString("FechaHora");
		}
			int respuesta = JOptionPane.showConfirmDialog(null,"¿Estas seguro que quieres borrar el siguiente elemento? \n"+camp[0]+" "+camp[1]+" "+camp[2]+" "+camp[3],"Eliminar sesion",JOptionPane.YES_NO_OPTION);

			if(respuesta == 0){
				System.out.println(id);
				stmt = bd.conexion.createStatement();
				stmt.execute("DELETE FROM sesiones WHERE IDSesion ="+id);
				
				JOptionPane.showMessageDialog(null, "Los cambios se han realizado");
			}else{
				JOptionPane.showMessageDialog(null, "No se han realizado los cambios");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	protected ResultSet sesion(BBDD bd){
		java.sql.Statement stmt;
		ResultSet rs = null;
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT Nombre FROM precios");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
	}

	protected ResultSet verSesiones(BBDD bd){
		java.sql.Statement stmt;
		ResultSet rs = null;
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM sesiones");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
	}

	protected String obtenerNombre(BBDD bd, String tabla, String campo, int id, String auxcampo){
		java.sql.Statement stmt;
		ResultSet rs = null;
	
		String nombre= "";
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT "+auxcampo+" FROM "+tabla+" WHERE "+campo+"="+id);
			while(rs.next()){
				nombre = rs.getString(auxcampo);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return nombre;
	}
}
