package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewClient = new JButton("Novo Cliente");
		btnNewClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistryClientFrame frame = new RegistryClientFrame();
				frame.disableBtnAnimal();
				frame.setVisible(true);
			}
		});
		btnNewClient.setBounds(30, 33, 131, 39);
		contentPane.add(btnNewClient);
		
		JButton btnNewVet = new JButton("Novo Veterinario");
		btnNewVet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistryVetFrame frame = new RegistryVetFrame();
				frame.setVisible(true);
			}
		});
		btnNewVet.setBounds(30, 83, 131, 39);
		contentPane.add(btnNewVet);
		
		JButton btnFindClient = new JButton("Procurar Cliente");
		btnFindClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientList frame = new ClientList();
				frame.setVisible(true);
			}
		});
		btnFindClient.setBounds(171, 56, 131, 39);
		contentPane.add(btnFindClient);


	}
}
