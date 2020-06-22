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
import model.Animal;
import javax.swing.JFormattedTextField;

public class RegistryTreatment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtStartDate;
	private JTextField txtEndDate;
	private JButton btnSalvar;
	
	/**
	 * Create the frame.
	 */
	public RegistryTreatment(Animal animal) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtStartDate = new JTextField();
		txtStartDate.setBounds(10, 33, 162, 20);
		contentPane.add(txtStartDate);
		txtStartDate.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setBounds(10, 14, 162, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("End Date");
		lblNewLabel2.setBounds(10, 64, 46, 14);
		contentPane.add(lblNewLabel2);
		
		txtEndDate = new JTextField();
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(10, 89, 162, 20);
		contentPane.add(txtEndDate);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.addTreatment(txtStartDate, txtEndDate, animal.getId());
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnSalvar.setBounds(10, 120, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(140, 120, 89, 23);
		contentPane.add(btnCancelar);
	}
}
