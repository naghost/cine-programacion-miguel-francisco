/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Empleado.
 * 
 * @author Migue
 */
public class Empleado {
	/**
	 * Description of the property apellidos.
	 */
	public String apellidos = "";

	/**
	 * Description of the property puesto.
	 */
	public String puesto = "";

	/**
	 * Description of the property dni.
	 */
	public String dni = "";

	/**
	 * Description of the property nombre.
	 */
	public String nombre = "";

	/**
	 * Description of the property entradas.
	 */
	public HashSet<Entrada> entradas = new HashSet<Entrada>();

	/**
	 * Description of the property edad.
	 */
	public Integer edad = Integer.valueOf(0);

	// Start of user code (user defined attributes for Empleado)

	// End of user code

	/**
	 * The constructor.
	 */
	public Empleado() {
		// Start of user code constructor for Empleado)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearEmpleado.
	 */
	public void crearEmpleado() {
		// Start of user code for method crearEmpleado
		// End of user code
	}

	/**
	 * Description of the method borrarEmpleado.
	 */
	public void borrarEmpleado() {
		// Start of user code for method borrarEmpleado
		// End of user code
	}

	/**
	 * Description of the method modificarEmpleado.
	 */
	public void modificarEmpleado() {
		// Start of user code for method modificarEmpleado
		// End of user code
	}

	// Start of user code (user defined methods for Empleado)

	// End of user code
	/**
	 * Returns apellidos.
	 * @return apellidos 
	 */
	public String getApellidos() {
		return this.apellidos;
	}

	/**
	 * Sets a value to attribute apellidos. 
	 * @param newApellidos 
	 */
	public void setApellidos(String newApellidos) {
		this.apellidos = newApellidos;
	}

	/**
	 * Returns puesto.
	 * @return puesto 
	 */
	public String getPuesto() {
		return this.puesto;
	}

	/**
	 * Sets a value to attribute puesto. 
	 * @param newPuesto 
	 */
	public void setPuesto(String newPuesto) {
		this.puesto = newPuesto;
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
	 * Returns nombre.
	 * @return nombre 
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Sets a value to attribute nombre. 
	 * @param newNombre 
	 */
	public void setNombre(String newNombre) {
		this.nombre = newNombre;
	}

	/**
	 * Returns entradas.
	 * @return entradas 
	 */
	public HashSet<Entrada> getEntradas() {
		return this.entradas;
	}

	/**
	 * Returns edad.
	 * @return edad 
	 */
	public Integer getEdad() {
		return this.edad;
	}

	/**
	 * Sets a value to attribute edad. 
	 * @param newEdad 
	 */
	public void setEdad(Integer newEdad) {
		this.edad = newEdad;
	}

}
