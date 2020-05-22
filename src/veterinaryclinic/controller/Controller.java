package controller;

import java.util.Map;
import java.util.Observer;
import model.*;

public class Controller {
    public static void setObserver(Observer observer){
        ClienteDAO.getInstance().addObserver(observer);
    }
    
    public static void addCliente(String nome, String endereco, String telefone, String cep, String email){
        ClienteDAO.getInstance().addCliente(nome, endereco, telefone, cep, email);
    }
    
    public static Map<Integer, Client> getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }

    public static void addAnimal(String name, int age, String sex, Treatment[] treatments, Species[] species) {
        AnimalDAO.getInstace().addAnimal(name, age, sex, treatments, species);
    } 
}
