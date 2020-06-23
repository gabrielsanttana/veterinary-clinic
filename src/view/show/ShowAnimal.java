package view.show;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import controller.Controller;
import model.Animal;
import model.Client;
import view.registry.RegistryAnimal;
import view.registry.RegistryTreatment;
import view.tableModel.*;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ShowAnimal extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private AnimalTableModel model;
    private List<Animal> listAnimal;

    
	/**
	 * Create the frame.
	 */
	public ShowAnimal(Client client) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		table = new JTable();
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 51, 414, 199);
		contentPane.add(table);
		listAnimal = Controller.getAnimalsByClient(client.getId());
		model = new AnimalTableModel(listAnimal);
		// TODO BUG IN SPECIE SHOW LIST
		table.setModel(model);
		if (table.getRowCount() > 0)
			table.setRowSelectionInterval(0, 0);
		
		JLabel lblListName = new JLabel("Lista de Animal do Client ID: " + client.getId());
		lblListName.setHorizontalAlignment(SwingConstants.CENTER);
		lblListName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListName.setBounds(10, 11, 244, 29);
		contentPane.add(lblListName);
		
		JButton btnNewAnimal = new JButton("Cadastrar Novo Animal");
		btnNewAnimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistryAnimal frame = new RegistryAnimal(client);
				frame.setVisible(true);
				dispose();
			}			
		});
		btnNewAnimal.setBounds(264, 11, 160, 29);
		contentPane.add(btnNewAnimal);
		
		JButton btnNewTreatment = new JButton("Marcar Tratamento");
		btnNewTreatment.setBounds(434, 52, 153, 35);
		btnNewTreatment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Animal animal = GetAnimalFromTable();
				RegistryTreatment frame = new RegistryTreatment(animal);				
				frame.setVisible(true);
				dispose();
			}			
		});
		contentPane.add(btnNewTreatment);
		
		JButton btnSeeTreatments = new JButton("Ver Tratamentos");
		btnSeeTreatments.setBounds(434, 98, 153, 35);
		btnSeeTreatments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Animal animal = GetAnimalFromTable();
				ShowTreatment frame = new ShowTreatment(animal);
				frame.setVisible(true);
				dispose();
			}			
		});
		contentPane.add(btnSeeTreatments);
	}
	
	public Animal GetAnimalFromTable() 
	{
		int index = table.getSelectedRow();
		return listAnimal.get(index);
		
		// Tabela	listAnimal.get(table.convertRowIndexToModel(index));
		// Lista	listAnimal.get(index);
		// Banco	Controller.getAnimalById(index);	
	}
}
