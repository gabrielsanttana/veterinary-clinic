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

public class RegistryConsult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDate;
	private JTextField txtHistoric;
	private JButton btnSalvar;
	
	/**
	 * Create the frame.
	 */
	public RegistryConsult() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 220);
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
		
		JLabel lbl3 = new JLabel("Tratamento");
		lbl3.setBounds(10, 74, 56, 14);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("Veterinary");
		lbl4.setBounds(10, 105, 56, 14);
		contentPane.add(lbl4);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.addConsult(txtDate,txtHistoric.getText(),null,null);
						
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		
		btnSalvar.setBounds(10, 150, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(140, 150, 89, 23);
		contentPane.add(btnCancelar);
	}
	
}
