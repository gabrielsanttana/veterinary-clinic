package controller;

import java.util.List;
import java.util.Observer;
import model.ClienteDAO;

/**
 *
 * @author Plinio Vilela
 */
public class Controller {
    public static void setObserver(Observer observer){
        ClienteDAO.getInstance().addObserver(observer);
    }
    
    public static void addCliente(String nome, String endereco, String telefone, String cep){
        ClienteDAO.getInstance().addCliente(nome, endereco, telefone, cep);
    }
    
    public static List getAllClientes(){
        return ClienteDAO.getInstance().getAllClientes();
    }
}
