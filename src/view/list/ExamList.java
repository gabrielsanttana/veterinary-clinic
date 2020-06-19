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
import model.*;
import view.tableModel.*;


public class ExamList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ExamTableModel model;
    private List<Exam> listExam;

	/**
	 * Create the frame.
	 */
	public ExamList() {
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
		listExam = Controller.getAllExam();
		model = new ExamTableModel(listExam);
		table.setModel(model);

		
		JLabel lblNewJgoodiesTitle = new JLabel("Lista de Exam");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(144, 11, 142, 29);
		contentPane.add(lblNewJgoodiesTitle);
	}
}