import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class V1Taquillero extends JFrame {

	private JPanel contentPane;
	private JTextField tFPelicula;
	private JTextField tFSesion;
	private JTextField tFSala;
	private JDateChooser dateChooser;
	private java.text.SimpleDateFormat formatFechaSQL;
	private String fechaMin="", fechaMax="";
	private DefaultTableModel modelo;
	private JTable tableEntradas;
	private JScrollPane scrollPaneTableEntradas;
	private ArrayList <Sala> datosSala= new ArrayList<Sala>();
	private int idEmp=0;
	private BBDD bd = null;
	
	
	public V1Taquillero(int idEmp)  {
		
		this.idEmp=idEmp;
		System.out.println(idEmp+ " ES EMPLEADO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setBounds(26, 27, 57, 14);
		contentPane.add(lblPelicula);
		
		tFPelicula = new JTextField();
		tFPelicula.setBounds(93, 24, 143, 20);
		contentPane.add(tFPelicula);
		tFPelicula.setColumns(10);
		
		JLabel lblSesin = new JLabel("Sesi\u00F3n");
		lblSesin.setBounds(26, 72, 46, 14);
		contentPane.add(lblSesin);
		
		tFSesion = new JTextField();
		tFSesion.setBounds(93, 69, 143, 20);
		contentPane.add(tFSesion);
		tFSesion.setColumns(10);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(26, 115, 46, 14);
		contentPane.add(lblSala);
		
		tFSala = new JTextField();
		tFSala.setBounds(93, 112, 143, 20);
		contentPane.add(tFSala);
		tFSala.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(525, 27, 95, 20);
		contentPane.add(dateChooser);
		
		//Cambia formato de fecha
		dateChooser.setDateFormatString("dd/MM/yyyy");
		//Coloca una fecha por defecto	
		dateChooser.setDate(Calendar.getInstance().getTime());
		//dateChooser.setMinSelectableDate(Calendar.getInstance().getTime());
		
		formatFechaSQL = new java.text.SimpleDateFormat("yyyy-MM-dd");
		fechaMin=formatFechaSQL.format(dateChooser.getDate().getTime());
		fechaMax=fechaMin+" 23:59:59";
		fechaMin=fechaMin+" 00:00:00";
		
		
		
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) { 
				
				formatFechaSQL = new java.text.SimpleDateFormat("yyyy-MM-dd");
				fechaMin=formatFechaSQL.format(dateChooser.getDate().getTime());
				fechaMax=fechaMin+" 23:59:59";
				fechaMin=fechaMin+" 00:00:00";
				
				System.out.println(fechaMin+" "+fechaMax);
				
				
			}});
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(438, 111, 89, 23);
		contentPane.add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				datosTabla(tFPelicula.getText().toString(),tFSesion.getText().toString(),tFSala.getText().toString());
							
			}
		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(537, 111, 89, 23);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
							
			}
		});
		
		 modelo = new DefaultTableModel();
		 tableEntradas = new JTable(modelo);
		 modelo.addColumn("Id");
		 modelo.addColumn("Pelicula");
		 modelo.addColumn("Sala");
		 modelo.addColumn("Fecha");
		 modelo.addColumn("Hora");
		 modelo.addColumn("Precio");
		 
		 TableColumn columna1 = tableEntradas.getColumn("Id");
		  columna1.setMaxWidth(60);
		  columna1.setCellRenderer(centrarCell());
		  
		  TableColumn columna2 = tableEntradas.getColumn("Pelicula");
		  columna2.setMaxWidth(250);
		  columna2.setCellRenderer(centrarCell());
		  
		  TableColumn columna3 = tableEntradas.getColumn("Sala");
		  columna3.setMaxWidth(60);
		  columna3.setCellRenderer(centrarCell());
		  
		  TableColumn columna4 = tableEntradas.getColumn("Fecha");
		  columna4.setMaxWidth(100);
		  columna4.setCellRenderer(centrarCell());
		  
		  TableColumn columna5 = tableEntradas.getColumn("Hora");
		  columna5.setMaxWidth(80);
		  columna5.setCellRenderer(centrarCell());
		  
		  TableColumn columna6 = tableEntradas.getColumn("Precio");
		  columna6.setMaxWidth(90);
		  columna6.setCellRenderer(centrarCell());
		 
		 tableEntradas .setPreferredScrollableViewportSize(new Dimension(400, 200));
		 scrollPaneTableEntradas = new JScrollPane(tableEntradas );
		 scrollPaneTableEntradas .setBounds(24, 157, 602, 357);
		 
		 
		 contentPane .add(scrollPaneTableEntradas );
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(381, 157, -133, -78);
		 contentPane .add(scrollPane);
		 
		 		 
		
		
		 		 
		 tableEntradas .addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		
			 		
			 		V2Taquillero vt= new V2Taquillero(idEmp, String.valueOf(modelo.getValueAt(tableEntradas.rowAtPoint(arg0.getPoint()),0)),String.valueOf(modelo.getValueAt(tableEntradas.rowAtPoint(arg0.getPoint()),1)),String.valueOf(modelo.getValueAt(tableEntradas.rowAtPoint(arg0.getPoint()),2)), String.valueOf(modelo.getValueAt(tableEntradas.rowAtPoint(arg0.getPoint()),4))+" "+String.valueOf(modelo.getValueAt(tableEntradas.rowAtPoint(arg0.getPoint()),3)));
					
					vt.setVisible(true);
					
					dispose();
			 		
			 		
			 	}});
	}
	
	
		
		
			
	
	public void datosTabla(String pel, String ses, String sala){
		
		vaciarTabla();
		
		String consulta="SELECT se.IDSesion, pe.Titulo, se.IDPelicula, se.IDSala, pr.Precio, se.FechaHora FROM sesiones se INNER JOIN peliculas pe INNER JOIN precios pr WHERE se.IDPelicula=pe.IDPelicula AND se.IDPrecio=pr.IDPrecio AND se.FechaHora>='"/*+ce.camFormat3(ce.camFormat1(diaFFSesion.getSelectedItem().toString(), mesFFSesion.getSelectedItem().toString(), anoFFSesion.getSelectedItem().toString()))+" 00:00:00'*/+fechaMin+"' AND se.FechaHora<='"+fechaMax+"'";/*+ce.camFormat3(ce.camFormat1(diaFFSesion.getSelectedItem().toString(), mesFFSesion.getSelectedItem().toString(), anoFFSesion.getSelectedItem().toString()))+" 23:59:59'";*/
		
		
		bd.Conexion();
		
		if(!pel.equals("")){
			
			consulta+="AND pe.Titulo='"+ pel+"'";
			
		}
		
		if(!ses.equals("")) {
			
			consulta+="AND se.IDSesion='"+ ses+"'";
		}
		
		if(!sala.equals("")) {
			
			consulta+="AND se.IDSala='"+ sala+"'";
		}
		
		ResultSet contenido= bd.seleccionar(consulta);
		
				
	try {	
		
		contenido.last();
		
		if(contenido.getRow()>0) {
		
		contenido.first();
		
			do {
			
			 
				Object [] fila = new Object[6];
			 
			 
			 
				 fila[0]=contenido.getString("IDSesion");
				 fila[1] = contenido.getString("Titulo");
				 fila[2] = contenido.getString("IDSala"); 
				 String fechHor [] =  contenido.getString("FechaHora").split(" ");
				 String [] fecha = fechHor[0].split("-");
				 String hora = fechHor[1].substring(0, 5);
				 fila[3] = fecha[2]+"/"+fecha[1]+"/"+fecha[0];
				 fila[4] = hora;
				 fila[5] = contenido.getString("Precio")+" $";
			 			 
				 	modelo.addRow ( fila );
			 
			
			}while(contenido.next());
		} else {
			
			JOptionPane.showMessageDialog(null, "No se han encontrado resultados!!");
			
		}
	} 
	
	catch(Exception e){
			 
		 System.out.println("Error");
	 }
		
				
	}
	
	public void vaciarTabla(){
		
		for(int i=modelo.getRowCount()-1; i>=0; i--) {
			
			modelo.removeRow(i);
					
		}	
	}
	
	public DefaultTableCellRenderer centrarCell(){
	
	DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
    modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

    return modelocentrar; 
    
	}
}
 