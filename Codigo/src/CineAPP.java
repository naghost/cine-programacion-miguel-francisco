import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CineAPP {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	
		BBDD bd = new BBDD();
		VAdministrador iniciar = new VAdministrador(bd);
		iniciar.setVisible(true);
		
	
	}
	
}
