package view.tableModel;

import java.util.List;

import model.Veterinary;

public class VeterinaryTableModel extends BaseTableModel<Veterinary> {

    public VeterinaryTableModel(List<Veterinary> listVeterinary) {
    	super(listVeterinary);
    	columns = new String[]{"ID","Nome","Endereço","Telefone"};
    }

    @Override
    public Object getValueAt(int row, int col) {        
        Veterinary veterinary = list.get(row);         
        switch (col) {
			case 0:
				return veterinary.getId();
            case 1:
                return veterinary.getVeterinaryName();
            case 2:
                return veterinary.getVeterinaryAddress();    
            case 3:
                return veterinary.getVeterinaryPhone();
        }        
        return null;        
    }

    private static final long serialVersionUID = 8089116544555428084L;


}
