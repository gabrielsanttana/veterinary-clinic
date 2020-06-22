package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.registry.RegistryClient;
import view.registry.RegistryVet;
import view.show.ShowClient;
import view.show.ShowVeterinary;

public final class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewClient = new JButton("Novo Cliente");
		btnNewClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistryClient frame = new RegistryClient();
				frame.setVisible(true);
			}
		});
		btnNewClient.setBounds(180, 11, 160, 40);
		contentPane.add(btnNewClient);
		
		JButton btnShowClients = new JButton("Show Clientes");
		btnShowClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowClient frame = new ShowClient();
				frame.setVisible(true);
			}
		});
		btnShowClients.setBounds(180, 85, 160, 40);
		contentPane.add(btnShowClients);
		
		JButton btnNewVet = new JButton("Novo Veterinario");
		btnNewVet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistryVet frame = new RegistryVet();
				frame.setVisible(true);
			}
		});
		btnNewVet.setBounds(10, 11, 160, 40);
		contentPane.add(btnNewVet);
		
		JButton btnShowVets = new JButton("Mostrar Veterinarios");
		btnShowVets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowVeterinary frame = new ShowVeterinary();
				frame.setVisible(true);
			}
		});
		btnShowVets.setBounds(10, 85, 160, 40);
		contentPane.add(btnShowVets);


	}
}
