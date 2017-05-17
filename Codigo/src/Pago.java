/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Pago.
 * 
 * @author Migue
 */
public class Pago {
	/**
	 * Description of the property tarjeta.
	 */
	public EDouble tarjeta = null;

	/**
	 * Description of the property entradas.
	 */
	public HashSet<Entrada> entradas = new HashSet<Entrada>();

	/**
	 * Description of the property efectivo.
	 */
	public EDouble efectivo = null;

	/**
	 * Description of the property coste.
	 */
	public EDouble coste = null;

	// Start of user code (user defined attributes for Pago)

	// End of user code

	/**
	 * The constructor.
	 */
	public Pago() {
		// Start of user code constructor for Pago)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearPago.
	 */
	public void crearPago() {
		// Start of user code for method crearPago
		// End of user code
	}

	/**
	 * Description of the method eliminarPago.
	 */
	public void eliminarPago() {
		// Start of user code for method eliminarPago
		// End of user code
	}

	// Start of user code (user defined methods for Pago)

	// End of user code
	/**
	 * Returns tarjeta.
	 * @return tarjeta 
	 */
	public EDouble getTarjeta() {
		return this.tarjeta;
	}

	/**
	 * Sets a value to attribute tarjeta. 
	 * @param newTarjeta 
	 */
	public void setTarjeta(EDouble newTarjeta) {
		this.tarjeta = newTarjeta;
	}

	/**
	 * Returns entradas.
	 * @return entradas 
	 */
	public HashSet<Entrada> getEntradas() {
		return this.entradas;
	}

	/**
	 * Returns efectivo.
	 * @return efectivo 
	 */
	public EDouble getEfectivo() {
		return this.efectivo;
	}

	/**
	 * Sets a value to attribute efectivo. 
	 * @param newEfectivo 
	 */
	public void setEfectivo(EDouble newEfectivo) {
		this.efectivo = newEfectivo;
	}

	/**
	 * Returns coste.
	 * @return coste 
	 */
	public EDouble getCoste() {
		return this.coste;
	}

	/**
	 * Sets a value to attribute coste. 
	 * @param newCoste 
	 */
	public void setCoste(EDouble newCoste) {
		this.coste = newCoste;
	}

}
