package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.List;

import controller.*;
import model.*;

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
            System.out.println("5 - Exibir Lista de Veterinarios");
            System.out.println("0 - Encerrar");
            
            int opcao = sc.nextInt();
            switch (opcao){
                case 1:
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
    				try {
    					VeterinaryList frame = new VeterinaryList();
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
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
        new ClinicaVeterinaria().menuPrincipal();
    }
    
}
