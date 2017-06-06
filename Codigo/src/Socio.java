
public class Socio extends Usuario{
	
	private String dni="";
	
	public Socio(String nombre, String apellidos, String dni) {
		super(nombre, apellidos);
		this.dni = dni;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public boolean comprobarDni() {
		// TODO Auto-generated method stub
		// Array con las letras posibles del dni en su posición
		boolean comprobar=true;
        char[] letraDni = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };  
  
       String num= "";
        int ind = 0;  
  
       // boolean que nos indicara si es un dni correcto o no
        boolean valido;
  
       // existen dnis con 7 digitos numericos, si fuese el caso
        // le añado un cero al principio
        if(dni.length() == 8) {
             dni = "0" + dni;
              
        }
  
        if(dni.length()==9) {
        	// compruebo que el 9º digito es una letra
        	if (Character.isLetter(dni.charAt(8))) {
              
           		// compruebo su longitud que sea 9
        		if (dni.length() == 9){   
             
        			 // Compruebo que lo 8 primeros digitos sean numeros
			        for (int i=0; i<8; i++)  {
			   
			            if(!Character.isDigit(dni.charAt(i))){
			                   comprobar=false;    
			             }
			             // si es numero, lo recojo en un String
			             num += dni.charAt(i);     
			         }
  
			        // paso a int el string donde tengo el numero del dni
        
			        if(comprobar){
        	
			        	ind = Integer.parseInt(num);
        
			        	// calculo la posición de la letra en el array que corresponde a este dni
			        	ind %= 23;
  
			        	// verifico que la letra del dni corresponde con la del array
			        	if ((Character.toUpperCase(dni.charAt(8))) != letraDni[ind]){
			        		
			        		comprobar=false;
			        	} 
        
			        }
        
        
        		} else {
        			
        			comprobar=false;
        			}
        	} else {
        		
        		comprobar=false;
        		
        		}
        } else {comprobar=false;
        	}
        return comprobar;
   	}



	

	

}
