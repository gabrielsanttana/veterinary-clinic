package view.registry;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Consult;

public class RegistryExam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSalvar;
	
	/**
	 * Create the frame.
	 */
	public RegistryExam(Consult consult) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descricao do Exame");
		lblNewLabel.setBounds(10, 14, 219, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea txtAreaExam = new JTextArea();
		txtAreaExam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAreaExam.setLineWrap(true);
		txtAreaExam.setBounds(10, 39, 219, 100);
		contentPane.add(txtAreaExam);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 150, 89, 23);
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.addExam(txtAreaExam.getText(), consult.getId());		
				JOptionPane.showMessageDialog(null, "Success", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
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
