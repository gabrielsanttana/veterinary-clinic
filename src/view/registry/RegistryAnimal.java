package view.registry;

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

public class RegistryAnimal extends JFrame {

	private static final long serialVersionUID = 1L;

	private Client client;	
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtSex;
	
	/**
	 * Create the frame.
	 */
	public RegistryAnimal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 181);
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
		
		JLabel lblAdress = new JLabel("Idade");
		lblAdress.setBounds(10, 46, 46, 14);
		contentPane.add(lblAdress);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(66, 42, 162, 20);
		contentPane.add(txtAge);
		
		txtSex = new JTextField();
		txtSex.setColumns(10);
		txtSex.setBounds(66, 71, 162, 20);
		contentPane.add(txtSex);
		
		JLabel lblPhone = new JLabel("Sex");
		lblPhone.setBounds(10, 74, 46, 14);
		contentPane.add(lblPhone);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.addAnimal(txtName.getText(), Integer.parseInt(txtAge.getText()),
						txtSex.getText(), client.getId());
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnSalvar.setBounds(10, 102, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(139, 102, 89, 23);
		contentPane.add(btnCancelar);
	}

	public void SetClient(Client client) 
	{
		this.client = client;
	}
}
