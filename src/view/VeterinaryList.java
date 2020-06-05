package view;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controller.Controller;
import model.Veterinary;


public class VeterinaryList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private VeterinaryTableModel model;
    private List<Veterinary> listVeterinary;

	/**
	 * Create the frame.
	 */
	public VeterinaryList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		listVeterinary = Controller.getAllVeterinary();
		model = new VeterinaryTableModel(listVeterinary);
		table = new JTable();
		table.setModel(model);
		table.setToolTipText("");
		table.setBounds(10, 51, 414, 199);
		contentPane.add(table);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Lista de Veterinarios");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(144, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
	}
}
