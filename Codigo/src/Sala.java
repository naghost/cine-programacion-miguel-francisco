/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Sala.
 * 
 * @author Migue
 */
public class Sala {
	/**
	 * Description of the property Columnas.
	 */
	public Integer Columnas = Integer.valueOf(0);

	/**
	 * Description of the property Filas.
	 */
	public Integer Filas = Integer.valueOf(0);

	/**
	 * Description of the property Audio.
	 */
	public String Audio = "";

	/**
	 * Description of the property Video.
	 */
	public String Video = "";

	/**
	 * Description of the property sesions.
	 */
	public HashSet<Sesion> sesions = new HashSet<Sesion>();

	// Start of user code (user defined attributes for Sala)

	// End of user code

	/**
	 * The constructor.
	 */
	public Sala() {
		// Start of user code constructor for Sala)
		super();
		// End of user code
	}

	/**
	 * Description of the method crearSala.
	 */
	public void crearSala() {
		// Start of user code for method crearSala
		// End of user code
	}

	/**
	 * Description of the method modificarSala.
	 */
	public void modificarSala() {
		// Start of user code for method modificarSala
		// End of user code
	}

	/**
	 * Description of the method eliminarSala.
	 */
	public void eliminarSala() {
		// Start of user code for method eliminarSala
		// End of user code
	}

	// Start of user code (user defined methods for Sala)

	// End of user code
	/**
	 * Returns Columnas.
	 * @return Columnas 
	 */
	public Integer getColumnas() {
		return this.Columnas;
	}

	/**
	 * Sets a value to attribute Columnas. 
	 * @param newColumnas 
	 */
	public void setColumnas(Integer newColumnas) {
		this.Columnas = newColumnas;
	}

	/**
	 * Returns Filas.
	 * @return Filas 
	 */
	public Integer getFilas() {
		return this.Filas;
	}

	/**
	 * Sets a value to attribute Filas. 
	 * @param newFilas 
	 */
	public void setFilas(Integer newFilas) {
		this.Filas = newFilas;
	}

	/**
	 * Returns Audio.
	 * @return Audio 
	 */
	public String getAudio() {
		return this.Audio;
	}

	/**
	 * Sets a value to attribute Audio. 
	 * @param newAudio 
	 */
	public void setAudio(String newAudio) {
		this.Audio = newAudio;
	}

	/**
	 * Returns Video.
	 * @return Video 
	 */
	public String getVideo() {
		return this.Video;
	}

	/**
	 * Sets a value to attribute Video. 
	 * @param newVideo 
	 */
	public void setVideo(String newVideo) {
		this.Video = newVideo;
	}

	/**
	 * Returns sesions.
	 * @return sesions 
	 */
	public HashSet<Sesion> getSesions() {
		return this.sesions;
	}

}
