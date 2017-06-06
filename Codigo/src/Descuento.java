import java.sql.Date;

public class Descuento {

	public String nombreDescuento = "";
	public java.util.Date fechaInicio;
	public java.util.Date fechaFin ;
	public String diaSemana = "";
	public boolean indefinido = false;
	public String descripcion = "";
	public boolean temporal = false;
	public int porcentaje;
	
	public Descuento(String nombreDescuento, String descripcion, java.util.Date date, java.util.Date date2, String diaSemana,
			 boolean temporal, int porcentaje) {
		
		this.nombreDescuento = nombreDescuento;
		this.fechaInicio = date;
		this.fechaFin = date2;
		this.diaSemana = diaSemana;
		this.descripcion = descripcion;
		this.temporal = temporal;
		this.porcentaje = porcentaje;
	}


	


	public void crearDescuento() {
		// Start of user code for method crearDescuento
		// End of user code
	}


	public void eliminarDescuento() {
		// Start of user code for method eliminarDescuento
		// End of user code
	}


	public void modificarDescuento() {
		// Start of user code for method modificarDescuento
		// End of user code
	}





		/**
	 * @return the nombreDescuento
	 */
	public String getNombreDescuento() {
		return nombreDescuento;
	}





	/**
	 * @param nombreDescuento the nombreDescuento to set
	 */
	public void setNombreDescuento(String nombreDescuento) {
		this.nombreDescuento = nombreDescuento;
	}





	/**
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}





	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	/**
	 * @return the fechaFin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}





	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}





	/**
	 * @return the diaSemana
	 */
	public String getDiaSemana() {
		return diaSemana;
	}





	/**
	 * @param diaSemana the diaSemana to set
	 */
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}





	/**
	 * @return the indefinido
	 */
	public int getIndefinido() {
		
		int n=0;
		if(indefinido) {
			
			return 1;
		
		}
		
		return n;
	}





	/**
	 * @param indefinido the indefinido to set
	 */
	public void setIndefinido(Boolean indefinido) {
		this.indefinido = indefinido;
	}





	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}





	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	/**
	 * @return the temporal
	 */
	public int getTemporal() {
		int n=0;
		
		if(this.temporal) {
			
			n=1;
		
		}
		
		return n;
	}





	/**
	 * @param temporal the temporal to set
	 */
	public void setTemporal(Boolean temporal) {
		this.temporal = temporal;
	}





	/**
	 * @return the porcentaje
	 */
	public Integer getPorcentaje() {
		return porcentaje;
	}





	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}
}
