package view.show;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import view.registry.RegistryConsult;
import view.tableModel.*;
import javax.swing.JButton;


public class ShowTreatment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private TreatmentTableModel model;
    private List<Treatment> listTreatment;
    private JButton btnSeeConsults;
    private JButton btnNewConsult;

	public ShowTreatment(Animal animal) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 51, 414, 199);
		contentPane.add(table);
		listTreatment = Controller.getTreatmentByAnimalId(animal.getId());
		model = new TreatmentTableModel(listTreatment);
		table.setModel(model);
		if (table.getRowCount() > 0)
			table.setRowSelectionInterval(0, 0);
		
		JLabel lblNewJgoodiesTitle = new JLabel("Lista de Treatment");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(10, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		btnNewConsult = new JButton("Marcar Consulta");
		btnNewConsult.setBounds(434, 51, 153, 35);
		btnNewConsult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				RegistryConsult frame = new RegistryConsult(GetSelectedTreat());				
				frame.setVisible(true);
				dispose();
			}			
		});
		contentPane.add(btnNewConsult);
		
		btnSeeConsults = new JButton("Ver Consultas");
		btnSeeConsults.setBounds(434, 97, 153, 35);
		btnSeeConsults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowConsult frame = new ShowConsult(GetSelectedTreat());
				frame.setVisible(true);
				dispose();
			}			
		});
		contentPane.add(btnSeeConsults);
	}
	
	private Treatment GetSelectedTreat() 
	{
		int index = table.getSelectedRow();
		return listTreatment.get(index);
	}
	
}
