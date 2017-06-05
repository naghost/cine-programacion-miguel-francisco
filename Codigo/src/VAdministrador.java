import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class VAdministrador extends JFrame {

	private JPanel contentPane;
	private JPanel panelSalas;
	private JTextField textFTituloPelicula;
	private JTextField textFTitulo;
	private JTextField textFDirectorPeliculas;
	private JTextField textFBusquedaPeliculas;
	private DefaultTableModel modelo;
	private DefaultTableModel modelo2;
	private DefaultTableModel modelo3;
	private DefaultTableModel modelo4;
	private DefaultTableModel modelo5;
	private DefaultTableModel modelo6;
	private DefaultTableModel modelo7;
	private DefaultTableModel modelo8;
	private DefaultTableModel modelo9;
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
	private boolean control=true;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_9;

	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_10;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private ControlErrores ce = new ControlErrores();
	private Integer idUsed_peliculas = null;
	private Integer idUsed_salas = null;
	private Integer idUsed_precio = null;
	private JCalendar calendar;
	/**
	 * Launch the application.
	 * @param bd 
	 * @throws SQLException 
	 */
	/*public static void main(String[] args) {


	/**
	 * Create the frame.
	 */
	public VAdministrador(BBDD bd) throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane pestana = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(pestana, BorderLayout.CENTER);
		
		JPanel panelSesiones = new JPanel();
		
		
		//Panel 1 de las Peliculas
		Peliculas(pestana, bd);

		//Panel 2 de las Salas
		Salas(pestana, bd);
			 
		//Panel 3 de Sesiones
		Sesiones(panelSesiones,pestana, bd);
		

				
		//Panel 5 de Precios
		Precios(pestana, bd);
		
		//Panel 6 de Entradas
		 Entradas(pestana);
		 
		//Panel 7 de Pagos
		 Pagos(pestana);
		 
		//Panel 8 de Socios				 
		 Socios(pestana);
		 
		 //Panel 9 de Empleados
		  Empleados(pestana);
		
	}





	private void Empleados(JTabbedPane pestana) {
		JPanel panelEmpleados = new JPanel();
		 pestana.addTab("Empleados", null, panelEmpleados , null);
		 panelEmpleados.setLayout(null);
		 calendar = new JCalendar();
		 calendar.setBounds(10, 10, 10, 10);
		 panelEmpleados.add(calendar);
		 calendar.setTodayButtonVisible(true);
		 calendar.setTodayButtonText("Hoy Día");
		 calendar.setNullDateButtonVisible(true);
		 JLabel lblNombre_4 = new JLabel("Nombre");
		 lblNombre_4.setBounds(22, 25, 46, 14);
		 panelEmpleados.add(lblNombre_4);
		 
		 textField_23 = new JTextField();
		 textField_23.setBounds(87, 22, 157, 20);
		 panelEmpleados.add(textField_23);
		 textField_23.setColumns(10);
		 
		 JLabel lblApellidos_1 = new JLabel("Apellidos");
		 lblApellidos_1.setBounds(22, 69, 67, 14);
		 panelEmpleados.add(lblApellidos_1);
		 
		 textField_24 = new JTextField();
		 textField_24.setBounds(87, 66, 157, 20);
		 panelEmpleados.add(textField_24);
		 textField_24.setColumns(10);
		 
		 JLabel lblDni_1 = new JLabel("D.N.I");
		 lblDni_1.setBounds(22, 112, 46, 14);
		 panelEmpleados.add(lblDni_1);
		 
		 textField_25 = new JTextField();
		 textField_25.setBounds(87, 109, 157, 20);
		 panelEmpleados.add(textField_25);
		 textField_25.setColumns(10);
		 
		 JComboBox puesto = new JComboBox();
		 puesto.setBounds(424, 22, 133, 20);
		 panelEmpleados.add(puesto);
		 
		 puesto.addItem("Administrador");
		 puesto.addItem("Taquillero");
		 
		 
		 modelo9 = new DefaultTableModel();
			
			
			tableEmpleados = new JTable(modelo9/*data1, columnNames*/);
			 modelo9.addColumn("Id");
			 modelo9.addColumn("Filas");
			 modelo9.addColumn("Columnas");
			 modelo9.addColumn("Audio");
			 modelo9.addColumn("Video");
			 
			 tableEmpleados.setPreferredScrollableViewportSize(new Dimension(400, 200));
			 scrollPaneTableEmpleados = new JScrollPane(tableEmpleados );
			 scrollPaneTableEmpleados.setBounds(22, 201, 535, 284);
			 
			 
			 panelEmpleados.add(scrollPaneTableEmpleados );
			 
			 JButton btnBuscar_8 = new JButton("Buscar");
			 btnBuscar_8.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 	}
			 });
			 btnBuscar_8.setBounds(22, 161, 89, 23);
			 panelEmpleados.add(btnBuscar_8);
			 
			 textField_26 = new JTextField();
			 textField_26.setBounds(117, 162, 144, 20);
			 panelEmpleados.add(textField_26);
			 textField_26.setColumns(10);
			 
			 JButton btnAadir_4 = new JButton("A\u00F1adir");
			 btnAadir_4.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 	}
			 });
			 btnAadir_4.setBounds(278, 161, 89, 23);
			 panelEmpleados.add(btnAadir_4);
			 
			 JButton btnModificar_6 = new JButton("Modificar");
			 btnModificar_6.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 	}
			 });
			 btnModificar_6.setBounds(377, 162, 89, 23);
			 panelEmpleados.add(btnModificar_6);
			 
			 JButton btnEliminar_5 = new JButton("Eliminar");
			 btnEliminar_5.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 	}
			 });
			 btnEliminar_5.setBounds(476, 161, 89, 23);
			 panelEmpleados.add(btnEliminar_5);
			 
			 
			 
			 /*
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
				 
				 modelo9.addRow ( fila );
				 
			 }
			 */
			 
			 tableEmpleados .addMouseListener(new MouseAdapter() {
				 	@Override
				 	public void mouseClicked(MouseEvent arg0) {
				 		
				 		
				 		
				 		
				 		
				 	}});
	}


	private void Socios(JTabbedPane pestana) {
		JPanel panelSocios = new JPanel();
		 pestana.addTab("Socios", null, panelSocios , null);
		 panelSocios.setLayout(null);
		 
		 JLabel lblNombre_3 = new JLabel("Nombre:");
		 lblNombre_3.setBounds(22, 33, 56, 14);
		 panelSocios.add(lblNombre_3);
		 
		 textField_19 = new JTextField();
		 textField_19.setBounds(84, 30, 157, 20);
		 panelSocios.add(textField_19);
		 textField_19.setColumns(10);
		 
		 JLabel lblApellidos = new JLabel("Apellidos");
		 lblApellidos.setBounds(22, 70, 65, 14);
		 panelSocios.add(lblApellidos);
		 
		 textField_20 = new JTextField();
		 textField_20.setBounds(84, 67, 157, 20);
		 panelSocios.add(textField_20);
		 textField_20.setColumns(10);
		 
		 JLabel lblDni = new JLabel("D.N.I");
		 lblDni.setBounds(22, 112, 56, 14);
		 panelSocios.add(lblDni);
		 
		 textField_21 = new JTextField();
		 textField_21.setBounds(84, 109, 157, 20);
		 panelSocios.add(textField_21);
		 textField_21.setColumns(10);
		 
		 JButton btnBuscar_7 = new JButton("Buscar");
		 btnBuscar_7.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnBuscar_7.setBounds(22, 151, 89, 23);
		 panelSocios.add(btnBuscar_7);
		 
		 textField_22 = new JTextField();
		 textField_22.setBounds(121, 152, 162, 20);
		 panelSocios.add(textField_22);
		 textField_22.setColumns(10);
		 
		 JButton btnNewButton = new JButton("A\u00F1adir");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnNewButton.setBounds(293, 151, 89, 23);
		 panelSocios.add(btnNewButton);
		 
		 JButton btnModificar_5 = new JButton("Modificar");
		 btnModificar_5.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnModificar_5.setBounds(392, 151, 89, 23);
		 panelSocios.add(btnModificar_5);
		 
		 JButton btnEiminar = new JButton("Eiminar");
		 btnEiminar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnEiminar.setBounds(491, 151, 89, 23);
		 panelSocios.add(btnEiminar);
 
 
			modelo8 = new DefaultTableModel();
			
			
			tableSocios = new JTable(modelo8/*data1, columnNames*/);
			 modelo8.addColumn("Id");
			 modelo8.addColumn("Filas");
			 modelo8.addColumn("Columnas");
			 modelo8.addColumn("Audio");
			 modelo8.addColumn("Video");
			 
			 tableSocios.setPreferredScrollableViewportSize(new Dimension(400, 200));
			 scrollPaneTableSocios = new JScrollPane(tableSocios );
			 scrollPaneTableSocios.setBounds(22, 201, 558, 284);
			 
			 
			 panelSocios.add(scrollPaneTableSocios );
			 
			 
			 /*
			 
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
				 
				 modelo8.addRow ( fila );
				 
			 }
			 */
			 
			 tableSocios .addMouseListener(new MouseAdapter() {
				 	@Override
				 	public void mouseClicked(MouseEvent arg0) {
				 		
				 		
				 		
				 		
				 		
				 	}});
	}


	private void Pagos(JTabbedPane pestana) {
		JPanel panelPagos = new JPanel();
		 pestana.addTab("Pagos", null, panelPagos , null);
		 panelPagos.setLayout(null);
		 
		 JButton btnBuscar_6 = new JButton("Buscar");
		 btnBuscar_6.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnBuscar_6.setBounds(36, 43, 89, 23);
		 panelPagos.add(btnBuscar_6);
		 
		 JLabel lblId = new JLabel("Id:");
		 lblId.setBounds(152, 47, 14, 14);
		 panelPagos.add(lblId);
		 
		 textField_18 = new JTextField();
		 textField_18.setBounds(176, 44, 144, 20);
		 panelPagos.add(textField_18);
		 textField_18.setColumns(10);
		 
			modelo7 = new DefaultTableModel();
			
			
			tablePagos = new JTable(modelo5/*data1, columnNames*/);
			 modelo7.addColumn("Id");
			 modelo7.addColumn("Filas");
			 modelo7.addColumn("Columnas");
			 modelo7.addColumn("Audio");
			 modelo7.addColumn("Video");
			 
			 tablePagos .setPreferredScrollableViewportSize(new Dimension(400, 200));
			 scrollPaneTablePagos = new JScrollPane(tablePagos );
			 scrollPaneTablePagos.setBounds(36, 105, 513, 380);
			 
			 
			 panelPagos.add(scrollPaneTablePagos );
			 
			 
			 /*
			 
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
				 
				 modelo7.addRow ( fila );
				 
			 }
			 */
			 
			 tablePagos .addMouseListener(new MouseAdapter() {
				 	@Override
				 	public void mouseClicked(MouseEvent arg0) {
				 		
				 		
				 		
				 		
				 		
				 	}});
	}


	private void Entradas(JTabbedPane pestana) {
		JPanel panelEntradas = new JPanel();
		 pestana.addTab("Entradas", null, panelEntradas, null);
		 panelEntradas.setLayout(null);
		 
		 JButton btnBuscar_4 = new JButton("Buscar");
		 btnBuscar_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnBuscar_4.setBounds(73, 23, 89, 23);
		 panelEntradas.add(btnBuscar_4);
		 
		 textField_15 = new JTextField();
		 textField_15.setBounds(172, 24, 183, 20);
		 panelEntradas.add(textField_15);
		 textField_15.setColumns(10);
		 
		 JComboBox cBCamposEntradas = new JComboBox();
			
			
		 cBCamposEntradas.setBounds(365, 24, 95, 20);
			panelEntradas.add(cBCamposEntradas);
			cBCamposEntradas.addItem("Pelicula");
			cBCamposEntradas.addItem("Sala");
			cBCamposEntradas.addItem("Sesion");
			cBCamposEntradas.addItem("Socios");
			
			
			modelo5 = new DefaultTableModel();
			 tableEntradas = new JTable(modelo5/*data1, columnNames*/);
			 modelo5.addColumn("Id");
			 modelo5.addColumn("Filas");
			 modelo5.addColumn("Columnas");
			 modelo5.addColumn("Audio");
			 modelo5.addColumn("Video");
			 
			 tableEntradas .setPreferredScrollableViewportSize(new Dimension(400, 200));
			 scrollPaneTableEntradas = new JScrollPane(tableEntradas );
			 scrollPaneTableEntradas.setBounds(41, 77, 492, 408);
			 
			 
			 panelEntradas.add(scrollPaneTableEntradas );
			 
			 
			 
			 /*
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
				 
				 modelo5.addRow ( fila );
				 
			 }
			 
			 */
			 tableEntradas .addMouseListener(new MouseAdapter() {
				 	@Override
				 	public void mouseClicked(MouseEvent arg0) {
				 		
				 		
				 		
				 		
				 		
				 	}});
	}


	private void Precios(JTabbedPane pestana, BBDD bd) {
		Precios precio = new Precios();
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
		 		String nombre = textField_10.getText();
		 		String aux = textField_16.getText().replace(',', '.');
		 		double precio2 = Double.parseDouble(aux);
		 		precio.crearPrecio(bd, nombre, precio2);
		 		
		 		 try {
		 			datosTablaPrecios(bd, precio);
		 		} catch (SQLException e1) {
		 			// TODO Auto-generated catch block
		 			e1.printStackTrace();
		 		}
		 		
		 	}
		 });
		 btnAadir_3.setBounds(269, 120, 89, 23);
		 panelPrecios.add(btnAadir_3);
		 
		 JButton btnModificar_4 = new JButton("Modificar");
		 btnModificar_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(idUsed_precio != null){
		 			String nombre = textField_10.getText();
		 			String aux = textField_16.getText().replace(',', '.');;
		 			double precio2 = Double.parseDouble(aux);
		 			precio.modificarPrecio(bd,idUsed_precio,nombre,precio2);
		 			
		 			 try {
				 			datosTablaPrecios(bd, precio);
				 		} catch (SQLException e1) {
				 			// TODO Auto-generated catch block
				 			e1.printStackTrace();
				 		}
		 			
		 		}else JOptionPane.showMessageDialog(null, "No has seleccionado ningun elemento");
		 			
		 		
		 	}
		 });
		 btnModificar_4.setBounds(368, 120, 89, 23);
		 panelPrecios.add(btnModificar_4);
		 
		 JButton btnEliminar_4 = new JButton("Eliminar");
		 btnEliminar_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		if(idUsed_precio!=null){
					precio.eliminarPrecio(bd, idUsed_precio);
					 try {
				 			datosTablaPrecios(bd, precio);
				 		} catch (SQLException e1) {
				 			// TODO Auto-generated catch block
				 			e1.printStackTrace();
				 		}
				}else JOptionPane.showMessageDialog(null, "No has seleccionado ningun elemento");
		 	}
		 });
		 btnEliminar_4.setBounds(467, 120, 89, 23);
		 panelPrecios.add(btnEliminar_4);
		 
		 
		 modelo6 = new DefaultTableModel();
		 tablePrecios = new JTable(modelo6);
		 modelo6.addColumn("ID");
		 modelo6.addColumn("Nombre");
		 modelo6.addColumn("Precio");
		 
		 
		 tablePrecios.getColumnModel().getColumn(0).setMaxWidth(0);
		 tablePrecios.getColumnModel().getColumn(0).setMinWidth(0);
		 tablePrecios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		 tablePrecios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		 tablePrecios .setPreferredScrollableViewportSize(new Dimension(400, 200));
		 scrollPaneTablePrecios = new JScrollPane(tablePrecios );
		 scrollPaneTablePrecios.setBounds(25, 164, 531, 321);
		 
		 
		 panelPrecios.add(scrollPaneTablePrecios );
		 
		 
		 

		 try {
			datosTablaPrecios(bd, precio);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	private void datosTablaPrecios(BBDD bd, Precios precio) throws SQLException {
		
		for(int i = (modelo6.getRowCount()-1); i>=0;i--){
		modelo6.removeRow(i);
		}
		ResultSet rs = precio.verPrecios(bd);
		 //cargamos datos
		 while(rs.next()){
			 Object [] fila = new Object[4];
			 
			 		fila[0] = rs.getString("IDPrecio");
	 				fila[1] = rs.getString("Nombre");
	 				fila[2] = rs.getString("Precio");
	 				
			 
			 modelo6.addRow ( fila );
			 
			 
		 }
		
		
		
		tablePrecios.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		idUsed_precio = Integer.parseInt(String.valueOf(modelo6.getValueAt(tablePrecios.rowAtPoint(arg0.getPoint()), 0)));
			 		textField_10.setText(String.valueOf(modelo6.getValueAt(tablePrecios.rowAtPoint(arg0.getPoint()), 1)));
			 		textField_16.setText(String.valueOf(modelo6.getValueAt(tablePrecios.rowAtPoint(arg0.getPoint()), 2)));

			 		
			 	}});
	}
	

	private void Descuentos(JTabbedPane pestana, String[] meses, Integer[] anos, JComboBox diaFISesion) {
		 
		 JPanel panelDescuentos = new JPanel();
			pestana.addTab("Descuentos", null, panelDescuentos, null);
			panelDescuentos.setLayout(null);
			
			JLabel lblNombre_1 = new JLabel("Nombre ");
			lblNombre_1.setBounds(25, 36, 58, 14);
			panelDescuentos.add(lblNombre_1);
			
			textField_12 = new JTextField();
			textField_12.setBounds(102, 33, 145, 20);
			panelDescuentos.add(textField_12);
			textField_12.setColumns(10);
			
			JLabel lblDescripcion = new JLabel("Descripcion");
			lblDescripcion.setBounds(25, 87, 68, 14);
			panelDescuentos.add(lblDescripcion);
			
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setBounds(102, 82, 145, 105);
			panelDescuentos.add(textArea_1);
			
			
			JLabel lblFIDescuentos = new JLabel("Fecha Inicio");
			lblFIDescuentos .setBounds(302, 34, 68, 14);
			panelDescuentos.add(lblFIDescuentos);
			
			
			JComboBox diaFIDescuentos = new JComboBox();
			diaFIDescuentos.setBounds(380, 31, 46, 20);
			panelDescuentos.add(diaFIDescuentos);
			
			for(int i=1; i<=31; i++){
				
				
				diaFIDescuentos.addItem(i);
			}
			
			
			
			JComboBox mesFIDescuentos = new JComboBox(meses);
			mesFIDescuentos.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					
					
					
					if(control){
						
						control=false;
					} else {
						
						control=true;
					}
					
					if (control){
					
					
					
					//diaEstreno.removeAll();
					
					if(arg0.getItem().equals("Feb")){
						
						
						if(diaFIDescuentos.getItemCount()==31) {
							
							diaFIDescuentos.removeItemAt(30);
							diaFIDescuentos.removeItemAt(29);
							
						}
						
						if(diaFIDescuentos.getItemCount()==30) { 
							
							diaFIDescuentos.removeItemAt(29);
						}
						
						
					} else {
						
						if( arg0.getItem().equals("Ene") || arg0.getItem().equals("Mar") || arg0.getItem().equals("May") || arg0.getItem().equals("Jul") || arg0.getItem().equals("Ago") || arg0.getItem().equals("Oct") || arg0.getItem().equals("Dic")){
							diaFIDescuentos.setSelectedItem(31);
						
						if(diaFISesion.getItemCount()==29){
							
							diaFIDescuentos.addItem("30");
							diaFIDescuentos.addItem("31");
						} 
						
						if (diaFIDescuentos.getItemCount()==30){
							
							diaFIDescuentos.addItem("31");
						}
						
						
						
						} else {
							
							if(diaFIDescuentos.getItemCount()==29){
								
								diaFIDescuentos.addItem("30");
								
							} 
							
							if (diaFIDescuentos.getItemCount()==31){
								
								diaFIDescuentos.removeItemAt(30);
							}
							
							
						}
					}}
				}
			});
			
			
			mesFIDescuentos.setBounds(436, 31, 63, 20);
			panelDescuentos.add(mesFIDescuentos);
			mesFIDescuentos.setSelectedIndex(2);
			
			
			
			JComboBox anoFIDescuentos = new JComboBox(anos);
			anoFIDescuentos.setBounds(509, 31, 53, 20);
			panelDescuentos.add(anoFIDescuentos);
			
			JLabel lblFFDescuentos = new JLabel("Fecha Fin");
			lblFFDescuentos.setBounds(302, 78, 53, 14);
			panelDescuentos.add(lblFFDescuentos);
			
			JComboBox diaFFDescuentos = new JComboBox();
			diaFFDescuentos.setBounds(380, 75, 46, 20);
			panelDescuentos.add(diaFFDescuentos);
			
			for(int i=1; i<=31; i++){
				
				
				diaFFDescuentos.addItem(i);
			}
			
			
			
			JComboBox mesFFDescuentos = new JComboBox(meses);
			mesFFDescuentos.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					
				
					
					if(control){
						
						control=false;
					} else {
						
						control=true;
					}
					
					if (control){
					
					
					//diaEstreno.removeAll();
					
					if(arg0.getItem().equals("Feb")){
						
						
						if(diaFFDescuentos.getItemCount()==31) {
							
							diaFFDescuentos.removeItemAt(30);
							diaFFDescuentos.removeItemAt(29);
							
						}
						
						if(diaFFDescuentos.getItemCount()==30) { 
							
							diaFFDescuentos.removeItemAt(29);
						}
						
						
					} else {
						
						if( arg0.getItem().equals("Ene") || arg0.getItem().equals("Mar") || arg0.getItem().equals("May") || arg0.getItem().equals("Jul") || arg0.getItem().equals("Ago") || arg0.getItem().equals("Oct") || arg0.getItem().equals("Dic")){
							diaFFDescuentos.setSelectedItem(31);
						
						if(diaFFDescuentos.getItemCount()==29){
							
							diaFFDescuentos.addItem("30");
							diaFFDescuentos.addItem("31");
						} 
						
						if (diaFFDescuentos.getItemCount()==30){
							
							diaFFDescuentos.addItem("31");
						}
						
						
						
						} else {
							
							if(diaFFDescuentos.getItemCount()==29){
								
								diaFFDescuentos.addItem("30");
								
							} 
							
							if (diaFFDescuentos.getItemCount()==31){
								
								diaFFDescuentos.removeItemAt(30);
							}
							
							
						}
					}}
				}
			});
			
			
			mesFFDescuentos.setBounds(436, 75, 63, 20);
			panelDescuentos.add(mesFFDescuentos);
			mesFFDescuentos.setSelectedIndex(2);
			
			
			
			JComboBox anoFFDescuentos = new JComboBox(anos);
			anoFFDescuentos.setBounds(509, 75, 53, 20);
			panelDescuentos.add(anoFFDescuentos);
			
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
			
			JLabel lblPorcentaje = new JLabel("Porcentaje");
			lblPorcentaje.setBounds(302, 163, 68, 14);
			panelDescuentos.add(lblPorcentaje);
			
			textField_13 = new JTextField();
			textField_13.setBounds(366, 160, 36, 20);
			panelDescuentos.add(textField_13);
			textField_13.setColumns(10);
			
			JLabel label = new JLabel("%");
			label.setBounds(412, 163, 19, 14);
			panelDescuentos.add(label);
			
			JRadioButton rdbtnTemporal = new JRadioButton("Temporal");
			rdbtnTemporal.setBounds(453, 159, 109, 23);
			panelDescuentos.add(rdbtnTemporal);
			
			JButton btnBuscar_3 = new JButton("Buscar");
			btnBuscar_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnBuscar_3.setBounds(21, 213, 96, 23);
			panelDescuentos.add(btnBuscar_3);
			
			textField_14 = new JTextField();
			textField_14.setBounds(127, 214, 145, 20);
			panelDescuentos.add(textField_14);
			textField_14.setColumns(10);
			
			JButton btnAadir_2 = new JButton("A\u00F1adir");
			btnAadir_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAadir_2.setBounds(287, 213, 89, 23);
			panelDescuentos.add(btnAadir_2);
			
			JButton btnModificar_3 = new JButton("Modificar");
			btnModificar_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnModificar_3.setBounds(380, 213, 89, 23);
			panelDescuentos.add(btnModificar_3);
			
			JButton btnEliminar_3 = new JButton("Eliminar");
			btnEliminar_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnEliminar_3.setBounds(479, 213, 89, 23);
			panelDescuentos.add(btnEliminar_3);
			
		

			modelo4 = new DefaultTableModel();
			 tableDescuentos = new JTable(modelo4/*data1, columnNames*/);
			 modelo4.addColumn("Id");
			 modelo4.addColumn("Filas");
			 modelo4.addColumn("Columnas");
			 modelo4.addColumn("Audio");
			 modelo4.addColumn("Video");
			 
			 tableDescuentos .setPreferredScrollableViewportSize(new Dimension(400, 200));
			 scrollPaneTableDescuentos = new JScrollPane(tableDescuentos );
			 scrollPaneTableDescuentos.setBounds(25, 259, 537, 226);
			 
			 
			 panelDescuentos.add(scrollPaneTableDescuentos );
			 
			 
			 
			 
		/*	 //cargamos datos
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
				 
				 modelo4.addRow ( fila );
				 
			 }*/
			 
			 
			 tableDescuentos .addMouseListener(new MouseAdapter() {
				 	@Override
				 	public void mouseClicked(MouseEvent arg0) {
				 		
				 		
				 		
				 		
				 		
				 	}});
		
	}


	private void Sesiones(JPanel panelSesiones, JTabbedPane pestana, BBDD bd) {
		 Sesion sesiones = new Sesion();
		pestana.addTab("Sesiones", null, panelSesiones, null);
		panelSesiones.setLayout(null);
		
		JLabel lblNombreDeSalaEnSesion = new JLabel("Sala");
		lblNombreDeSalaEnSesion .setBounds(22, 34, 96, 14);
		panelSesiones.add(lblNombreDeSalaEnSesion );
		
		textField_7 = new JTextField();
		textField_7.setBounds(124, 31, 121, 20);
		panelSesiones.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNombreDePelicula = new JLabel("Pelicula");
		lblNombreDePelicula.setBounds(22, 78, 96, 14);
		panelSesiones.add(lblNombreDePelicula);
		
		textField_9 = new JTextField();
		textField_9.setBounds(124, 75, 121, 20);
		panelSesiones.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblFechaIncio = new JLabel("Fecha Inicio");
		lblFechaIncio.setBounds(302, 34, 68, 14);
		panelSesiones.add(lblFechaIncio);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(384, 78, 203, 22);
		panelSesiones.add(dateChooser);
		
		
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(302, 78, 53, 14);
		panelSesiones.add(lblFechaFin);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(384, 34, 203, 22);
		panelSesiones.add(dateChooser_1);

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
		lblPrecio.setBounds(22, 121, 85, 14);
		panelSesiones.add(lblPrecio);
		

		JComboBox precioSesion = new JComboBox();
		precioSesion.setBounds(124, 121, 121, 20);
		panelSesiones.add(precioSesion);
		
		ResultSet rs = sesiones.precios(bd);
		try {
			while(rs.next()){
			precioSesion.addItem(rs.getString("Nombre"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
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
			
				String precio = (String) precioSesion.getSelectedItem();
				Date fechainicio = dateChooser_1.getDate();
				Date fechafin = dateChooser.getDate();
				boolean l = rdbtnL.isSelected();
				boolean m = rdbtnM.isSelected();
				boolean x = rdbtnX.isSelected();
				boolean j = rdbtnJ.isSelected();
				boolean v = rdbtnV.isSelected();
				boolean s = rdbtnS.isSelected();
				boolean d = rdbtnD.isSelected();
				int hora = (int) horaSesion.getSelectedItem();
				int minutos = (int) minSesion.getSelectedItem();

					if(idUsed_peliculas != null){
						int idpelicula = idUsed_peliculas;
						if(idUsed_salas != null){
							int idsala = idUsed_salas;
							if(fechafin == null){
							sesiones.crearSesion(bd,idpelicula, idsala, precio, fechainicio, hora, minutos);
							}else{
								if(l == true || m == true || x == true || j == true || v == true || s == true || d == true){
									sesiones.crearSesion(bd, idpelicula, idsala, precio, fechainicio, fechafin , l,m,x,j,v,s,d, hora, minutos);
								}else{
									sesiones.crearSesion(bd,idpelicula, idsala, precio, fechainicio, fechafin , hora, minutos);

								}
							}
							}
							else JOptionPane.showMessageDialog(null, "No has seleccionado una sala","Resultado Operacion",JOptionPane.ERROR_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "No has seleccionado una pelicula","Resultado Operacion",JOptionPane.ERROR_MESSAGE);
						
						

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
		
		 modelo3.addColumn("Sala");
		 modelo3.addColumn("Pelicula");
		 modelo3.addColumn("Precio");
		 modelo3.addColumn("Fecha");
		 
		 tableSesiones .setPreferredScrollableViewportSize(new Dimension(400, 200));
		 scrollPaneTableSesiones = new JScrollPane(tableSesiones );
		 scrollPaneTableSesiones.setBounds(22, 283, 562, 202);
		 
		 
		 panelSesiones.add(scrollPaneTableSesiones );
		 
		 
		 
		 
/*
		
		 for(int i=0; i<datosSala.size(); i++){
			 
			 Object [] fila = new Object[5];
			 
			 fila[0] = datosSala.get(i).getIdSala();
			 fila[1] = datosSala.get(i).getFilas();
			 fila[2] = datosSala.get(i).getColumnas();
			 fila[3] = datosSala.get(i).getAudio();
			 fila[4] = datosSala.get(i).getVideo();
			 
			 modelo3.addRow ( fila );
			 
		 }
		 */
		 
		 tableSesiones .addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		
			 		
			 		
			 		
			 	}});
		
	}


	public void Peliculas(JTabbedPane pestana, BBDD bd) throws SQLException{
		Pelicula pelicula = new Pelicula();
		
		JPanel panelPeliculas = new JPanel();
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
	
		String [] generos = {"Documental", "Biográfico", "Histórico", "Musical", "Comedia", "Infantil", "Western", "Aventura", "Accion", "Bélico", "Ciencia ficción", "Drama", "Suspense","Terror / horror","Porno-erótico" };
		for(int aux = 0; aux <generos.length;aux++){
			cBGeneros.addItem(generos[aux]);
		}
	
		
		
		
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
		
		/*Fechas*/
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(78, 90, 183, 20);
		panelPeliculas.add(dateChooser);
		
		JLabel lblEsteno = new JLabel("Esteno");
		lblEsteno.setBounds(24, 96, 46, 14);
		panelPeliculas.add(lblEsteno);
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			
				String titulo = textFTituloPelicula.getText();
				String director = textFDirectorPeliculas.getText();
				String genero = (String) cBGeneros.getSelectedItem();
				Date estreno = dateChooser.getDate();
				String sinopsis = textArea.getText();
				
				pelicula.crearPelicula(bd,titulo, director, genero, sinopsis,estreno);
				try {
					datosTablaPelicula(bd, pelicula, cBGeneros, textArea, dateChooser);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		btnAadir.setBounds(271, 170, 89, 23);
		panelPeliculas.add(btnAadir);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Boton de modificar mostrar datos seleccionados en la tabla en los campos al pulsar
				 * modificar realizar actualizacion de los datos*/
					if(idUsed_peliculas != null){
					int id = idUsed_peliculas;
					String titulo = textFTituloPelicula.getText();
					String director = textFDirectorPeliculas.getText();
					String genero = (String) cBGeneros.getSelectedItem();
					String sinopsis = textArea.getText();
					Date estreno = dateChooser.getDate();
					
					pelicula.modificarPelicula(bd,titulo, director, genero,  sinopsis, id,estreno);
					try {
						datosTablaPelicula(bd, pelicula, cBGeneros, textArea, dateChooser);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else JOptionPane.showMessageDialog(null, "No has seleccionado ningun elemento");
			}
		});
		btnModificar.setBounds(370, 170, 89, 23);
		panelPeliculas.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idUsed_peliculas!=null){
					pelicula.borrarPelicula(bd, idUsed_peliculas);
					try {
						datosTablaPelicula(bd, pelicula, cBGeneros, textArea, dateChooser);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else JOptionPane.showMessageDialog(null, "No has seleccionado ningun elemento");
				
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
		 modelo.addColumn("ID");
		 modelo.addColumn("Titulo");
		 modelo.addColumn("Genero");
		 modelo.addColumn("Director");
		 modelo.addColumn("Sinopsis");
		 modelo.addColumn("Estreno");
		 
		 tablePeliculas.getColumnModel().getColumn(0).setMaxWidth(0);
		 tablePeliculas.getColumnModel().getColumn(0).setMinWidth(0);
		 tablePeliculas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		 tablePeliculas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		 tablePeliculas.setPreferredScrollableViewportSize(new Dimension(400, 200));
		 scrollPaneTablePeliculas= new JScrollPane(tablePeliculas);
		 scrollPaneTablePeliculas.setBounds(24, 220, 534, 252);
		 
		 
		 panelPeliculas.add(scrollPaneTablePeliculas);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(381, 157, -133, -78);
		 panelPeliculas.add(scrollPane);
		 
		datosTablaPelicula(bd, pelicula, cBGeneros, textArea, dateChooser);
		
		
		 
	}


	private void datosTablaPelicula(BBDD bd, Pelicula pelicula,JComboBox cBGeneros, JTextArea textArea, JDateChooser dateChooser ) throws SQLException {
		for(int i = (modelo.getRowCount()-1); i>=0;i--){
		modelo.removeRow(i);
		}
		ResultSet rs = pelicula.verPelicula(bd);
		 //cargamos datos
		 while(rs.next()){
			 Object [] fila = new Object[6];
			 
			 		fila[0] = rs.getString("IDPelicula");
	 				fila[1] = rs.getString("Titulo");
	 				fila[2] = rs.getString("Genero");
	 				fila[3] = rs.getString("Director");
	 				fila[4] = rs.getString("Sinopsis");
	 				fila[5] = rs.getDate("Estreno");
			 
			 modelo.addRow ( fila );
			 
			 
		 }
		 
		 
		 tablePeliculas.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		idUsed_peliculas = Integer.parseInt(String.valueOf(modelo.getValueAt(tablePeliculas.rowAtPoint(arg0.getPoint()), 0)));
			 		textFTituloPelicula.setText(String.valueOf(modelo.getValueAt(tablePeliculas.rowAtPoint(arg0.getPoint()), 1)));
			 		String combox = String.valueOf(modelo.getValueAt(tablePeliculas.rowAtPoint(arg0.getPoint()), 2));
			 		for(int i = 0; i<cBGeneros.getItemCount();i++){
			 			if(combox.equals(cBGeneros.getItemAt(i))){
			 				
			 				cBGeneros.setSelectedIndex(i);
			 			}
			 		}
			 		textFDirectorPeliculas.setText(String.valueOf(modelo.getValueAt(tablePeliculas.rowAtPoint(arg0.getPoint()), 3)));
			 		
			 		textArea.setText(String.valueOf(modelo.getValueAt(tablePeliculas.rowAtPoint(arg0.getPoint()), 4)));
			 		String aux = String.valueOf(modelo.getValueAt(tablePeliculas.rowAtPoint(arg0.getPoint()), 5));
			 		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			 		Date fechapelicula = null;
					try {
						fechapelicula = sdf.parse(aux);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 		dateChooser.setDate(fechapelicula);
			 		textField_9.setText(String.valueOf(modelo.getValueAt(tablePeliculas.rowAtPoint(arg0.getPoint()), 1)));
			 			 						
			 	}});
	}
	
	
	private void Salas(JTabbedPane pestana, BBDD bd) {
			Sala sala = new Sala();
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
					String nombre = textField.getText();
					int filas = Integer.parseInt(textField_1.getText());
					int columnas = Integer.parseInt(textField_2.getText());
					String audio = textField_3.getText();
					String video = textField_4.getText();

					sala.añadirSala(bd, nombre, filas, columnas, audio, video);
					
					datosTablaSalas(sala, bd,textField,textField_1,textField_2,textField_3,textField_4);

					
				}
			});
			btnAadir_1.setBounds(285, 239, 89, 23);
			panelSalas.add(btnAadir_1);
			
			JButton btnModificar_1 = new JButton("Modificar");
			btnModificar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(idUsed_salas!=null){
						String nombre = textField.getText();
						int filas = Integer.parseInt(textField_1.getText());
						int columnas = Integer.parseInt(textField_2.getText());
						String audio = textField_3.getText();
						String video = textField_4.getText();
						
						sala.modificarSala(bd, nombre, filas, columnas, audio, video, idUsed_salas);
						
						datosTablaSalas(sala, bd,textField,textField_1,textField_2,textField_3,textField_4);
					}
					else{
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun elemento");
					}
				}
			});
			btnModificar_1.setBounds(384, 239, 89, 23);
			panelSalas.add(btnModificar_1);
			
			JButton btnEliminar_1 = new JButton("Eliminar");
			btnEliminar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(idUsed_salas!=null){
						sala.borrarSala(bd, idUsed_salas);
						datosTablaSalas(sala, bd,textField,textField_1,textField_2,textField_3,textField_4);
						
					}else JOptionPane.showMessageDialog(null, "No has seleccionado ningun elemento");
			
				}
			});
			btnEliminar_1.setBounds(483, 239, 89, 23);
			panelSalas.add(btnEliminar_1);
			
			
			
			modelo2 = new DefaultTableModel();
			 tableSalas = new JTable(modelo2/*data1, columnNames*/);
			 modelo2.addColumn("ID Sala");
			 modelo2.addColumn("Nombre");
			 modelo2.addColumn("Filas");
			 modelo2.addColumn("Columnas");
			 modelo2.addColumn("Audio");
			 modelo2.addColumn("Video");
			 
			 tableSalas.getColumnModel().getColumn(0).setMaxWidth(0);
			 tableSalas.getColumnModel().getColumn(0).setMinWidth(0);
			 tableSalas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
			 tableSalas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
			 tableSalas .setPreferredScrollableViewportSize(new Dimension(400, 200));
			 scrollPaneTableSalas = new JScrollPane(tableSalas );
			 scrollPaneTableSalas .setBounds(23, 270, 549, 202);
			 
			 
			 panelSalas.add(scrollPaneTableSalas );
			 
			 
			 
			 
			 datosTablaSalas(sala, bd,textField,textField_1,textField_2,textField_3,textField_4);
		
	}


	private void datosTablaSalas(Sala sala, BBDD bd, JTextField textField, JTextField textField_110, JTextField textField_27, JTextField textField_32, JTextField textField_42) {
		
		for(int i = (modelo2.getRowCount()-1); i>=0;i--){
		modelo2.removeRow(i);
		}
		ResultSet rs = sala.verSalas(bd);
		 //cargamos datos
		 try {
			while(rs.next()){
				 Object [] fila = new Object[6];
				 
				 		fila[0] = rs.getString("IDSalas");
						fila[1] = rs.getString("Nombre");
						fila[2] = rs.getString("Filas");
						fila[3] = rs.getString("Columnas");
						fila[4] = rs.getString("Audio");
						fila[5] = rs.getString("Video");
				 
				 modelo2.addRow ( fila );
				 
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 
		 
		 tableSalas .addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		
			 		idUsed_salas = Integer.parseInt(String.valueOf(modelo2.getValueAt(tableSalas.rowAtPoint(arg0.getPoint()), 0)));
			 		textField.setText(String.valueOf(modelo2.getValueAt(tableSalas.rowAtPoint(arg0.getPoint()), 1)));
			 		textField_1.setText(String.valueOf(modelo2.getValueAt(tableSalas.rowAtPoint(arg0.getPoint()), 2)));
			 		textField_2.setText(String.valueOf(modelo2.getValueAt(tableSalas.rowAtPoint(arg0.getPoint()), 3)));
			 		textField_3.setText(String.valueOf(modelo2.getValueAt(tableSalas.rowAtPoint(arg0.getPoint()), 4)));
			 		textField_4.setText(String.valueOf(modelo2.getValueAt(tableSalas.rowAtPoint(arg0.getPoint()), 5)));
			 		textField_7.setText(String.valueOf(modelo2.getValueAt(tableSalas.rowAtPoint(arg0.getPoint()), 1)));
			 		
			 	}});
	}
}
