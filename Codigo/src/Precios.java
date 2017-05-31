import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Precios {
	private int id = 0;
	private Double Precio = new Double(0);
	private String nombrePrecio = new String();
	private String [] campos = {"IDPrecio", "Nombre","Precio"};

	public void crearPrecio(BBDD bd, String nombre, Double precio) {
		this.nombrePrecio = nombre;
		this.Precio= precio;
		   try {
	            String Query = "INSERT INTO precios VALUES(null,'"+this.nombrePrecio+"', "+this.Precio+")";
	          System.out.println(Query);
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.executeUpdate(Query);
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	        }
	}
	

	public void eliminarPrecio(BBDD bd, Integer idUsed_precio) {
	
		java.sql.Statement stmt;
		ResultSet rs = null;
		String campo[] = new String[campos.length];
		
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM precios WHERE IDPrecio="+idUsed_precio);
			
			while(rs.next()){
				for(int i = 0; i<this.campos.length;i++){
				campo[i]=rs.getString(this.campos[i]);
				}
			}
			int respuesta = JOptionPane.showConfirmDialog(null,"¿Estas seguro que quieres borrar el siguiente elemento? \n"+campo[1]+" "+campo[2]+" "+campo[3]+" "+campo[4]+" "+campo[5],"Eliminar pelicula",JOptionPane.YES_NO_OPTION);

			if(respuesta == 0){
				stmt = bd.conexion.createStatement();
				stmt.execute("DELETE FROM precios WHERE IDPrecio="+idUsed_precio);
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

	public void modificarPrecio(BBDD bd, Integer idUsed_precio, String nombre, double precio2) {
		this.nombrePrecio = nombre;
		this.Precio = precio2;
		id = idUsed_precio;
		  try {
	            String Query = "UPDATE precios SET Nombre='"+this.nombrePrecio+"', Precio="+this.Precio+" WHERE IDPrecio ="+id;         
	            java.sql.Statement st = bd.conexion.createStatement();
	            st.executeUpdate(Query);
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	        }
	}

	public ResultSet verPrecios(BBDD bd) {
		java.sql.Statement stmt;
		ResultSet rs = null;
		try {
			stmt = bd.conexion.createStatement();
			rs = stmt.executeQuery("SELECT * FROM precios");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
	}



}
