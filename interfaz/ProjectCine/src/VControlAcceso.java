import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VControlAcceso extends JFrame {

	private JPanel contentPane;
	public static JTextField tusuario;
	public static JPasswordField tclave;

	


	/**
	 * Create the frame.
	 */
	public VControlAcceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribaSuNombre = new JLabel("Escriba su nombre y contrase\u00F1a");
		lblEscribaSuNombre.setBounds(112, 41, 197, 14);
		contentPane.add(lblEscribaSuNombre);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(64, 103, 67, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(64, 150, 46, 14);
		contentPane.add(lblClave);
		
		tusuario= new JTextField();
		tusuario.setText("");
		tusuario.setBounds(124, 100, 185, 20);
		contentPane.add(tusuario);
		tusuario.setColumns(10);
		
		tclave = new JPasswordField();
		tclave.setText("");
		tclave.setBounds(120, 147, 189, 20);
		contentPane.add(tclave);
		tclave.setColumns(10);
		
		Bd baseD = new Bd();
		
		JButton bAceptarAcceso = new JButton("Aceptar");
		bAceptarAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				int control=baseD.controlAcceso();
				
				if(control==1) {
					
					System.out.println("Eres administrador");
					
					VAdministrador va = new VAdministrador();
					va.setVisible(true);
					JOptionPane.showMessageDialog(null, "Bienvenido señor administrador "+ tusuario.getText());
					
					dispose();
					
				} else if (control==2) {
					
					
					V1Taquillero vt = new V1Taquillero();
					vt.setVisible(true);
					JOptionPane.showMessageDialog(null, "Bienvenido señor Vendedor "+ tusuario.getText());
					dispose();
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Lo sentimos no esta registrado como usuario o a contraseña es incorrecta");
				}
				
			
				
			}
		});
		bAceptarAcceso.setBounds(224, 207, 89, 23);
		contentPane.add(bAceptarAcceso);
		
		JButton bCancelarAcceso = new JButton("Cancelar");
		bCancelarAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//metodo para cerrar ventana
				dispose();
			}
		});
		bCancelarAcceso.setBounds(323, 207, 89, 23);
		contentPane.add(bCancelarAcceso);
	}
}
