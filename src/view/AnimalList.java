package view;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import controller.Controller;
import model.Animal;
import model.Client;
import view.tableModel.*;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AnimalList extends JFrame {

	
	private Client client;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private AnimalTableModel model;
    private List<Animal> listAnimal;

    
    public void SetClient(Client c) 
    {
    	client = c;    	
    }
    
	/**
	 * Create the frame.
	 */
	public AnimalList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		table.setToolTipText("");
		table.setBounds(10, 51, 414, 199);
		contentPane.add(table);
		listAnimal = Controller.getAllAnimal();
		model = new AnimalTableModel(listAnimal);
		table.setModel(model);

		
		JLabel lblNewJgoodiesTitle = new JLabel("Lista de Animal");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(10, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		JButton btnNewAnimal = new JButton("Cadastrar Novo Animal");
		btnNewAnimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistryAnimalFrame frame = new RegistryAnimalFrame();
				frame.SetClient(client);
				frame.setVisible(true);
				dispose();
			}
			
		});
		btnNewAnimal.setBounds(264, 11, 160, 29);
		contentPane.add(btnNewAnimal);
		
		JButton btnTreatment = new JButton("Marcar Tratamento");
		btnTreatment.setBounds(434, 52, 132, 35);
		contentPane.add(btnTreatment);
		
		JButton btnConsult = new JButton("Marcar Consulta");
		btnConsult.setBounds(434, 107, 132, 35);
		contentPane.add(btnConsult);
	}
}
