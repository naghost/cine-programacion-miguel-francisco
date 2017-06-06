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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class VControlAcceso extends JFrame {

	private JPanel contentPane;
	public static JTextField tusuario;
	public static JPasswordField tclave;
	private int id=0;
	public String claveP="";
	public String consulta="";
	//0 primer paso, 1 pedirle nueva contraseña, 2 pedirle contraseña y compararla
	public int proceso=0;

	private ResultSet contiene=null;

		/**
	 * Create the frame.
	 */
	public VControlAcceso(BBDD bd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribaSuNombre = new JLabel("Escriba su usuario y clave.");
		lblEscribaSuNombre.setBounds(112, 41, 197, 14);
		contentPane.add(lblEscribaSuNombre);
		
		JLabel lblPrimVez = new JLabel("(Si accede por primera vez solo rellene en el campo de clave su ID)");
		lblPrimVez .setBounds(25, 70, 450, 14);
		contentPane.add(lblPrimVez);
		
		
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
		
		
		
		JButton bAceptarAcceso = new JButton("Aceptar");
		bAceptarAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(proceso==0){		
					if(tclave.getText().equals("x") && !tclave.getText().equals("")) {
					
						
						consulta="SELECT * FROM empleados WHERE IDEmpleado="+tusuario.getText().toString();
						bd.Conexion();
						contiene=bd.seleccionar(consulta);
					
						try {	
							contiene.last();
					
							if(contiene.getRow()>0) {
						
								if(contiene.getString("Clave").equals("x")){
							
									id=Integer.parseInt(contiene.getString("IDEmpleado"));
									proceso=1;
									tusuario.setText(contiene.getString("Nombre"));
									tclave.setText("");
									JOptionPane.showMessageDialog(null, "Escriba su nueva clave (carácteres entre 6 y 10)");
									
							
								} else {
							
							
							
									JOptionPane.showMessageDialog(null, "Ya introdujo su clave. Si la olvido consulte con su administrador");
							
								}
						
						
							} else {
						
								JOptionPane.showMessageDialog(null, "No existe este ID ");
								tclave.setText("");
							}
					
					
						}catch(Exception e){
					
					
						}
				
					} else if (!tusuario.getText().equals("") && !tclave.getText().equals("")) {
						
						
						consulta="SELECT `IDEmpleado`, Puesto FROM `empleados` WHERE `Nombre`='"+tusuario.getText()+"' AND `Clave`='"+tclave.getText()+"'";
						bd.Conexion();
						contiene=bd.seleccionar(consulta);
						
						try {
							
							contiene.last();
							
							if(contiene.getRow()>0){
								
								
								if(contiene.getString("Puesto").equals("Administrador")) {
									
									
									VAdministrador va = new VAdministrador(bd);
									va.setVisible(true);
									JOptionPane.showMessageDialog(null, "Bienvenido señor administrador "+ tusuario.getText());
									
									dispose();
									
									
								} else {
									
									id=Integer.parseInt(contiene.getString("IDEmpleado"));
									V1Taquillero vt = new V1Taquillero(id, bd);
									vt.setVisible(true);
									JOptionPane.showMessageDialog(null, "Bienvenido señor Vendedor "+ tusuario.getText());
									dispose();
									
								}
								
														
								
							} else {
								
								JOptionPane.showMessageDialog(null, "El usuario no existe o la clave esta mal");
								
							} 
							
						}catch(Exception e) {}
						
						
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Debes completar los campos");
						
					}
					
				} else 	if(proceso==1){
					
					
					if(!tclave.getText().equals("")){
						
						if(tclave.getText().length()>5 && tclave.getText().length()<11) {
							
							consulta="SELECT `IDEmpleado` FROM `empleados` WHERE `Clave`='"+tclave.getText()+"'";
							contiene=bd.seleccionar(consulta);
							
							try {
								contiene.last();
								
								if(contiene.getRow()>0){
									
									JOptionPane.showMessageDialog(null, "Esa clave ya existe elija otra");
									
								}else {
									
									claveP=tclave.getText();
									tclave.setText("");
									JOptionPane.showMessageDialog(null, "Escriba de nuevo la clave");
									proceso=2;
								}
							} catch (Exception e){}
							
						} else {
							
							JOptionPane.showMessageDialog(null, "La clave debe de contener entre 6 y 10 carácteres ");
							
						}
											
						
						
					} else {
						
						JOptionPane.showMessageDialog(null, "No has escrito ninguna clave ");
						
					}
					
					
					
				} else if (proceso==2) {
					
					
					if(tclave.getText().equals(claveP)){
						
						consulta="UPDATE `empleados` SET `Clave`='"+claveP+"' WHERE `IDEmpleado`='"+id+"'";
						bd.insModEli(consulta);
						bd.desconexion();
						JOptionPane.showMessageDialog(null, "Su clave ha sido registrada en el sistema");
						proceso=0;
						
					} else {
						
						JOptionPane.showMessageDialog(null, "No se acuerda de la clave que acaba de escribir??");
						tclave.setText("");
					}
					
					
				}
				
				
							
			
				
			}
		});
		bAceptarAcceso.setBounds(224, 207, 89, 23);
		contentPane.add(bAceptarAcceso);
		
		JButton bCancelarAcceso = new JButton("Cancelar");
		bCancelarAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				proceso=0;
				tusuario.setText("");
				tclave.setText("");
				
			}
		});
		bCancelarAcceso.setBounds(323, 207, 89, 23);
		contentPane.add(bCancelarAcceso);
	}
}
