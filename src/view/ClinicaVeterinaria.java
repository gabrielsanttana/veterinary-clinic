package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;

import controller.*;
import model.*;
import view.list.*;

public class ClinicaVeterinaria implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Dados Atualizados!!");
        System.out.println(arg);
    }
    
    public void listaClientes()
    {
    	List<Client> clients = Controller.getAllClientes();
        for (Client c : clients)
        	System.out.println(c);        
    }
    
    public void menuPrincipal()
    {
        Scanner sc = new Scanner(System.in);
        //Controller.setObserver(this);
        while (true)
        {
            System.out.println("1- Inserir cliente");
            System.out.println("2- Listar clientes");
            System.out.println("3 - Inserir animal");
            System.out.println("4 - Listar animais");
            System.out.println("5 - Exibir Lista de Animal");
            System.out.println("6 - Exibir Lista de Cliente");
            System.out.println("7 - Exibir Lista de Consulta");
            System.out.println("8 - Exibir Lista de Exame");
            System.out.println("9 - Exibir Lista de Especie");
            System.out.println("10 - Exibir Lista de Tratamento");
            System.out.println("11 - Exibir Lista de Veterinario");
            System.out.println("0 - Encerrar");
            
            int opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    Controller.addAnimal("Doguinho", 999, "Brabo",1);
                    Controller.addCliente("Plinio Vilela", "endereco","email", "(19)98787-9988","111-111");
                    Controller.addConsult(new Date(System.currentTimeMillis()), "Historico", 1, 1);
                    Controller.addExam("Descricao do exame", 1);
                    Controller.addSpecies("Primeira Specie");
                    Controller.addTreatment(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 1);
                    Controller.addVeterinary("Plinio Vilela", "endereco", "(19)98787-9988");
                    break;
                case 2:
                    listaClientes();
                    break;
                case 3:
                    System.out.println("Digite o ID do cliente: ");
                    int clientId = sc.nextInt();

                    System.out.println("Digite o nome do animal: ");
                    String animalName = sc.nextLine();

                    System.out.println("Digite a idade do animal: ");
                    int animalAge = sc.nextInt();

                    System.out.println("Digite o sexo do animal: ");
                    String animalSex = sc.nextLine();

                    Controller.addAnimal(animalName, animalAge, animalSex, clientId);
                    break;
                case 4: 
                    break;
                    
                case 5:
    					AnimalList animalFrame = new AnimalList();
    					animalFrame.setVisible(true);
    					break;
                case 6:
    					ClientList clientFrame = new ClientList();
    					clientFrame.setVisible(true);
    					break;
                case 7:
    					ConsultList consultFrame = new ConsultList();
    					consultFrame.setVisible(true);
    					break;
                case 8:
    					ExamList examFrame = new ExamList();
    					examFrame.setVisible(true);
    					break;
                case 9:
    					SpeciesList speciesFrame = new SpeciesList();
    					speciesFrame.setVisible(true);
    					break;
                case 10:
    					TreatmentList treatmentList = new TreatmentList();
    					treatmentList.setVisible(true);
    					break;
                case 11:
    					VeterinaryList frame = new VeterinaryList();
    					frame.setVisible(true);
                	break;
                case 0:
                	sc.close();
                    return;
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	VeterinaryDAO.getInstance();
    	ExamDAO.getInstance();
    	ConsultDAO.getInstance();
    	SpeciesDAO.getInstance();
    	ClientDAO.getInstance();
    	AnimalDAO.getInstance();
    	TreatmentDAO.getInstance();
//        new ClinicaVeterinaria().menuPrincipal();

		MainFrame frame = new MainFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width-200, screenSize.height-100);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
    }
    
}
