package view.list;

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
import view.tableModel.*;


public class AnimalList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private AnimalTableModel model;
    private List<Animal> listAnimal;

	/**
	 * Create the frame.
	 */
	public AnimalList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		lblNewJgoodiesTitle.setBounds(144, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
	}
}