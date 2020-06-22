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
import model.Client;
import view.tableModel.ClientTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;


public class ClientList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ClientTableModel model;
    private List<Client> listClient;
    private JButton btnFind;

	/**
	 * Create the frame.
	 */
	public ClientList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setToolTipText("");
		table.setBounds(10, 51, 414, 199);
		contentPane.add(table);
		listClient = Controller.getAllClient();
		model = new ClientTableModel(listClient);
		table.setModel(model);
		if (table.getRowCount() > 0)
			table.setRowSelectionInterval(0, 0);
		
		JLabel lblNewJgoodiesTitle = new JLabel("Lista de Client");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(10, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
		
		btnFind = new JButton("Find");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistryClientFrame r = new RegistryClientFrame();
				int index = table.getSelectedRow();
				Client c = listClient.get(table.convertRowIndexToModel(index));
				
				r.SetClient(c);
				r.setVisible(true);
				dispose();
			}
		});
		btnFind.setBounds(268, 17, 156, 23);
		contentPane.add(btnFind);
	}
}
