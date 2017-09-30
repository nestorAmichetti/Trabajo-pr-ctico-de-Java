package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	
	public void inicio(){}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
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
	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 707, 411);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		JMenuItem mntmAltaPersona = new JMenuItem("ABMC Persona");
		mntmAltaPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuPersonaClick();
			}
		});
		mnPersona.add(mntmAltaPersona);
		
		JMenuItem mnListado = new JMenuItem("Listado");
		mnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoPersonaClick();
			}
		});
		mnPersona.add(mnListado);
		
		JMenu mnElemento = new JMenu("Elemento");
		menuBar.add(mnElemento);
		
		JMenuItem mntmConsultaElemento = new JMenuItem("ABMC Elemento");
		mntmConsultaElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuElementoClick();
			}
		});
		mnElemento.add(mntmConsultaElemento);
		
		JMenu mnTipoElemento = new JMenu("Tipo Elemento");
		menuBar.add(mnTipoElemento);
		
		JMenuItem mntmConsultaTipoElemento = new JMenuItem("ABMC Tipo de Elemento");
		mntmConsultaTipoElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuTipoElementoClick();
			}
		});
		mnTipoElemento.add(mntmConsultaTipoElemento);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	protected void mnuElementoClick() {
		ABMCElementoDesktop e= new ABMCElementoDesktop();
		desktopPane.add(e);
		e.setVisible(true);
	}
	
	protected void mnuTipoElementoClick() {
		ABMCTipoElementoDesktop t= new ABMCTipoElementoDesktop();
		desktopPane.add(t);
		t.setVisible(true);
	}
	
	protected void mnuPersonaClick() {
		ABMCPersonaDesktop p= new ABMCPersonaDesktop();
		desktopPane.add(p);
		p.setVisible(true);
	}
	
	protected void mnuListadoPersonaClick() {
		ListadoPersonas lp= new ListadoPersonas();
		desktopPane.add(lp);
		lp.setVisible(true);
	}
	
	
}
