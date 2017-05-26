import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlErrores {

	public ControlErrores() {
	
		
		// 1 Comprueba si el string introducido es un Entero
		// 2 Comprueba si el string introducido es un Decimal, depende de isEntero	
		// 3 Comprueba si el string introducido es una sola palabra solo con letras
		// 4 Comprueba si el string introducido son varias palabras o una solo letras, depende de isPalabra
		// 5 Comprueba si el string introducido es una sola palabra con letras y numeros
		// 6 Comprueba si el string introducido son varias palabras o una de letras y enteros, depende de isPalabraEntero
		//Comprueba si el numero de digitos o caracteres está entre un max y un min incluidos.
		// 7 Comprueba formato de fecha (dd/mm/aaaa) y su validez.
		// 8 Comprueba formato (nnnnnnnnl) y valida dni
		//Devuelve la fecha actual.
		//Compara dos fechas y devuelve 1 si la primera fechas es mayor, 2 si la segunda es mayor y 0 si son iguales, -1 si da error. 
		//Compara dos rangos de fechas y comprueba si se pisa o un uno al otro. True no se pisan. False se pisan
		//Compara dos fechas y dice cuantos dias meses y años hay entre una y otra.
		//Comprueba dirección de correo solo gmail.com y hotmail.com
		//Devuelve el numero de dias de un mes dependiendo del año
		
	}
	
	//Comprueba si el string introducido es un Entero	
	public boolean isEntero (String entero) {
		
		
		String cadena="0123456789"; 
		int c=0;
		boolean bandera=false;
		
		for (int i=0; i<cadena.length(); i++){
			
			for (int e=0; e<entero.length(); e++){
				
				if(entero.substring(e, (e+1)).equals(cadena.substring(i, (i+1)))){
					
					c++;
		
				}
			
			}
		}
		
		if(c==entero.length()){
			
			bandera=true;
			
		}
		
		return bandera;
	}
	
	//Comprueba si el string introducido es un Decimal, depende de isEntero	
	public boolean isDecimal (String entero) {
	
	boolean bandera=false;
	String [] dividir = entero.split("\\.");
	
	if(dividir.length==2){
		
		if(isEntero(dividir[0]) && isEntero(dividir[1])){
			
			bandera=true;			
			
		}
				
	}
	
	return bandera;
	
	}
	
	//Comprueba si el string introducido es una sola palabra solo con letras	
		public boolean isPalabra (String palabra) {
		
		String cadena="abcdefghijklmnñopqrstuvwxyzáéíóú"; 
		int c=0;
		boolean bandera=false;
		
		for (int i=0; i<cadena.length(); i++){
			
			for (int e=0; e<palabra.length(); e++){
				
				if(palabra.substring(e, (e+1)).toLowerCase().equals(cadena.substring(i, (i+1)))){
					
					c++;
		
				}
			
			}
		}
		
		if(c==palabra.length()){
			
			bandera=true;
			
		}
		
		
			
		return bandera;	
		}
		
	//Comprueba si el string introducido son varias palabras o una solo letras, depende de isPalabra	
		public boolean isPalabras (String palabras) {
		
		boolean bandera=false;
		String cadena="";
		String [] dividir = palabras.split(" ");
		
		if(dividir.length>0){
			
			for(int i=0; i<dividir.length; i++){
				
				cadena=cadena+dividir[i];
			}
					
		}
		
		if(isPalabra(cadena)){
			
			bandera=true;
		}
		
		return bandera;
		
		}
		
		
		
		//Comprueba si el string introducido es una sola palabra con letras y numeros	
		public boolean isPalabraEntero (String palabra) {
		
		String cadena="abcdefghijklmnñopqrstuvwxyzáéíóú0123456789"; 
		int c=0;
		boolean bandera=false;
		
		for (int i=0; i<cadena.length(); i++){
			
			for (int e=0; e<palabra.length(); e++){
				
				if(palabra.substring(e, (e+1)).toLowerCase().equals(cadena.substring(i, (i+1)))){
					
					c++;
		
				}
			
			}
		}
		
		if(c==palabra.length()){
			
			bandera=true;
			
		}
		
		
			
		return bandera;	
		}
		
			
	//Comprueba si el string introducido son varias palabras o una de letras y enteros, depende de isPalabraEntero	
		public boolean isPalabrasEntero (String palabras) {
		
		boolean bandera=false;
		String cadena="";
		String [] dividir = palabras.split(" ");
		
		if(dividir.length>0){
			
			for(int i=0; i<dividir.length; i++){
				
				cadena=cadena+dividir[i];
			}
					
		}
		
		if(isPalabra(cadena)){
			
			bandera=true;
		}
		
		return bandera;
		
		}
		
		
		//Comprueba si el numero de digitos o caracteres está entre un max y un min incluidos.
		public boolean isIntcar (String cadena, int max, int min) {
		
		boolean bandera=false;
		
		//Eliminar espacios
		cadena=cadena.replace(" ","");
		
		if(cadena.length()<=max && cadena.length()>=min){
			
			bandera=true;
		}
				
		return bandera;
				
		}
		
		//Comprueba formato de fecha (dd/mm/aaaa) y su validez.
		public boolean isValFecha (String fecha) {
				
		boolean bandera=false;
		int dia=0, mes=0, ano=0;
		String [] div;
				
		div=fecha.split("/");
		
		if(div.length==3) {
			
			if(div[0].length()==2 && div[1].length()==2 && div[2].length()==4){
				
				
				if(isEntero(div[0]) && isEntero(div[1]) && isEntero(div[2]) ) {
					
					dia=Integer.parseInt(div[0]);
					mes=Integer.parseInt(div[1]);
					ano=Integer.parseInt(div[2]);
					
					if(dia>0 && dia<diasMes(ano, mes)+1 && mes>0 && mes<13 && ano>1500 && ano<2500){
						
						bandera=true;
												
					}
				}
				
			}
			
			
		}
		
				
		
						
		return bandera;
						
				}
		
				
		//Comprueba formato (nnnnnnnnl) y valida dni
		public boolean isDni(String dni) {
		
			boolean bandera=false;
			String num="", letra="", valores="trwagmyfpdxbnjzsqvhlcke";
			
			
			if(dni.length()==9) {
				
				
				letra= dni.substring(8, 9);
				num=dni.substring(0, 8);
				
				if(isEntero(num) && isPalabra(letra)){
					
					int n= Integer.parseInt(num);
					letra= letra.toLowerCase();
					
					
					n=n%23;
					
					if(n>=0 && n<=22){
						
						if(letra.equals(valores.substring(n, n+1))){
							
							bandera=true;
							
						}
						
						
					}
					
					
				}
				
				
				
			}
			
			
			
			
			
			
		return bandera;	
		}	
		
		//Devuelve la fecha actual. 
		public String fechaACtual(){
			
		Date date = new Date ();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		int dia=Integer.parseInt(sdf.format(date).toString().substring(0,2));
		int mes=Integer.parseInt(sdf.format(date).toString().substring(3,5));
		int ano=Integer.parseInt(sdf.format(date).toString().substring(6,10));
		String fecha="";
		
		if(dia<10) {
			
			fecha="0"+dia;
		}else {
			
			fecha=""+dia;
		}
		
		if (mes<10){
			
			fecha=fecha+"/0"+mes+"/"+ano;
			
		} else{
			
			fecha=fecha+"/"+mes+"/"+ano;
		}
		
		
		return fecha;
		}
		//Compara dos fechas y devuelve 1 si la primera fechas es mayor, 2 si la segunda es mayor y 0 si son iguales, -1 si da error. 
		
		public int comparaFechas(String f1, String f2){
			
			int respuesta=-1, d1=0, d2=0, m1=0, m2=0, a1=0, a2=0;
			
			if(isValFecha(f1) && isValFecha(f2)){
				
				d1=Integer.parseInt(f1.substring(0,2));
				d2=Integer.parseInt(f2.substring(0,2));
				
				m1=Integer.parseInt(f1.substring(3,5));
				m2=Integer.parseInt(f2.substring(3,5));
				
				a1=Integer.parseInt(f1.substring(6,10));
				a2=Integer.parseInt(f2.substring(6,10));
				
				if(a1==a2){
					
					if(m1==m2){
						
						if(d1==d2){
							
							respuesta=0;
							
						}else {
							
							if(d1>d2){
								
								respuesta=1;
							} else {
								
								respuesta=2;
								
							}
							
						}
						
					}else {
						
						if(m1>m2){
							
							respuesta=1;
						} else {
							
							respuesta=2;
							
						}
						
						
					}
					
				} else {
					
					if(a1>a2){
						
						respuesta=1;
					} else {
						
						respuesta=2;
						
					}					
					
				}
				
				System.out.println(d1+" "+m1+" "+a1 );
				
			} else {
				
				respuesta=-1;
				
			}
			
			
			return respuesta;
		}
		
	//Compara dos rangos de fechas y comprueba si se pisa o un uno al otro. True no se pisan. False se pisan
		
			public boolean rangoFechas (String r1f1, String r1f2, String r2f1, String r2f2) {
				
				boolean bandera=false;
				
				if(comparaFechas(r1f1,r1f2)==2 && comparaFechas(r2f1,r2f2)==2){
					
					if((comparaFechas(r1f1, r2f1)==2 && comparaFechas(r1f2, r2f1)==2) || (comparaFechas(r1f1, r2f2)==1 && comparaFechas(r1f2, r2f2)==1)){
						
						
						bandera=true;
						
					}
					
					
				}
				
				
				
				return bandera;				
			}
		
	//Compara dos fechas y dice cuantos dias meses y años hay entre una y otra. 
			public int [] difFechas(String f1, String f2){
			
			//primer valor dias, segundo mes, tercero año
			int [] dif= new int[3];
			String[] fecha1, fecha2;
			
			
			
			if(comparaFechas(f1, f2)==2){
				
			
				fecha1=f1.split("/");
				fecha2=f2.split("/");
				
				
					
					dif[2]=(Integer.parseInt(fecha2[2])- Integer.parseInt(fecha1[2]));
					
				
				
				if(Integer.parseInt(fecha1[1])<=Integer.parseInt(fecha2[1])){
					
				
					dif[1]= ((Integer.parseInt(fecha2[1])- Integer.parseInt(fecha1[1])));
					
				} else {
					
					dif[1]= ((12- Integer.parseInt(fecha1[1])) + Integer.parseInt(fecha2[1]));
					
					dif[2]--;
					
				}
				
				if(Integer.parseInt(fecha1[0])<=Integer.parseInt(fecha2[0])) {
					
					dif[0]= Integer.parseInt(fecha2[0])-Integer.parseInt(fecha1[0]);	
					
				} else {
					
					
					dif[0]=((diasMes(Integer.parseInt(fecha1[2]), Integer.parseInt(fecha1[1])))-Integer.parseInt(fecha1[0]))+Integer.parseInt(fecha2[0]);
					dif[1]--;
				}
				
				
				
				
			}
			
			
			
			
			return dif;
		}
		
		//Comprueba dirección de correo solo gmail.com y hotmail.com
		public boolean isEmail(String email){
			
			boolean bandera=false;
			
			String [] division=email.split("@");
			
		
			
			if(division.length==2){
				
				if(division[1].equals("hotmail.com") || division[1].equals("gmail.com")){
					
					
					bandera=true;
					
				}
				
			}
			
			return bandera;
		}
		
		
		
		//Devuelve el numero de dias de un mes dependiendo del año
		public int diasMes (int ano, int mes1){
			
			int dias=0;
			
			
			switch (mes1){
			
			case 1:
				
				dias=31;
				
				break;
				
			case 2:
				
				boolean bisiesto=false;
				
				if((ano%4)==0){
					
					if((ano%100)==0){
						
						
						if((ano%400)==0){
							
							//Es numero bisiesto
							bisiesto=true;
						}else {
							
							//No es numero bisiesto
							bisiesto=false;
						}
						
					}else {
						
						//Es numero bisiesto
						bisiesto=true;
					}
					
				}else {
					//No es bisiesto
					bisiesto=false;
				}
				
				
				if(bisiesto){
					dias=29;
				} else {
					dias=28;
					}	
					
				
				break;
			case 3:
				
				dias=31;
				break;
			case 4:
				dias=30;
				
				break;
			case 5:
				dias=31;
				break;
				
			case 6:
				dias=30;
				
				break;
			case 7:
				dias=31;
				break;
			case 8:
				dias=31;
				break;
			case 9:
				dias=30;
				break;
				
			case 10:
				dias=31;
				break;
			case 11:
				dias=30;
				
				break;
			case 12:
				dias=31;
				break;
			
			
			}			
			
			
			return dias;
		}
		
		
		//Devuelve el día de la semana
		public int DiasSemana(int dia, int mes,int ano){
			
			int D=26, M=8, A=1984, A1=84, a=0, b=0, c=0, d=0, e=0;
			
			A1=ano%100;
			A=ano;
			M=mes;
			D=dia;
			
			if(A>1699 && A<1800) {
				
				a=5;
			}else if(A>1799 && A<1900) {
				a=3;
				
			}else if(A>1899 && A<2000) {
				
				a=1;
				
			}else if(A>1999 && A<2100) {
				a=0;
				
			}else if(A>2099 && A<2200) {
				
				a=-2;
			}else if(A>2199 && A<2300) {
				
				a=-4;
				
			}
			
			
			b=A1+(A1/4);
			
			
			boolean bisiesto=false;
			
			if((A%4)==0){
				
				if((A%100)==0){
					
					
					if((A%400)==0){
						
						//Es numero bisiesto
						bisiesto=true;
					}else {
						
						//No es numero bisiesto
						bisiesto=false;
					}
					
				}else {
					
					//Es numero bisiesto
					bisiesto=true;
				}
				
			}else {
				//No es bisiesto
				bisiesto=false;
			}
			
			if(bisiesto && (M==1||M==2)){
				
				
				c=-1;
				
			}else {
				
				c=0;
				
			}
			
			
			switch(M){
			
			case 1:
				d=6;
				break;
			case 2:
				d=2;
				break;
			case 3:
				d=2;
				break;
			case 4:
				d=5;
				break;
			case 5:
				d=0;
				break;
			case 6:
				d=3;
				break;
			case 7:
				d=5;
				break;
			case 8:
				d=1;
				break;
			case 9:
				d=4;
				break;
			case 10:
				d=6;
				break;
			case 11:
				d=2;
				break;
			case 12:
				d=4;
				break;
			}
			
			
			
			e=D;
			
			a=a+b+c+d+e;
			
			while (a>7){
				
				a=a-7;
				
			}
			
			return a;
			
		}
		
		//Cambio de formato por ejemplo de 01Ene2017 a 01/01/2017
		public String camFormat1 (String diaIn, String mesIn, String anoIn) {

			int mes=0;
			String fechaOu="";

			String[] meses ={"Ene", "Feb", "Mar", "Abri", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

			for(int i=0; i<meses.length; i++) {

				if(mesIn.equals(meses[i])){

					mes=i+1;
					
				}

			}
			
			if(mes<10) {fechaOu=diaIn+"/0"+mes+"/"+anoIn;} else {fechaOu=diaIn+"/"+mes+"/"+anoIn;}
			
			return fechaOu;

		}



		//Cambio de formato por ejemplo de 01/01/2017 a 01Ene2017
		public String[] camFormat2 (String fechaIn) {

			int mes;
			String [] fechaOu=  fechaIn.split("/");

			String[] meses ={"Ene", "Feb", "Mar", "Abri", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

			fechaOu[1]= meses[Integer.parseInt(fechaOu[1])-1];
			
			return fechaOu;

		}

		//Cambio de formato por ejemplo de 01/02/2017 a 20170201
		public String camFormat3 (String fechaIn) {

			String fechaOu;

			String [] div = fechaIn.split("/");
			
			fechaOu=div[2]+""+div[1]+""+div[0];
			
			return fechaOu;

		}
		
		
		
		
		
		
		

}
