
public class Sala {
	
	private int idSala=0;
	private int filas=0;
	private int columnas =0;
	private String audio="";
	private String video ="";
	
	
	
	
	public Sala(int idSala, int filas, int columnas, String audio, String video) {
		super();
		this.idSala = idSala;
		this.filas = filas;
		this.columnas = columnas;
		this.audio = audio;
		this.video = video;
	}
	/**
	 * @return the idSala
	 */
	public int getIdSala() {
		return idSala;
	}
	/**
	 * @param idSala the idSala to set
	 */
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	/**
	 * @return the filas
	 */
	public int getFilas() {
		return filas;
	}
	/**
	 * @param filas the filas to set
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}
	/**
	 * @return the columnas
	 */
	public int getColumnas() {
		return columnas;
	}
	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
	/**
	 * @return the audio
	 */
	public String getAudio() {
		return audio;
	}
	/**
	 * @param audio the audio to set
	 */
	public void setAudio(String audio) {
		this.audio = audio;
	}
	/**
	 * @return the video
	 */
	public String getVideo() {
		return video;
	}
	/**
	 * @param video the video to set
	 */
	public void setVideo(String video) {
		this.video = video;
	}
	

}
