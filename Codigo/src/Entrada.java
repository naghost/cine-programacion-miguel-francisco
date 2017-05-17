/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Entrada.
 * 
 * @author Migue
 */
public class Entrada {
	/**
	 * Description of the property IDSocio.
	 */
	public Integer IDSocio = Integer.valueOf(0);

	/**
	 * Description of the property IDPago.
	 */
	public Integer IDPago = Integer.valueOf(0);

	/**
	 * Description of the property Precio.
	 */
	public EDouble Precio = null;

	/**
	 * Description of the property IDEmpleado.
	 */
	public Integer IDEmpleado = Integer.valueOf(0);

	/**
	 * Description of the property sesions.
	 */
	public HashSet<Sesion> sesions = new HashSet<Sesion>();

	/**
	 * Description of the property empleados.
	 */
	public HashSet<Empleado> empleados = new HashSet<Empleado>();

	/**
	 * Description of the property IDDescuento.
	 */
	public Integer IDDescuento = Integer.valueOf(0);

	/**
	 * Description of the property Columna.
	 */
	public Integer Columna = Integer.valueOf(0);

	/**
	 * Description of the property Fila.
	 */
	public Integer Fila = Integer.valueOf(0);

	/**
	 * Description of the property socios.
	 */
	public HashSet<Socio> socios = new HashSet<Socio>();

	/**
	 * Description of the property Suplemento.
	 */
	public Boolean Suplemento = Boolean.FALSE;

	/**
	 * Description of the property pagos.
	 */
	public HashSet<Pago> pagos = new HashSet<Pago>();

	/**
	 * Description of the property descuentos.
	 */
	public HashSet<Descuento> descuentos = new HashSet<Descuento>();

	/**
	 * Description of the property IDSesion.
	 */
	public Integer IDSesion = Integer.valueOf(0);

	// Start of user code (user defined attributes for Entrada)

	// End of user code

	/**
	 * The constructor.
	 */
	public Entrada() {
		// Start of user code constructor for Entrada)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearEntrada.
	 */
	public void crearEntrada() {
		// Start of user code for method crearEntrada
		// End of user code
	}

	/**
	 * Description of the method borrarEntrada.
	 */
	public void borrarEntrada() {
		// Start of user code for method borrarEntrada
		// End of user code
	}

	// Start of user code (user defined methods for Entrada)

	// End of user code
	/**
	 * Returns IDSocio.
	 * @return IDSocio 
	 */
	public Integer getIDSocio() {
		return this.IDSocio;
	}

	/**
	 * Sets a value to attribute IDSocio. 
	 * @param newIDSocio 
	 */
	public void setIDSocio(Integer newIDSocio) {
		this.IDSocio = newIDSocio;
	}

	/**
	 * Returns IDPago.
	 * @return IDPago 
	 */
	public Integer getIDPago() {
		return this.IDPago;
	}

	/**
	 * Sets a value to attribute IDPago. 
	 * @param newIDPago 
	 */
	public void setIDPago(Integer newIDPago) {
		this.IDPago = newIDPago;
	}

	/**
	 * Returns Precio.
	 * @return Precio 
	 */
	public EDouble getPrecio() {
		return this.Precio;
	}

	/**
	 * Sets a value to attribute Precio. 
	 * @param newPrecio 
	 */
	public void setPrecio(EDouble newPrecio) {
		this.Precio = newPrecio;
	}

	/**
	 * Returns IDEmpleado.
	 * @return IDEmpleado 
	 */
	public Integer getIDEmpleado() {
		return this.IDEmpleado;
	}

	/**
	 * Sets a value to attribute IDEmpleado. 
	 * @param newIDEmpleado 
	 */
	public void setIDEmpleado(Integer newIDEmpleado) {
		this.IDEmpleado = newIDEmpleado;
	}

	/**
	 * Returns sesions.
	 * @return sesions 
	 */
	public HashSet<Sesion> getSesions() {
		return this.sesions;
	}

	/**
	 * Returns empleados.
	 * @return empleados 
	 */
	public HashSet<Empleado> getEmpleados() {
		return this.empleados;
	}

	/**
	 * Returns IDDescuento.
	 * @return IDDescuento 
	 */
	public Integer getIDDescuento() {
		return this.IDDescuento;
	}

	/**
	 * Sets a value to attribute IDDescuento. 
	 * @param newIDDescuento 
	 */
	public void setIDDescuento(Integer newIDDescuento) {
		this.IDDescuento = newIDDescuento;
	}

	/**
	 * Returns Columna.
	 * @return Columna 
	 */
	public Integer getColumna() {
		return this.Columna;
	}

	/**
	 * Sets a value to attribute Columna. 
	 * @param newColumna 
	 */
	public void setColumna(Integer newColumna) {
		this.Columna = newColumna;
	}

	/**
	 * Returns Fila.
	 * @return Fila 
	 */
	public Integer getFila() {
		return this.Fila;
	}

	/**
	 * Sets a value to attribute Fila. 
	 * @param newFila 
	 */
	public void setFila(Integer newFila) {
		this.Fila = newFila;
	}

	/**
	 * Returns socios.
	 * @return socios 
	 */
	public HashSet<Socio> getSocios() {
		return this.socios;
	}

	/**
	 * Returns Suplemento.
	 * @return Suplemento 
	 */
	public Boolean getSuplemento() {
		return this.Suplemento;
	}

	/**
	 * Sets a value to attribute Suplemento. 
	 * @param newSuplemento 
	 */
	public void setSuplemento(Boolean newSuplemento) {
		this.Suplemento = newSuplemento;
	}

	/**
	 * Returns pagos.
	 * @return pagos 
	 */
	public HashSet<Pago> getPagos() {
		return this.pagos;
	}

	/**
	 * Returns descuentos.
	 * @return descuentos 
	 */
	public HashSet<Descuento> getDescuentos() {
		return this.descuentos;
	}

	/**
	 * Returns IDSesion.
	 * @return IDSesion 
	 */
	public Integer getIDSesion() {
		return this.IDSesion;
	}

	/**
	 * Sets a value to attribute IDSesion. 
	 * @param newIDSesion 
	 */
	public void setIDSesion(Integer newIDSesion) {
		this.IDSesion = newIDSesion;
	}

}
