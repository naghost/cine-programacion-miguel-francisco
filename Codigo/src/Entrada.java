
public class Entrada {

	private Integer IDPago = new Integer(0);
	private Integer IDDescuento = new Integer(0);
	private Integer IDSesion = new Integer(0);
	private Integer IDSocio = new Integer(0);
	private Integer IDEmpleado = new Integer(0);
	
	private Double Precio = new Double(0);
	private Integer Columna = new Integer(0);
	private Integer Fila = new Integer(0);
	private Boolean Suplemento = new Boolean(false);


	// Start of user code (user defined attributes for Entrada)

	// End of user code

	
	public Entrada(Integer iDSesion, Integer iDEmpleado, Integer iDSocio, Integer fila, Integer columna, int descuento) {
		super();
		IDSesion = iDSesion;
		IDEmpleado = iDEmpleado;
		IDSocio=iDSocio;
		Columna = columna;
		Fila = fila;
		IDDescuento=descuento;
	}

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

	/**
	 * @return the iDPago
	 */
	public Integer getIDPago() {
		return IDPago;
	}

	/**
	 * @param iDPago the iDPago to set
	 */
	public void setIDPago(Integer iDPago) {
		IDPago = iDPago;
	}

	/**
	 * @return the iDDescuento
	 */
	public Integer getIDDescuento() {
		return IDDescuento;
	}

	/**
	 * @param iDDescuento the iDDescuento to set
	 */
	public void setIDDescuento(Integer iDDescuento) {
		IDDescuento = iDDescuento;
	}

	/**
	 * @return the iDSesion
	 */
	public Integer getIDSesion() {
		return IDSesion;
	}

	/**
	 * @param iDSesion the iDSesion to set
	 */
	public void setIDSesion(Integer iDSesion) {
		IDSesion = iDSesion;
	}

	/**
	 * @return the iDSocio
	 */
	public Integer getIDSocio() {
		return IDSocio;
	}

	/**
	 * @param iDSocio the iDSocio to set
	 */
	public void setIDSocio(Integer iDSocio) {
		IDSocio = iDSocio;
	}

	/**
	 * @return the iDEmpleado
	 */
	public Integer getIDEmpleado() {
		return IDEmpleado;
	}

	/**
	 * @param iDEmpleado the iDEmpleado to set
	 */
	public void setIDEmpleado(Integer iDEmpleado) {
		IDEmpleado = iDEmpleado;
	}

	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return Precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		Precio = precio;
	}

	/**
	 * @return the columna
	 */
	public Integer getColumna() {
		return Columna;
	}

	/**
	 * @param columna the columna to set
	 */
	public void setColumna(Integer columna) {
		Columna = columna;
	}

	/**
	 * @return the fila
	 */
	public Integer getFila() {
		return Fila;
	}

	/**
	 * @param fila the fila to set
	 */
	public void setFila(Integer fila) {
		Fila = fila;
	}

	/**
	 * @return the suplemento
	 */
	public Boolean getSuplemento() {
		return Suplemento;
	}

	/**
	 * @param suplemento the suplemento to set
	 */
	public void setSuplemento(Boolean suplemento) {
		Suplemento = suplemento;
	}

	// Start of user code (user defined methods for Entrada)

	// End of user code
	

}