
public class Bd {
	
	
	

	public Bd() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int controlAcceso() {
		
		//Si control es 0 no accede, si es 1 accede como administrador, si es 2 accede como empleado
		int control=0;
		String usuarioC=VControlAcceso.tusuario.getText();
		String claveC=VControlAcceso.tclave.getText();
		
		
		System.out.println(usuarioC+""+claveC);
		
		if(usuarioC.equals("Francisco") && claveC.equals("1234")){
			
			control=1;
			
		}
		
		if(usuarioC.equals("Diana") && claveC.equals("1234")){
			
			control=2;
			
		}
			
			
			
			
		
		
		
		return control;
	}
	
	

}
