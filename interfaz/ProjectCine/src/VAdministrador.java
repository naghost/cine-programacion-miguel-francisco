import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAdministrador extends JFrame {

	private JPanel contentPane;
	private JPanel panelSalas;
	//No necesito
	private JTextField textFTituloPelicula;
	private JTextField textFTitulo;
	private JTextField textFDirectorPeliculas;
	private JTextField textFBusquedaPeliculas;
	//
	private SimpleDateFormat formatFechaSQL;
	private SimpleDateFormat formatFechaDate;
	private int idDes=0;
	private int idSoc=0;
	private int idEmp=0;
	private JDateChooser cFecIniDescuentos;
	private JDateChooser cFecFinDescuentos;
	//No necesito
	private DefaultTableModel modelo;
	private DefaultTableModel modelo2;
	private DefaultTableModel modelo3;
	//
	private DefaultTableModel modelTableDescuentos;
	private DefaultTableModel modelTableEntradas;
	//No necesito
	private DefaultTableModel modelo6;
	//
	private DefaultTableModel modelTablePagos;
	private DefaultTableModel modelTableSocios;
	private DefaultTableModel modelTableEmpleados;
	private JTable tablePeliculas;
	private JTable tableSalas;
	private JTable tableSesiones;
	private JTable tableDescuentos;
	private JTable tableEntradas;
	private JTable tablePrecios;
	private JTable tablePagos;
	private JTable tableSocios;
	private JTable tableEmpleados;
	private JScrollPane scrollPaneTablePeliculas;
	private JScrollPane scrollPaneTableSalas;
	private JScrollPane scrollPaneTableSesiones;
	private JScrollPane scrollPaneTableDescuentos;
	private JScrollPane scrollPaneTableEntradas;
	private JScrollPane scrollPaneTablePrecios;
	private JScrollPane scrollPaneTablePagos;
	private JScrollPane scrollPaneTableSocios;
	private JScrollPane scrollPaneTableEmpleados;
	private ArrayList <Sala> datosSala = new ArrayList<Sala>();
	//no lo necesito
	private boolean control=true;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	//
	private JTextField tFNombreDescuento;
	private JSpinner sPPorDescuento;
	/*private JTextField tFPorDescuentos;*/
	private JTextField tFBuscarDescuento;
	private JTextField tFEntradas;
	//no necesito
	private JTextField textField_10;
	private JTextField textField_16;
	private JTextField textField_17;
	//
	private JTextField tFPago;
	private JTextField tFNombreSocio;
	private JTextField tFApellidosSocio;
	private JTextField tFDniSocio;
	private JTextField tFBuscarSocio;
	private JTextField tFNombreEmpleado;
	private JTextField tFApellidosEmpleado;
	private JTextField tFDniEmpleado;
	private JTextField tFBuscarEmpleado;
	private Bbdd bd = new Bbdd();
	private ResultSet contiene=null;
	private String consulta="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAdministrador frame = new VAdministrador();
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
	public VAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane pestana = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(pestana, BorderLayout.CENTER);
		
		JPanel panelPeliculas = new JPanel();
		
		
		
		//Ventana de Peliculas
		pestana.addTab("Peliculas", null, panelPeliculas, null);
		panelPeliculas.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(24, 31, 46, 14);
		panelPeliculas.add(lblTitulo);
		
		textFTituloPelicula = new JTextField();
		textFTituloPelicula.setBounds(78, 28, 183, 20);
		panelPeliculas.add(textFTituloPelicula);
		textFTituloPelicula.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		lblGnero.setBounds(24, 62, 46, 14);
		panelPeliculas.add(lblGnero);
		
		
		
		JComboBox cBGeneros = new JComboBox();
		
		
		cBGeneros.setBounds(78, 59, 183, 20);
		panelPeliculas.add(cBGeneros);
		cBGeneros.addItem("Documental");
		cBGeneros.addItem("Biográfico");
		cBGeneros.addItem("Histórico");
		cBGeneros.addItem("Musical");
		cBGeneros.addItem("Comedia");
		cBGeneros.addItem("Infantil");
		cBGeneros.addItem("Western");
		cBGeneros.addItem("Aventura");
		cBGeneros.addItem("Accion");
		cBGeneros.addItem("Bélico");
		cBGeneros.addItem("Ciencia ficción");
		cBGeneros.addItem("Drama");
		cBGeneros.addItem("Suspenso");
		cBGeneros.addItem("Terror / horror");
		cBGeneros.addItem("Porno-erótico");
		
		//cBGeneros.removeItemAt(0);
		
		JLabel lblEstreno = new JLabel("Estreno");
		lblEstreno.setBounds(24, 90, 46, 14);
		panelPeliculas.add(lblEstreno);
		
		JComboBox diaEstreno = new JComboBox();
		diaEstreno.setBounds(79, 87, 46, 20);
		panelPeliculas.add(diaEstreno);
		
		for(int i=1; i<=31; i++){
			
			
			diaEstreno.addItem(i);
		}
		
		String [] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
		
		JComboBox mesEstreno = new JComboBox(meses);
		mesEstreno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				
				
				if(control){
					
					control=false;
				} else {
					
					control=true;
				}
				
				if (control){
				
				System.out.println(diaEstreno.getItemCount());
				
				//diaEstreno.removeAll();
				
				if(arg0.getItem().equals("Feb")){
					
					
					if(diaEstreno.getItemCount()==31) {
						
						diaEstreno.removeItemAt(30);
						diaEstreno.removeItemAt(29);
						
					}
					
					if(diaEstreno.getItemCount()==30) { 
						
						diaEstreno.removeItemAt(29);
					}
					
					
				} else {
					
					if( arg0.getItem().equals("Ene") || arg0.getItem().equals("Mar") || arg0.getItem().equals("May") || arg0.getItem().equals("Jul") || arg0.getItem().equals("Ago") || arg0.getItem().equals("Oct") || arg0.getItem().equals("Dic")){
					diaEstreno.setSelectedItem(31);
					
					if(diaEstreno.getItemCount()==29){
						
						diaEstreno.addItem("30");
						diaEstreno.addItem("31");
					} 
					
					if (diaEstreno.getItemCount()==30){
						
						diaEstreno.addItem("31");
					}
					
					
					
					} else {
						
						if(diaEstreno.getItemCount()==29){
							
							diaEstreno.addItem("30");
							
						} 
						
						if (diaEstreno.getItemCount()==31){
							
							diaEstreno.removeItemAt(30);
						}
						
						
					}
				}}
			}
		});
		
		
		mesEstreno.setBounds(135, 87, 63, 20);
		panelPeliculas.add(mesEstreno);
		mesEstreno.setSelectedIndex(2);
		
		
		Integer [] anos = {2017, 2018, 2019, 2020};
		JComboBox anoEstreno = new JComboBox(anos);
		anoEstreno.setBounds(208, 87, 53, 20);
		panelPeliculas.add(anoEstreno);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(308, 34, 63, 14);
		panelPeliculas.add(lblDirector);
		
		textFDirectorPeliculas = new JTextField();
		textFDirectorPeliculas.setBounds(381, 28, 164, 20);
		panelPeliculas.add(textFDirectorPeliculas);
		textFDirectorPeliculas.setColumns(10);
		
		JLabel lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setBounds(308, 62, 63, 14);
		panelPeliculas.add(lblSinopsis);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(381, 57, 164, 102);
		panelPeliculas.add(textArea);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnAadir.setBounds(271, 170, 89, 23);
		panelPeliculas.add(btnAadir);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(370, 170, 89, 23);
		panelPeliculas.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(469, 170, 89, 23);
		panelPeliculas.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(24, 170, 89, 23);
		panelPeliculas.add(btnBuscar);
		
		textFBusquedaPeliculas = new JTextField();
		textFBusquedaPeliculas.setBounds(123, 171, 137, 20);
		panelPeliculas.add(textFBusquedaPeliculas);
		textFBusquedaPeliculas.setColumns(10);
		
		
		
		
		
		modelo = new DefaultTableModel();
		 tablePeliculas = new JTable(modelo/*data1, columnNames*/);
		 modelo.addColumn("Id");
		 modelo.addColumn("Filas");
		 modelo.addColumn("Columnas");
		 modelo.addColumn("Audio");
		 modelo.addColumn("Video");
		 
		 tablePeliculas.setPreferredScrollableViewportSize(new Dimension(400, 200));
		 scrollPaneTablePeliculas= new JScrollPane(tablePeliculas);
		 scrollPaneTablePeliculas.setBounds(24, 220, 534, 252);
		 
		 
		 panelPeliculas.add(scrollPaneTablePeliculas);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(381, 157, -133, -78);
		 panelPeliculas.add(scrollPane);
		 
		 
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
		 
		 
		 tablePeliculas.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		
			 		
			 		System.out.println(tablePeliculas.rowAtPoint(arg0.getPoint()));			 		
			 		
			 		
			 	}});
		 //Termina Ventana de Peliculas
		 
		 //Ventana de Salas
		 JPanel panelSalas = new JPanel();
			pestana.addTab("Salas", null, panelSalas, null);
			panelSalas.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(23, 35, 58, 14);
			panelSalas.add(lblNombre);
			
			textField = new JTextField();
			textField.setBounds(150, 32, 178, 20);
			panelSalas.add(textField);
			textField.setColumns(10);
			
			JLabel lblFilasDeButacas = new JLabel("Filas de Butacas");
			lblFilasDeButacas.setBounds(23, 76, 95, 14);
			panelSalas.add(lblFilasDeButacas);
			
			textField_1 = new JTextField();
			textField_1.setBounds(150, 73, 46, 20);
			panelSalas.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblColumnasDeButacas = new JLabel("Columnas de Butacas");
			lblColumnasDeButacas.setBounds(23, 116, 117, 14);
			panelSalas.add(lblColumnasDeButacas);
			
			textField_2 = new JTextField();
			textField_2.setBounds(150, 113, 46, 20);
			panelSalas.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblAudio = new JLabel("Audio");
			lblAudio.setBounds(23, 157, 58, 14);
			panelSalas.add(lblAudio);
			
			textField_3 = new JTextField();
			textField_3.setBounds(150, 154, 86, 20);
			panelSalas.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblVideo = new JLabel("Video");
			lblVideo.setBounds(23, 199, 58, 14);
			panelSalas.add(lblVideo);
			
			textField_4 = new JTextField();
			textField_4.setBounds(150, 196, 86, 20);
			panelSalas.add(textField_4);
			textField_4.setColumns(10);
			
			JButton btnBuscar_1 = new JButton("Buscar");
			btnBuscar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnBuscar_1.setBounds(23, 239, 89, 23);
			panelSalas.add(btnBuscar_1);
			
			textField_5 = new JTextField();
			textField_5.setBounds(122, 240, 153, 20);
			panelSalas.add(textField_5);
			textField_5.setColumns(10);
			
			JButton btnAadir_1 = new JButton("A\u00F1adir");
			btnAadir_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAadir_1.setBounds(285, 239, 89, 23);
			panelSalas.add(btnAadir_1);
			
			JButton btnModificar_1 = new JButton("Modificar");
			btnModificar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnModificar_1.setBounds(384, 239, 89, 23);
			panelSalas.add(btnModificar_1);
			
			JButton btnEliminar_1 = new JButton("Eliminar");
			btnEliminar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnEliminar_1.setBounds(483, 239, 89, 23);
			panelSalas.add(btnEliminar_1);
			
			
			
			modelo2 = new DefaultTableModel();
			 tableSalas = new JTable(modelo2/*data1, columnNames*/);
			 modelo2.addColumn("Id");
			 modelo2.addColumn("Filas");
			 modelo2.addColumn("Columnas");
			 modelo2.addColumn("Audio");
			 modelo2.addColumn("Video");
			 
			 tableSalas .setPreferredScrollableViewportSize(new Dimension(400, 200));
			 scrollPaneTableSalas = new JScrollPane(tableSalas );
			 scrollPaneTableSalas .setBounds(23, 270, 549, 202);
			 
			 
			 panelSalas.add(scrollPaneTableSalas );
			 
			 
			 
			 
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
				 
				 modelo2.addRow ( fila );
				 
			 }
			 
			 
			 tableSalas .addMouseListener(new MouseAdapter() {
				 	@Override
				 	public void mouseClicked(MouseEvent arg0) {
				 		
				 		
				 		
				 		System.out.println(tableSalas .rowAtPoint(arg0.getPoint()));			 		
				 		
				 		
				 	}});
			 
			 
			 
			 // Ventana de Sesiones
			 JPanel panelSesiones = new JPanel();
				pestana.addTab("Sesiones", null, panelSesiones, null);
				panelSesiones.setLayout(null);
				
				JLabel lblIdDeSalaEnSesion = new JLabel("Id Sala");
				lblIdDeSalaEnSesion .setBounds(22, 34, 61, 14);
				panelSesiones.add(lblIdDeSalaEnSesion );
				
				textField_6 = new JTextField();
				textField_6.setBounds(124, 31, 44, 20);
				panelSesiones.add(textField_6);
				textField_6.setColumns(10);
				
				JLabel lblNombreDeSalaEnSesion = new JLabel("Nombre de Sala");
				lblNombreDeSalaEnSesion .setBounds(22, 78, 96, 14);
				panelSesiones.add(lblNombreDeSalaEnSesion );
				
				textField_7 = new JTextField();
				textField_7.setBounds(124, 75, 121, 20);
				panelSesiones.add(textField_7);
				textField_7.setColumns(10);
				
				JLabel lblIdPelicula = new JLabel("Id Pelicula");
				lblIdPelicula.setBounds(22, 121, 61, 14);
				panelSesiones.add(lblIdPelicula);
				
				textField_8 = new JTextField();
				textField_8.setBounds(124, 118, 44, 20);
				panelSesiones.add(textField_8);
				textField_8.setColumns(10);
				
				JLabel lblNombreDePelicula = new JLabel("Nombre de Pelicula");
				lblNombreDePelicula.setBounds(22, 166, 96, 14);
				panelSesiones.add(lblNombreDePelicula);
				
				textField_9 = new JTextField();
				textField_9.setBounds(124, 163, 121, 20);
				panelSesiones.add(textField_9);
				textField_9.setColumns(10);
				
				JLabel lblFechaIncio = new JLabel("Fecha Inicio");
				lblFechaIncio.setBounds(302, 34, 68, 14);
				panelSesiones.add(lblFechaIncio);
				
				
				JComboBox diaFISesion = new JComboBox();
				diaFISesion.setBounds(380, 31, 46, 20);
				panelSesiones.add(diaFISesion);
				
				for(int i=1; i<=31; i++){
					
					
					diaFISesion.addItem(i);
				}
				
				
				
				JComboBox mesFISesion = new JComboBox(meses);
				mesFISesion.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						
						
						
						if(control){
							
							control=false;
						} else {
							
							control=true;
						}
						
						if (control){
						
						System.out.println(diaFISesion.getItemCount());
						
						//diaEstreno.removeAll();
						
						if(arg0.getItem().equals("Feb")){
							
							
							if(diaFISesion.getItemCount()==31) {
								
								diaFISesion.removeItemAt(30);
								diaFISesion.removeItemAt(29);
								
							}
							
							if(diaFISesion.getItemCount()==30) { 
								
								diaFISesion.removeItemAt(29);
							}
							
							
						} else {
							
							if( arg0.getItem().equals("Ene") || arg0.getItem().equals("Mar") || arg0.getItem().equals("May") || arg0.getItem().equals("Jul") || arg0.getItem().equals("Ago") || arg0.getItem().equals("Oct") || arg0.getItem().equals("Dic")){
								diaFISesion.setSelectedItem(31);
							
							if(diaFISesion.getItemCount()==29){
								
								diaFISesion.addItem("30");
								diaFISesion.addItem("31");
							} 
							
							if (diaFISesion.getItemCount()==30){
								
								diaFISesion.addItem("31");
							}
							
							
							
							} else {
								
								if(diaFISesion.getItemCount()==29){
									
									diaFISesion.addItem("30");
									
								} 
								
								if (diaFISesion.getItemCount()==31){
									
									diaFISesion.removeItemAt(30);
								}
								
								
							}
						}}
					}
				});
				
				
				mesFISesion.setBounds(436, 31, 63, 20);
				panelSesiones.add(mesFISesion);
				mesFISesion.setSelectedIndex(2);
				
				
				
				JComboBox anoFISesion = new JComboBox(anos);
				anoFISesion.setBounds(509, 31, 53, 20);
				panelSesiones.add(anoFISesion);
				
				JLabel lblFechaFin = new JLabel("Fecha Fin");
				lblFechaFin.setBounds(302, 78, 53, 14);
				panelSesiones.add(lblFechaFin);
				
				JComboBox diaFFSesion = new JComboBox();
				diaFFSesion.setBounds(380, 75, 46, 20);
				panelSesiones.add(diaFFSesion);
				
				for(int i=1; i<=31; i++){
					
					
					diaFFSesion.addItem(i);
				}
				
				
				
				JComboBox mesFFSesion = new JComboBox(meses);
				mesFFSesion.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						
						System.out.println("final");
						
						if(control){
							
							control=false;
						} else {
							
							control=true;
						}
						
						if (control){
						
						System.out.println(diaFFSesion.getItemCount());
						
						//diaEstreno.removeAll();
						
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
				
				
				mesFFSesion.setBounds(436, 75, 63, 20);
				panelSesiones.add(mesFFSesion);
				mesFFSesion.setSelectedIndex(2);
				
				
				
				JComboBox anoFFSesion = new JComboBox(anos);
				anoFFSesion.setBounds(509, 75, 53, 20);
				panelSesiones.add(anoFFSesion);
				
				JRadioButton rdbtnL = new JRadioButton("L");
				rdbtnL.setBounds(302, 117, 36, 23);
				panelSesiones.add(rdbtnL);
				
				JRadioButton rdbtnM = new JRadioButton("M");
				rdbtnM.setBounds(340, 117, 36, 23);
				panelSesiones.add(rdbtnM);
				
				JRadioButton rdbtnX = new JRadioButton("X");
				rdbtnX.setBounds(380, 117, 36, 23);
				panelSesiones.add(rdbtnX);
				
				JRadioButton rdbtnJ = new JRadioButton("J");
				rdbtnJ.setBounds(417, 117, 36, 23);
				panelSesiones.add(rdbtnJ);
				
				JRadioButton rdbtnV = new JRadioButton("V");
				rdbtnV.setBounds(455, 117, 36, 23);
				panelSesiones.add(rdbtnV);
				
				JRadioButton rdbtnS = new JRadioButton("S");
				rdbtnS.setBounds(493, 117, 36, 23);
				panelSesiones.add(rdbtnS);
				
				JRadioButton rdbtnD = new JRadioButton("D");
				rdbtnD.setBounds(533, 117, 51, 23);
				panelSesiones.add(rdbtnD);
				
				
				
				JLabel lblHora = new JLabel("Hora");
				lblHora.setBounds(302, 166, 46, 14);
				panelSesiones.add(lblHora);
				
				JComboBox horaSesion = new JComboBox();
				horaSesion.setBounds(380, 163, 46, 20);
				panelSesiones.add(horaSesion);
				
				for(int i=0; i<=23; i++){
					
					
					horaSesion.addItem(i);
				}
				
				
				
				
				
				JComboBox minSesion = new JComboBox();
				minSesion.setBounds(436, 163, 46, 20);
				panelSesiones.add(minSesion);
				
							
				
				JLabel lblPrecio = new JLabel("Precio");
				lblPrecio.setBounds(22, 213, 85, 14);
				panelSesiones.add(lblPrecio);
				

				JComboBox precioSesion = new JComboBox();
				precioSesion.setBounds(124, 210, 121, 20);
				panelSesiones.add(precioSesion);
				
				precioSesion.addItem("Normal");
				
				
				
				JButton btnBuscar_2 = new JButton("Buscar");
				btnBuscar_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnBuscar_2.setBounds(18, 249, 100, 23);
				panelSesiones.add(btnBuscar_2);
				
				textField_11 = new JTextField();
				textField_11.setBounds(124, 250, 144, 20);
				panelSesiones.add(textField_11);
				textField_11.setColumns(10);
				
				JButton btnInsertar = new JButton("Insertar");
				btnInsertar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnInsertar.setBounds(294, 249, 89, 23);
				panelSesiones.add(btnInsertar);
				
				JButton btnModificar_2 = new JButton("Modificar");
				btnModificar_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnModificar_2.setBounds(393, 249, 89, 23);
				panelSesiones.add(btnModificar_2);
				
				JButton btnEliminar_2 = new JButton("Eliminar");
				btnEliminar_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnEliminar_2.setBounds(491, 249, 89, 23);
				panelSesiones.add(btnEliminar_2);
				
				for(int i=0; i<=59; i++){
					
					
					minSesion.addItem(i);
				}
				
				
				modelo3 = new DefaultTableModel();
				 tableSesiones = new JTable(modelo3/*data1, columnNames*/);
				 modelo3.addColumn("Id");
				 modelo3.addColumn("Filas");
				 modelo3.addColumn("Columnas");
				 modelo3.addColumn("Audio");
				 modelo3.addColumn("Video");
				 
				 tableSesiones .setPreferredScrollableViewportSize(new Dimension(400, 200));
				 scrollPaneTableSesiones = new JScrollPane(tableSesiones );
				 scrollPaneTableSesiones.setBounds(22, 283, 562, 202);
				 
				 
				 panelSesiones.add(scrollPaneTableSesiones );
				 
				 
				 
				 
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
					 
					 modelo3.addRow ( fila );
					 
				 }
				 
				 
				 tableSesiones .addMouseListener(new MouseAdapter() {
					 	@Override
					 	public void mouseClicked(MouseEvent arg0) {
					 		
					 		
					 		
					 		System.out.println(tableSesiones .rowAtPoint(arg0.getPoint()));			 		
					 		
					 		
					 	}});
				 //Fin ventana de Sesiones
				 
				 
				 //Ventana de Descuentos
				 JPanel panelDescuentos = new JPanel();
					pestana.addTab("Descuentos", null, panelDescuentos, null);
					panelDescuentos.setLayout(null);
					
					
					JLabel lblNombreDescuento = new JLabel("Nombre ");
					lblNombreDescuento.setBounds(25, 36, 58, 14);
					panelDescuentos.add(lblNombreDescuento);
					
					tFNombreDescuento = new JTextField();
					tFNombreDescuento.setBounds(102, 33, 145, 20);
					panelDescuentos.add(tFNombreDescuento);
					tFNombreDescuento.setColumns(10);
					JLabel lblDescDescuento = new JLabel("Descripcion");
					lblDescDescuento.setBounds(25, 87, 68, 14);
					panelDescuentos.add(lblDescDescuento);
					
					tFNombreDescuento.addKeyListener(new KeyAdapter(){
						 
						public void keyTyped(KeyEvent e) {
							
							if (tFNombreDescuento.getText().length()== 30){
							
								e.consume();
							}
						    
						}						 
						
					});
					
					JTextArea tADesDescuento = new JTextArea();
					tADesDescuento.setBounds(0, 0, 145, 105);
					//textArea_1.setEditable(false);
					tADesDescuento.setLineWrap(true); 
					JScrollPane scroll = new JScrollPane(tADesDescuento);
					scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scroll.setBounds(102, 82, 145, 105);
					panelDescuentos.add(scroll);
									
					
					tADesDescuento.addKeyListener(new KeyAdapter(){
						 
						public void keyTyped(KeyEvent e) {
							
							if (tADesDescuento.getText().length()== 300){
							
								e.consume();
							}
						    
						}						 
						
					});
					
					
					JLabel lblFIDescuentos = new JLabel("Fecha Inicio");
					lblFIDescuentos .setBounds(302, 34, 68, 14);
					panelDescuentos.add(lblFIDescuentos);
					
					formatFechaSQL = new java.text.SimpleDateFormat("yyyy-MM-dd");
					formatFechaDate = new java.text.SimpleDateFormat("dd/MM/yyyy");
					
					cFecIniDescuentos = new JDateChooser();
					cFecIniDescuentos.setBounds(450, 34, 95, 20);
					panelDescuentos.add(cFecIniDescuentos);
					
					//Cambia formato de fecha
					cFecIniDescuentos.setDateFormatString("dd/MM/yyyy");
					//Coloca una fecha por defecto	
					cFecIniDescuentos.setDate(Calendar.getInstance().getTime());
					cFecIniDescuentos.setMinSelectableDate(Calendar.getInstance().getTime());
					
					
					cFecIniDescuentos.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(PropertyChangeEvent arg0) { 
							
							cFecFinDescuentos.setMinSelectableDate(cFecIniDescuentos.getDate());
							
						}});
					
					
					JLabel lblFFDescuentos = new JLabel("Fecha Fin");
					lblFFDescuentos.setBounds(302, 78, 53, 14);
					panelDescuentos.add(lblFFDescuentos);
					
					cFecFinDescuentos = new JDateChooser();
					cFecFinDescuentos.setBounds(450, 78, 95, 20);
					panelDescuentos.add(cFecFinDescuentos);
					
					//Cambia formato de fecha
					cFecFinDescuentos.setDateFormatString("dd/MM/yyyy");
					//Coloca una fecha por defecto	
					cFecFinDescuentos.setDate(Calendar.getInstance().getTime());
					cFecFinDescuentos.setMinSelectableDate(Calendar.getInstance().getTime());
					cFecIniDescuentos.setMaxSelectableDate(cFecFinDescuentos.getDate());
					
					cFecFinDescuentos.addPropertyChangeListener(new PropertyChangeListener() {
						public void propertyChange(PropertyChangeEvent arg0) { 
							
							cFecIniDescuentos.setMaxSelectableDate(cFecFinDescuentos.getDate());
							
						}});
					
					
					JRadioButton rdbtnDescuentosL = new JRadioButton("L");
					rdbtnDescuentosL.setBounds(302, 117, 36, 23);
					panelDescuentos.add(rdbtnDescuentosL);
					
					JRadioButton rdbtnDescuentosM = new JRadioButton("M");
					rdbtnDescuentosM.setBounds(340, 117, 36, 23);
					panelDescuentos.add(rdbtnDescuentosM);
					
					JRadioButton rdbtnDescuentosX = new JRadioButton("X");
					rdbtnDescuentosX.setBounds(380, 117, 36, 23);
					panelDescuentos.add(rdbtnDescuentosX);
					
					JRadioButton rdbtnDescuentosJ = new JRadioButton("J");
					rdbtnDescuentosJ.setBounds(417, 117, 36, 23);
					panelDescuentos.add(rdbtnDescuentosJ);
					
					JRadioButton rdbtnDescuentosV = new JRadioButton("V");
					rdbtnDescuentosV.setBounds(455, 117, 36, 23);
					panelDescuentos.add(rdbtnDescuentosV);
					
					JRadioButton rdbtnDescuentosS = new JRadioButton("S");
					rdbtnDescuentosS.setBounds(493, 117, 36, 23);
					panelDescuentos.add(rdbtnDescuentosS);
					
					JRadioButton rdbtnDescuentosD = new JRadioButton("D");
					rdbtnDescuentosD.setBounds(533, 117, 51, 23);
					panelDescuentos.add(rdbtnDescuentosD);
					
					JLabel lblPorcDescuentos = new JLabel("Porcentaje");
					lblPorcDescuentos.setBounds(302, 163, 68, 20);
					panelDescuentos.add(lblPorcDescuentos);
					
					sPPorDescuento = new JSpinner();
					sPPorDescuento.setBounds(366, 160, 36, 20);
					panelDescuentos.add(sPPorDescuento);
					SpinnerNumberModel nm = new SpinnerNumberModel();
			        nm.setMaximum(100);
			        nm.setMinimum(0);
			        sPPorDescuento.setModel(nm);
					
															
					JLabel lbPorcentaje = new JLabel("%");
					lbPorcentaje.setBounds(412, 163, 19, 14);
					panelDescuentos.add(lbPorcentaje);
					
					JRadioButton rdbtnTemporal = new JRadioButton("Temporal");
					rdbtnTemporal.setBounds(453, 159, 109, 23);
					panelDescuentos.add(rdbtnTemporal);
					
					JButton btnBuscarDescuento = new JButton("Buscar");
					btnBuscarDescuento.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
														 
							 VaciarTabla(modelTableDescuentos);
							 
							 bd.Conexion();
							 
							 if(tFBuscarDescuento.getText().equals("")){
							 
								 consulta="SELECT * FROM descuentos";
								 
							 } else {
								 
								 consulta="SELECT * FROM `descuentos` WHERE IDDescuento='"+tFBuscarDescuento.getText()+"' OR Nombre LIKE '%"+tFBuscarDescuento.getText()+"%'";
								 
							 }
							 
							 contiene=bd.seleccionar(consulta);
							 
							 try {	
									
								 contiene.last();
								 
								
								 if(contiene.getRow()>0) {
								
									 contiene.first();
									 
									 do {
										 System.out.println(contiene.getRow()+" Numero de filas");
										 
										 Object [] fila = new Object[8];
										 
										 fila[0]=contiene.getString("IDDescuento");
										 
										 fila[1] = contiene.getString("Nombre");
										 
										 fila[2] = contiene.getString("Descripcion"); 
										 
										 String [] fecha = contiene.getString("FechaInicio").split("-");
										 fila[3] = fecha[2]+"/"+fecha[1]+"/"+fecha[0];
										
										  fecha = contiene.getString("FechaFin").split("-");
										 fila[4] = fecha[2]+"/"+fecha[1]+"/"+fecha[0];
										 
										 fila[5] = contiene.getString("DiaSemana");
										 
										 fila[6] = contiene.getString("Porcentaje");
										 
										 if(contiene.getString("Temporal").equals("0")){
											 
											 fila[7] ="No"; 
											 
										 } else {
											 
											 fila[7] ="Si";
										 }
									 			 
										 modelTableDescuentos.addRow ( fila );
										 
										 
									 } while(contiene.next());
								 } else {
									 
									 JOptionPane.showMessageDialog(null, "No se han encontrado resultados!!");
								 }
									
								} catch(Exception er){}
									
							 bd.desconexion();
						}
					});
					btnBuscarDescuento.setBounds(21, 213, 96, 23);
					panelDescuentos.add(btnBuscarDescuento);
					
					tFBuscarDescuento = new JTextField();
					tFBuscarDescuento.setBounds(127, 214, 145, 20);
					panelDescuentos.add(tFBuscarDescuento);
					tFBuscarDescuento.setColumns(10);
					
					tFBuscarDescuento.addKeyListener(new KeyAdapter(){
						 
						public void keyTyped(KeyEvent e) {
							
							if (tFBuscarDescuento.getText().length()== 30){
							
								e.consume();
							}
						    
						}						 
						
					});
					
					JButton btnAddDescuento = new JButton("A\u00F1adir");
					btnAddDescuento.setBounds(287, 213, 89, 23);
					panelDescuentos.add(btnAddDescuento);
					
					btnAddDescuento.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String diasSemana="";
							
							if (rdbtnDescuentosD.isSelected()) {
								
								diasSemana=diasSemana+"1";
							}
							
							if (rdbtnDescuentosL.isSelected()) {
								
								diasSemana=diasSemana+"2";
							}
							
							if (rdbtnDescuentosM.isSelected()) {
								
								diasSemana=diasSemana+"3";
							}
							
							if (rdbtnDescuentosX.isSelected()) {
								
								diasSemana=diasSemana+"4";
							}
							
							if (rdbtnDescuentosJ.isSelected()) {
								
								diasSemana=diasSemana+"5";
							}
							
							if (rdbtnDescuentosV.isSelected()) {
								
								diasSemana=diasSemana+"6";
							}
							
							if (rdbtnDescuentosS.isSelected()) {
								
								diasSemana=diasSemana+"7";
							} 
							
							if(diasSemana.equals("")){
								
								diasSemana="1234567";
							}
							
							
							if(!tFNombreDescuento.getText().equals("") && !sPPorDescuento.getValue().toString().equals("") && !tADesDescuento.getText().equals("")){
								
							Descuento desc= new Descuento(tFNombreDescuento.getText(), tADesDescuento.getText(), cFecIniDescuentos.getDate(), cFecFinDescuentos.getDate(), diasSemana, rdbtnTemporal.isSelected(), Integer.parseInt(sPPorDescuento.getValue().toString()));
							
							consulta="INSERT INTO `descuentos`(`Nombre`, `Descripcion`, `FechaInicio`, `FechaFin`, `DiaSemana`, `Porcentaje`, `Temporal`) VALUES ('"+desc.getNombreDescuento()+"','"+desc.getDescripcion()+"','"+formatFechaSQL.format(desc.getFechaInicio())+"','"+formatFechaSQL.format(desc.getFechaFin())+"','"+desc.getDiaSemana()+"','"+desc.getPorcentaje()+"','"+desc.getPorcentaje()+"')";
							
							
							if(bd.Conexion()==null) {
					 			
					 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
					 			
					 		}
							
							bd.insModEli(consulta);
							
							bd.desconexion();							
							
							JOptionPane.showMessageDialog(null, "Los datos se han insertado correctamente");
							VaciarTabla(modelTableDescuentos);
							
							} else {
								
								JOptionPane.showMessageDialog(null, "Debes de rellenar los campos!!");
							}
							
									
						}
					});
					
					
					JButton btnModDescuento = new JButton("Modificar");
					btnModDescuento.setBounds(380, 213, 89, 23);
					panelDescuentos.add(btnModDescuento);
					
					btnModDescuento.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(idDes>0) {
								
								String diasSemana="";
								
								if (rdbtnDescuentosD.isSelected()) {
									
									diasSemana=diasSemana+"1";
								}
								
								if (rdbtnDescuentosL.isSelected()) {
									
									diasSemana=diasSemana+"2";
								}
								
								if (rdbtnDescuentosM.isSelected()) {
									
									diasSemana=diasSemana+"3";
								}
								
								if (rdbtnDescuentosX.isSelected()) {
									
									diasSemana=diasSemana+"4";
								}
								
								if (rdbtnDescuentosJ.isSelected()) {
									
									diasSemana=diasSemana+"5";
								}
								
								if (rdbtnDescuentosV.isSelected()) {
									
									diasSemana=diasSemana+"6";
								}
								
								if (rdbtnDescuentosS.isSelected()) {
									
									diasSemana=diasSemana+"7";
								} 
								
								if(diasSemana.equals("")){
									
									diasSemana="1234567";
								}
								
								
									if(!tFNombreDescuento.getText().equals("") && !sPPorDescuento.getValue().toString().equals("") && !tADesDescuento.getText().equals("")){
																						
										Descuento desc= new Descuento(tFNombreDescuento.getText(), tADesDescuento.getText(), cFecIniDescuentos.getDate(), cFecFinDescuentos.getDate(), diasSemana, rdbtnTemporal.isSelected(), Integer.parseInt(sPPorDescuento.getValue().toString()));
								
										consulta="UPDATE `descuentos` SET `Nombre`='"+desc.getNombreDescuento()+"',`Descripcion`='"+desc.getDescripcion()+"',`FechaInicio`='"+formatFechaSQL.format(desc.getFechaInicio())+"',`FechaFin`='"+formatFechaSQL.format(desc.getFechaFin())+"',`DiaSemana`='"+desc.getDiaSemana()+"',`Porcentaje`='"+desc.getPorcentaje()+"',`Temporal`='"+desc.getTemporal()+"' WHERE `IDDescuento`='"+idDes+"'";
								
										if(bd.Conexion()==null) {
								 			
								 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
								 			
								 		}
								
										bd.insModEli(consulta);
								
										bd.desconexion();
										
										JOptionPane.showMessageDialog(null, "Descuento Modificado");
										VaciarTabla(modelTableDescuentos);
								
										} else {JOptionPane.showMessageDialog(null, "Debes de rellenar los campos");}
									
									} else {JOptionPane.showMessageDialog(null, "Comprueba que has seleccionado un descuento");}
								
							}
							
							
						
					});
					
					
					JButton btnEliDescuento = new JButton("Eliminar");
					btnEliDescuento.setBounds(479, 213, 89, 23);
					panelDescuentos.add(btnEliDescuento);
					
					btnEliDescuento.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(idDes>0) {
								
								consulta="DELETE FROM descuentos WHERE `IDDescuento`='"+idDes+"'";
								
								if(bd.Conexion()==null) {
						 			
						 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
						 			
						 		}
							
								if(!bd.insModEli(consulta)) {
									
									JOptionPane.showMessageDialog(null, "Descuento Eliminado");
									VaciarTabla(modelTableDescuentos);
																		
								} else {
									
									JOptionPane.showMessageDialog(null, "No se ha podido eliminar el descuento, ya que su información está siendo compartida por otras entidades!!!");
								}
							
								bd.desconexion();
								
								
							} else {
								
								JOptionPane.showMessageDialog(null, "Comprueba que has seleccionado un descuento!!");
							}
							
							
						}
					});
					
					modelTableDescuentos = new DefaultTableModel();
					 tableDescuentos = new JTable(modelTableDescuentos);
					 modelTableDescuentos.addColumn("Id");
					 modelTableDescuentos.addColumn("Nombre");
					 modelTableDescuentos.addColumn("Descripcion");
					 modelTableDescuentos.addColumn("Inicio");
					 modelTableDescuentos.addColumn("Fin");
					 modelTableDescuentos.addColumn("Dia Sem");
					 modelTableDescuentos.addColumn("Porcentaje");
					 modelTableDescuentos.addColumn("Temporal");
					 
					TableColumn col1Descuentos = tableDescuentos.getColumn("Id");
					col1Descuentos.setMaxWidth(40);
					col1Descuentos.setCellRenderer(centrarCell());
					TableColumn col2Descuentos = tableDescuentos.getColumn("Nombre");
					col2Descuentos.setMaxWidth(110);
					col2Descuentos.setCellRenderer(centrarCell());
					TableColumn col3Descuentos = tableDescuentos.getColumn("Descripcion");
					col3Descuentos.setMaxWidth(140);
					col3Descuentos.setCellRenderer(centrarCell());
					TableColumn col4Descuentos = tableDescuentos.getColumn("Inicio");
					col4Descuentos.setMaxWidth(70);
					col4Descuentos.setCellRenderer(centrarCell());
					TableColumn col5Descuentos = tableDescuentos.getColumn("Fin");
					col5Descuentos.setMaxWidth(70);
					col5Descuentos.setCellRenderer(centrarCell());
					TableColumn col6Descuentos = tableDescuentos.getColumn("Dia Sem");
					col6Descuentos.setMaxWidth(60);
					col6Descuentos.setCellRenderer(centrarCell());
					TableColumn col7Descuentos = tableDescuentos.getColumn("Porcentaje");
					col7Descuentos.setMaxWidth(45);
					col7Descuentos.setCellRenderer(centrarCell());
					TableColumn col8Descuentos = tableDescuentos.getColumn("Temporal");
					col8Descuentos.setMaxWidth(50);
					col8Descuentos.setCellRenderer(centrarCell());
										 
					 tableDescuentos .setPreferredScrollableViewportSize(new Dimension(450, 200));
					 scrollPaneTableDescuentos = new JScrollPane(tableDescuentos );
					 scrollPaneTableDescuentos.setBounds(25, 259, 587, 226);
					 
					 panelDescuentos.add(scrollPaneTableDescuentos );
					 
					
					 
					 tableDescuentos .addMouseListener(new MouseAdapter() {
						 	@Override
						 	public void mouseClicked(MouseEvent arg0) {
						 		
						 		idDes=Integer.parseInt(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),0)));			 		
						 		
						 		tFNombreDescuento.setText(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),1)));
						 		tADesDescuento.setText(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),2)));
						 							 		
						 		try {
						 		      String fecha =String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),3));
						 		      java.util.Date fechaDate =  formatFechaDate.parse(fecha);
						 		      cFecIniDescuentos.setDate(fechaDate);
						 		      
						 		      fecha =String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),4));
						 		      fechaDate =  formatFechaDate.parse(fecha);
						 		      cFecFinDescuentos.setDate(fechaDate);
						 		      } catch (ParseException ex) {
						 		        
						 		      } 
						 		 
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),5)).indexOf("1")<0){
						 
						 		 		rdbtnDescuentosD.setSelected(false);
						 					 
					 				} else {
					 					
					 					rdbtnDescuentosD.setSelected(true);
					 				}
						 		 	
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),5)).indexOf("2")<0){
										 
						 		 		rdbtnDescuentosL.setSelected(false);
						 					 
					 				} else {
					 					
					 					rdbtnDescuentosL.setSelected(true);
					 				}
						 		 	
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),5)).indexOf("3")<0){
										 
						 		 		rdbtnDescuentosM.setSelected(false);
						 					 
					 				} else {
					 					
					 					rdbtnDescuentosM.setSelected(true);
					 				}
						 		 	
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),5)).indexOf("4")<0){
										 
						 		 		rdbtnDescuentosX.setSelected(false);
						 					 
					 				} else {
					 					
					 					rdbtnDescuentosX.setSelected(true);
					 				}
						 		 	
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),5)).indexOf("5")<0){
										 
						 		 		rdbtnDescuentosJ.setSelected(false);
						 					 
					 				} else {
					 					
					 					rdbtnDescuentosJ.setSelected(true);
					 				}
						 		 	
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),5)).indexOf("6")<0){
										 
						 		 		rdbtnDescuentosV.setSelected(false);
						 					 
					 				} else {
					 					
					 					rdbtnDescuentosV.setSelected(true);
					 				}
						 		 	
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),5)).indexOf("7")<0){
										 
						 		 		rdbtnDescuentosS.setSelected(false);
						 					 
					 				} else {
					 					
					 					rdbtnDescuentosS.setSelected(true);
					 				}
						 		 	
						 		 	
						 		 	sPPorDescuento.setValue(Integer.parseInt((String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),6)))));						 		 	
						 		 	if(String.valueOf(modelTableDescuentos.getValueAt(tableDescuentos.rowAtPoint(arg0.getPoint()),7)).equals("Si")){
						 		 		
						 		 		
						 		 		rdbtnTemporal.setSelected(true);
						 		 		
						 		 	} else {
						 		 		
						 		 		rdbtnTemporal.setSelected(false);
						 		 		
						 		 	}
						 		 
						 		
						 	}});
					 
					 
					 
					 //Fin Ventana de Descuentos
					 
					 //Ventana de Precios
					 JPanel panelPrecios = new JPanel();
					 pestana.addTab("Precios", null, panelPrecios , null);
					 panelPrecios .setLayout(null);
					 
					 JLabel lblNombre_2 = new JLabel("Nombre");
					 lblNombre_2.setBounds(25, 25, 53, 14);
					 panelPrecios.add(lblNombre_2);
					 
					 textField_10 = new JTextField();
					 textField_10.setBounds(82, 22, 147, 20);
					 panelPrecios.add(textField_10);
					 textField_10.setColumns(10);
					 
					 JLabel lblPrecio_1 = new JLabel("Precio");
					 lblPrecio_1.setBounds(25, 76, 46, 14);
					 panelPrecios.add(lblPrecio_1);
					 
					 textField_16 = new JTextField();
					 textField_16.setBounds(82, 73, 53, 20);
					 panelPrecios.add(textField_16);
					 textField_16.setColumns(10);
					 
					 JButton btnBuscar_5 = new JButton("Buscar");
					 btnBuscar_5.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent e) {
					 	}
					 });
					 btnBuscar_5.setBounds(25, 120, 89, 23);
					 panelPrecios.add(btnBuscar_5);
					 
					 textField_17 = new JTextField();
					 textField_17.setBounds(125, 121, 122, 20);
					 panelPrecios.add(textField_17);
					 textField_17.setColumns(10);
					 
					 JButton btnAadir_3 = new JButton("A\u00F1adir");
					 btnAadir_3.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent e) {
					 	}
					 });
					 btnAadir_3.setBounds(269, 120, 89, 23);
					 panelPrecios.add(btnAadir_3);
					 
					 JButton btnModificar_4 = new JButton("Modificar");
					 btnModificar_4.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent e) {
					 	}
					 });
					 btnModificar_4.setBounds(368, 120, 89, 23);
					 panelPrecios.add(btnModificar_4);
					 
					 JButton btnEliminar_4 = new JButton("Eliminar");
					 btnEliminar_4.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent e) {
					 	}
					 });
					 btnEliminar_4.setBounds(467, 120, 89, 23);
					 panelPrecios.add(btnEliminar_4);
					 
					 
					 modelo6 = new DefaultTableModel();
					 tablePrecios = new JTable(modelo6/*data1, columnNames*/);
					 modelo6.addColumn("Id");
					 modelo6.addColumn("Filas");
					 modelo6.addColumn("Columnas");
					 modelo6.addColumn("Audio");
					 modelo6.addColumn("Video");
					 
					 tablePrecios .setPreferredScrollableViewportSize(new Dimension(400, 200));
					 scrollPaneTablePrecios = new JScrollPane(tablePrecios );
					 scrollPaneTablePrecios.setBounds(25, 164, 531, 321);
					 
					 
					 panelPrecios.add(scrollPaneTablePrecios );
					 
					 
					 
					 
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
						 
						 modelo6.addRow ( fila );
						 
					 }
					 
					 
					 tablePrecios .addMouseListener(new MouseAdapter() {
						 	@Override
						 	public void mouseClicked(MouseEvent arg0) {
						 		
						 		
						 		
						 		System.out.println(tablePrecios .rowAtPoint(arg0.getPoint()));			 		
						 		
						 		
						 	}});
					 
					 //Fin ventana de Precios
					 
					 //Ventana de Entradas
					 JPanel panelEntradas = new JPanel();
					 pestana.addTab("Entradas", null, panelEntradas, null);
					 panelEntradas.setLayout(null);
					 
					 JComboBox cBCamposEntradas = new JComboBox();
					 cBCamposEntradas.setBounds(365, 24, 95, 20);
						panelEntradas.add(cBCamposEntradas);
						cBCamposEntradas.addItem("Entrada");
						cBCamposEntradas.addItem("Sesion");
						cBCamposEntradas.addItem("Socio");
						cBCamposEntradas.addItem("Empleado");
						cBCamposEntradas.addItem("Descuento");
						cBCamposEntradas.addItem("Suplemento");
						cBCamposEntradas.addItem("Pago");
					 
					 JButton btnBuscarEntrada = new JButton("Buscar");
					 btnBuscarEntrada.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent e) {
					 		
					 	
							 VaciarTabla(modelTableEntradas);
					 		
					 		consulta="SELECT * FROM entradas ";
					 		
					 		if(!tFEntradas.getText().equals("")){
					 			
					 		switch(cBCamposEntradas.getSelectedItem().toString()){
					 			
					 			
					 			case "Entrada":
					 				
					 				consulta=consulta+"WHERE IDEntrada=";
					 				
					 				break;
					 			
					 			case "Sesion":
					 				
					 				consulta=consulta+"WHERE IDSesion=";
					 				
					 				break;
					 			case "Socio":
					 				
					 				consulta=consulta+"WHERE IDSocio=";
					 				
					 				break;
					 			case "Empleado":
					 				
					 				consulta=consulta+"WHERE IDEmpleado=";
					 				
					 				break;
					 			
					 			case "Descuento":
				 				
					 				consulta=consulta+"WHERE IDDescuento=";
				 				
					 				break;
				 				
					 			case "Suplemento":
					 				
					 				consulta=consulta+"WHERE Suplemento=";
					 				
					 				break;
					 			
					 			
					 			
					 			case "Pago":
				 				
				 				consulta=consulta+"WHERE IDPago=";
				 				
				 				break;
					 			
				 			}
					 			
					 		consulta=consulta+"'"+tFEntradas.getText()+"'";
					 			
					 		}
					 		
					 					 		
					 		if(bd.Conexion()==null) {
					 			
					 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
					 			
					 		}
					 		contiene=bd.seleccionar(consulta);
					 		
					 		try {
					 		
					 		contiene.last();
					 		
					 		
					 		
					 		if(contiene.getRow()>0){
					 			
					 			contiene.first();
					 			
					 			do {
					 				
					 				 Object [] fila = new Object[10];
									 
									 fila[0]=contiene.getString("IDEntrada");
									 fila[1] = contiene.getString("IDSesion");
									 fila[2] = contiene.getString("IDSocio"); 
									 fila[3] = contiene.getString("IDEmpleado");
									 fila[4] = contiene.getString("IDDescuento");
									 fila[5] = contiene.getString("IDPago");
									 fila[6] = contiene.getString("Fila");
									 fila[7] = contiene.getString("Columna");
									 fila[8] = contiene.getString("Suplemento");
									 fila[9] = contiene.getString("Precio");
									 
									 modelTableEntradas.addRow ( fila );
									 
														 				
					 				
					 				
					 			} while(contiene.next());
					 			
					 		} else { JOptionPane.showMessageDialog(null, "No se han encontrado resultados!!");}
					 		
					 		
					 		
					 		} catch(Exception er){
					 			
					 			
					 			
					 		}}
					 		
					 	}
					 );
					 btnBuscarEntrada.setBounds(73, 23, 89, 23);
					 panelEntradas.add(btnBuscarEntrada);
					 
					 tFEntradas = new JTextField();
					 tFEntradas.setBounds(172, 24, 183, 20);
					 panelEntradas.add(tFEntradas);
					 tFEntradas.setColumns(10);
					 
					 tFEntradas.addKeyListener(new KeyAdapter(){
						 
							public void keyTyped(KeyEvent e) {
								
								if (tFEntradas.getText().length()== 30){
								
									e.consume();
								}
							    
							}						 
							
						});
					 
					 
						
						
						modelTableEntradas = new DefaultTableModel();
						tableEntradas = new JTable(modelTableEntradas);
						modelTableEntradas.addColumn("Id");
						modelTableEntradas.addColumn("Sesión");
						modelTableEntradas.addColumn("Id Socio");
						modelTableEntradas.addColumn("Id Empleado");
						modelTableEntradas.addColumn("Id Descuento");
						modelTableEntradas.addColumn("Id Pago");
						modelTableEntradas.addColumn("Fila");
						modelTableEntradas.addColumn("Columna");
						modelTableEntradas.addColumn("Suplemento");
						modelTableEntradas.addColumn("Precio");
						
						TableColumn col1Entradas = tableEntradas.getColumn("Id");
						col1Entradas.setMaxWidth(30);
						col1Entradas.setCellRenderer(centrarCell());
						TableColumn col2Entradas = tableEntradas.getColumn("Sesión");
						col2Entradas.setMaxWidth(47);
						col2Entradas.setCellRenderer(centrarCell());
						TableColumn col3Entradas = tableEntradas.getColumn("Id Socio");
						col3Entradas.setMaxWidth(50);
						col3Entradas.setCellRenderer(centrarCell());
						TableColumn col4Entradas = tableEntradas.getColumn("Id Empleado");
						col4Entradas.setMaxWidth(90);
						col4Entradas.setCellRenderer(centrarCell());
						TableColumn col5Entradas = tableEntradas.getColumn("Id Descuento");
						col5Entradas.setMaxWidth(95);
						col5Entradas.setCellRenderer(centrarCell());
						TableColumn col6Entradas = tableEntradas.getColumn("Id Pago");
						col6Entradas.setMaxWidth(60);
						col6Entradas.setCellRenderer(centrarCell());
						TableColumn col7Entradas = tableEntradas.getColumn("Fila");
						col7Entradas.setMaxWidth(45);
						col7Entradas.setCellRenderer(centrarCell());
						TableColumn col8Entradas = tableEntradas.getColumn("Columna");
						col8Entradas.setMaxWidth(70);
						col8Entradas.setCellRenderer(centrarCell());
						TableColumn col9Entradas = tableEntradas.getColumn("Suplemento");
						col9Entradas.setMaxWidth(90);
						col9Entradas.setCellRenderer(centrarCell());
						TableColumn col10Entradas = tableEntradas.getColumn("Precio");
						col10Entradas.setMaxWidth(50);
						col10Entradas.setCellRenderer(centrarCell());
						
						tableEntradas .setPreferredScrollableViewportSize(new Dimension(500, 200));
						scrollPaneTableEntradas = new JScrollPane(tableEntradas );
						scrollPaneTableEntradas.setBounds(33, 77, 592, 408);
						 
						 
						 panelEntradas.add(scrollPaneTableEntradas );
						 
						 
						 tableEntradas .addMouseListener(new MouseAdapter() {
							 	@Override
							 	public void mouseClicked(MouseEvent arg0) {
							 		
							 		
							 		
							 		System.out.println(tableEntradas .rowAtPoint(arg0.getPoint()));			 		
							 		
							 		
							 	}});
						 
						 //Fin Ventana Entradas
						 
						 //Ventana Pagos
						 JPanel panelPagos = new JPanel();
						 pestana.addTab("Pagos", null, panelPagos , null);
						 panelPagos.setLayout(null);
						 
						 JButton btnBuscarPagos = new JButton("Buscar");
						 btnBuscarPagos.addActionListener(new ActionListener() {
						 	public void actionPerformed(ActionEvent e) {
						 		
						 								 
								 VaciarTabla(modelTablePagos);
						 		
						 		consulta="SELECT * FROM pagos ";
						 		
						 		if(!tFPago.getText().equals("")){
						 		
						 			consulta=consulta+"WHERE IDPagos='"+tFPago.getText()+"'";
						 		
						 		}
						 		
						 		if(bd.Conexion()==null) {
						 			
						 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
						 			
						 		}
						 		
						 		contiene=bd.seleccionar(consulta);
						 		
						 		try {
						 		
						 		contiene.last();
						 		
						 						 		
						 		if(contiene.getRow()>0){
						 			
						 			contiene.first();
						 			
						 			do {
						 				
						 				 Object [] fila = new Object[4];
										 
										 fila[0]=contiene.getString("IDPagos");
										 fila[1] = contiene.getString("PrecioTotal");
										 fila[2] = contiene.getString("Efectivo"); 
										 fila[3] = contiene.getString("Tarjeta");
										
										 modelTablePagos.addRow ( fila );
						 				
						 				
						 				
						 			} while(contiene.next());
						 			
						 		} else { JOptionPane.showMessageDialog(null, "No se han encontrado resultados!!");}
						 		
						 		
						 		
						 		} catch(Exception er){
						 			
						 			
						 			
						 		}
						 							 		
						 	}
						 });
						 btnBuscarPagos.setBounds(36, 43, 89, 23);
						 panelPagos.add(btnBuscarPagos);
						 
						 JLabel lblIdPagos = new JLabel("Id:");
						 lblIdPagos.setBounds(152, 47, 14, 14);
						 panelPagos.add(lblIdPagos);
						 
						 tFPago = new JTextField();
						 tFPago.setBounds(176, 44, 144, 20);
						 panelPagos.add(tFPago);
						 tFPago.setColumns(10);
						 
						 tFPago.addKeyListener(new KeyAdapter(){
							 
								public void keyTyped(KeyEvent e) {
									
									if (tFPago.getText().length()== 30){
									
										e.consume();
									}
								    
								}						 
								
							});
						 
						 
							modelTablePagos = new DefaultTableModel();
							
							
							tablePagos = new JTable(modelTablePagos);
							 modelTablePagos.addColumn("Id");
							 modelTablePagos.addColumn("Precio Total");
							 modelTablePagos.addColumn("Efectivo");
							 modelTablePagos.addColumn("Tarjeta");
							 
							 TableColumn col1Pagos = tablePagos.getColumn("Id");
							 col1Pagos.setMaxWidth(60);
							 col1Pagos.setCellRenderer(centrarCell());
							 TableColumn col2Pagos = tablePagos.getColumn("Precio Total");
							 col2Pagos.setMaxWidth(190);
							 col2Pagos.setCellRenderer(centrarCell());
							 TableColumn col3Pagos = tablePagos.getColumn("Efectivo");
							 col3Pagos.setMaxWidth(190);
							 col3Pagos.setCellRenderer(centrarCell());
							 TableColumn col4Pagos = tablePagos.getColumn("Tarjeta");
							 col4Pagos.setMaxWidth(190);
							 col4Pagos.setCellRenderer(centrarCell());
							 
							 tablePagos .setPreferredScrollableViewportSize(new Dimension(400, 200));
							 scrollPaneTablePagos = new JScrollPane(tablePagos );
							 scrollPaneTablePagos.setBounds(36, 105, 513, 380);
							 
							 
							 panelPagos.add(scrollPaneTablePagos );
							 
							tablePagos .addMouseListener(new MouseAdapter() {
								 	@Override
								 	public void mouseClicked(MouseEvent arg0) {
								 		
								 		
								 		//System.out.println(tablePagos .rowAtPoint(arg0.getPoint()));			 		
							}});
							 //Fin ventana de Pagos
							 
							 //Ventana de Socios
							 JPanel panelSocios = new JPanel();
							 pestana.addTab("Socios", null, panelSocios , null);
							 panelSocios.setLayout(null);
							 
							 JLabel lblNombreSocio = new JLabel("Nombre:");
							 lblNombreSocio.setBounds(22, 33, 56, 14);
							 panelSocios.add(lblNombreSocio);
							 
							 tFNombreSocio = new JTextField();
							 tFNombreSocio.setBounds(84, 30, 157, 20);
							 panelSocios.add(tFNombreSocio);
							 tFNombreSocio.setColumns(10);
							 
							 tFNombreSocio.addKeyListener(new KeyAdapter(){
								 
									public void keyTyped(KeyEvent e) {
										
										if (tFNombreSocio.getText().length()== 30){
										
											e.consume();
										}
									    
									}						 
									
								});
							 
							 JLabel lblApellidosSocio = new JLabel("Apellidos");
							 lblApellidosSocio.setBounds(22, 70, 65, 14);
							 panelSocios.add(lblApellidosSocio);
							 
							 tFApellidosSocio = new JTextField();
							 tFApellidosSocio.setBounds(84, 67, 157, 20);
							 panelSocios.add(tFApellidosSocio);
							 tFApellidosSocio.setColumns(10);
							 
							 tFApellidosSocio.addKeyListener(new KeyAdapter(){
								 
									public void keyTyped(KeyEvent e) {
										
										if ( tFApellidosSocio.getText().length()== 30){
										
											e.consume();
										}
									    
									}						 
									
								});
							 
							 JLabel lblDniSocio = new JLabel("D.N.I");
							 lblDniSocio.setBounds(22, 112, 56, 14);
							 panelSocios.add(lblDniSocio);
							 
							 tFDniSocio = new JTextField();
							 tFDniSocio.setBounds(84, 109, 157, 20);
							 panelSocios.add(tFDniSocio);
							 tFDniSocio.setColumns(10);
							 
							 tFDniSocio.addKeyListener(new KeyAdapter(){
								 
									public void keyTyped(KeyEvent e) {
										
										if ( tFDniSocio.getText().length()== 9){
										
											e.consume();
										}
									    
									}						 
									
								});
							 
							 JButton btnBuscarSocio = new JButton("Buscar");
							 btnBuscarSocio.addActionListener(new ActionListener() {
							 	public void actionPerformed(ActionEvent e) {
							 		
							 										 
							 		VaciarTabla(modelTableSocios);
									 
									consulta="SELECT * FROM socios ";
									
									if(!tFBuscarSocio.getText().equals("")){
										
										consulta=consulta+"WHERE IDSocios='"+tFBuscarSocio.getText()+"' OR Nombre LIKE '%"+tFBuscarSocio.getText()+"%' OR Apellidos LIKE '%"+tFBuscarSocio.getText()+"%' OR DNI='"+tFBuscarSocio.getText()+"'";
																														
									}
									
									if(bd.Conexion()==null) {
							 			
							 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
							 			
							 		}
									
									contiene=bd.seleccionar(consulta);
							 		
							 		try {
							 		
							 		contiene.last();
							 		
							 						 		
							 		if(contiene.getRow()>0){
							 			
							 			contiene.first();
							 			
							 			do {
							 				
							 				 Object [] fila = new Object[4];
											 
											 fila[0]=contiene.getString("IDSocios");
											 fila[1] =contiene.getString("Nombre");
											 fila[2] =contiene.getString("Apellidos"); 
											 fila[3] =contiene.getString("DNI");
											
											 modelTableSocios.addRow ( fila );
							 				
							 				
							 				
							 			} while(contiene.next());
							 			
							 		} else { JOptionPane.showMessageDialog(null, "No se han encontrado resultados!!");}
							 		
							 		
							 		
							 		} catch(Exception er){
							 			
							 			
							 			
							 		}
									
									
							 		
							 		
							 	}
							 });
							 btnBuscarSocio.setBounds(22, 151, 89, 23);
							 panelSocios.add(btnBuscarSocio);
							 
							 tFBuscarSocio = new JTextField();
							 tFBuscarSocio.setBounds(121, 152, 162, 20);
							 panelSocios.add(tFBuscarSocio);
							 tFBuscarSocio.setColumns(10);
							 
							 tFBuscarSocio.addKeyListener(new KeyAdapter(){
								 
									public void keyTyped(KeyEvent e) {
										
										if ( tFBuscarSocio.getText().length()== 30){
										
											e.consume();
										}
									    
									}						 
									
								});
							 
							 JButton btnAddSocio = new JButton("A\u00F1adir");
							 btnAddSocio.addActionListener(new ActionListener() {
							 	public void actionPerformed(ActionEvent e) {
							 		
							 		if(!tFNombreSocio.getText().equals("") && !tFApellidosSocio.getText().equals("") && !tFDniSocio.getText().equals("")){
							 			
							 			Usuario s = new Socio(tFNombreSocio.getText(), tFApellidosSocio.getText(), tFDniSocio.getText());
							 			
							 			if(((Socio)s).comprobarDni()){
							 				
							 				if(bd.Conexion()==null) {
									 			
									 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
									 			
									 		}
							 				
							 				consulta="INSERT INTO `socios`( `Nombre`, `Apellidos`, `DNI`) VALUES ('"+((Socio)s).getNombre()+"', '"+((Socio)s).getApellidos()+"', '"+((Socio)s).getDni()+"')";
							 				bd.insModEli(consulta);
							 				bd.desconexion();
							 				
							 				JOptionPane.showMessageDialog(null, "Se han introducido los datos correctamente");
							 				VaciarTabla(modelTableSocios);
							 				
							 			} else { JOptionPane.showMessageDialog(null, "El DNI o formato no es el correcto!! El formato correcto es: NNNNNNNNL");}
							 			
							 			
							 		} else {JOptionPane.showMessageDialog(null, "Debes de rellenar todos los campos!!");}
							 		
							 		
							 	}
							 });
							 btnAddSocio.setBounds(293, 151, 89, 23);
							 panelSocios.add(btnAddSocio);
							 
							 JButton btnModificarSocio = new JButton("Modificar");
							 btnModificarSocio.addActionListener(new ActionListener() {
							 	public void actionPerformed(ActionEvent e) {
							 		
							 		if(!tFNombreSocio.getText().equals("") && !tFApellidosSocio.getText().equals("") && !tFDniSocio.getText().equals("")){
							 			
							 			Usuario s = new Socio(tFNombreSocio.getText(), tFApellidosSocio.getText(), tFDniSocio.getText());
							 			
							 			if(((Socio)s).comprobarDni()){
							 				
							 				if(bd.Conexion()==null) {
									 			
									 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
									 			
									 		}
							 				consulta="UPDATE `socios` SET `Nombre`='"+((Socio)s).getNombre()+"',`Apellidos`='"+((Socio)s).getApellidos()+"',`DNI`='"+((Socio)s).getDni()+"' WHERE IDSocios='"+idSoc+"'";
							 				System.out.println(consulta);
							 				if(!bd.insModEli(consulta)){
							 					JOptionPane.showMessageDialog(null, "Se han modificado los datos correctamente");
							 					VaciarTabla(modelTableSocios);	
							 				}else {
							 						
							 					JOptionPane.showMessageDialog(null, "No se ha podido realizar la operación. Compruebe que Id de Socio tiene Seleccionado");
							 						
							 					}
							 				bd.desconexion();
							 				
							 				
							 				
							 			} else { JOptionPane.showMessageDialog(null, "El DNI o formato no es el correcto!! El formato correcto es: NNNNNNNNL");}
							 			
							 			
							 		} else {JOptionPane.showMessageDialog(null, "Debes de rellenar todos los campos!!");}
							 		
							 		
							 	}
							 });
							 btnModificarSocio.setBounds(392, 151, 89, 23);
							 panelSocios.add(btnModificarSocio);
							 
							 JButton btnEiminarSocio = new JButton("Eiminar");
							 btnEiminarSocio.addActionListener(new ActionListener() {
							 	public void actionPerformed(ActionEvent e) {
							 		
							 		if(bd.Conexion()==null) {
							 			
							 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
							 			
							 		}
							 		consulta="DELETE FROM socios WHERE IDSocios='"+idSoc+"'";
							 		if(idSoc!=0){
							 			if(!bd.insModEli(consulta)) {
							 				
							 				JOptionPane.showMessageDialog(null, "Se han eliminado los datos correctamente");
							 				VaciarTabla(modelTableSocios);
							 				
							 			} else {
							 				
							 				JOptionPane.showMessageDialog(null, "No se puede eliminar el socio seleccionado, ya que su Id lo utilizan otras entidades");
							 			}
							 			
							 										 									 			
							 		} else {
							 			
							 			JOptionPane.showMessageDialog(null, "No se ha podido realizar la operación. Compruebe que Id de Socio tiene Seleccionado");
							 			
							 		}
							 		bd.desconexion();
							 	}
							 });
							 btnEiminarSocio.setBounds(491, 151, 89, 23);
							 panelSocios.add(btnEiminarSocio);
						 
						 
								modelTableSocios = new DefaultTableModel();
								
								
								tableSocios = new JTable(modelTableSocios);
								 modelTableSocios.addColumn("Id");
								 modelTableSocios.addColumn("Nombre");
								 modelTableSocios.addColumn("Apellidos");
								 modelTableSocios.addColumn("D.N.I");
								 
								 TableColumn col1Socios = tableSocios.getColumn("Id");
								 col1Socios.setMaxWidth(80);
								 col1Socios.setCellRenderer(centrarCell());
								 TableColumn col2Socios = tableSocios.getColumn("Nombre");
								 col2Socios.setMaxWidth(150);
								 col2Socios.setCellRenderer(centrarCell());
								 TableColumn col3Socios = tableSocios.getColumn("Apellidos");
								 col3Socios.setMaxWidth(230);
								 col3Socios.setCellRenderer(centrarCell());
								 TableColumn col4Socios = tableSocios.getColumn("D.N.I");
								 col4Socios.setMaxWidth(120);
								 col4Socios.setCellRenderer(centrarCell());
															 
								 tableSocios.setPreferredScrollableViewportSize(new Dimension(400, 200));
								 scrollPaneTableSocios = new JScrollPane(tableSocios );
								 scrollPaneTableSocios.setBounds(22, 201, 558, 284);
								 
								 
								 panelSocios.add(scrollPaneTableSocios );
								 
								 
																			 
								 tableSocios .addMouseListener(new MouseAdapter() {
									 	@Override
									 	public void mouseClicked(MouseEvent arg0) {
									 		
									 		idSoc=(Integer.parseInt(String.valueOf(modelTableSocios.getValueAt(tableSocios.rowAtPoint(arg0.getPoint()),0))));
									 		tFNombreSocio.setText(String.valueOf(modelTableSocios.getValueAt(tableSocios.rowAtPoint(arg0.getPoint()),1)));			 		
									 		tFApellidosSocio.setText(String.valueOf(modelTableSocios.getValueAt(tableSocios.rowAtPoint(arg0.getPoint()),2)));
									 		tFDniSocio.setText(String.valueOf(modelTableSocios.getValueAt(tableSocios.rowAtPoint(arg0.getPoint()),3)));
									 		
									 	}});
								 //Fin ventana de Socios
								 
								 
								 //Ventana de Empleados
								 JPanel panelEmpleados = new JPanel();
								 pestana.addTab("Empleados", null, panelEmpleados , null);
								 panelEmpleados.setLayout(null);
								 
								 JLabel lblNombreEmpleado = new JLabel("Nombre");
								 lblNombreEmpleado.setBounds(22, 25, 46, 14);
								 panelEmpleados.add(lblNombreEmpleado);
								 
								 tFNombreEmpleado = new JTextField();
								 tFNombreEmpleado.setBounds(87, 22, 157, 20);
								 panelEmpleados.add(tFNombreEmpleado);
								 tFNombreEmpleado.setColumns(10);
								 
								 tFNombreEmpleado.addKeyListener(new KeyAdapter(){
									 
										public void keyTyped(KeyEvent e) {
											
											if ( tFNombreEmpleado.getText().length()== 30){
											
												e.consume();
											}
										    
										}						 
										
									});
								 
								 JLabel lblApellidosEmpleado = new JLabel("Apellidos");
								 lblApellidosEmpleado.setBounds(22, 69, 67, 14);
								 panelEmpleados.add(lblApellidosEmpleado);
								 
								 tFApellidosEmpleado = new JTextField();
								 tFApellidosEmpleado.setBounds(87, 66, 157, 20);
								 panelEmpleados.add(tFApellidosEmpleado);
								 tFApellidosEmpleado.setColumns(10);
								 
								 tFApellidosEmpleado.addKeyListener(new KeyAdapter(){
									 
										public void keyTyped(KeyEvent e) {
											
											if ( tFApellidosEmpleado.getText().length()== 30){
											
												e.consume();
											}
										    
										}						 
										
									});
								 
								 JLabel lblDniEmpleado = new JLabel("D.N.I");
								 lblDniEmpleado.setBounds(22, 112, 46, 14);
								 panelEmpleados.add(lblDniEmpleado);
								 
								 tFDniEmpleado = new JTextField();
								 tFDniEmpleado.setBounds(87, 109, 157, 20);
								 panelEmpleados.add(tFDniEmpleado);
								 tFDniEmpleado.setColumns(10);
								 
								 tFDniEmpleado.addKeyListener(new KeyAdapter(){
									 
										public void keyTyped(KeyEvent e) {
											
											if ( tFDniEmpleado.getText().length()== 9){
											
												e.consume();
											}
										    
										}						 
										
									});
								 
								 JComboBox cBPuestoEmpleado = new JComboBox();
								 cBPuestoEmpleado.setBounds(424, 22, 133, 20);
								 panelEmpleados.add(cBPuestoEmpleado);
								 
								 cBPuestoEmpleado.addItem("Administrador");
								 cBPuestoEmpleado.addItem("Taquillero");
								 
								 
								 modelTableEmpleados = new DefaultTableModel();
									
									
									tableEmpleados = new JTable(modelTableEmpleados/*data1, columnNames*/);
									 modelTableEmpleados.addColumn("Id");
									 modelTableEmpleados.addColumn("Nombre");
									 modelTableEmpleados.addColumn("Apellidos");
									 modelTableEmpleados.addColumn("DNI");
									 modelTableEmpleados.addColumn("Puesto");
									 
									 TableColumn col1Empleados = tableEmpleados.getColumn("Id");
									 col1Empleados.setMaxWidth(60);
									 col1Empleados.setCellRenderer(centrarCell());
									 TableColumn col2Empleados = tableEmpleados.getColumn("Nombre");
									 col2Empleados.setMaxWidth(150);
									 col2Empleados.setCellRenderer(centrarCell());
									 TableColumn col3Empleados = tableEmpleados.getColumn("Apellidos");
									 col3Empleados.setMaxWidth(230);
									 col3Empleados.setCellRenderer(centrarCell());
									 TableColumn col4Empleados = tableEmpleados.getColumn("DNI");
									 col4Empleados.setMaxWidth(120);
									 col4Empleados.setCellRenderer(centrarCell());
									 TableColumn colEmpleados = tableEmpleados.getColumn("Puesto");
									 colEmpleados.setMaxWidth(120);
									 colEmpleados.setCellRenderer(centrarCell());
									 
									 tableEmpleados.setPreferredScrollableViewportSize(new Dimension(400, 200));
									 scrollPaneTableEmpleados = new JScrollPane(tableEmpleados );
									 scrollPaneTableEmpleados.setBounds(22, 201, 535, 284);
									 
									 
									 panelEmpleados.add(scrollPaneTableEmpleados );
									 
									 JButton btnBuscarEmpleado = new JButton("Buscar");
									 btnBuscarEmpleado.addActionListener(new ActionListener() {
									 	public void actionPerformed(ActionEvent e) {
									 		
									 		
											 
											 VaciarTabla(modelTableEmpleados);
											 
											consulta="SELECT * FROM empleados ";
											
											if(!tFBuscarEmpleado.getText().equals("")){
												
												consulta=consulta+"WHERE IDEmpleado='"+tFBuscarEmpleado.getText()+"' OR Nombre LIKE '%"+tFBuscarEmpleado.getText()+"%' OR Apellido LIKE '%"+tFBuscarEmpleado.getText()+"%' OR DNI='"+tFBuscarEmpleado.getText()+"' OR Puesto LIKE'%"+tFBuscarEmpleado.getText()+"%'";
												System.out.println(consulta);																				
											}
											
											if(bd.Conexion()==null) {
									 			
									 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
									 			
									 		}
											
											contiene=bd.seleccionar(consulta);
									 		
									 		try {
									 		
									 		contiene.last();
									 		
									 						 		
									 		if(contiene.getRow()>0){
									 			
									 			contiene.first();
									 			
									 			do {
									 				
									 				 Object [] fila = new Object[5];
													 
													 fila[0]=contiene.getString("IDEmpleado");
													 fila[1] =contiene.getString("Nombre");
													 fila[2] =contiene.getString("Apellido"); 
													 fila[3] =contiene.getString("DNI");
													 fila[4] =contiene.getString("Puesto");
													
													 modelTableEmpleados.addRow ( fila );
									 				
									 				
									 				
									 			} while(contiene.next());
									 			
									 		} else { JOptionPane.showMessageDialog(null, "No se han encontrado resultados!!");}
									 		
									 		
									 		
									 		} catch(Exception er){
									 			
									 			
									 			
									 		}
									 	}
									 });
									 btnBuscarEmpleado.setBounds(22, 161, 89, 23);
									 panelEmpleados.add(btnBuscarEmpleado);
									 
									 tFBuscarEmpleado = new JTextField();
									 tFBuscarEmpleado.setBounds(117, 162, 144, 20);
									 panelEmpleados.add(tFBuscarEmpleado);
									 tFBuscarEmpleado.setColumns(10);
									 
									 tFBuscarEmpleado.addKeyListener(new KeyAdapter(){
										 
											public void keyTyped(KeyEvent e) {
												
												if ( tFBuscarEmpleado.getText().length()== 30){
												
													e.consume();
												}
											    
											}						 
											
										});
									 
									 JButton btnAddEmpleado = new JButton("A\u00F1adir");
									 btnAddEmpleado.addActionListener(new ActionListener() {
									 	public void actionPerformed(ActionEvent e) {
									 		
									 		if(!tFNombreEmpleado.getText().equals("") && !tFApellidosEmpleado.getText().equals("") && !tFDniEmpleado.getText().equals("")){
									 			
									 			Usuario s = new Empleado (tFNombreEmpleado.getText(), tFApellidosEmpleado.getText(), tFDniEmpleado.getText(), cBPuestoEmpleado.getSelectedItem().toString());
									 			
									 			if(((Empleado)s).comprobarDni()){
									 				
									 				if(bd.Conexion()==null) {
											 			
											 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
											 			
											 		}
									 				consulta="INSERT INTO `empleados`(`Nombre`, `Apellido`, `DNI`, `Puesto`, 'Clave') VALUES ('"+((Empleado)s).getNombre()+"', '"+((Empleado)s).getApellidos()+"','"+((Empleado)s).getDni()+"','"+((Empleado)s).getCategoria()+"', 'x')";
									 				bd.insModEli(consulta);
									 				bd.desconexion();
									 				
									 				JOptionPane.showMessageDialog(null, "Se han introducido los datos correctamente");
									 				VaciarTabla(modelTableEmpleados);									 				
									 				
									 			} else { JOptionPane.showMessageDialog(null, "El DNI o formato no es el correcto!! El formato correcto es: NNNNNNNNL");}
									 			
									 			
									 		} else {JOptionPane.showMessageDialog(null, "Debes de rellenar todos los campos!!");}
									 		
									 	
									 		
									 	}
									 });
									 btnAddEmpleado.setBounds(278, 161, 89, 23);
									 panelEmpleados.add(btnAddEmpleado);
									 
									 JButton btnModificarEmpleado = new JButton("Modificar");
									 btnModificarEmpleado.addActionListener(new ActionListener() {
									 	public void actionPerformed(ActionEvent e) {
									 		
									 		if(!tFNombreEmpleado.getText().equals("") && !tFApellidosEmpleado.getText().equals("") && !tFDniEmpleado.getText().equals("")){
									 			
									 			Usuario s = new Empleado (tFNombreEmpleado.getText(), tFApellidosEmpleado.getText(), tFDniEmpleado.getText(), cBPuestoEmpleado.getSelectedItem().toString());
									 			
									 			if(((Empleado)s).comprobarDni()){
									 				
									 				if(bd.Conexion()==null) {
											 			
											 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
											 			
											 		}
									 				consulta="UPDATE `empleados` SET `Nombre`='"+((Empleado)s).getNombre()+"',`Apellido`='"+((Empleado)s).getApellidos()+"',`DNI`='"+((Empleado)s).getDni()+"', `Puesto`= '"+((Empleado)s).getCategoria()+"' WHERE IDEmpleado='"+idEmp+"'";
									 				
									 				if(!bd.insModEli(consulta)){
									 				
									 					JOptionPane.showMessageDialog(null, "Se han modificado los datos correctamente");
									 					VaciarTabla(modelTableEmpleados);
									 				}
									 				else {
									 						
									 					JOptionPane.showMessageDialog(null, "No se ha podido realizar la operación. Compruebe que Id de Empleado tiene Seleccionado");
									 						
									 					}
									 				bd.desconexion();
									 				
									 				
									 				
									 			} else { JOptionPane.showMessageDialog(null, "El DNI o formato no es el correcto!! El formato correcto es: NNNNNNNNL");}
									 			
									 			
									 		} else {JOptionPane.showMessageDialog(null, "Debes de rellenar todos los campos!!");}
									 		
									 	}
									 });
									 btnModificarEmpleado.setBounds(377, 162, 89, 23);
									 panelEmpleados.add(btnModificarEmpleado);
									 
									 JButton btnEliminarEmpleado = new JButton("Eliminar");
									 btnEliminarEmpleado.addActionListener(new ActionListener() {
									 	public void actionPerformed(ActionEvent e) {
									 		
									 		
									 		if(bd.Conexion()==null) {
									 			
									 			JOptionPane.showMessageDialog(null, "La base de datos no esta conectada!!");
									 			
									 		}
									 		consulta="DELETE FROM empleados WHERE IDEmpleado='"+idEmp+"'";
									 		if(idEmp!=0){
									 			if(!bd.insModEli(consulta)) {
									 				
									 				JOptionPane.showMessageDialog(null, "Se han eliminado los datos correctamente");
									 				VaciarTabla(modelTableEmpleados);
									 				
									 			} else {
									 				
									 				JOptionPane.showMessageDialog(null, "No se puede eliminar el empleado seleccionado, ya que su Id lo utilizan otras entidades");
									 			}
									 			
									 										 									 			
									 		} else {
									 			
									 			JOptionPane.showMessageDialog(null, "No se ha podido realizar la operación. Compruebe que Id de Socio tiene Seleccionado");
									 			
									 		}
									 		bd.desconexion();
									 		
									 	}
									 });
									 btnEliminarEmpleado.setBounds(476, 161, 89, 23);
									 panelEmpleados.add(btnEliminarEmpleado);
									 
									 
									 
									 
									 tableEmpleados .addMouseListener(new MouseAdapter() {
										 	@Override
										 	public void mouseClicked(MouseEvent arg0) {
										 		
										 												 		
										 		idEmp=(Integer.parseInt(String.valueOf(modelTableEmpleados.getValueAt(tableEmpleados.rowAtPoint(arg0.getPoint()),0))));
										 		tFNombreEmpleado.setText(String.valueOf(modelTableEmpleados.getValueAt(tableEmpleados.rowAtPoint(arg0.getPoint()),1)));			 		
										 		tFApellidosEmpleado.setText(String.valueOf(modelTableEmpleados.getValueAt(tableEmpleados.rowAtPoint(arg0.getPoint()),2)));
										 		tFDniEmpleado.setText(String.valueOf(modelTableEmpleados.getValueAt(tableEmpleados.rowAtPoint(arg0.getPoint()),3)));
										 		cBPuestoEmpleado.setSelectedItem(String.valueOf(modelTableEmpleados.getValueAt(tableEmpleados.rowAtPoint(arg0.getPoint()),4)));
										 		
										 		
										 	}});
									 //Fin Ventana de Empleados
		
	}
	
	
	public DefaultTableCellRenderer centrarCell(){
		
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
	    modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

	    return modelocentrar; 
	    
		}
	
	public void VaciarTabla(DefaultTableModel model){
		
		for(int i=model.getRowCount()-1; i>=0; i--) {
			
			model.removeRow(i);
					
		}	
	}


}
