package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CtrlABMCTipoElemento;
import entity.NombreTipoElemento;
import entity.Persona;
import entity.TipoElemento;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ABMCTipoElementoDesktop extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtCantMax;
	private JComboBox cboNombre;
	private CtrlABMCTipoElemento ctrl;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCTipoElementoDesktop JInternalFrame = new ABMCTipoElementoDesktop();
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
	public ABMCTipoElementoDesktop() {
		setClosable(true);
		ctrl=new CtrlABMCTipoElemento();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAltaTipoElemento = new JLabel("ABMC Tipo Elemento");
		lblAltaTipoElemento.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblCantidadMximaDe = new JLabel("Cantidad m\u00E1xima de reservas");
		
		JLabel lblId = new JLabel("Id");
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					btnAltaClicked();
			}
		});
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtCantMax = new JTextField();
		txtCantMax.setColumns(10);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBajaClicked();
			}
		});
		
		JButton btnModificacin = new JButton("Modificaci\u00F3n");
		btnModificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModificacionClicked();
			}
		});
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultaClicked();
			}
		});
		
		cboNombre = new JComboBox();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addComponent(lblAltaTipoElemento)
					.addContainerGap(143, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAlta)
							.addGap(18)
							.addComponent(btnBaja)
							.addGap(18)
							.addComponent(btnModificacin)
							.addGap(18)
							.addComponent(btnConsulta)
							.addGap(38))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCantidadMximaDe)
									.addGap(18)
									.addComponent(txtCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId)
										.addComponent(lblNombre))
									.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cboNombre, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtId, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(129, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAltaTipoElemento)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(cboNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadMximaDe)
						.addComponent(txtCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlta)
						.addComponent(btnBaja)
						.addComponent(btnModificacin)
						.addComponent(btnConsulta))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
		loadLists();
	}
	
	private void loadLists() {
		try {
			this.cboNombre.setModel(new DefaultComboBoxModel(this.ctrl.getNombreTipoE().toArray()));
			this.cboNombre.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Tipo de Elemento");
		}
	}
	
	protected void btnAltaClicked(){
		TipoElemento tipo = this.mapearDeJFrame();
		try {
			ctrl.add(tipo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Error en alta");
		}
		this.txtId.setText(String.valueOf(tipo.getId()));
		
	}
	
	protected void btnBajaClicked(){			
		try{
		ctrl.delete(this.mapearDeJFrame());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Error en baja");
		}
	}
	
	protected void btnModificacionClicked(){
		try {
			ctrl.update(this.mapearDeJFrame());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Error en modificación");
		}
	}
	
	protected void btnConsultaClicked() {
		try{
			this.mapearAJFrame(ctrl.getByNombre(this.mapearDeJFrame()));
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Error en consulta");
		}
		
	}
	
	private void mapearAJFrame(TipoElemento e){
		this.txtCantMax.setText(String.valueOf(e.getCantMaxReservas()));	
		this.txtId.setText(String.valueOf(e.getId()));
		if (e.getTipoElemenento() !=null){
			this.cboNombre.setSelectedItem(e.getTipoElemenento());
		}
	}
	
	private TipoElemento mapearDeJFrame(){
		TipoElemento t=new TipoElemento();
		if(!this.txtId.getText().isEmpty()){
			t.setId(Integer.parseInt(this.txtId.getText()));
		}
		if (cboNombre.getSelectedIndex() != -1){
			t.setTipoElemenento((NombreTipoElemento)cboNombre.getSelectedItem());

		}
		return t;
	}
	
	public void showPersona(TipoElemento e){
		this.mapearAJFrame(e);
		
	}

}
