package ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.ManejadorTabla;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;

public class DateTimeExample extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaHora;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateTimeExample frame = new DateTimeExample();
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
	public DateTimeExample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora");
		
		txtFechaHora = new JTextField();
		txtFechaHora.setColumns(10);
		
		JButton btnConvertirJunto = new JButton("Convertir junto");
		btnConvertirJunto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnConvertirJuntoClicked();
			}
		});
		
		JLabel lblFormatoDeFechahora = new JLabel("Formato de fechaHora dd/MM/yyyy HH:mm");
		
		JLabel lblPeroPuedeCambiarse = new JLabel("pero puede cambiarse en el código con SimpleDateFormat");
		
		JLabel label = new JLabel("Fecha y hora");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFormatoDeFechahora)
						.addComponent(lblPeroPuedeCambiarse)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblFechaYHora)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFechaHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnConvertirJunto))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(146)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(167, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConvertirJunto)
						.addComponent(txtFechaHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaYHora))
					.addGap(18)
					.addComponent(lblFormatoDeFechahora)
					.addGap(26)
					.addComponent(lblPeroPuedeCambiarse)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnConvertirJuntoClicked() {
		ManejadorTabla mt=new ManejadorTabla();
		
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			java.util.Date fechaHora=f.parse(this.txtFechaHora.getText());
			mt.guardarJunto(fechaHora);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}