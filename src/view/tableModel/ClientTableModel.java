package view.tableModel;

import java.util.List;

import model.Client;

public class ClientTableModel extends BaseTableModel<Client> {
	
	private static final long serialVersionUID = 1L;

	public ClientTableModel(List<Client> listClient) {
    	super(listClient);
    	columns = new String[]{"ID","Nome","Endereço","Telefone","CEP","Email"};
    }

    @Override
    public Object getValueAt(int row, int col) {        
    	Client client = list.get(row);         
        switch (col) {
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

}
