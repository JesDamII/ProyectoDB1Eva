package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.DBProyecto1Eva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GestionCompras extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumCompra;
	private JTextField txtNombreCliente;
	private JTextField txtFechaCompraDia;
	private JButton btnAltas;
	private JButton btnBajas;
	private JButton btnModificar;
	private JButton btnVolver;
	private JButton btnVerificarCompra;
	private JButton btnLimpiarPantalla;
	private JComboBox cbxCliente;
	private JTextArea textArea;
	private JTextField txtFechaCompraMes;
	private JTextField txtFechaCompraAnio;
	private JButton btnVisualizarCompra;


	/**
	 * Create the dialog.
	 */
	public GestionCompras(Frame parent,boolean modal) {
		super(parent,modal);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Gesti\u00F3n de Compras\r\n");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 619);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(175, 238, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
		lblCodigoCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Nombre de Cliente\r\n");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtNumCompra = new JTextField();
		txtNumCompra.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumCompra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNumCompra.setColumns(10);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setEditable(false);
		
		JLabel lblNCompra = new JLabel("N\u00BA Compra");
		lblNCompra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblFechaDeCompra = new JLabel("Fecha de compra");
		lblFechaDeCompra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		String clientes[]=DBProyecto1Eva.listarClientes();
		DefaultComboBoxModel modeloCb=new DefaultComboBoxModel<>(clientes);
		cbxCliente = new JComboBox(modeloCb);
		cbxCliente.addActionListener(this);
		
		txtFechaCompraDia = new JTextField();
		txtFechaCompraDia.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFechaCompraDia.setFont(new Font("Serif", Font.PLAIN, 14));
		txtFechaCompraDia.setColumns(10);
		
		btnVerificarCompra = new JButton("Verificar Compra");
		btnVerificarCompra.setFont(new Font("Serif", Font.PLAIN, 14));
		btnVerificarCompra.addActionListener(this);
		
		btnLimpiarPantalla = new JButton("Limpiar Pantalla");
		btnLimpiarPantalla.setFont(new Font("Serif", Font.PLAIN, 14));
		btnLimpiarPantalla.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAltas = new JButton("Altas\r\n");
		btnAltas.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAltas.addActionListener(this);
		
		btnBajas = new JButton("Bajas");
		btnBajas.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnBajas.addActionListener(this);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnModificar.addActionListener(this);
		
		btnVolver = new JButton("Salir\r\n");
		btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnVolver.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		txtFechaCompraMes = new JTextField();
		txtFechaCompraMes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFechaCompraMes.setFont(new Font("Serif", Font.PLAIN, 14));
		txtFechaCompraMes.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("SansSerif", Font.PLAIN, 18));
		
		txtFechaCompraAnio = new JTextField();
		txtFechaCompraAnio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFechaCompraAnio.setFont(new Font("Serif", Font.PLAIN, 14));
		txtFechaCompraAnio.setColumns(10);
		
		btnVisualizarCompra = new JButton("Visualizar Compra");
		btnVisualizarCompra.setFont(new Font("Serif", Font.PLAIN, 14));
		btnVisualizarCompra.addActionListener(this);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodigoCliente)
								.addComponent(lblNCompra)
								.addComponent(cbxCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtNumCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(49)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeCompra)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtFechaCompraDia, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFechaCompraMes, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFechaCompraAnio, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnVisualizarCompra, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
						.addComponent(btnLimpiarPantalla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVerificarCompra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(109, Short.MAX_VALUE)
					.addComponent(btnAltas)
					.addGap(18)
					.addComponent(btnBajas)
					.addGap(18)
					.addComponent(btnModificar)
					.addGap(18)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(94))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoCliente)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVerificarCompra))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNCompra)
								.addComponent(lblFechaDeCompra)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnVisualizarCompra, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFechaCompraDia, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtFechaCompraMes, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFechaCompraAnio, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpiarPantalla, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumCompra))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAltas)
						.addComponent(btnBajas)
						.addComponent(btnModificar)
						.addComponent(btnVolver))
					.addGap(52))
		);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);
		contentPanel.setLayout(gl_contentPanel);
	}

//	----------EVENTOS:
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento=e.getSource();
		
		if (evento==cbxCliente) {
			String nombre;
			String codigo=cbxCliente.getSelectedItem().toString();
			nombre=DBProyecto1Eva.enlazarNombreCliente(codigo);
			txtNombreCliente.setText(nombre);
		}
		if (evento==btnAltas) {
			String fecha="";
			fecha=String.format("%s:%s:%s", txtFechaCompraDia.getText(),txtFechaCompraMes.getText(),txtFechaCompraAnio.getText());
			int numcompra=Integer.parseInt(txtNumCompra.getText());
			int codCli=Integer.parseInt(cbxCliente.getSelectedItem().toString());
			
			DBProyecto1Eva.AltaCompras(numcompra, codCli, fecha);
		}
		else if(evento==btnBajas){}
		else if(evento==btnLimpiarPantalla){
			textArea.setText("");
		}
		else if(evento==btnModificar){
			
		}
		else if(evento==btnVerificarCompra){
			
		}
		else if(evento==btnVisualizarCompra){
			textArea.setText(DBProyecto1Eva.sentenciaGestionCompras());
		}
		else if(evento==btnVolver){
			GestionCompras gtc=new GestionCompras(null, false);
			gtc.setVisible(false);
			dispose();
		}
		
	}
}
