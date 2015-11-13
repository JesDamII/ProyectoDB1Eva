package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CrearBDNeodatis extends JDialog implements ActionListener{
	private JButton btnSalir;
	private JButton btCrearNeodatis;
	private JButton btnLimpiarPantalla;
	private JTextArea textArea;

	

	/**
	 * Create the dialog.
	 */
	public CrearBDNeodatis(Frame parent,boolean modal) {
		super(parent,modal);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Pasar a Neodatis");
		getContentPane().setBackground(new Color(175, 238, 238));
		setBounds(100, 100, 601, 504);
		
		btCrearNeodatis = new JButton("Crear DBO Neodatis");
		btCrearNeodatis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCrearNeodatis.addActionListener(this);
		JScrollPane scrollPane = new JScrollPane();
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.addActionListener(this);
		
		btnLimpiarPantalla = new JButton("Limpiar pantalla");
		btnLimpiarPantalla.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnLimpiarPantalla.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLimpiarPantalla))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(221)
							.addComponent(btCrearNeodatis)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(btCrearNeodatis)
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir)
						.addComponent(btnLimpiarPantalla))
					.addGap(14))
		);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 11));
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento=e.getSource();
		
		if(evento==btCrearNeodatis){
			
		}
		else if(evento==btnLimpiarPantalla){
			textArea.setText("");
		}
		else if(evento==btnSalir){
			CrearBDNeodatis cbn=new CrearBDNeodatis(null, false);
			cbn.setVisible(false);
			dispose();
		}
		
	}
}
