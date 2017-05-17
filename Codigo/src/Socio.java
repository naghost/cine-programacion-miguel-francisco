/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Socio.
 * 
 * @author Migue
 */
public class Socio {
	/**
	 * Description of the property Apellido.
	 */
	public String Apellido = "";

	/**
	 * Description of the property dni.
	 */
	public String dni = "";

	/**
	 * Description of the property Nombre.
	 */
	public String Nombre = "";

	/**
	 * Description of the property entradas.
	 */
	public HashSet<Entrada> entradas = new HashSet<Entrada>();

	// Start of user code (user defined attributes for Socio)

	// End of user code

	/**
	 * The constructor.
	 */
	public Socio() {
		// Start of user code constructor for Socio)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearCliente.
	 */
	public void crearCliente() {
		// Start of user code for method crearCliente
		// End of user code
	}

	/**
	 * Description of the method eliminarCliente.
	 */
	public void eliminarCliente() {
		// Start of user code for method eliminarCliente
		// End of user code
	}

	/**
	 * Description of the method borrarCliente.
	 */
	public void borrarCliente() {
		// Start of user code for method borrarCliente
		// End of user code
	}

	// Start of user code (user defined methods for Socio)

	// End of user code
	/**
	 * Returns Apellido.
	 * @return Apellido 
	 */
	public String getApellido() {
		return this.Apellido;
	}

	/**
	 * Sets a value to attribute Apellido. 
	 * @param newApellido 
	 */
	public void setApellido(String newApellido) {
		this.Apellido = newApellido;
	}

	/**
	 * Returns dni.
	 * @return dni 
	 */
	public String getDni() {
		return this.dni;
	}

	/**
	 * Sets a value to attribute dni. 
	 * @param newDni 
	 */
	public void setDni(String newDni) {
		this.dni = newDni;
	}

	/**
	 * Returns Nombre.
	 * @return Nombre 
	 */
	public String getNombre() {
		return this.Nombre;
	}

	/**
	 * Sets a value to attribute Nombre. 
	 * @param newNombre 
	 */
	public void setNombre(String newNombre) {
		this.Nombre = newNombre;
	}

	/**
	 * Returns entradas.
	 * @return entradas 
	 */
	public HashSet<Entrada> getEntradas() {
		return this.entradas;
	}

}
