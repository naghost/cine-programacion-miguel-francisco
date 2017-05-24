import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class V1Taquillero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean control=true;
	private DefaultTableModel modelo;
	private JTable tableEntradas;
	private JScrollPane scrollPaneTableEntradas;
	private ArrayList <Sala> datosSala= new ArrayList<Sala>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1Taquillero frame = new V1Taquillero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1Taquillero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setBounds(26, 27, 57, 14);
		contentPane.add(lblPelicula);
		
		textField = new JTextField();
		textField.setBounds(93, 24, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSesin = new JLabel("Sesi\u00F3n");
		lblSesin.setBounds(26, 72, 46, 14);
		contentPane.add(lblSesin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(93, 69, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(26, 115, 46, 14);
		contentPane.add(lblSala);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 112, 143, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFechaFin = new JLabel("Fecha ");
		lblFechaFin.setBounds(381, 27, 53, 14);
		contentPane.add(lblFechaFin);
		
		JComboBox diaFFSesion = new JComboBox();
		diaFFSesion.setBounds(444, 24, 46, 20);
		contentPane.add(diaFFSesion);
		
		for(int i=1; i<=31; i++){
			
			
			diaFFSesion.addItem(i);
		}
		
		String [] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
		
		JComboBox mesFFSesion = new JComboBox(meses);
		mesFFSesion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				
				
				if(control){
					
					control=false;
				} else {
					
					control=true;
				}
				
				if (control){
				
				System.out.println(diaFFSesion.getItemCount());
				
				//diaEstreno.removeAll();
				
				System.out.println(arg0.getItem().toString());
				
				if(arg0.getItem().equals("Feb")){
					
					
					
					if(diaFFSesion.getItemCount()==31) {
						
						diaFFSesion.removeItemAt(30);
						diaFFSesion.removeItemAt(29);
						
					}
					
					if(diaFFSesion.getItemCount()==30) { 
						
						diaFFSesion.removeItemAt(29);
					}
					
					
				} else {
					
					if( arg0.getItem().equals("Ene") || arg0.getItem().equals("Mar") || arg0.getItem().equals("May") || arg0.getItem().equals("Jul") || arg0.getItem().equals("Ago") || arg0.getItem().equals("Oct") || arg0.getItem().equals("Dic")){
						diaFFSesion.setSelectedItem(31);
					
					if(diaFFSesion.getItemCount()==29){
						
						diaFFSesion.addItem("30");
						diaFFSesion.addItem("31");
					} 
					
					if (diaFFSesion.getItemCount()==30){
						
						diaFFSesion.addItem("31");
					}
					
					
					
					} else {
						
						if(diaFFSesion.getItemCount()==29){
							
							diaFFSesion.addItem("30");
							
						} 
						
						if (diaFFSesion.getItemCount()==31){
							
							diaFFSesion.removeItemAt(30);
						}
						
						
					}
				}}
			}
		});
		
		
		mesFFSesion.setBounds(500, 24, 63, 20);
		contentPane.add(mesFFSesion);
		mesFFSesion.setSelectedIndex(2);
		
		String [] anos = {"2017", "2018", "2019", "2020"};
		
		JComboBox anoFFSesion = new JComboBox(anos);
		anoFFSesion.setBounds(573, 24, 53, 20);
		contentPane.add(anoFFSesion);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(438, 111, 89, 23);
		contentPane.add(btnBuscar);
		
		modelo = new DefaultTableModel();
		 tableEntradas = new JTable(modelo/*data1, columnNames*/);
		 modelo.addColumn("Id Sesión");
		 modelo.addColumn("Pelicula");
		 modelo.addColumn("Sala");
		 modelo.addColumn("Fecha");
		 modelo.addColumn("Hora");
		 modelo.addColumn("Precio");
		 
		 tableEntradas .setPreferredScrollableViewportSize(new Dimension(400, 200));
		 scrollPaneTableEntradas = new JScrollPane(tableEntradas );
		 scrollPaneTableEntradas .setBounds(24, 157, 602, 357);
		 
		 
		 contentPane .add(scrollPaneTableEntradas );
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(381, 157, -133, -78);
		 contentPane .add(scrollPane);
		 
		 JButton btnCancelar = new JButton("Cancelar");
		 btnCancelar.setBounds(537, 111, 89, 23);
		 contentPane.add(btnCancelar);
		 
		 
		 //cargamos datos
		 for(int i=0; i<18; i++){
			 
			 datosSala.add(new Sala(1, 50, 60, "C3", "C5"));
			 
			 
		 }
		 
		
		 for(int i=0; i<datosSala.size(); i++){
			 
			 Object [] fila = new Object[5];
			 
			 fila[0] = datosSala.get(i).getIdSala();
			 fila[1] = datosSala.get(i).getFilas();
			 fila[2] = datosSala.get(i).getColumnas();
			 fila[3] = datosSala.get(i).getAudio();
			 fila[4] = datosSala.get(i).getVideo();
			 
			 modelo.addRow ( fila );
			 
		 }
		 
		 
		 tableEntradas .addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		
			 		
			 		System.out.println(tableEntradas .rowAtPoint(arg0.getPoint()));	
			 		
			 		V2Taquillero vt= new V2Taquillero("Chapolin Colorado");
					
					vt.setVisible(true);
					
					dispose();
			 		
			 		
			 	}});
	}
}
