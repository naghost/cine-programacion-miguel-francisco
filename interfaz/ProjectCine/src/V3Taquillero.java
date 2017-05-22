import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V3Taquillero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultTableModel modelo;
	private JTable tableEntradas;
	private JScrollPane scrollPaneTableEntradas;
	private ArrayList <Sala> datos = new ArrayList<Sala>();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V3Taquillero frame = new V3Taquillero();
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
	public V3Taquillero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 100, 680, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnComprobarSocio = new JButton("Comprobar Socio");
		btnComprobarSocio.setBounds(90, 179, 139, 23);
		contentPane.add(btnComprobarSocio);
		
		JRadioButton rdbtnSuplemento = new JRadioButton("Complemento");
		rdbtnSuplemento.setBounds(495, 91, 109, 23);
		contentPane.add(rdbtnSuplemento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(353, 33, 136, 20);
		contentPane.add(comboBox);
		
		comboBox.addItem("Día del Espectador");
		comboBox.addItem("Socio");
		comboBox.addItem("Días de Cine");
		comboBox.setSelectedIndex(0);
		
		JLabel lblDescuentos = new JLabel("Descuentos");
		lblDescuentos.setBounds(511, 36, 80, 14);
		contentPane.add(lblDescuentos);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(239, 179, 89, 23);
		contentPane.add(btnAplicar);
		
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				V1Taquillero vt= new V1Taquillero();
				vt.setVisible(true);
				dispose();
				
			}
		});
		btnCobrar.setBounds(338, 179, 89, 23);
		contentPane.add(btnCobrar);
		
		 JButton btnCancelar = new JButton("Cancelar");
		 btnCancelar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		V1Taquillero vt= new V1Taquillero();
				vt.setVisible(true);
				dispose();
		 	}
		 });
		 btnCancelar.setBounds(437, 179, 89, 23);
		 contentPane.add(btnCancelar);
		
		modelo = new DefaultTableModel();
		 tableEntradas = new JTable(modelo/*data1, columnNames*/);
		 modelo.addColumn("Id");
		 modelo.addColumn("Filas");
		 modelo.addColumn("Columnas");
		 modelo.addColumn("Audio");
		 modelo.addColumn("Video");
		 
		 tableEntradas.setPreferredScrollableViewportSize(new Dimension(400, 200));
		 scrollPaneTableEntradas= new JScrollPane(tableEntradas);
		 scrollPaneTableEntradas.setBounds(35, 227, 569, 252);
		 
		 
		 contentPane.add(scrollPaneTableEntradas);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(381, 157, -133, -78);
		 contentPane.add(scrollPane);
		 
		
		 
		 
		 //cargamos datos
		 for(int i=0; i<18; i++){
			 
			 datos.add(new Sala(1, 50, 60, "C3", "C5"));
			 
			 
		 }
		 
		
		 for(int i=0; i<datos.size(); i++){
			 
			 Object [] fila = new Object[5];
			 
			 fila[0] = datos.get(i).getIdSala();
			 fila[1] = datos.get(i).getFilas();
			 fila[2] = datos.get(i).getColumnas();
			 fila[3] = datos.get(i).getAudio();
			 fila[4] = datos.get(i).getVideo();
			 
			 modelo.addRow ( fila );
			 
		 }
		 
		 
		 tableEntradas.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		
			 		
			 		System.out.println(tableEntradas.rowAtPoint(arg0.getPoint()));			 		
			 		
			 		
			 	}});
	}
}
