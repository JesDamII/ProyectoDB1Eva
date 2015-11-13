package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.Image;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnGestionCompra;
	private JButton btnDetalleCompras;
	private JButton btnCrearNeo;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/recursos/dam-1.png")));
		setResizable(false);
		setTitle("Ejercicio 1Eva A.D.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		setContentPane(contentPane);
		
		btnGestionCompra = new JButton("Gesti\u00F3n Compra");
		btnGestionCompra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnGestionCompra.addActionListener(this);
		
		btnDetalleCompras= new JButton("Detalle Compra");
		btnDetalleCompras.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnDetalleCompras.addActionListener(this);
		
		btnCrearNeo = new JButton("Crear ODB Neodatis");
		btnCrearNeo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnCrearNeo.addActionListener(this);
		
		btnExit = new JButton("Salir");
		btnExit.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnExit.addActionListener(this);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCrearNeo, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addComponent(btnDetalleCompras, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addComponent(btnGestionCompra, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(btnGestionCompra)
					.addGap(51)
					.addComponent(btnDetalleCompras)
					.addGap(49)
					.addComponent(btnCrearNeo)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addGap(32))
		);
		setLocationRelativeTo(null);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento=e.getSource();
		
		if (evento==btnGestionCompra) {
			GestionCompras gtc=new GestionCompras(this,true);
			gtc.setVisible(true);
		}
		else if(evento==btnDetalleCompras){
			DetalleCompras dtc=new DetalleCompras(this,true);
			dtc.setVisible(true);
		}
		else if(evento==btnCrearNeo){
			CrearBDNeodatis bdn=new CrearBDNeodatis(this,true);
			bdn.setVisible(true);
		}
		else if(evento==btnExit){
			System.exit(0);
		}
		
	}

}
