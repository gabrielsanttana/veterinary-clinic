package veterinaryclinic.controller;

import java.util.List;
import java.util.Observer;
import veterinaryclinic.model.*;

/**
 *
 * @author Plinio Vilela
 */
public class Controller {
    public static void setObserver(Observer observer){
        ClienteDAO.getInstance().addObserver(observer);
    }
    
    public static void addCliente(String nome, String endereco, String telefone, String cep, String email){
        ClienteDAO.getInstance().addCliente(nome, endereco, telefone, cep, email);
    }
    
    public static List<Client> getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
}
