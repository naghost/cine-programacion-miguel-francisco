import java.sql.Date;

public class Descuento {
	public HashSet<Entrada> entradas = new HashSet<Entrada>();
	public String nombreDescuento = "";
	public Date fechaInicio =;
	public Date fechaFin ;
	public String diaSemana = "";
	public Boolean indefinido = false;
	public String descripcion = "";
	public Boolean temporal = false;
	public Integer porcentaje;


	public void crearDescuento() {
		// Start of user code for method crearDescuento
		// End of user code
	}

	/**
	 * Description of the method eliminarDescuento.
	 */
	public void eliminarDescuento() {
		// Start of user code for method eliminarDescuento
		// End of user code
	}

	/**
	 * Description of the method modificarDescuento.
	 */
	public void modificarDescuento() {
		// Start of user code for method modificarDescuento
		// End of user code
	}

	// Start of user code (user defined methods for Descuento)

	// End of user code
	/**
	 * Returns entradas.
	 * @return entradas 
	 */
	public HashSet<Entrada> getEntradas() {
		return this.entradas;
	}

	/**
	 * Returns nombreDescuento.
	 * @return nombreDescuento 
	 */
	public String getNombreDescuento() {
		return this.nombreDescuento;
	}

	/**
	 * Sets a value to attribute nombreDescuento. 
	 * @param newNombreDescuento 
	 */
	public void setNombreDescuento(String newNombreDescuento) {
		this.nombreDescuento = newNombreDescuento;
	}

	/**
	 * Returns fechaFin.
	 * @return fechaFin 
	 */
	public EDate getFechaFin() {
		return this.fechaFin;
	}

	/**
	 * Sets a value to attribute fechaFin. 
	 * @param newFechaFin 
	 */
	public void setFechaFin(EDate newFechaFin) {
		this.fechaFin = newFechaFin;
	}

	/**
	 * Returns diaSemana.
	 * @return diaSemana 
	 */
	public String getDiaSemana() {
		return this.diaSemana;
	}

	/**
	 * Sets a value to attribute diaSemana. 
	 * @param newDiaSemana 
	 */
	public void setDiaSemana(String newDiaSemana) {
		this.diaSemana = newDiaSemana;
	}

	/**
	 * Returns indefinido.
	 * @return indefinido 
	 */
	public Boolean getIndefinido() {
		return this.indefinido;
	}

	/**
	 * Sets a value to attribute indefinido. 
	 * @param newIndefinido 
	 */
	public void setIndefinido(Boolean newIndefinido) {
		this.indefinido = newIndefinido;
	}

	/**
	 * Returns descripcion.
	 * @return descripcion 
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Sets a value to attribute descripcion. 
	 * @param newDescripcion 
	 */
	public void setDescripcion(String newDescripcion) {
		this.descripcion = newDescripcion;
	}

	/**
	 * Returns temporal.
	 * @return temporal 
	 */
	public Boolean getTemporal() {
		return this.temporal;
	}

	/**
	 * Sets a value to attribute temporal. 
	 * @param newTemporal 
	 */
	public void setTemporal(Boolean newTemporal) {
		this.temporal = newTemporal;
	}

	/**
	 * Returns fechaInicio.
	 * @return fechaInicio 
	 */
	public EDate getFechaInicio() {
		return this.fechaInicio;
	}

	/**
	 * Sets a value to attribute fechaInicio. 
	 * @param newFechaInicio 
	 */
	public void setFechaInicio(EDate newFechaInicio) {
		this.fechaInicio = newFechaInicio;
	}

	/**
	 * Returns porcentaje.
	 * @return porcentaje 
	 */
	public Integer getPorcentaje() {
		return this.porcentaje;
	}

	/**
	 * Sets a value to attribute porcentaje. 
	 * @param newPorcentaje 
	 */
	public void setPorcentaje(Integer newPorcentaje) {
		this.porcentaje = newPorcentaje;
	}

}
