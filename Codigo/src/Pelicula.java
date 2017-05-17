/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Pelicula.
 * 
 * @author Migue
 */
public class Pelicula {
	/**
	 * Description of the property Estreno.
	 */
	public EDate Estreno = null;

	/**
	 * Description of the property Titulo.
	 */
	public String Titulo = "";

	/**
	 * Description of the property Director.
	 */
	public String Director = "";

	/**
	 * Description of the property Genero.
	 */
	public String Genero = "";

	/**
	 * Description of the property Sinopsis.
	 */
	public String Sinopsis = "";

	/**
	 * Description of the property sesions.
	 */
	public HashSet<Sesion> sesions = new HashSet<Sesion>();

	// Start of user code (user defined attributes for Pelicula)

	// End of user code

	/**
	 * The constructor.
	 */
	public Pelicula() {
		// Start of user code constructor for Pelicula)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearPelicula.
	 */
	public void crearPelicula() {
		// Start of user code for method crearPelicula
		// End of user code
	}

	/**
	 * Description of the method borrarPelicula.
	 */
	public void borrarPelicula() {
		// Start of user code for method borrarPelicula
		// End of user code
	}

	/**
	 * Description of the method modificarPelicula.
	 */
	public void modificarPelicula() {
		// Start of user code for method modificarPelicula
		// End of user code
	}

	// Start of user code (user defined methods for Pelicula)

	// End of user code
	/**
	 * Returns Estreno.
	 * @return Estreno 
	 */
	public EDate getEstreno() {
		return this.Estreno;
	}

	/**
	 * Sets a value to attribute Estreno. 
	 * @param newEstreno 
	 */
	public void setEstreno(EDate newEstreno) {
		this.Estreno = newEstreno;
	}

	/**
	 * Returns Titulo.
	 * @return Titulo 
	 */
	public String getTitulo() {
		return this.Titulo;
	}

	/**
	 * Sets a value to attribute Titulo. 
	 * @param newTitulo 
	 */
	public void setTitulo(String newTitulo) {
		this.Titulo = newTitulo;
	}

	/**
	 * Returns Director.
	 * @return Director 
	 */
	public String getDirector() {
		return this.Director;
	}

	/**
	 * Sets a value to attribute Director. 
	 * @param newDirector 
	 */
	public void setDirector(String newDirector) {
		this.Director = newDirector;
	}

	/**
	 * Returns Genero.
	 * @return Genero 
	 */
	public String getGenero() {
		return this.Genero;
	}

	/**
	 * Sets a value to attribute Genero. 
	 * @param newGenero 
	 */
	public void setGenero(String newGenero) {
		this.Genero = newGenero;
	}

	/**
	 * Returns Sinopsis.
	 * @return Sinopsis 
	 */
	public String getSinopsis() {
		return this.Sinopsis;
	}

	/**
	 * Sets a value to attribute Sinopsis. 
	 * @param newSinopsis 
	 */
	public void setSinopsis(String newSinopsis) {
		this.Sinopsis = newSinopsis;
	}

	/**
	 * Returns sesions.
	 * @return sesions 
	 */
	public HashSet<Sesion> getSesions() {
		return this.sesions;
	}

}
