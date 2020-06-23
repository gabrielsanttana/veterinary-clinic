package view.show;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import controller.Controller;
import model.*;
import view.registry.RegistryExam;
import view.tableModel.*;


public class ShowConsult extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ConsultTableModel model;
    private List<Consult> listConsult;
    
    private JButton btnSeeConsults;
    private JButton btnNewConsult;
    
	/**
	 * Create the frame.
	 */
	public ShowConsult(Treatment treat) {
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
		listConsult = Controller.getConsultByTreatmentId(treat.getId());
		model = new ConsultTableModel(listConsult);
		table.setModel(model);
		if (table.getRowCount() > 0)
			table.setRowSelectionInterval(0, 0);
		
		JLabel lblNewJgoodiesTitle = new JLabel("Lista de Consult");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(144, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		btnNewConsult = new JButton("Marcar Exames");
		btnNewConsult.setBounds(434, 51, 153, 35);
		btnNewConsult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				RegistryExam frame = new RegistryExam(GetSelectedConsult());			
				frame.setVisible(true);
				dispose();
			}			
		});
		contentPane.add(btnNewConsult);
		
		btnSeeConsults = new JButton("Ver Exames");
		btnSeeConsults.setBounds(434, 97, 153, 35);
		btnSeeConsults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowExam frame = new ShowExam(GetSelectedConsult());
				frame.setVisible(true);
				dispose();
			}	
		});
		contentPane.add(btnSeeConsults);
	}

	private Consult GetSelectedConsult() {		
		int index = table.getSelectedRow();
		return listConsult.get(index);
	}
	
}
