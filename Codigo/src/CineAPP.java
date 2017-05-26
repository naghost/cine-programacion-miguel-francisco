

public class CineAPP {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		BBDD bd = new BBDD();
		VAdministrador iniciar = new VAdministrador(bd);
		iniciar.setVisible(true);
		
	
	}
	
}
