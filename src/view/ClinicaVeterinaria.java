package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import model.AnimalDAO;
import model.ClientDAO;
import model.ConsultDAO;
import model.ExamDAO;
import model.SpeciesDAO;
import model.TreatmentDAO;
import model.VeterinaryDAO;

public class ClinicaVeterinaria 
{

    public static void main(String[] args) {
    	
    	VeterinaryDAO.getInstance();
    	ExamDAO.getInstance();
    	ConsultDAO.getInstance();
    	SpeciesDAO.getInstance();
    	ClientDAO.getInstance();
    	AnimalDAO.getInstance();
    	TreatmentDAO.getInstance();

		MainFrame frame = new MainFrame();
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setSize(screenSize.width/2, screenSize.height/2);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
    }
    
}
