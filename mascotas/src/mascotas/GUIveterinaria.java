package mascotas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;



import javax.swing.JToolBar;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ItemEvent;

public class GUIveterinaria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreA;
	private JTextField textEdad;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JTextField textTelefono;
	private JTextField textNombreVet;
	private TreeSet<cita> listado = new TreeSet<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIveterinaria frame = new GUIveterinaria();
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
	public GUIveterinaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(124, 238, 77, 24);
		contentPane.add(spinner);
		SpinnerDateModel modeloFecha = new SpinnerDateModel();
		spinner.setModel(modeloFecha);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(UIManager.getColor("Button.shadow"));
		toolBar.setBounds(0, 10, 639, 24);
		contentPane.add(toolBar);
		JComboBox comboBoxraza = new JComboBox();
		comboBoxraza.setBounds(71, 170, 96, 29);
		contentPane.add(comboBoxraza);
		
		JComboBox comboBoxespecie = new JComboBox();
		comboBoxespecie.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String seleccion = (String) comboBoxespecie.getSelectedItem();
				comboBoxraza.removeAllItems();
				if(seleccion.equals("Perro")){
					comboBoxraza.addItem("Golden Retriver");
					comboBoxraza.addItem("Pastor Alemán");
					comboBoxraza.addItem("Bulldog Francés");
					comboBoxraza.addItem("Chihuahua");
				}
				if(seleccion.equals("Gato")){
					comboBoxraza.addItem("Siamés");
					comboBoxraza.addItem("Maine Coon");
					comboBoxraza.addItem("Persa");
					comboBoxraza.addItem("Sphynx");
				}
				if(seleccion.equals("Serpiente")){
					comboBoxraza.addItem("Pitón Real");
					comboBoxraza.addItem("Falsa Coral");
					comboBoxraza.addItem("Boa Constrictor");
					comboBoxraza.addItem("Serpiente del Maíz");
				}
				if(seleccion.equals("Perico")){
					comboBoxraza.addItem("Australiano");
					comboBoxraza.addItem("Monje");
					comboBoxraza.addItem("Frente Naranja");
					comboBoxraza.addItem("Gargantiblanca");
				}
				if(seleccion.equals("Pez")){
					comboBoxraza.addItem("Betta");
					comboBoxraza.addItem("Guppy");
					comboBoxraza.addItem("Ángel");
					comboBoxraza.addItem("Goldfish");
				}

			}
		});
		comboBoxespecie.setBounds(71, 132, 96, 29);
		contentPane.add(comboBoxespecie);
		comboBoxespecie.addItem("Perro");
		comboBoxespecie.addItem("Gato");
		comboBoxespecie.addItem("Pez");
		comboBoxespecie.addItem("Serpiente");
		comboBoxespecie.addItem("Perico");
		
		JButton btnLlenar = new JButton("Llnear Formulario");
		btnLlenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dueño dueño1 = new dueño(textNombre.getText(),textApellido.getText(),textCorreo.getText(),textTelefono.getText());
				String especie = (String) comboBoxespecie.getSelectedItem();
				String raza = (String) comboBoxraza.getSelectedItem();
				animal animal1 = new animal(textNombreA.getText(),Integer.parseInt(textEdad.getText()),especie,raza);
				java.util.Date fechaUtil = (java.util.Date) spinner.getValue();
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				String textoFecha = formato.format(fechaUtil);
				LocalDate fechaCita = LocalDate.parse(textoFecha);
				cita cita1 = new cita(fechaCita,textNombreVet.getText(),animal1,dueño1,"");
				listado.add(cita1);
				JOptionPane.showMessageDialog(null, "Formulario Llenado, solo Falta"+"que el doctor llene las observaciones");
				
			}
		});
		toolBar.add(btnLlenar);
		
		JButton btnObservaciones = new JButton("Observaciones ");
		btnObservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(btnObservaciones);
		
		JButton btnverCitas = new JButton("Ver Citas");
		toolBar.add(btnverCitas);
		
		textNombreA = new JTextField();
		textNombreA.setBounds(71, 75, 96, 18);
		contentPane.add(textNombreA);
		textNombreA.setColumns(10);
		
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(71, 108, 96, 18);
		contentPane.add(textEdad);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 78, 44, 12);
		contentPane.add(lblNewLabel);
		

		
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 111, 44, 12);
		contentPane.add(lblEdad);
		
		JLabel lblNewLabel_1_1 = new JLabel("Especie");
		lblNewLabel_1_1.setBounds(10, 140, 44, 12);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Raza");
		lblNewLabel_1_1_1.setBounds(10, 178, 44, 12);
		contentPane.add(lblNewLabel_1_1_1);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(244, 75, 96, 18);
		contentPane.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(244, 108, 96, 18);
		contentPane.add(textApellido);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(244, 137, 96, 18);
		contentPane.add(textCorreo);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(244, 172, 96, 18);
		contentPane.add(textTelefono);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(190, 78, 44, 12);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(190, 111, 44, 12);
		contentPane.add(lblApellido);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setBounds(190, 140, 44, 12);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(190, 178, 44, 12);
		contentPane.add(lblTelefono);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(391, 72, 238, 144);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Animal");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(71, 44, 109, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Dueño");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(244, 44, 109, 21);
		contentPane.add(lblNewLabel_2_1);
		
		
        
        JLabel lblNewLabel_3 = new JLabel("Fecha");
        lblNewLabel_3.setBounds(48, 243, 44, 12);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2_2 = new JLabel("Datos de Cita");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2_2.setBounds(92, 207, 109, 21);
        contentPane.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_2_1 = new JLabel("Observaciones");
        lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2_2_1.setBounds(455, 44, 109, 21);
        contentPane.add(lblNewLabel_2_2_1);
        
        JLabel lblNewLabel_3_1 = new JLabel("Nombre Del Veterinario");
        lblNewLabel_3_1.setBounds(10, 270, 82, 12);
        contentPane.add(lblNewLabel_3_1);
        
        textNombreVet = new JTextField();
        textNombreVet.setColumns(10);
        textNombreVet.setBounds(118, 267, 96, 18);
        contentPane.add(textNombreVet);
		

	}
}
