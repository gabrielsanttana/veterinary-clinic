package view.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Client;

public class ClientTableModel extends AbstractTableModel {

    private List<Client> listClient;
    private String[] colunas = {"ID","Nome","Endereço","Telefone","CEP","Email"};    


    public ClientTableModel(List<Client> listClient) {
        this.listClient = listClient; 
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    } 

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return listClient.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {        
    	Client client = listClient.get(linha);         
        switch (coluna) {
    		case 0:
    			return client.getId();
            case 1:
                return client.getName();
            case 2:
                return client.getAddress();  
            case 3:
                return client.getPhone(); 
            case 4:
                return client.getCep();
            case 5:
                return client.getEmail();
        }        
        return null;        
    }



    /**
     * 
     */
    private static final long serialVersionUID = 8089116544555428084L;


}
