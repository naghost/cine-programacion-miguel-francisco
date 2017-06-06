
public abstract class Usuario {
	
	
	protected String nombre="";
	protected String apellidos="";
	
	
	public Usuario( String nombre, String apellidos) {
		
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

		
	abstract public boolean comprobarDni ();
	
}
