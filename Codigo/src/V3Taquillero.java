import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V3Taquillero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEfectivo;
	private JLabel lblTarjeta;
	private JSlider slider;
	private DefaultTableModel modelo;
	private JTable tableEntradas;
	private JScrollPane scrollPaneTableEntradas;
	
	private String consulta="";
	private ControlErrores ce= new ControlErrores();
	private String fechaSQL="";
	private int diaSemana=0;
	private int entradaSel=0;
	private Entrada[] entradas=null;
	private int [] descuentos=null;
	private String hora="";
	private String pelicula="";
	private boolean bandera=true;
	private double precio=0, efectivo=0, tarjeta;
	DecimalFormat df = new DecimalFormat("#.00");
	private ResultSet contenido=null;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public V3Taquillero(Entrada[] entradas, String pelicula, String hora, BBDD bd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.entradas=entradas;
		this.hora=hora;
		this.pelicula=pelicula;
		descuentos= new int[entradas.length];
		
		for(int i=0; i<descuentos.length; i++) {
			
			descuentos[i]=0;
		}
		
		
		fechaSQL=ce.camFormat3(hora.substring(6,16));
		int dia = Integer.parseInt(hora.substring(6,8));
		int mes = Integer.parseInt(hora.substring(9,11));
		int ano = Integer.parseInt(hora.substring(12,16));
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.MONTH, mes-1);
		c.set(Calendar.YEAR, ano);
		
		diaSemana= c.get(Calendar.DAY_OF_WEEK);
		
		bd.Conexion();
		
		consulta="SELECT pr.Precio FROM sesiones se INNER JOIN precios pr WHERE pr.IDPrecio= se.IDPrecio AND se.IDSesion="+entradas[0].getIDSesion();
		
		contenido= bd.seleccionar(consulta);
		
		
		try {	
			
			contenido.last();
			
			if(contenido.getRow()>0) {
			
			contenido.first();
			
			for(int i=0; i<entradas.length; i++) {
			
				entradas[i].setPrecio(Double.parseDouble(contenido.getString("Precio")));
			
			}
			
			 }else {
				 
				 System.out.println("No hay entradas");
				 
			 }} 
		
				catch(Exception e){
				 
				 System.out.println("Error");
			 }
		
		
		JLabel lblIdSocio = new JLabel("Id Socio");
		lblIdSocio.setBounds(50, 36, 54, 14);
		contentPane.add(lblIdSocio);
		
		textField = new JTextField();
		textField.setBounds(114, 33, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(50, 73, 271, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(49, 108, 223, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDni = new JLabel("D.N.I:");
		lblDni.setBounds(50, 143, 203, 14);
		contentPane.add(lblDni);
		
		JRadioButton rdbtnSuplemento = new JRadioButton("Suplemento");
		rdbtnSuplemento.setBounds(495, 75, 109, 23);
		contentPane.add(rdbtnSuplemento);
		
		lblEfectivo = new JLabel("Efectivo: 0 $");
		lblEfectivo.setBounds(380, 125, 95, 14);
		contentPane.add(lblEfectivo);
		
		lblTarjeta = new JLabel("Tarjeta: 0$");
		lblTarjeta.setBounds(520, 125, 95, 14);
		contentPane.add(lblTarjeta);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				efectivo=(slider.getValue()*precio)/100;
				tarjeta=((100-slider.getValue())*precio)/100;
				lblEfectivo.setText("Efectivo: "+df.format(efectivo)+" $");
				lblTarjeta.setText("Tarjeta: "+df.format(tarjeta)+" $");
			}
		});
		
		slider.setBounds(380, 140, 230, 40);
		contentPane.add(slider);
		slider.setValue(50);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(353, 33, 136, 20);
		contentPane.add(comboBox);
		bd.Conexion();
		
		consulta="SELECT * FROM `descuentos` WHERE ((FechaInicio<='"+fechaSQL+"' AND FechaFin>='"+fechaSQL+"') OR (Temporal=0)) AND DiaSemana LIKE '%"+diaSemana+"%'";
		
		contenido= bd.seleccionar(consulta);
		
		
		try {	
			
			contenido.last();
			
			if(contenido.getRow()>0) {
			
			contenido.first();
			
			do {
				
				comboBox.addItem(contenido.getString("Nombre"));				 
				 
				 
				
			 }while(contenido.next()); }else {
				 
				 comboBox.addItem("No ha descuentos");
				 
			 }} 
		
				catch(Exception e){
				 
				 System.out.println("Error");
			 }
		
		
		comboBox.setSelectedIndex(0);
		
		JLabel lblDescuentos = new JLabel("Descuentos");
		lblDescuentos.setBounds(511, 36, 80, 14);
		contentPane.add(lblDescuentos);
		
		JButton btnComprobarSocio = new JButton("Comprobar Socio");
		btnComprobarSocio.setBounds(90, 200, 139, 23);
		contentPane.add(btnComprobarSocio);
		btnComprobarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().equals("") && !textField.getText().equals("1")) {
					
					bd.Conexion();
					consulta="SELECT * FROM socios WHERE IDSocios='"+textField .getText()+"'";
					
					ResultSet contenido2= bd.seleccionar(consulta);
										
					try {	
						
						contenido2.last();
						
						if (contenido2.getRow()>0){
							
							contenido2.first();
							lblNombre.setText("Nombre:        "+contenido2.getString("Nombre"));
							lblApellidos.setText("Apellidos:    "+contenido2.getString("Apellidos"));
							lblDni.setText("D.N.I:            "+contenido2.getString("DNI"));
							
							entradas[entradaSel].setIDSocio(Integer.parseInt(textField.getText().toString()));
							
						} else {
							
							lblNombre.setText("Nombre: ");
							lblApellidos.setText("Apellidos: ");
							lblDni.setText("D.N.I: ");
							
							JOptionPane.showMessageDialog(null, "Socio no registrado");
							
						}
						
					} 
					
					catch(Exception e1){
							 
						 System.out.println(e1);
					}
					
					
				} else {
					
					lblNombre.setText("Nombre: ");
					lblApellidos.setText("Apellidos: ");
					lblDni.setText("D.N.I: ");
					
					JOptionPane.showMessageDialog(null, "Socio no registrado");
					
				}	
				
				
			}});
				
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(239, 200, 89, 23);
		contentPane.add(btnAplicar);
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(descuentos[entradaSel]!=0) {
										
					entradas[entradaSel].setPrecio((100*entradas[entradaSel].getPrecio())/(100-descuentos[entradaSel]));
				} 
				
				if(rdbtnSuplemento.isSelected() && !entradas[entradaSel].getSuplemento()){
									
					entradas[entradaSel].setSuplemento(true);
				} 
				
				if(!rdbtnSuplemento.isSelected() && entradas[entradaSel].getSuplemento()){
					
					entradas[entradaSel].setSuplemento(false);
				
				}
				
				
				bd.Conexion();
				consulta="SELECT IDDescuento, Porcentaje FROM descuentos WHERE Nombre='"+comboBox.getSelectedItem().toString()+"'";
				
				contenido= bd.seleccionar(consulta);
								
				try {	
					
					contenido.last();
					int cont=contenido.getRow();
					contenido.first();
					
					if(cont>0) {
									
					 entradas[entradaSel].setIDDescuento(Integer.parseInt(contenido.getString("IDDescuento")));
					 descuentos[entradaSel]=Integer.parseInt(contenido.getString("Porcentaje"));
					
						}else {
						 
						  comboBox.addItem("No hay descuentos");
						 
						}
				} 
				
				catch(Exception e1){
						 
					 System.out.println(e1);
				 }
				
					
				if(entradas[entradaSel].getIDDescuento()!=0) {
					
					entradas[entradaSel].setPrecio(-((entradas[entradaSel].getPrecio()*descuentos[entradaSel])/(100))+entradas[entradaSel].getPrecio());
										
				}
				
				actualizarTabla();
							
				
			}});
		
		
		
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bd.Conexion();
				String consulta="INSERT INTO pagos( `Preciototal`, `Efectivo`, `Tarjeta`) VALUES ("+precio+","+efectivo+","+tarjeta+")";
				bd.insModEli(consulta);
				
				
				int idPago=0;
				consulta="SELECT IDPagos FROM pagos ORDER BY IDPagos DESC LIMIT 1";
				contenido= bd.seleccionar(consulta);
				
				try {
					
					contenido.first();
					idPago= Integer.parseInt(contenido.getString("IDPagos"));
					
				} catch (Exception e1){
					
					System.out.println("fatal error");
										
				}
				
				
				for(int i=0; i<entradas.length; i++){
					
									
					if(entradas[i].getSuplemento()){
					
					consulta="INSERT INTO `entradas`( `IDSesion`, `IDSocio`, `IDEmpleado`, `IDDescuento`, `IDPago`, `Fila`, `Columna`, `Suplemento`, `Precio`) VALUES ('"+entradas[i].getIDSesion()+"','"+entradas[i].getIDSocio()+"','"+entradas[i].getIDEmpleado()+"','"+entradas[i].getIDDescuento()+"','"+idPago+"','"+entradas[i].getFila()+"','"+entradas[i].getColumna()+"','1','"+entradas[i].getPrecio()+"')";
					bd.insModEli(consulta);
										
					
					} else {
						
						consulta="INSERT INTO `entradas`( `IDSesion`, `IDSocio`, `IDEmpleado`, `IDDescuento`, `IDPago`, `Fila`, `Columna`, `Suplemento`, `Precio`) VALUES ('"+entradas[i].getIDSesion()+"','"+entradas[i].getIDSocio()+"','"+entradas[i].getIDEmpleado()+"','"+entradas[i].getIDDescuento()+"','"+idPago+"','"+entradas[i].getFila()+"','"+entradas[i].getColumna()+"','0','"+entradas[i].getPrecio()+"')";	
						bd.insModEli(consulta);
											
					}
				}
				
				bd.desconexion();
				
				JOptionPane.showMessageDialog(null, "La operación se ha realizado con exito");
				
				V1Taquillero vt= new V1Taquillero(entradas[0].getIDEmpleado(), bd);
				vt.setVisible(true);
				dispose();
				
			}
		});
		btnCobrar.setBounds(338, 200, 89, 23);
		contentPane.add(btnCobrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		 		
			JOptionPane.showMessageDialog(null, "La operación ha sido cancelada!!");
		 		V1Taquillero vt= new V1Taquillero(entradas[0].getIDEmpleado(), bd);
				vt.setVisible(true);
				dispose();
		 	}
		 });
		
		btnCancelar.setBounds(437, 200, 89, 23);
		contentPane.add(btnCancelar);
		
		modelo = new DefaultTableModel();
		tableEntradas = new JTable(modelo);
		modelo.addColumn("Entrada");
		modelo.addColumn("Pelicula");
		modelo.addColumn("Sesión");
		modelo.addColumn("Fil");
		modelo.addColumn("Col");
		modelo.addColumn("Desc");
		modelo.addColumn("Supl");
		modelo.addColumn("Precio");
		 
		TableColumn columna1 = tableEntradas.getColumn("Entrada");
		columna1.setMaxWidth(60);
		columna1.setCellRenderer(centrarCell());
		  
		TableColumn columna2 = tableEntradas.getColumn("Pelicula");
		columna2.setMaxWidth(250);
		columna2.setCellRenderer(centrarCell());
		  
		TableColumn columna3 = tableEntradas.getColumn("Sesión");
		columna3.setMaxWidth(60);
		columna3.setCellRenderer(centrarCell());
		  
		TableColumn columna4 = tableEntradas.getColumn("Fil");
		columna4.setMaxWidth(40);
		columna4.setCellRenderer(centrarCell());
		  
		TableColumn columna5 = tableEntradas.getColumn("Col");
		columna5.setMaxWidth(40);
		columna5.setCellRenderer(centrarCell());
		  
		TableColumn columna6 = tableEntradas.getColumn("Desc");
		columna6.setMaxWidth(40);
		columna6.setCellRenderer(centrarCell());
		  
		TableColumn columna7 = tableEntradas.getColumn("Supl");
		columna7.setMaxWidth(40);
		columna7.setCellRenderer(centrarCell());
		  
		TableColumn columna8 = tableEntradas.getColumn("Precio");
		columna8.setMaxWidth(75);
		columna8.setCellRenderer(centrarCell());
		 
		tableEntradas.setPreferredScrollableViewportSize(new Dimension(400, 200));
		scrollPaneTableEntradas= new JScrollPane(tableEntradas);
		scrollPaneTableEntradas.setBounds(35, 235, 569, 252);
		 
		contentPane.add(scrollPaneTableEntradas);
		 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(381, 157, -133, -78);
		contentPane.add(scrollPane);
		 
		actualizarTabla();
				 
		tableEntradas.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 					 		
			 		entradaSel=tableEntradas.rowAtPoint(arg0.getPoint());
			 					 		
			 	}});
	}
	
	public void actualizarTabla() {
		
		precio=0;
		int nFilas=modelo.getRowCount();
		for(int i=0; i<nFilas; i++) {
			
			modelo.removeRow(0);
			
		}
		
		
		for(int i=0; i<entradas.length+1; i++){
			 
			
			 Object [] fila = new Object[8];
						
			if(i<entradas.length) { 
			fila[0] = i+1;
			fila[1] = pelicula;
			fila[2] = hora.substring(0, 5);
			fila[3] = entradas[i].getFila();
			fila[4] = entradas[i].getColumna();
			fila[5] = descuentos[i]+"%";
			if(entradas[i].getSuplemento()){
				  
			  fila[6] = "+3 $";	  
				  
			} else {
				  
			  fila[6] = "0 $";
			
			}
			  
			  if(entradas[i].getSuplemento()){ 
				
				  fila[7] = entradas[i].getPrecio()+3+" $";
				  precio=precio+entradas[i].getPrecio()+3;
				  
			  } else {
				 			  
				  fila[7] = entradas[i].getPrecio()+" $";
				  precio=precio+entradas[i].getPrecio();
				  
			  }
			
			} else {
				
				fila[6] = "Total";
				fila[7] = precio+" $";
				
				efectivo=(slider.getValue()*precio)/100;
				tarjeta=((100-slider.getValue())*precio)/100;
				lblEfectivo.setText("Efectivo: "+df.format(efectivo)+" $");
				lblTarjeta.setText("Tarjeta: "+df.format(tarjeta)+" $");
			}
						
			 modelo.addRow ( fila );
			 
		 }
		
		
	}
	
	public DefaultTableCellRenderer centrarCell(){
		
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
	    modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

	    return modelocentrar; 
	    
		}
}
