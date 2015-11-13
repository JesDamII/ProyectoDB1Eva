package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class DetalleCompras extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumCliente;
	private JTextField txtNomClient;
	private JTextField txtNombreArticulo;
	private JTextField txtUnidadesArticulo;
	private JTextField txtPrecioArticulo;
	private JTextField txtStockArticulo;
	private JTextField txtImporteCompra;
	private JButton btnInsertar;
	private JButton btnConsultar;
	private JButton btnSalir;
	private JComboBox cbxNumCompra;
	private JComboBox cbxCodArti;
	private JButton btnClear;
	private JTextArea textArea;

	

	/**
	 * Create the dialog.
	 */
	public DetalleCompras(Frame parent,boolean modal) {
		super(parent,modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetalleCompras.class.getResource("/recursos/iconoDam.png")));
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Detalle Compras");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 574);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.SOUTH);
		
		cbxNumCompra = new JComboBox();
		cbxNumCompra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("N\u00BA de Compra\r\n");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblArtculo = new JLabel("Art\u00EDculo");
		lblArtculo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		cbxCodArti = new JComboBox();
		cbxCodArti.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSalir.addActionListener(this);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cliente");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblNDeCliente = new JLabel("N\u00BA de Cliente");
		lblNDeCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNumCliente = new JTextField();
		txtNumCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNumCliente.setColumns(10);
		
		txtNomClient = new JTextField();
		txtNomClient.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNomClient.setColumns(10);
		
		JLabel lblNombreArtculo = new JLabel("Nombre Art\u00EDculo");
		lblNombreArtculo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNombreArticulo = new JTextField();
		txtNombreArticulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNombreArticulo.setColumns(10);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtUnidadesArticulo = new JTextField();
		txtUnidadesArticulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtUnidadesArticulo.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtPrecioArticulo = new JTextField();
		txtPrecioArticulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtPrecioArticulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Stock\r\n");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtStockArticulo = new JTextField();
		txtStockArticulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtStockArticulo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Importe\r\n");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtImporteCompra = new JTextField();
		txtImporteCompra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtImporteCompra.setColumns(10);
		
		btnClear = new JButton("Limpiar pantalla");
		btnClear.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnClear.addActionListener(this);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxCodArti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxNumCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(lblArtculo))
							.addGap(28)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNumCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNDeCliente)
								.addComponent(txtNombreArticulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombreArtculo))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtUnidadesArticulo, 0, 0, Short.MAX_VALUE)
											.addComponent(lblUnidades))
										.addGap(31)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtPrecioArticulo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblPrecio))
										.addGap(26)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtStockArticulo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_2))
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtImporteCompra, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_3)))
									.addComponent(txtNomClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(55))))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(111)
					.addComponent(btnInsertar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnClear)
					.addGap(125))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNDeCliente)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxNumCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArtculo)
						.addComponent(lblNombreArtculo)
						.addComponent(lblUnidades)
						.addComponent(lblPrecio)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxCodArti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombreArticulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUnidadesArticulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrecioArticulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStockArticulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtImporteCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInsertar)
						.addComponent(btnConsultar)
						.addComponent(btnSalir)
						.addComponent(btnClear))
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 11));
		scrollPane.setViewportView(textArea);
		contentPanel.setLayout(gl_contentPanel);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento=e.getSource();
		
		if(evento==btnClear){
			textArea.setText("");
		}
		else if (evento==btnConsultar) {
			
		}
		else if(evento==btnInsertar){
			
		}
		else if(evento==btnSalir){
			DetalleCompras dtc=new DetalleCompras(null, false);
			dtc.setVisible(false);
			dispose();
		}
		else if(evento==cbxCodArti){
			
		}	
		else if(evento==cbxNumCompra){
			
		}	
	}
}
