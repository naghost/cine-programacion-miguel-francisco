/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Sesion.
 * 
 * @author Migue
 */
public class Sesion {
	/**
	 * Description of the property entradas.
	 */
	public HashSet<Entrada> entradas = new HashSet<Entrada>();

	/**
	 * Description of the property fechaHora.
	 */
	public EDate fechaHora = null;

	/**
	 * Description of the property IDPrecio.
	 */
	public Integer IDPrecio = Integer.valueOf(0);

	/**
	 * Description of the property salas.
	 */
	public HashSet<Sala> salas = new HashSet<Sala>();

	/**
	 * Description of the property precioss.
	 */
	public HashSet<Precios> precioss = new HashSet<Precios>();

	/**
	 * Description of the property peliculas.
	 */
	public HashSet<Pelicula> peliculas = new HashSet<Pelicula>();

	/**
	 * Description of the property IDPelicula.
	 */
	public Integer IDPelicula = Integer.valueOf(0);

	/**
	 * Description of the property IDSala.
	 */
	public Integer IDSala = Integer.valueOf(0);

	// Start of user code (user defined attributes for Sesion)

	// End of user code

	/**
	 * The constructor.
	 */
	public Sesion() {
		// Start of user code constructor for Sesion)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearSesion.
	 */
	public void crearSesion() {
		// Start of user code for method crearSesion
		// End of user code
	}

	/**
	 * Description of the method borrarSesion.
	 */
	public void borrarSesion() {
		// Start of user code for method borrarSesion
		// End of user code
	}

	/**
	 * Description of the method modificarSesion.
	 */
	public void modificarSesion() {
		// Start of user code for method modificarSesion
		// End of user code
	}

	// Start of user code (user defined methods for Sesion)

	// End of user code
	/**
	 * Returns entradas.
	 * @return entradas 
	 */
	public HashSet<Entrada> getEntradas() {
		return this.entradas;
	}

	/**
	 * Returns fechaHora.
	 * @return fechaHora 
	 */
	public EDate getFechaHora() {
		return this.fechaHora;
	}

	/**
	 * Sets a value to attribute fechaHora. 
	 * @param newFechaHora 
	 */
	public void setFechaHora(EDate newFechaHora) {
		this.fechaHora = newFechaHora;
	}

	/**
	 * Returns IDPrecio.
	 * @return IDPrecio 
	 */
	public Integer getIDPrecio() {
		return this.IDPrecio;
	}

	/**
	 * Sets a value to attribute IDPrecio. 
	 * @param newIDPrecio 
	 */
	public void setIDPrecio(Integer newIDPrecio) {
		this.IDPrecio = newIDPrecio;
	}

	/**
	 * Returns salas.
	 * @return salas 
	 */
	public HashSet<Sala> getSalas() {
		return this.salas;
	}

	/**
	 * Returns precioss.
	 * @return precioss 
	 */
	public HashSet<Precios> getPrecioss() {
		return this.precioss;
	}

	/**
	 * Returns peliculas.
	 * @return peliculas 
	 */
	public HashSet<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	/**
	 * Returns IDPelicula.
	 * @return IDPelicula 
	 */
	public Integer getIDPelicula() {
		return this.IDPelicula;
	}

	/**
	 * Sets a value to attribute IDPelicula. 
	 * @param newIDPelicula 
	 */
	public void setIDPelicula(Integer newIDPelicula) {
		this.IDPelicula = newIDPelicula;
	}

	/**
	 * Returns IDSala.
	 * @return IDSala 
	 */
	public Integer getIDSala() {
		return this.IDSala;
	}

	/**
	 * Sets a value to attribute IDSala. 
	 * @param newIDSala 
	 */
	public void setIDSala(Integer newIDSala) {
		this.IDSala = newIDSala;
	}

}
