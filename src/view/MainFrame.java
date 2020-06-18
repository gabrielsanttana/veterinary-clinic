package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.list.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBarList = new JMenuBar();
		menuBarList.setBounds(0, 0, 101, 22);
		contentPane.add(menuBarList);
		
		JMenu mnLista = new JMenu("Cadastros");
		menuBarList.add(mnLista);
		
		JMenuItem mntmAnimalList = new JMenuItem("Lista de Animal");
		mnLista.add(mntmAnimalList);
		
		JMenuItem mntmClientList = new JMenuItem("Lista de Cliente");
		mnLista.add(mntmClientList);
		
		JMenuItem mntmConsultList = new JMenuItem("Lista de Consulta");
		mnLista.add(mntmConsultList);
		
		JMenuItem mntmExamList = new JMenuItem("Lista de Exame");
		mnLista.add(mntmExamList);
		
		JMenuItem mntmSpeciesList = new JMenuItem("Lista de Especies");
		mnLista.add(mntmSpeciesList);
		
		JMenuItem mntmTreatmentList = new JMenuItem("Lista de Tratamento");
		mnLista.add(mntmTreatmentList);
		
		JMenuItem mntmVeterinaryList = new JMenuItem("Lista de Veterinario");
		mnLista.add(mntmVeterinaryList);
		

		mntmAnimalList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("eoqAnimal");
				AnimalList frame = new AnimalList();
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				frame.setVisible(true);
			}
		});
		mntmClientList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("eoqClient");
				ClientList frame = new ClientList();
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				frame.setVisible(true);
			}
		});
		mntmConsultList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultList frame = new ConsultList();
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				frame.setVisible(true);
			}
		});
		mntmExamList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamList frame = new ExamList();
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				frame.setVisible(true);
			}
		});
		mntmSpeciesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpeciesList frame = new SpeciesList();
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				frame.setVisible(true);
			}
		});
		mntmTreatmentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreatmentList frame = new TreatmentList();
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				frame.setVisible(true);
			}
		});
		mntmVeterinaryList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeterinaryList frame = new VeterinaryList();
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				frame.setVisible(true);
			}
		});



		
	}
}
