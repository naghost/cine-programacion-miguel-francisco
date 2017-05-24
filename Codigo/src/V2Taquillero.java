import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class V2Taquillero extends JFrame {

	private JPanel contentPane;
	JLabel lblButacas;
	DibSala w;
	int filas=6, columnas=13;
	String butacasTex="Butacas: ";
	//Walk w1= new Walk(10,10,1);
	
	ArrayList<Butaca> butacas = new ArrayList<Butaca>();
	private final JButton btnNewButton = new JButton("New button");
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba2 frame = new Prueba2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public V2Taquillero(String pelicula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		int x=5, y=5;
		
		for(int i=0; i<filas;i++){
			
			for(int e=0; e<columnas; e++){
				
								
					butacas.add(new Butaca(x,y, 1, i+1, e+1));
								
				x=x+50;
			}
			x=5;
			y=y+50;
		}
		
		
		
		
		w= new DibSala(butacas);
		contentPane.add(w);
		w.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 355, 589, 154);
		w.add(panel);
		panel.setLayout(null);
		
		JLabel lblPeliculaLaVilla = new JLabel(pelicula);
		lblPeliculaLaVilla.setBounds(10, 11, 175, 14);
		panel.add(lblPeliculaLaVilla);
		
		JLabel lblSala = new JLabel("Sala: 5");
		lblSala.setBounds(10, 36, 46, 14);
		panel.add(lblSala);
		
		JLabel lblSesin = new JLabel("Sesi\u00F3n: 22/08/2017 22:00");
		lblSesin.setBounds(10, 61, 150, 14);
		panel.add(lblSesin);
		
		JButton btnSiguiente = new JButton("Aceptar");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				V3Taquillero vt= new V3Taquillero();
				vt.setVisible(true);
				dispose();
				
			}
		});
		btnSiguiente.setBounds(472, 92, 89, 23);
		panel.add(btnSiguiente);
		
		JButton btnAtrs = new JButton("Cancelar");
		btnAtrs.setBounds(362, 92, 89, 23);
		panel.add(btnAtrs);
	
		lblButacas = new JLabel(butacasTex);
		lblButacas.setBounds(10, 96, 342, 14);
		panel.add(lblButacas);
		
		
			
			
			//contentPane.add(w1);
			//btnNewButton.setBounds(161, 92, 89, 23);
			
			
			
		
	
		
		
	
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				butacasTex="Butacas: ";
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
						
						
						butacasTex=butacasTex+" F"+butacas.get(i).getF()+"C"+butacas.get(i).getC();
					}
					
					
				
				}
				
				lblButacas.setText(butacasTex);
				w.butacas=butacas;
				w.repaint();
					
				
				}
		});
		
			
		
		//}
		
		
		
		
	}
}
