package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CtrlABMCElemento;
import controllers.CtrlABMCPersona;
import entity.Elemento;
import entity.Persona;
import util.AppDataException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Principal extends JInternalFrame {

	private JPanel contentPane;
	private JPasswordField txtClave;
	private JTextField txtUsuario;
	private CtrlABMCPersona ctrl;
	private JLabel lblLoguearse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionReservasDesktop JInternalFrame = new GestionReservasDesktop();
					JInternalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setClosable(true);
		ctrl=new CtrlABMCPersona();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtClave = new JPasswordField();
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					btnIngresarClicked();	
			}
		});
		
		lblLoguearse = new JLabel("Loguearse");
		lblLoguearse.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsuario)
									.addGap(40))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClave)
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnIngresar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtClave, Alignment.LEADING)
								.addComponent(txtUsuario, Alignment.LEADING)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(174)
							.addComponent(lblLoguearse)))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLoguearse)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblClave)
						.addComponent(txtClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnIngresar)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnIngresarClicked(){
		
		try {
			if(ctrl.validar(this.mapearDeJFrame())!=null)
			{
				JOptionPane.showMessageDialog(this, "Bienvenido");
				Principal p=new Principal();
				p.dispose();
				JFrame frame=new JFrame();
				frame.setVisible(true);
				
				
				
			} else{
				
				JOptionPane.showMessageDialog(this, "Error en ingreso");

			}
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	private Persona mapearDeJFrame() {
		Persona persona=new Persona();
		persona.setUsuario(this.txtUsuario.getText());
		persona.setClave(this.txtClave.getText());
		return persona;
	}
	
	private void mapearAJFrame(Persona p){
		
			this.txtUsuario.setText(p.getUsuario());
			this.txtClave.setText(p.getclave());
            
		}
	}

