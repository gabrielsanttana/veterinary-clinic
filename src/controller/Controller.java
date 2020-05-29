package controller;

import java.util.ArrayList;
import java.util.Observer;
import model.*;

public class Controller {
    public static void addCliente(String nome, String endereco, String telefone, String cep, String email){
        ClientDAO.getInstance().addClient(nome, endereco, telefone, cep, email);
    }
    
    public static ArrayList<Client> getAllClientes(){
        return new ArrayList<Client>(ClientDAO.getInstance().getAllClients().values());
    }

    public static void addAnimal(String name, int age, String sex, Treatment[] treatments, Species species) {
        AnimalDAO.getInstance().addAnimal(name, age, sex, treatments, species);
    } 
}
