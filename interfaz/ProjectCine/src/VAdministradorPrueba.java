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

public class VAdministradorPrueba extends JFrame {

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
	//private ArrayList <Sala> datosSala = new ArrayList<Sala>();
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
					VAdministradorPrueba frame = new VAdministradorPrueba();
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
	public VAdministradorPrueba() {
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
					
					/*public void crearModelTabla (DefaultTableModel modelo, String [] campos, int [] columnas) {
					 * 
					 * 
					 * 
					 * 
					 * 
					 * }*/
					
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
					 
					 String [] camposTablaDescuentos= {"Id", "Nombre", "Descripcion", "Inicio", "Fin", "Dia Sem", "Porcentaje", "Temporal"}; 
					 int [] columnMedida= {40, 110, 140, 70, 70, 60, 45, 50};
					 
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
