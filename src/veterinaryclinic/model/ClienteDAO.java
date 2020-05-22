package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Plinio Vilela
 */
public class ClienteDAO extends Observable{
    private static ClienteDAO instance;
    private List<Client> clientes;
    private int id;
    
    private ClienteDAO(){
        clientes = new ArrayList<Client>();
        id = 0;
    }
    
    // Singleton
    public static ClienteDAO getInstance(){
       if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    
// Partial CRUD    
    // Create
    public void addCliente(String nome, String endereco, String telefone, String cep, String email){
        Client cliente = new Client(id,nome,endereco,telefone,cep, email);
        id++;
        clientes.add(cliente);
        setChanged();
        notifyObservers(cliente);
    }
    
    // RetrieveAll
    public List<Client> getAllClientes(){        
        return clientes;
    }
    
    // RetrieveById
    // Os grupos devem implementar as modificacoes para permitir que um cliente seja
    // encontrado a partir de um id (inteiro).
    // Sugestao, ao inves de usar um List, usar um Map.
    public Client getClienteById(int id){
        for(Client cliente : clientes){
            if(cliente.getId()==id){
                return cliente;
            }
        }
        return null;
    }
    
    // RetrieveByName
    
    // Updade
    
    // Delete   
    public void deleteCliente(Client client){
        clientes.remove(client);
    }
    
}
