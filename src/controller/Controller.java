package controller;

import java.util.List;
import model.*;

public class Controller {
    
    public static void addCliente(String name, String address, String email, String phone, String cep){
        ClientDAO.getInstance().addClient(name, address, phone, cep, email);
    }
    
    public static List<Client> getAllClientes(){
        return ClientDAO.getInstance().getAllClients();
    }
    
    public static Client getClienteById(int id){
        return ClientDAO.getInstance().getClientById(id);
    }
    
    public static void deleteCliente(Client cliente){
        ClientDAO.getInstance().deleteClient(cliente);
    }
    public static List<Veterinary> getAllVeterinary(){
        return VeterinaryDAO.getInstance().getAllVeterinary();
    }
    
    public static void addAnimal(String animalName, int animalAge, String animalSex, int clientId){
        AnimalDAO.getInstance().addAnimal(animalName, animalAge, animalSex, clientId);
    }    
    
    public static void addVeterinary(String veterinaryName, String veterinaryAddress, String veterinaryPhone){
        VeterinaryDAO.getInstance().addVeterinary(veterinaryName, veterinaryAddress, veterinaryPhone);
    }
    
}
