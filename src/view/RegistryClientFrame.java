package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Client;

public class RegistryClientFrame extends JFrame {

	
	private Client currentClient;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtCep;
	private JTextField txtEmail;
	private JButton btnSalvar;
	private JButton btnAnimais;
	
	/**
	 * Create the frame.
	 */
	public RegistryClientFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(66, 11, 162, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setBounds(10, 46, 46, 14);
		contentPane.add(lblAdress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(66, 42, 162, 20);
		contentPane.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(66, 71, 162, 20);
		contentPane.add(txtPhone);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(10, 74, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblCep = new JLabel("cep");
		lblCep.setBounds(10, 106, 46, 14);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(66, 102, 162, 20);
		contentPane.add(txtCep);
		
		JLabel lblAdress_1_1 = new JLabel("email");
		lblAdress_1_1.setBounds(10, 135, 46, 14);
		contentPane.add(lblAdress_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(66, 131, 162, 20);
		contentPane.add(txtEmail);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.addCliente(txtName.getText(), txtAddress.getText(),
						txtPhone.getText(), txtCep.getText(), txtEmail.getText());
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnSalvar.setBounds(10, 210, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(139, 210, 89, 23);
		contentPane.add(btnCancelar);
		
		btnAnimais = new JButton("Animais");
		btnAnimais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnimalList frame = new AnimalList();
				frame.SetClient(currentClient);				
				frame.setVisible(true);
				dispose();
			}
		});
		btnAnimais.setBounds(66, 167, 162, 23);
		contentPane.add(btnAnimais);
	}
	
	public void SetClient(Client c) 
	{
		btnSalvar.setEnabled(false);
		txtName.setText(c.getName());
		txtAddress.setText(c.getAddress());
		txtPhone.setText(c.getPhone());
		txtCep.setText(c.getCep());
		txtEmail.setText(c.getEmail());
		
		c.setAnimals(Controller.getAnimalsByClient(c.getId()));
		
		currentClient = c;
		
		btnSalvar.setVisible(false);
	}

	public void disableBtnAnimal() {
		btnAnimais.setVisible(false);
	}
	
}
