package model;

import java.util.Observable;
import java.util.HashMap;
import java.util.Map;

public class ClienteDAO extends Observable{
    private static ClienteDAO instance;
    private Map<Integer, Client> clients;
    private Integer id;
    
    private ClienteDAO(){
    	clients = new HashMap<Integer, Client>();
    	id = 0;
    }
    
    // Singleton
    public static ClienteDAO getInstance(){
       if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    // Create
    public void addCliente(String nome, String endereco, String telefone, String cep, String email){
        Client cliente = new Client(id,nome,endereco,telefone,cep, email);
        clients.put(id, cliente);
        id++;
        setChanged();
        notifyObservers(cliente);
    }
    
    // RetrieveAll
    public Map<Integer, Client> getAllClientes(){        
        return clients;
    }
    
    // RetrieveById
    public Client getClienteById(int id)
    {
    	return clients.get(id);
    }
    
    // RetrieveByName
    public Client getClienteByName(String name)
    {
    	for (Client c : clients.values())
    		if(c.getName() == name)
    			return c;
		return null;
    }
    
    // Update
    
    // Delete   
    public void deleteCliente(int id){
    	clients.remove(id);
    }
    
}
