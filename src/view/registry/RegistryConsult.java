package view.registry;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
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
import model.Treatment;
import model.Veterinary;
import view.comboBoxModel.VeterinaryComboBoxModel;

public class RegistryConsult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDate;
	private JTextField txtHistoric;
	private JButton btnSalvar;
	private JComboBox<Veterinary> comboBoxVet;
	private List<Veterinary> listVeterinary;
	
	/**
	 * Create the frame.
	 */
	public RegistryConsult(Treatment treat) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDate = new JTextField();
		txtDate.setBounds(66, 11, 162, 20);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdress = new JLabel("Historico");
		lblAdress.setBounds(10, 46, 46, 14);
		contentPane.add(lblAdress);
		
		txtHistoric = new JTextField();
		txtHistoric.setColumns(10);
		txtHistoric.setBounds(66, 42, 162, 20);
		contentPane.add(txtHistoric);
		
		comboBoxVet = new JComboBox<Veterinary>();
		comboBoxVet.setBounds(66, 77, 163, 22);
		listVeterinary = Controller.getAllVeterinary();
		VeterinaryComboBoxModel model = new VeterinaryComboBoxModel(listVeterinary);
		comboBoxVet.setModel(model);		
		contentPane.add(comboBoxVet);
		
		JLabel lbl4 = new JLabel("Veterinary");
		lbl4.setBounds(10, 81, 56, 14);
		contentPane.add(lbl4);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO txtDate to Date
				Date date = null;
				Veterinary vet = (Veterinary)comboBoxVet.getSelectedItem();
				Controller.addConsult(date, txtHistoric.getText(), treat.getId(), vet.getId());		
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnSalvar.setBounds(10, 117, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(140, 117, 89, 23);
		contentPane.add(btnCancelar);
	}
}
