package view.registry;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Client;
import model.Species;
import view.comboBoxModel.SpeciesComboBoxModel;

public class RegistryAnimal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtSex;
	List<Species> listSpecies;
	
	/**
	 * Create the frame.
	 */
	public RegistryAnimal(Client client) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 230);
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
		
		JLabel lblSpecie = new JLabel("Specie");
		lblSpecie.setBounds(10, 117, 56, 14);
		contentPane.add(lblSpecie);
		
		JComboBox<Species> comboBoxSpecie = new JComboBox<Species>();
		comboBoxSpecie.setBounds(66, 113, 163, 22);
		listSpecies = Controller.getAllSpecies();
		SpeciesComboBoxModel model = new SpeciesComboBoxModel(listSpecies);
		comboBoxSpecie.setModel(model);
		contentPane.add(comboBoxSpecie);
		
		JLabel lblPhone = new JLabel("Sex");
		lblPhone.setBounds(10, 74, 46, 14);
		contentPane.add(lblPhone);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.addAnimal(txtName.getText(), Integer.parseInt(txtAge.getText()), txtSex.getText(), 
						((Species)comboBoxSpecie.getSelectedItem()).getId(),client.getId());
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnSalvar.setBounds(10, 157, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(139, 157, 89, 23);
		contentPane.add(btnCancelar);
			
	}
}
