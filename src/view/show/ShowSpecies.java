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
import model.*;
import view.tableModel.*;


public class ShowSpecies extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private SpeciesTableModel model;
    private List<Species> listSpecies;

	/**
	 * Create the frame.
	 */
	public ShowSpecies() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 51, 414, 199);
		contentPane.add(table);
		listSpecies = Controller.getAllSpecies();
		model = new SpeciesTableModel(listSpecies);
		table.setModel(model);
		if (table.getRowCount() > 0)
			table.setRowSelectionInterval(0, 0);
		
		JLabel lblNewJgoodiesTitle = new JLabel("Lista de Species");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(144, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
	}
}
