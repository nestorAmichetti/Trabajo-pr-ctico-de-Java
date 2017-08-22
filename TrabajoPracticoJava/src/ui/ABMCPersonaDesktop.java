package ui;

import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import java.awt.EventQueue;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding;

import controllers.CtrlABMCPersona;
import entity.Categoria;
import entity.Persona;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class ABMCPersonaDesktop extends JInternalFrame {
//public class ABMCPersonaDesktop extends JFrame {
	
	private AutoBinding<Persona, Categoria, JComboBox, Object> cbo;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JPasswordField txtClave;
	private JTextField txtUsuario;
	private CtrlABMCPersona ctrl=new CtrlABMCPersona();
	private JTextField txtId;
	private JCheckBox chkHabilitado;
	private JLabel lblAltaPersonas;
	private JButton btnBaja;
	private JButton btnModifiacin;
	private JButton btnConsulta;
	private JComboBox cboCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaDesktop JinternalFrame = new ABMCPersonaDesktop();
					JinternalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ABMCPersonaDesktop() {
		setClosable(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		
		JLabel lblDni = new JLabel("DNI");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setSelected(true);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
					btnAltaClicked();
			}
		});
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		
		lblAltaPersonas = new JLabel("ABMC Personas");
		lblAltaPersonas.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		
		cboCategoria = new JComboBox();
		
		btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBajaClicked();
			}
		});
		
		btnModifiacin = new JButton("Modificaci\u00F3n");
		btnModifiacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModificacionClicked();
			}
		});
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultaClicked();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(lblAltaPersonas)
					.addGap(161))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(lblApellido)
						.addComponent(lblNombre)
						.addComponent(lblClave)
						.addComponent(lblCategora)
						.addComponent(lblDni))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAlta)
									.addGap(18)
									.addComponent(btnBaja)
									.addGap(18)
									.addComponent(btnModifiacin)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnConsulta))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtApellido, Alignment.LEADING)
										.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(cboCategoria, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtUsuario, Alignment.LEADING))
										.addComponent(txtNombre, Alignment.LEADING))
									.addGap(110)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblId)
											.addGap(18)
											.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(chkHabilitado))))
							.addGap(14))
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtClave, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtDni, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDni)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNombre)
										.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblId)
										.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblApellido)
										.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClave)
								.addComponent(txtClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAltaPersonas)
							.addGap(180)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategora)
						.addComponent(cboCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkHabilitado))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBaja)
						.addComponent(btnAlta)
						.addComponent(btnModifiacin)
						.addComponent(btnConsulta))
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
		loadLists();

	}
	
	private void loadLists() {
		try {
			this.cboCategoria.setModel(new DefaultComboBoxModel(this.ctrl.getCategorias().toArray()));
			this.cboCategoria.setSelectedIndex(-1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Categorias");
		}
	}	
	
	protected void btnAltaClicked(){
		Persona p = this.mapearDeJFrame();
		try {
			ctrl.add(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error en alta");
		}
		this.txtId.setText(String.valueOf(p.getId()));
		
	}
	
	protected void btnBajaClicked(){
		try{
			ctrl.delete(this.mapearDeJFrame());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error en baja");
		}
	}
	
	protected void btnModificacionClicked(){
		try{
			ctrl.update(this.mapearDeJFrame());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error en modificación");
		}
	}
	
	protected void btnConsultaClicked() {
		try {
			this.mapearAJFrame(ctrl.getByDni(this.mapearDeJFrame()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error en consulta");
		}
		
	}
	
	private void mapearAJFrame(Persona p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.chkHabilitado.setSelected(p.isHabilitado());
		this.txtId.setText(String.valueOf(p.getId()));
		if (p.getCategoria() !=null){
			this.cboCategoria.setSelectedItem(p.getCategoria());
		}
	}
	
	private Persona mapearDeJFrame(){
		Persona p=new Persona();
		if(!this.txtId.getText().isEmpty()){
			p.setId(Integer.parseInt(this.txtId.getText()));
		}
		p.setDni(this.txtDni.getText());
		p.setNombre(this.txtNombre.getText());
		p.setApellido(this.txtApellido.getText());
		p.setHabilitado(this.chkHabilitado.isSelected());
		if (cboCategoria.getSelectedIndex() != -1){
			p.setCategoria((Categoria)cboCategoria.getSelectedItem());
		}
		return p;
	}
	
	public void showPersona(Persona p){
		this.mapearAJFrame(p);
		
	}
}
