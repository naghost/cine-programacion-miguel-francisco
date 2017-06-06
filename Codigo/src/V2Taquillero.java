import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class V2Taquillero extends JFrame {

	private JPanel contentPane;
	private JLabel lblButacas;
	private DibSala w;
	private int filas=6, columnas=13;
	private String butacasTex="Butacas: ";
	private String butacasSel="";
	private int sesion=0;
	private ArrayList<Butaca> butacas = new ArrayList<Butaca>();
	private final JButton btnNewButton = new JButton("New button");
	private BBDD bd= null;
	private String consulta="";
	private int idEmp=0;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public V2Taquillero(int IdEmp, String sesionE, String pelicula, String sala, String hora) {
		this.sesion=Integer.parseInt(sesionE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.idEmp=IdEmp;
		bd.Conexion();
		consulta="SELECT * FROM salas WHERE IDSalas="+sala;
		
		ResultSet contenido= bd.seleccionar(consulta);
		
		try {
			
			contenido.first();
			filas=Integer.parseInt(contenido.getString("Filas"));
			columnas=Integer.parseInt(contenido.getString("Columnas"));
			
			
		} catch(Exception e){
			
			
		}
		
		
		
		int x=5, y=5;
		for(int i=0; i<filas;i++){
			
			for(int e=0; e<columnas; e++){
				
					butacas.add(new Butaca(x,y, 1, i+1, e+1));
					x=x+50;
			}
			
			x=5;
			y=y+50;
		}
		
		
		bd.Conexion();
		consulta="SELECT Fila, Columna FROM entradas WHERE IDSesion="+sesionE;
		contenido= bd.seleccionar(consulta);
		
		try {
			
			contenido.last();
						
			if(contenido.getRow()>0){
				
				contenido.first();
				
				do{	
				
					for(int i=0; i<butacas.size(); i++){
					
						if(butacas.get(i).getF()==contenido.getInt("Fila") && butacas.get(i).getC()==contenido.getInt("Columna")){
						
							butacas.get(i).setEstado(0);
						
						}
					}
				
				}while(contenido.next());
				
								
			}
			
			
		} catch(Exception e){
			
		}
		
		bd.desconexion();
				
		w= new DibSala(butacas);
		contentPane.add(w);
		w.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 355, 589, 154);
		w.add(panel);
		panel.setLayout(null);
		
		JLabel lblPeliculaLaVilla = new JLabel("Titulo: "+pelicula);
		lblPeliculaLaVilla.setBounds(10, 11, 300, 14);
		panel.add(lblPeliculaLaVilla);
		
		JLabel lblSala = new JLabel("Sala: "+sala);
		lblSala.setBounds(10, 36, 46, 14);
		panel.add(lblSala);
		
		JLabel lblSesin = new JLabel("Sesi\u00F3n: "+hora);
		lblSesin.setBounds(10, 61, 300, 14);
		panel.add(lblSesin);
		
		JButton btnSiguiente = new JButton("Aceptar");
		btnSiguiente.setBounds(472, 92, 89, 23);
		panel.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String [] div = butacasSel.split(" "); 
				
				if(div.length>1){
							
					Entrada [] entradas= new Entrada[div.length-1];
				
					for(int i=0; i<entradas.length; i++){
						
						String [] fc = div[i+1].trim().split("C");
						
						int f=Integer.parseInt(fc[0].substring(1, fc[0].length()));
						int c=Integer.parseInt(fc[1]);
						
					
						entradas[i]=new Entrada(sesion, idEmp, 1, f, c,1);
					
					}
				
					V3Taquillero vt= new V3Taquillero(entradas, pelicula, hora);
					vt.setVisible(true);
					dispose();
				} else {
					
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna butaca!!");
					
				}
			}
		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(362, 92, 89, 23);
		panel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "La operación ha sido cancelada");
				V1Taquillero atras = new V1Taquillero(idEmp);
				atras.setVisible(true);
				dispose();
				
			}});
	
		lblButacas = new JLabel(butacasTex);
		lblButacas.setBounds(10, 96, 342, 14);
		panel.add(lblButacas);
		
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				butacasSel="";
				for(int i=0; i<butacas.size(); i++){
					
					if(arg0.getY()>butacas.get(i).y && arg0.getY()<butacas.get(i).y+50 && arg0.getX()>butacas.get(i).x && arg0.getX()<=butacas.get(i).x+50 ){
									
						if(butacas.get(i).estado!=0){
										
							if(butacas.get(i).estado==1){	
										
								butacas.get(i).estado=2;}
							else {
										
								butacas.get(i).estado=1;
								}
						}
					}
					
					if(butacas.get(i).getEstado()==2){
												
						butacasSel=butacasSel+" F"+butacas.get(i).getF()+"C"+butacas.get(i).getC();
					}
							
				}
				
				lblButacas.setText(butacasTex+""+butacasSel);
				w.butacas=butacas;
				w.repaint();
					
			}
		});
		
	
	}
}
