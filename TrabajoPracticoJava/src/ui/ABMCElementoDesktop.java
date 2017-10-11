package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CtrlABMCElemento;
import controllers.CtrlABMCTipoElemento;
import entity.TipoElemento;
import entity.Elemento;
import entity.NombreElemento;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ABMCElementoDesktop extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private CtrlABMCElemento ctrl;
	private JTextField txtId;
	private JComboBox cboElemento;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElementoDesktop JInternalFrame = new ABMCElementoDesktop();
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
	public ABMCElementoDesktop() {
		setClosable(true);
		ctrl=new CtrlABMCElemento();
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblModificarElementos = new JLabel("ABMC Elementos");
		lblModificarElementos.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		
		JButton btnModificar = new JButton("Modificaci\u00F3n");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					btnmodificacionClicked();
			}
		});
		
		cboElemento = new JComboBox();
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAltaClicked();
			}
		});
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBajaClicked();
			}
		});
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultaClicked();
			}
		});
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(153)
					.addComponent(lblModificarElementos)
					.addContainerGap(153, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAlta)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(lblNombre)
								.addComponent(lblTipoElemento))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(btnBaja, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtId, 0, 0, Short.MAX_VALUE)
								.addComponent(txtNombre, 0, 0, Short.MAX_VALUE)
								.addComponent(cboElemento, 0, 78, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(btnModificar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnConsulta)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModificarElementos)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoElemento))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar)
						.addComponent(btnBaja)
						.addComponent(btnAlta)
						.addComponent(btnConsulta))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		loadLists();
	}
	
	private void loadLists() {
		try {
			this.cboElemento.setModel(new DefaultComboBoxModel(this.ctrl.getNombreE().toArray()));
			this.cboElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Elemento");
		}
	}	
	
	protected void btnAltaClicked() {
		Elemento e = this.mapearDeJFrame();
		try {
			ctrl.add(e);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Error en alta");
			
		}
		this.txtId.setText(String.valueOf(e.getId()));
		
	}
	
	protected void btnBajaClicked(){
		try{
		ctrl.delete(this.mapearDeJFrame());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Error en baja");
		}
	}
	
	protected void btnmodificacionClicked(){
		try {
			ctrl.update(this.mapearDeJFrame());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error en modficación");
		}
	}
	
	protected void btnConsultaClicked() {
		try {
			this.mapearAJFrame(ctrl.getByNombre(this.mapearDeJFrame()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error en consulta");
		}
	}
	
	private Elemento mapearDeJFrame() {
		Elemento e=new Elemento();
		if(!this.txtId.getText().isEmpty()){
			e.setId(Integer.parseInt(this.txtId.getText()));
		}
		e.setNombre(this.txtNombre.getText()); 
		if (cboElemento.getSelectedIndex() != -1){
			e.setElemento((NombreElemento)cboElemento.getSelectedItem());
		}
		return e;
	}
	
	private void mapearAJFrame(Elemento e) {
		this.txtId.setText(String.valueOf(e.getId()));
		this.txtNombre.setText(e.getNombre());
		if (e.getElemento() !=null){
			this.cboElemento.setSelectedItem(e.getElemento());
		}
	}
}
