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

public class RegistrySpecie extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNameSpecie;
	
	/**
	 * Create the frame.
	 */
	public RegistrySpecie() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNameSpecie = new JTextField();
		txtNameSpecie.setBounds(10, 39, 219, 20);
		contentPane.add(txtNameSpecie);
		txtNameSpecie.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome Especie");
		lblNewLabel.setBounds(10, 14, 162, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.addSpecies(txtNameSpecie.getText());
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnSalvar.setBounds(10, 73, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(140, 73, 89, 23);
		contentPane.add(btnCancelar);
	}

}
