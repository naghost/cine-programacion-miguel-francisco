/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Precios.
 * 
 * @author Migue
 */
public class Precios {
	/**
	 * Description of the property Precio.
	 */
	public EDouble Precio = null;

	/**
	 * Description of the property nombrePrecio.
	 */
	public String nombrePrecio = "";

	/**
	 * Description of the property sesions.
	 */
	public HashSet<Sesion> sesions = new HashSet<Sesion>();

	// Start of user code (user defined attributes for Precios)

	// End of user code

	/**
	 * The constructor.
	 */
	public Precios() {
		// Start of user code constructor for Precios)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearPrecio.
	 */
	public void crearPrecio() {
		// Start of user code for method crearPrecio
		// End of user code
	}

	/**
	 * Description of the method eliminarPrecio.
	 */
	public void eliminarPrecio() {
		// Start of user code for method eliminarPrecio
		// End of user code
	}

	/**
	 * Description of the method modificarPrecio.
	 */
	public void modificarPrecio() {
		// Start of user code for method modificarPrecio
		// End of user code
	}

	// Start of user code (user defined methods for Precios)

	// End of user code
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
	 * Returns nombrePrecio.
	 * @return nombrePrecio 
	 */
	public String getNombrePrecio() {
		return this.nombrePrecio;
	}

	/**
	 * Sets a value to attribute nombrePrecio. 
	 * @param newNombrePrecio 
	 */
	public void setNombrePrecio(String newNombrePrecio) {
		this.nombrePrecio = newNombrePrecio;
	}

	/**
	 * Returns sesions.
	 * @return sesions 
	 */
	public HashSet<Sesion> getSesions() {
		return this.sesions;
	}

}
